package JavaList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * List（列表）相关知识
 * ArrayList:数组线性表
 * 	大小可变的数组，在内存中分配连续的空间
 * 	遍历元素和随机访问元素的效率高（因为有下标（指针））
 * 	但对于不是在最后位置增删元素时 效率低（因为增加删除都会使后面元素的对应下标改变）
 * @author jinsh
 *
 */
public class ArrayListDemo {

	public static void main(String[] args) {
		//多态：List接口的一个子类ArrayList实现 数组List
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<String>();
		//向List中添加元素
		list1.add("张一");
		list1.add("张二");
		list1.add("张三");
		list1.add("张四");
		list1.add("张五");
		
		list2.add("曹操");
		list2.add("曹丕");
		list2.add("曹植");
		System.out.println("---向List中添加元素---");
		System.out.println(list1);
		
		//规定位置插入元素
		list1.add(1, "李1");
		System.out.println("---规定位置插入元素---");
		System.out.println(list1);
		
		//规定位置改变 set 元素
		list1.set(2, "黄1");
		System.out.println("---规定位置改变 set 元素---");
		System.out.println(list1);
		
		//向List中添加另外一个list所有元素
		list1.addAll(list2);
		System.out.println("---向List中添加另外一个list所有元素---");
		System.out.println(list1);
		
		//删除元素
		System.out.println("---删除指针为2的元素---");
		list1.remove(2);
		//或者list1.remove("黄1")
		System.out.println(list1);
		
		//subList取区间，左闭右开[ )
		System.out.println("---subList取区间3,4---");
		System.out.println("subList(3,5) : " + list1.subList(3, 5));
		
		/**
		 * 集合list的遍历方法
		 */
		//1.for循环遍历
		System.out.println("---for循环遍历---");
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + ",  ");
		}
		System.out.println();
		
		//2.foreach遍历,直接遍历元素，但需要给定元素的类型
		System.out.println("---foreach遍历---");
		for(String str : list1) {
			System.out.print(str + ",  ");
		}
		System.out.println();
		
		//3.迭代器遍历 iterator(),需要使泛型
		System.out.println("---迭代器遍历---");
		Iterator<String> it = list1.iterator();
		    //如果迭代器里有下一个，则继续（相当于遍历）
		while(it.hasNext()) {
			System.out.print(it.next() + ",  ");
		}
		System.out.println();
		
		//4.使用ListIterator迭代器
		System.out.println("---ListIterator迭代器---");
		ListIterator<String> listIt = list1.listIterator();//默认从指针0开始获得迭代器
		while(listIt.hasNext()) {
			System.out.print(listIt.next() + ",  ");
		}
		System.out.println();
		
		
		/**
		 * ListIterator迭代器与iterator()区别
		 */
		//1.ListIterator可以向后访问，也能向前访问
		System.out.println("---ListIterator向前访问(逆序)---");
		ListIterator<String> listIt2 = list1.listIterator(list1.size());//从最后为止开始获得迭代器
		while(listIt2.hasPrevious()) {//当迭代器中的元素存在上一个时
			System.out.print(listIt2.previous() + ",  ");
		}
		System.out.println();
		
		//2.ListIterator可以修改list中的元素
		System.out.println("---ListIterator可以修改list中的元素---");
		ListIterator<String> listIt3 = list1.listIterator(3);//获得指针为3
		if(listIt3.hasPrevious()) {//判断前面是否有元素
			listIt3.previous();//指针移动到前面（因为第三个元素指针是2）
			listIt3.set("赵子龙");
			System.out.println(list1);
		}
		
		
		
	}
	
	/**
	 * 迭代器的好处:不依赖某个类的实现
	 * 可以任意的类型进行遍历 
	 */
	public void show(Iterator<? extends Student> it) {
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

/**
 * 随意创建一个student类
 * @author jinsh
 *
 */
class Student{
	
}
