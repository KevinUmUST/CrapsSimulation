/**
 * Just some Java code to allow you to explore inheritance, constructor
 * chaining, and polymorphism ("dynamic method lookup")
 * 
 */

public class PlayWithInheritance
{
	public static int RUN_EXAMPLE = 1;
	
	public static void main(String[] args)
	{
		StdOut.println();

		Die aSingleDie = new Die();
		CrookedDie1 crooked1 = new CrookedDie1();
		CrookedDie2 crooked2 = new CrookedDie2();

		StdOut.println();

		Die alias;
		
		switch(RUN_EXAMPLE)
		{
			case 1:
				StdOut.println("Note the output: constructor chaining.");
				break;
			case 2:
				StdOut.println(aSingleDie.toString());
				StdOut.print("toString() automatically called when reference treated as String: ");
				StdOut.println(aSingleDie.toString());
				StdOut.println("Concatenating a string to a reference: " + aSingleDie.toString());
				break;
			case 3:	
				StdOut.println("die1's toString(): '" + aSingleDie + "'");
				StdOut.println("crooked1's toString(): '" + crooked1 + "'");
				StdOut.println("crooked2's toString(): '" + crooked2 + "'");
				break;
			case 4:
				//alias = die1; // try replacing this line with either below
				alias = crooked1; // upcasting!
				//alias = crooked2; // ditto
				StdOut.println("alias's toString(): '" + alias.toString() + "'");
				StdOut.println();
				break;
			case 5:
				double toss = Math.random(); // [0.0..1.0)
	
				if (toss < 0.333)
					alias = aSingleDie;
				else if (toss < 0.666)
					alias = crooked1;
				else
					alias = crooked2;
				describe("Which toString() is called? Answer is: ", alias);
				break;
			case 6:
				Dice dice = new Dice(aSingleDie, crooked1); // we'll try substituting here
	
				dice.roll();
	
				int result = dice.getLastRoll();
				StdOut.printf("Roll of '%s' and '%s' is: %d.\n", aSingleDie, crooked1, result);
		}
		StdOut.println();
	}

	/**
	 * Shows polymorphism via passing either Die ref as toDescribe, or
	 * CrookedDie1 or CrookedDie2 ref instead
	 * 
	 * @param msg
	 * @param toDescribe
	 */

	public static void describe(String msg, Die toDescribe)
	{
		StdOut.printf("%s '%s' \n", msg, toDescribe.toString());
	}

}
