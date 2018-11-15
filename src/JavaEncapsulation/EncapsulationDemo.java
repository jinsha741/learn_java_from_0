package JavaEncapsulation;

/**
 * 
 * @Description:建模后的一系列操作
 * 1.写出全局变量 
 * 2.直接get，set工具建立方法 
 * 右键source -> getter and setter
 * 3.自动换行：ctrl+shift+f
 * 4.构造方法和重载：右键source -> constructors from/constructors using
 * @Title: EncapsulationDemo.java
 * @Package JavaEncapsulation
 * @author: ZhangYang
 * @date: 2018年11月11日 上午12:12:10
 */

public class EncapsulationDemo {
	/**
	 * 要求
	 * 1.玩家创建名称就不能更改了 -> "封装的方式来解决"
	 * 2.级别在1-999之间
	 * 3.玩家每一级所需的经验公式：
	 * ((等级-1)^3 + 60) / 5 * ((等级 - 1) * 2 + 60)
	 */
	
	private long id;
	private String niceName;
	private int level;
	private long exp;
	
	
    /**
     * 构造默认方法
     */
	public EncapsulationDemo() {
		super();
	}
	
	
    /**
     * 方法的重载
     * @param id
     * @param niceName
     * @param level
     * @param exp
     */
	public EncapsulationDemo(long id, String niceName, int level, long exp) {
		super();
		this.id = id;
		this.niceName = niceName;
		this.level = level;
		this.exp = exp;
	}
    
	/**
	 * 在这个设置初始名字，再把setNiceName方法删除或者改成private
	 * 就能实现只能设置一次名字
	 * @param niceName
	 */
	public EncapsulationDemo(String niceName) {
		this.niceName = niceName;
	}


	public long getId() {
		return id;
	}
    
	/**
	 * 修改封装条件
	 * @param id
	 */
	public void setId(long id) {
		if(id <= 0) id = 1;
		else
		    this.id = id;
	}

	public String getNiceName() {
		return niceName;
	}
    
	/**
	 * 修改封装条件
	 * @param niceName
	 */
	private void setNiceName(String niceName) {
		if(niceName == null) {
			niceName = "无效姓名";
		}else {
		    this.niceName = niceName;
		}
	}

	public int getLevel() {
		return level;
	}
    
	/**
	 * 修改封装条件
	 * @param level
	 */
	public void setLevel(int level) {
		if(level < 1 || level > 999) {
			this.level = 1;
		}else {
		    this.level = level;
		}
	}

	public long getExp() {
		//Math.pow　是浮点型，需要强转long型
		exp = ((long)Math.pow((level - 1), 3) + 60) / 5 * ((level - 1) * 2 + 60);
		return exp;
	}

	/*
	 * 每次得到经验是通过公式，而不是用户自己设置
	 */
//	public void setExp(long exp) {
//		this.exp = exp;
//	}

}
