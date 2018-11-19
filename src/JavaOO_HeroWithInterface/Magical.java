package JavaOO_HeroWithInterface;

public class Magical extends LongRangeHero{
	
	
	public Magical() {
		super();
		setName("傻逼的法师");
	}

	public Magical(String name, int id, int attackRange , int x , int y) {
		super(name, id, attackRange , x ,y);
	}
	
	/**
	 * 法师的攻击距离是300
	 * attackRange = 300
	 */
	@Override
	public boolean isFightByDistance(Assailable assa) {
		int distance = (int) getDistance(getX(), getY(), assa.getX(), assa.getY());
		if(distance <= getAttackRange()) {
			return true;
		}
		System.out.println("距离不够，攻击失败");
		return false;
	}
	
	/**
	 * 法师的攻击力0-20
	 */
	@Override
	public void fight(Assailable assa) {
		setAttack(((int)(Math.random() * 1000)) % 21);
		assa.setCurrHp(assa.getCurrHp() - getAttack());
	}
	
}
