package JavaList;

/**
 * 练习用List来增加角色的信息
 * 
 * @author jinsh
 *
 */

/**
 *为了使用自带的Collections.sort()方法排序，需要实现接口Comparable
 */
public class Role implements Comparable<Role>{
	private String name;
	private String title;
	private int hp;
	private int attack;

	public Role(String name, String title, int hp, int attack) {
		this.name = name;
		this.title = title;
		this.hp = hp;
		this.attack = attack;
	}
	
	
	
	public Role(String name) {
		this.name = name;
	}
	
	/**
	 * 接口Comparable的方法需要实现
	 */
	@Override
	public int compareTo(Role role) {
		//用血量值来排序
		if(hp > role.getHp()) return 1;
		if(hp > role.getHp()) return -1;
		return 0;
	}

	/**
	 * 重写equals方法，以便在集合中可以自动通过对象比较的方式进行删除元素
	 * ！！！！！！！！！！！重要
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Role)) { //传入对象的类型不匹配，直接返回flase
			return false;
		}
		Role role = (Role) obj;   //obj强转成Role类型
		return name.equals(role.getName()); //我们认为：两个对象的name相同就是相同的对象
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}



	

}
