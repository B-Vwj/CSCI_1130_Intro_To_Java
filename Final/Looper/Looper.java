public class Looper {

	public void loop() {
		//print ints 1 thru 10
		int n = 1;
		while (n <= 10) {
			prn("n: " + n);
			n++;
		}
	}

	public void reverseLoop() {
		//print ints 10 thru 1
		int n = 10;
		while (n >= 1) {
			prn("n: " + n);
			n--;
		}
	}

	public void demoSum() {
		//sum ints 1 through 10
		int n = 1;
		int sum = 0;
		while (n <= 10) {
			sum = sum + n;
			n++;
		}
		prn("Sum: " + sum);
	}

	public int sumFromTo(int from, int to) {
		/*A more dynamic sum, we sum
		a range using the passed params
		Assumption: to >= from
		Return the sum */
		int n = from;
		int sum = 0;
		while (n <= to) {
			sum = sum + n;
			n++;
		}
		return sum;
	}

	public int sumFromTo(int from, int to, int by) {
		/*Even more dynamic.
		We vary how much we increment
		this time */
		int n = from;
		int sum = 0;
		while (n <= to) {
			sum = sum + n;
			n = n + by;
		}
		return sum;
	}

	/*Recall our mathy dividend / divisor = quotient
	e.g.
		10 / 2 = 5
		14 / 7 = 2
	Java truncates, so:
		11 / 2 = 5
		20 / 7 = 2
	For pos numbers, reminder equals modulus (mod)
	Java uses % for modulus
		11 % 2 = 1 (remainder)
		20 % 7 = 6 (remainder)
		3 % 2 = 1
		4 % 2 = 0
	If mod is zero,
	then dividend is divisible by divisor
	*/
	public boolean isDivisibleBy(int dividend, int divisor) {
		//Java uses % for modulus/remainder
		//Return true if mod==0 (is divisible)
		int mod = dividend % divisor;
		return mod == 0;
	}

	public int countAllDivisibleBy(int divisor, int from, int to) {
		//All divisible by divisor in range
		//Make use of helper method
		int count = 0;
		int n = from;
		while (n <= to) {
			if (isDivisibleBy(n, divisor)) {
				count = count + 1;
			}
			n++;
		}
		return count;
	}

	public int sumAllDivisibleBy(int divisor, int from, int to) {
		int sum = 0;
		int n = from;
		while (n <= to) {
			if (isDivisibleBy(n, divisor)) {
				sum += n; // sum = sum + n;
			}
			n++;
		}
		return sum;
	}

	public boolean isPrime(int num) {
		// 1 is NOT a prime, so auto set to FALSE
		if (num <= 1) {
			return false;
		} else if (num == 2) { // 2 is a prime, so auto set to TRUE
			return true;
		} else if (num > 2) { // If num is greater than 2, run this block of code
			// Checks for whether num is ODD or EVEN
			if (num % 2 == 0) {
				return false;
			} else {
				int n = 3;
				int to = num - 1;
				while (n <= to) {
					if (isDivisibleBy(to, n)) {
						return false;
					}
					n = n + 2;
				}
			}
		}
		return true;
	}

	public int countPrimes(int start, int stop) {
		int count = 0;
		int n = start;
		while (n <= stop) {
			if (isPrime(stop)) {
				count = count + 1;
			}
		}
		return count;
	}

	// public void demo_objectPlay() {
	// 	/*We'll often manipulate objects in loops*/
	// 	prn("\ndemo_objectPlay");
	// 	int n = 1;
	// 	Rectangle rec = new Rectangle(4, 3);
	// 	while (n <= 10) {
	// 		rec.doubleSmallestDimension();
	// 		n++;
	// 	}
	// 	prn("Sent 'doubleSmallestDimension' 10 times");
	// 	prn("final result: " + rec);
	// }

	//===========================================

	public static void prn(Object o) {
		System.out.println(o);
	}

}
