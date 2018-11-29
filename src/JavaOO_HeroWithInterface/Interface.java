package JavaOO_HeroWithInterface;
/**
 * 接口的一些重要特点
 * @author ZhangYang
 * @date Nov 22, 2018 3:56:20 PM
 * @remarks TODO
 */
public interface Interface {
	//子类再去使用N变量时，不能修改N的值
	//因为是static和final定义的
	//下面书写方法相同
	public static final String N = "呵呵";
	String M = "呵呵";
	
	//接口方法的默认书写:
	//接口的方法永远是抽象类的，需要子类去实现
	//下面书写方法相同
	public abstract void method();
	void method1();
	
	
	//java1.8之后才可以在接口的方法里面定义方法的实现
	//必须使用default
	default public void method2() {
		System.out.println("default的方法");
	}
}
