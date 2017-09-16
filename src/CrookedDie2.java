public class CrookedDie2 extends Die
{
	public CrookedDie2()
	{
		CrapsGame.println("  CrookedDie2's constructor called.");
	}

	@Override
	public void roll()
	{
		int testRoll = getLastRoll();
		
		if (testRoll == 6)
			this.setLastRoll(1);
		else
			this.setLastRoll(++testRoll);
	}

	@Override
	public String toString()
	{
		return "A CrookedDie2 rolling 1,2,3,4,5,6 in sequence, and... ";
	}

}
