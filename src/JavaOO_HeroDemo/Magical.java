package JavaOO_HeroDemo;
/**
 * 远程法师类
 * @Description:  
 * @Title:  Magical.java   
 * @Package JavaOO_HeroDemo   
 * @author: ZhangYang     
 * @date:   2018年11月19日 下午4:52:00
 */
public class Magical extends LongRangeHero{
	
	public Magical() {
		super();
	}
	
	public Magical(String name , int id , int attackRange , int x , int y) {
		super(name , id , attackRange , x, y);	
	}
	
	/**
	 * 重写远程英雄的攻击
	 * 0-20
	 */
	@Override
	protected void fight(Hero hero) {
		//set自己的攻击力
		setAttack(((int)(Math.random() * 1000)) % 21);
		//传入的hero的当前生命 = 传入的hero的最大生命 - 攻击力
		hero.setCurrHp(hero.getMaxHp() - getAttack());
	}
	
	/**
	 * 重写远程英雄的攻击距离，300
	 */
	@Override
	protected boolean isFightByDistance(Hero hero) {
		//这里是没有直接继承Hero，所以getX需要加this，表示magical来获取
		double distance = getDistance(this.getX(), this.getY(), hero.getX(), hero.getY());
		if(Math.abs(distance) <= getAttackRange()) {
			return true;
		}
		System.out.println("距离不够，攻击失败");
		return false;
	}


}
