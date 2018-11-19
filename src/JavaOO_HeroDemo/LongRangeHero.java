package JavaOO_HeroDemo;

/**
 * 远程攻击的射手类 包括：法师，射手等
 * 
 * @Description:
 * @Title: LongRangeHero.java
 * @Package JavaOO_HeroDemo
 * @author: ZhangYang
 * @date: 2018年11月19日 下午4:45:06
 */
public abstract class LongRangeHero extends Hero {
	private int attackRange;

	public LongRangeHero() {
		super();
	}
	 /**
	  * 父类的方法里面决定了子类值的传入
	  * 必须set
	  * @param name
	  * @param id
	  * @param attackRange
	  * @param x
	  * @param y
	  */
	public LongRangeHero(String name, int id , int attackRange , int x , int y) {
		super(name , id);
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

}
