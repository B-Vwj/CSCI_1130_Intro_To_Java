
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class GraphicsApp extends JPanel {

	private JPanel buttonBar;
	private Timer timer;
	private ClearType clearOption;
	private int interval;
	private boolean inputChanged;
	private OuterSpace outerSpace;

	public static void main(String[] args) {
		GraphicsApp drawer = new GraphicsApp();
		JFrame application = new JFrame();

		application.addComponentListener(new FrameListner(drawer));

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(drawer);
		application.setSize(1000, 750);
		application.setVisible(true);
		application.setBackground(Color.white);
	}

	private enum ClearType {
		NONE, CLEAR_ONLY, CLEAR_CONTINUE
	};

	public void setButtonBar(JPanel pane) {
		this.buttonBar = pane;
	}

	public void setInputChanged(boolean inputChanged) {
		this.inputChanged = inputChanged;
	}

	public GraphicsApp() {
		this.interval = 10;
		setLayout(new BorderLayout());
		ToolbarGenerator.constructToolbar(this);
		this.clearOption = ClearType.NONE;
		this.inputChanged = false;
	}

	public int getInterval() {
		return this.interval;
	}

	public void setInterval(int newInterval) {
		this.interval = newInterval;
	}

	public boolean canDraw() {
		return this.getWidth() > 0;
	}

	public OuterSpace getOuterSpace() {
		if (this.outerSpace == null) {
			System.out.println("Constructing Outer Space");
			Frame boundary = new Frame(0, 0, this.getWidth(), (this.getHeight() - getToolbarHeight()));
			this.outerSpace = new OuterSpace(boundary);
			this.outerSpace.randomize();
		}
		return this.outerSpace;
	}

	public void setOuterSpace(OuterSpace outerSpace) {
		this.outerSpace = outerSpace;
	}

	@Override
	public void paintComponent(Graphics g) {

		if (this.clearOption != ClearType.NONE) {
			//System.out.println("Clearing");
			super.paintComponent(g);
			boolean cont = this.clearOption == ClearType.CLEAR_CONTINUE;
			this.clearOption = ClearType.NONE;
			if (!cont)
				return;
		}

		//System.out.println("Drawing");

		boolean initializing = this.outerSpace == null;
		OuterSpace space = this.getOuterSpace();
		if (initializing)
			this.refreshUI();

		//Erase
		space.drawOn(g, this.getBackground());

		//Move
		space.move();

		//Draw
		space.drawOn(g);
	}

	public int getToolbarHeight() {
		return this.buttonBar.getHeight();
	}

	public Frame getCanvasFrame() {
		return new Frame(0, 0, this.getWidth(), this.getHeight() - getToolbarHeight());
	}

	public void clear(Graphics g) {
		this.clearOption = ClearType.CLEAR_ONLY;
		this.repaint();
		this.clearOption = ClearType.NONE;
	}

	private JComponent paneNamed(String paneName) {
		for (Component each : buttonBar.getComponents())
			if (each.getName() != null)
				if (each.getName().equals(paneName))
					return (JComponent) each;
		return null;
	}

	public void refreshModel() {
//		OuterSpace2 space = this.getOuterSpace();
//		this.interval = getPaneValueAsInt("pInterval");
//		space.setRate(getPaneValueAsInt("pXRate"), getPaneValueAsInt("pYRate"));

		//TODO
		//space.getSpaceObject().setLongDimension(getPaneValueAsInt("pSize"));

//		space.assureObjectsInside();
	}

	public void refreshUI() {
		this.setBackground(Color.white);
//		OuterSpace2 space = this.getOuterSpace();
//		SpaceObject so = space.getSpaceObject();
//		setPaneValue("pInterval", this.interval);
//		Point rate = so.getRate();
//		setPaneValue("pXRate", rate.getX());
//		setPaneValue("pYRate", rate.getY());
//		setPaneValue("pSize", so.getLongDimension());
	}

	public void randomize() {
		if (!canDraw())
			return;
		this.getOuterSpace().randomize();
		this.refreshUI();
		this.clearOption = ClearType.CLEAR_CONTINUE;
		this.repaint();
	}

	public void startTimer() {
		this.timer = new Timer();
		//timer task, initial delay , rate (ms)
		timer.schedule(new DrawingTask(this), 0, this.getInterval());
	}

	public void stopTimer() {
		if (this.timer != null) {
			this.timer.cancel();
			//this.outerSpace = null;
		}
		this.timer = null;
	}

	public void go() {
		this.basicClear();
		if (this.inputChanged) {
			this.refreshModel();
			this.inputChanged = false;
		}

		//TODO
		//this.interval = getPaneValueAsInt("pInterval");
		this.interval = 10;

		this.startTimer();
	}

	private void basicClear() {
		this.clearOption = ClearType.CLEAR_ONLY;
		this.repaint();
	}

	public void clear() {
		if (this.outerSpace != null)
			this.stopTimer();
		this.basicClear();
	}

	public static int getRandomNumber(int bound) {
		Random rand = new Random();
		return rand.nextInt(bound);
	}

	public String getPaneValue(String paneName) {
		JTextArea field = (JTextArea) paneNamed(paneName);
		return field.getText();
	}

	public void setPaneValue(String paneName, Object value) {
		JTextArea field = (JTextArea) paneNamed(paneName);
		field.setText(value.toString());
	}

	public int getPaneValueAsInt(String paneName) {
		return Integer.parseInt(getPaneValue(paneName));

	}

	public void resized() {
		this.setOuterSpace(null);
	}

	class DrawingTask extends TimerTask {
		private GraphicsApp app;

		public DrawingTask(GraphicsApp anApp) {
			this.app = anApp;
		}

		public void run() {
			app.repaint();
		}
	}

}









class DocListener implements DocumentListener {
	private GraphicsApp app;
    public DocListener(GraphicsApp anApp) {
		this.app = anApp;
	}
	public void insertUpdate(DocumentEvent e) {
		this.app.setInputChanged(true);
    }
    public void removeUpdate(DocumentEvent e) {
		this.app.setInputChanged(true);
    }
    public void changedUpdate(DocumentEvent e) {
		this.app.setInputChanged(true);
    }
}

//===========================================================================

class ToolbarGenerator {

	public static void constructToolbar(GraphicsApp app) {

		JButton button1, button2, button3;

		//Construct buttons
		button1 = new JButton("Go");
		button1.addActionListener(evt -> app.go());

		button2 = new JButton("Stop");
		button2.addActionListener(evt -> app.stopTimer());

		button3 = new JButton("Clear");
		button3.addActionListener(evt -> app.clear());

		button3 = new JButton("Randomize");
		button3.addActionListener(evt -> app.randomize());

		JTextArea blank = new JTextArea("  ");

		//Button bar
		JPanel buttonBar = new JPanel();
		buttonBar.setLayout(new FlowLayout(FlowLayout.CENTER));

		JTextArea field;

		field = addInput(5, "pXRate", "Rate (x)", buttonBar);
		field.getDocument().addDocumentListener(new DocListener(app));
		buttonBar.add(blank);

		field = addInput(5, "pYRate", "Rate (y)", buttonBar);
		field.getDocument().addDocumentListener(new DocListener(app));
		buttonBar.add(blank);

		field = addInput(5, "pSize", "Size", buttonBar);
		field.getDocument().addDocumentListener(new DocListener(app));
		buttonBar.add(blank);

		field = addInput(5, "pInterval", "Interval (ms)", buttonBar);
		field.getDocument().addDocumentListener(new DocListener(app));
		buttonBar.add(blank);

		buttonBar.add(button1);
		buttonBar.add(button2);
		buttonBar.add(button3);

		app.add(buttonBar, BorderLayout.SOUTH);
		app.setButtonBar(buttonBar);

		app.randomize();
	}

	public static JTextArea addInput(int width, String name, String label, JPanel container) {
		JTextArea input = new JTextArea(1, width);
		input.setBorder(BorderFactory.createLineBorder(Color.black));
		input.setName(name);
		container.add(new JLabel(label));
		container.add(input);
		return input;
	}

}

//===========================================================================



class FrameListner implements ComponentListener {

	private GraphicsApp app;

    public FrameListner(GraphicsApp app) {
		this.app = app;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		this.app.resized();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
	}






}

