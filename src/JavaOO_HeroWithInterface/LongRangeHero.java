package JavaOO_HeroWithInterface;

public abstract class LongRangeHero extends Hero {
	private int attackRange;

	public LongRangeHero() {
		super();
	}

	public LongRangeHero(String name, int id, int attackRange , int x , int y) {
		super(name, id);
		setAttackRange(attackRange);
		setX(x);
		setY(y);
	}

	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}

	public abstract boolean isFightByDistance(Assailable assa);

	public abstract void fight(Assailable assa);

}
