import java.util.Scanner;

public class Multiply {

    public void go()
	{
        //Use "n1", "n2", "result" as variable names
        int n1, n2, result;

        //PROGRAM STARTS HERE
		n1 = getNumberFromUser("Please enter a number (integer):");
		n2 = getNumberFromUser("Please enter another number (integer):");

		showTextToUser("You entered numbers: " + n1 + " and " + n2);

		result = n1 * n2;

		showTextToUser("The result of your entered numbers being multiplied together is: " + result);
	}





	//=====================================================================
	//NOTE WELL -- The code below is completed and provided.
	//No changes are needed.
	//We'll learn about this code later.

    public static void main(String[] args)
    {
        showTextToUser("");
		Multiply myObject = new Multiply();
		myObject.go();
        showTextToUser("");
    }

	public static void showTextToUser(Object o) {
		System.out.println(o.toString());
	}

	public static void basicPrint(Object o) {
		System.out.print(o.toString());
	}

	public static String getTextFromUser(String label)
	{
        Scanner scanner = new Scanner(System.in);
		basicPrint("\n" + label + " ");
        String enteredText = scanner.nextLine();
		return enteredText;
	}

	public static int getNumberFromUser(String label)
	{
		String text = getTextFromUser(label);
		int number;
		number = Integer.valueOf(text);
		return number;
	}


}