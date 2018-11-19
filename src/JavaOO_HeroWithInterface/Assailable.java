package JavaOO_HeroWithInterface;
/**
 * 实现一个可以攻击和被攻击的英雄或其他所有事物的接口
 * 接口里面写的全是之后对战物体的共同方法
 * 默认public可以不用public等关键字
 * @Description:  
 * @Title:  Attackable.java   
 * @Package JavaOO_HeroWithInterface   
 * @author: ZhangYang     
 * @date:   2018年11月19日 下午10:42:49
 */
public interface Assailable {
	String getName();
	int getX();
	void setX(int x);
	int getY();
	void setY(int y);
	int getMaxHp();
	void setMaxHp(int maxHp);
	int getCurrHp();
	void setCurrHp(int currHp);
	
	/**
	 * 根据距离判断，是否能够攻击另一个具备攻击的对象
	 * @param assa 传入的一个具有攻击能力的对象
	 * @return
	 */
	boolean isFightByDistance(Assailable assa);
	
	/**
	 * 和另一个具备攻击的对象打架
	 * @param assa
	 */
	void fight(Assailable assa);
	

}
