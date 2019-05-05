package JavaList;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * Vector和ArrayList差不多类似
 * vector是线程安全的
 * 长度增长时，vector增加一倍。ArrayList增加50%，有利于节省空间
 * 如果不许呀同步，最好用ArrayList，因为速度快
 * @author jinsh
 *
 */
public class VectorDemo {

	public static void main(String[] args) {
		Vector vec = new Vector();
		
		//添加元素
		vec.add("aaa");        //boolean型
		vec.addElement("bbb"); //void型
		
		//size与capacity的区别 , capacity初始容量是10
		System.out.println("size:" + vec.size());
		System.out.println("capacity:" + vec.capacity());
		System.out.println();
		
		//size大与capacity后？capacity自动增加
		System.out.println("size大与capacity后？");
		vec.add("aaa");
		vec.add("aaa"); 
		vec.add("aaa"); 
		vec.add("aaa"); 
		vec.add("aaa"); 
		vec.add("aaa"); 
		vec.add("aaa"); 
		vec.add("aaa"); 
		vec.add("aaa"); 
		System.out.println("size:" + vec.size());
		System.out.println("capacity:" + vec.capacity());
		System.out.println();
		
		
		//设置size与capacity一致
		System.out.println("设置size与capacity一致");
		vec.trimToSize();
		System.out.println("size:" + vec.size());
		System.out.println("capacity:" + vec.capacity());
		System.out.println();
		
		//自定义capacity
		System.out.println("自定义capacity");
		vec.ensureCapacity(300);
		System.out.println("size:" + vec.size());
		System.out.println("capacity:" + vec.capacity());
		System.out.println();
		
		
		//vector遍历的几种方法：for，iterator，枚举Enumeration，lambda表达式
		//1.for循环方法遍历
		
		System.out.println("1.for循环方法遍历");
		for (int i = 0; i < vec.size(); i++) {
			System.out.print(vec.get(i) + ", ");
		}
		System.out.println();
		
		//2.iterator
		System.out.println("iterator方法遍历");
		Iterator it = vec.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println();
		
		//3.枚举遍历方法 - 早期版本方法 - 实现方法和迭代器很想像 - 早期的迭代器
		System.out.println("枚举遍历方法");
		Enumeration<String> str = vec.elements();
		while(str.hasMoreElements()) {
			System.out.print(str.nextElement() + ", ");
		}
		System.out.println();
		
		//4.lambda表达式遍历
		System.out.println("lambda表达式遍历");
		vec.forEach(str1 -> System.out.print(str1 + ", "));
		System.out.println();
		
		
		//查询元素
		System.out.println();
		System.out.println("第一个元素：" + vec.firstElement());
		System.out.println("最后一个元素：" + vec.lastElement());
		System.out.println("第二个元素：" + vec.elementAt(1));
		
		//删除元素
		System.out.println();
		System.out.println("删除第二个元素：" + vec.remove(1));
		for (int i = 0; i < vec.size(); i++) {
			System.out.print(vec.get(i) + ", ");
		}
		System.out.println();

	}

}
