public class Die
{
	private int lastRoll;

	public Die()
	{
		this.roll();
	}

	public Die(int firstValue)
	{
		setLastRoll(firstValue);
	}

	public int getLastRoll()
	{

		return this.lastRoll;
	}

	protected void setLastRoll(int lastRoll)
	{
		this.lastRoll = lastRoll;
	}

	public void roll()
	{
		setLastRoll((int) (Math.random() * 6 + 1));
	}

	@Override
	public String toString()
	{
		return "A Die object with roll " + this.getLastRoll() + " " + super.toString();
	}

	public String toString(int msg)
	{
		return msg + this.toString();
	}
}
