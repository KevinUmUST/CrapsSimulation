/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */
public class Dice
{
	private int lastRoll;
	private Die die1;
	private Die die2;

	public Dice()
	{
		this.die1 = new Die();
		this.die2 = new Die();
		this.roll();
	}

	public Dice(Die die1, Die die2)
	{
		this.die1 = die1;
		this.die2 = die2;
	}

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll()
	{
		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();

	}

	public String toString()
	{
		return "Roll of " + getLastRoll() + ": " + die1.getLastRoll() + " + " + die2.getLastRoll();

	}

	public static final int NUM_TRIALS = 360;

	public static void main(String[] args)
	{
		Dice dice1 = new Dice();
		int snakeEyesCount = 0;

		for (int i = 0; i < NUM_TRIALS; i++)
		{
			dice1.roll();
			StdOut.println(dice1);
			
			if (dice1.getLastRoll() == 2)
				snakeEyesCount++;
		}

		StdOut.println("Actual count: " + snakeEyesCount);
		StdOut.println("Expected count: " + (NUM_TRIALS / 36.0));
	}
}
