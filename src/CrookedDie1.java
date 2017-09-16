public class CrookedDie1 extends Die
{
	public CrookedDie1()
	{
		CrapsGame.println("  CrookedDie1's constructor called.");
	}

	@Override
	public int getLastRoll()
	{
		return 3;
	}

	@Override
	public String toString()
	{
		return "A CrookedDie1 always rolling 3, and... " + super.toString();
	}

}
