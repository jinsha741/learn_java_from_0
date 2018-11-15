package JavaBoxing;
/**
 * 理解包装的概念
 * 1.直接赋值的数据类型 -> 之后不可以用对象调用转换数据类型
 * 
 * 2_1.自动装箱  ：自动装成前面的数据类型
 * 2_2.手动装箱  :可以手动选择装成什么数据类型，
 * 之后可以用对象调用转换数据类型
 * -> num2.toString()等等转换方法
 * @Title:  BoxingDemo.java   
 * @Package JavaBoxing   
 * @author: ZhangYang     
 * @date:   2018年11月13日 下午2:55:59
 */
public class BoxingDemo {

	public static void main(String[] args) {
		double num1 = 3.14; //直接赋值
		
		Double num2 = new Double("3.14");//手动装箱
		Double num3 = Double.valueOf(num1);
		
		Double num4 = 3.14;  //自动装箱
		
		System.out.println(num1 + "\t" + num2.toHexString(num1) + "\t" + num3.toHexString(num1)
		+ "\t" + num4);
	}

}
