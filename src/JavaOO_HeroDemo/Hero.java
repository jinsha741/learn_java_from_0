package JavaOO_HeroDemo;

/**
 * 抽象父类
 * 
 * @Description:
 * @Title: Hero.java
 * @Package JavaOO_HeroDemo
 * @author: ZhangYang
 * @date: 2018年11月19日 上午1:58:39
 */
public abstract class Hero {
	private String name;
	private int id;
	private int level;
	private int maxHp;
	private int currHp;
	private int attack;
	private int x;
	private int y;

	
	public Hero() {
		setMaxHp(100);
		setCurrHp(100);
	}
	
	/**
	 * 方法的重载
	 * this(); -> 调用自己的构造方法
	 * 上面的setMaxHp(100);setCurrHp(100);就有了
	 * @param name
	 * @param id
	 */
	public Hero(String name , int id) {
		this();
		setName(name);
		setId(id);
	}
	
	/**
	 * 攻击的总括方法
	 * 判断距离，判断血量，再攻击
	 * @param hero
	 */
	public void pk(Hero hero) {
		//1.计算距离是否可以攻击到对方
		//2.如果可以，则调用fight方法
		if(isFightByDistance(hero) == true && currHp > 0 && hero.getCurrHp() > 0) {
			System.out.println(name + "攻击了" + hero.getName());
			fight(hero);
		}else {
			System.out.println("攻击距离不够，请移动位置");
		}
		System.out.println("当前英雄状态：");
		System.out.println("昵称\t血量\tX坐标\tY坐标");
		System.out.println(name + "\t" + currHp + "\t" + x + "\t" + y);
		System.out.println(hero.getName() + "\t" + hero.getCurrHp() + "\t" + hero.getX() + "\t" + hero.getY());	
	}
	
	/**
	 * 两点之间的距离
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @return
	 */
	public double getDistance(int x1 , int x2 , int y1 , int y2) {
		System.out.printf("%d , %d , %d , %d\n" , x1 , x2 , y1 , y2);
		int x0 = Math.abs(x1 - x2);
		//System.out.println("x0:" + x0);
		int y0 = Math.abs(y1 - y2);
		//System.out.println("y0:" + y0);
		//System.out.println("距离：" + (double) Math.sqrt(Math.pow(x0, 2) + Math.pow(y0, 2)));
		return (double) Math.sqrt(Math.pow(x0, 2) + Math.pow(y0, 2));
	}
	
	/**
	 * protected : 子类可以访问
	 * abstract ： 抽象类的方法，子类去实现
	 * @param hero
	 */
	protected abstract void fight(Hero hero);
	
	protected abstract boolean isFightByDistance(Hero hero);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if(level < 0 || level > 100) {
			level = 1;
		}else {
			this.level = level;
		}
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getCurrHp() {
		return currHp;
	}

	public void setCurrHp(int currHp) {
		this.currHp = currHp;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	
}
