package JavaOO;
/** 
 * @Description:
 * 单例模式的应用 -本类里面生成一个唯一的new的方法供外部调用
 * @Title:  SingleModel.java   
 * @Package JavaOO   
 * @author: ZhangYang     
 * @date:   2018年11月18日 下午3:11:45
 */
public class SingleModel {
	//用来保存本类唯一的实例
	private static SingleModel me = null;
	
	public int count = 0;
	
	//构造方法
	private SingleModel() {
		count++;
	}
	
	//用静态方法提供唯一的一次new实例化，因为是private，所以只有在本类里面进行实列，方法在外部调用
	//只要me为空，就是唯一的一次实例化，外部也只能调用一次
	public static SingleModel getInstance() {
		if(me == null)
			me = new SingleModel();
		return me;
	}
}
