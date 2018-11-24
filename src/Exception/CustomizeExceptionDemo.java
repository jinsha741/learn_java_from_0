package Exception;
/**
 * 自定义一个异常处理方法
 * 方法：继承Exception父类
 * @Description:  
 * @Title:  CustomizeExceptionDemo.java   
 * @Package Exception   
 * @author: ZhangYang     
 * @date:   2018年11月23日 下午7:04:24
 */
public class CustomizeExceptionDemo extends Exception{
	//1.定义一个异常为：不能小于零
	private int value;
	
	public CustomizeExceptionDemo() {
		System.out.println("数字不能小于零");
	}
	
	public CustomizeExceptionDemo(int value) {
		System.out.println("输入的数字为：" + value);
	}
}
