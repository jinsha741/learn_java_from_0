package JavaOO_HeroWithInterface;
/**
 * 战士类，继承Hero
 * @Description:  
 * @Title:  Warrior.java   
 * @Package JavaOO_HeroWithInterface   
 * @author: ZhangYang     
 * @date:   2018年11月19日 下午11:22:04
 */
public class Warrior extends Hero{
	
	
	public Warrior() {
		super();
		setName("无敌的战士");
	}

	public Warrior(String name, int id , int x , int y) {
		super(name, id);
		setX(x);
		setY(y);
	}

	@Override
	public boolean isFightByDistance(Assailable assa) {
		double distance = (double) getDistance(this.getX(), this.getY(), assa.getX(), assa.getY());
		return distance <= 100;
	}

	@Override
	public void fight(Assailable assa) {
		//1.战士的随机攻击力0-30
		//2.被攻击者的当前血量set(max - attack)
		int attack = ((int)(Math.random() * 1000)) % 31;
		setAttack(attack);
		
		assa.setCurrHp(assa.getCurrHp() - getAttack());
	}

}
