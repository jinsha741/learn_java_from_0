package JavaOO_PrintDemo.iface;
/**
 * 实现接口的类
 * @Description:  
 * @Title:  ColorInkboxImpl.java   
 * @Package JavaOO_PrintDemo.iface   
 * @author: ZhangYang     
 * @date:   2018年11月22日 下午9:45:18
 */
public class ColorInkboxImpl implements IInkbox{
	
	/**
	 * 接口的方法重写
	 */
	@Override
	public String getColor() {
		return "红色";
	}
	
}
