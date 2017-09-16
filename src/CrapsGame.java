public class CrapsGame
{
	private int point;
	private Dice dice;
	public static boolean showOutput = true;

	public static void println(String str)
	{
		if (showOutput)
			StdOut.println(str);
	}

	public CrapsGame()
	{
		dice = new Dice();
	}

	public CrapsGame(Die die1, Die die2)
	{
		dice = new Dice(die1, die2);
	}

	public boolean playOneGame(int[] wins, int[] losses)
	{
		int steps = 1;

		doFirstRoll();
		
		if (winCondition())
		{
			return winForPlayer(wins, steps);
		}
		else if (loseCondition())
		{
			return lossForPlayer(losses, steps);
		}
		else
		{
			println("Point is: " + point);
			
			int rollResult = 0;
			do
			{
				dice.roll();
				steps++;
				rollResult = dice.getLastRoll();
				println("Next roll is: " + rollResult);
			}
			while (gameNotOver(rollResult));
			
			if (rollResult == 7)
			{
				// loss: record losses and return false
				println("You lose throwing a 7.");
				losses[steps]++;
				return false;
			}
			else if (rollResult == point)
			{
				// win: record wins and return false
				println("You win by throwing your point " + rollResult);
				wins[steps]++;
				return true;
			}
		}

		return false;
	}

	private boolean loseCondition()
	{
		return point==2 || point == 3 || point==12;
	}

	private boolean winCondition()
	{
		return point == 7 || point == 11;
	}

	private boolean gameNotOver(int value)
	{
		return value != 7 && value != point;
	}

	private boolean lossForPlayer(int[] losses, int steps)
	{
		println("Loss for player with " + point);
		losses[steps]++; 
		return false;
	}

	private void doFirstRoll()
	{
		dice.roll();
		point = dice.getLastRoll();
		println("First roll is: " + dice.getLastRoll());
	}

	private boolean winForPlayer(int[] wins, int steps)
	{
		println("Win for player with " + point);
		wins[steps]++; 
		return true;
	}

	public static void main(String[] args)
	{
		// play a game!
	}
}
