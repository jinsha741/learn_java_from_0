package JavaOO_HeroDemo;
/**
 * Hero的子类，战士类
 * @Description:  
 * @Title:  Warrior.java   
 * @Package JavaOO_HeroDemo   
 * @author: ZhangYang     
 * @date:   2018年11月19日 上午2:14:16
 */
public class Warrior extends Hero{
	
	/**
	 * 本类构造方法
	 * super(); -> 调用父类构造方法
	 */
	public Warrior() {
		super();
		setName("无敌的战士");
	}
	
	/**
	 * 重载方法
	 * @param name
	 * @param id
	 * @param x
	 * @param y
	 */
	public Warrior(String name , int id , int x , int y) {
		super(name , id);
		setX(x);
		setY(y);
	}
    
	/**
	 * 随机生成攻击力来打
	 * attack : 0 - 30
	 */
	@Override
	protected void fight(Hero hero) {
		//set自己的攻击力
		setAttack(((int)(Math.random() * 1000)) % 31);
		//传入的hero的当前生命 = 传入的hero的最大生命 - 攻击力
		hero.setCurrHp(hero.getMaxHp() - getAttack());
	}

	@Override
	protected boolean isFightByDistance(Hero hero) {
		/** 战士攻击距离是100 */
		double distance = getDistance(getX(), getY(), hero.getX(), hero.getY());
		
		return distance <= 100;
	}
}
