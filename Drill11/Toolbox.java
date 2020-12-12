import java.util.Random;

public class Toolbox {
	
	public static int getRandomNumber(int bound) {
		//Returns a random number between 0 and bound
    	Random rand = new Random();
    	return rand.nextInt(Math.max(Math.abs(bound), 1));
	}
	
	public static float getRandomFloat(float bound) {
		//Returns a random number between 0 and bound
    	Random rand = new Random();
    	return rand.nextFloat() * bound;
	}	


}
