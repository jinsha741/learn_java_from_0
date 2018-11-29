package JavaOO_HeroWithInterface;

import javax.annotation.Generated;

public class DefenseTower implements Assailable {
	private String name;
	private int x;
	private int y;
	private int maxHp;
	private int currHp;
	private int attackRange;
	private int attack;

	public DefenseTower() {
		super();

	}

	public DefenseTower(String name, int currHp, int x, int y) {
		setName(name);
		setCurrHp(currHp);
		setX(x);
		setY(y);
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getDistance(int x1, int x2, int y1, int y2) {
//		System.out.printf("%d , %d , %d , %d\n" , x1 , x2 , y1 , y2);
		int x0 = Math.abs(x1 - x2);
		// System.out.println("x0:" + x0);
		int y0 = Math.abs(y1 - y2);
		// System.out.println("y0:" + y0);
		// System.out.println("距离：" + (double) Math.sqrt(Math.pow(x0, 2) + Math.pow(y0,
		// 2)));
		return (double) Math.sqrt(Math.pow(x0, 2) + Math.pow(y0, 2));
	}

	public void pk(Assailable assa) {
		System.out.println(getName() + "攻击了" + assa.getName());
		if (!isFightByDistance(assa) == true) {
			System.out.println("攻击距离不够");
		} else if (currHp <= 0) {
			System.out.println(getName() + "当前生命小于0");
		} else if (assa.getCurrHp() < 0) {
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
	 * 判断防御塔的攻击距离是否能够攻击 防御塔有固定距离
	 */
	@Override
	public boolean isFightByDistance(Assailable assa) {
		setAttackRange(300);
		if (getDistance(getX(), getY(), assa.getX(), assa.getY()) <= getAttackRange()) {
			return true;
		}
		System.out.println("塔的攻击距离不够！");
		return false;
	}

	/**
	 * 防御塔的攻击 防御塔有固定攻击力50
	 */
	@Override
	public void fight(Assailable assa) {
		setAttack(50);
		assa.setCurrHp(assa.getCurrHp() - getAttack());
	}

}
