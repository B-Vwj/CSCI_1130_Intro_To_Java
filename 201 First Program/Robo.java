import java.util.Scanner;

public class Robo
{
    public void go()
    {
		String text;
		int n1, result;

		//PROGRAM STARTS HERE

		showTextToUser("Hello End User, Good Day!");
		showTextToUser("I am a Java program named 'Robo'");

		n1 = getNumberFromUser("Please enter a number (integer): ");

		showTextToUser("You entered: " + n1);

		result = n1 * 2;

		showTextToUser("Your number doubled is: " + result);

		result = n1 * 3;

		showTextToUser("Your number tripled is: " + result);

		showTextToUser("I am done computing. I hope to see you again");

    }






	//=====================================================================
	//NOTE WELL -- The code below is completed and provided.
	//No changes are needed.
	//We'll learn about this code later.

    public static void main(String[] args)
    {
        showTextToUser("");
		Robo myObject = new Robo();
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



