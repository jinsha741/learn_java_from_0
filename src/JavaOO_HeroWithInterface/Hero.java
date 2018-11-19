package JavaOO_HeroWithInterface;

/**
 * 抽象类的Hero实现接口
 * 
 * @Description:
 * @Title: Hero.java
 * @Package JavaOO_HeroWithInterface
 * @author: ZhangYang
 * @date: 2018年11月19日 下午11:08:55
 */
public abstract class Hero implements Assailable {
	private String name;
	private int id;
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
	 * 反复攻击，知道一人血量到底
	 * @param assa
	 */
	public void repeatedlyPk(Assailable assa) {
		for (int i = 0; i < 5; i++) {
			pk(assa);
		}
	}
	
	/**
	 * pk对象是 接口所定义的所有可攻击对象
	 * @param assa 可攻击对象
	 */
	public void pk(Assailable assa) {
		System.out.println(getName() + "攻击了" + assa.getName());
		if(!isFightByDistance(assa) == true) {
			System.out.println("攻击距离不够");
		}else if(currHp <= 0) {
			System.out.println(getName() + "当前生命小于0");	
		}else if(assa.getCurrHp() < 0) {
			System.out.println(assa.getName() + "当前生命小于0");
		}
		fight(assa);
		System.out.println("当前英雄状态：");
		System.out.println("昵称\t血量\tX坐标\tY坐标");
		System.out.println(name + "\t" + currHp + "\t" + x + "\t" + y);
		System.out.println(assa.getName() + "\t" + assa.getCurrHp() + "\t" + assa.getX() + "\t" + assa.getY());	
		System.out.println();
		
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
//		System.out.printf("%d , %d , %d , %d\n" , x1 , x2 , y1 , y2);
		int x0 = Math.abs(x1 - x2);
		//System.out.println("x0:" + x0);
		int y0 = Math.abs(y1 - y2);
		//System.out.println("y0:" + y0);
		//System.out.println("距离：" + (double) Math.sqrt(Math.pow(x0, 2) + Math.pow(y0, 2)));
		return (double) Math.sqrt(Math.pow(x0, 2) + Math.pow(y0, 2));
	}
	
	public abstract boolean isFightByDistance(Assailable assa);
	
	public abstract void fight(Assailable assa);
	

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

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
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

}
