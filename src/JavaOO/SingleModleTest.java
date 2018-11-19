package JavaOO;

public class SingleModleTest {

	public static void main(String[] args) {
		
		//对象是private属性，外部不能直接调用
		// SingleModel singModel = new SingleModle();
		
		//需要用 SingleModel类的getInstance方法实例化
		SingleModel singModel1 = SingleModel.getInstance();
		System.out.println(singModel1.count);
		singModel1.count++;
		
		//静态属性就算被重新new了也不会变值
		SingleModel singModel2 = SingleModel.getInstance();
		System.out.println(singModel2.count);
		
		//生成唯一的实例，不管new多少次
		System.out.println(singModel1 == singModel2);
		
		
	}

}
