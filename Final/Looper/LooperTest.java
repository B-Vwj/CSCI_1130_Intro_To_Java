public class LooperTest {

	public void demo_Loop() {
		prn("\ndemo_Loop");
		Looper loopster = new Looper();
		loopster.loop();
	}

	public void demo_reverseLoop() {
		prn("\ndemo_reverseLoop");
		Looper loopster = new Looper();
		loopster.reverseLoop();
	}

	public void demo_demoSum() {
		prn("\ndemo_demoSum");
		Looper loopster = new Looper();
		loopster.demoSum();
	}

	public void demo_sumFromTo1() {
		prn("\ndemo_sumFromTo1");
		Looper loopster = new Looper();
		int sum = loopster.sumFromTo(1, 4);
		prn("Sum (expecting 10): " + sum);
	}

	public void demo_sumFromTo2() {
		prn("\ndemo_sumFromTo2");
		Looper loopster = new Looper();
		int sum = loopster.sumFromTo(10, 40, 10);
		prn("Sum: (expecting 100): " + sum);
	}

	public void demo_countAllDivisibleBy() {
		prn("\ndemo_countAllDivisibleBy");
		Looper loopster = new Looper();
		int count = loopster.countAllDivisibleBy(2, 1, 10);
		prn("count (expecting 5): " + count);
		count = loopster.countAllDivisibleBy(3, 1, 10);
		prn("count (expecting 3): " + count);
	}

	//===========================================

	public static void prn(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		LooperTest d = new LooperTest();
		d.demo_Loop();
		d.demo_reverseLoop();
		d.demo_demoSum();
		d.demo_sumFromTo1();
		d.demo_sumFromTo2();
		d.demo_countAllDivisibleBy();
	}
}