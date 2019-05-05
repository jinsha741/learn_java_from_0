package JavaList;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
/**
 * Set（集）的用法
 * 能够对集合中的对象进行排序。
 * @author jinsh
 *
 */
public class SetDemo {

	public static void main(String[] args) {
		//HashSetDemo();
		//linkedHashSetDemo();
		TreeSetDemo();

	}
	
	public static void HashSetDemo() {
		//HashSet方法的集合规律
		//1.不能有重复
		//2.无序
		
		Set<String> nameSet = new HashSet<>();
		nameSet.add("老大");
		nameSet.add("老二");
		nameSet.add("老三");
		nameSet.add("老四");
		nameSet.add("老五");
		nameSet.add("老大");
		System.out.println("排序如下：");
		nameSet.forEach(str -> System.out.print(str + ", ")); // lambda表达式排序
	}
	
	public static void linkedHashSetDemo() {
		//HashSet方法的集合规律
		//1.不能有重复
		//2.按照实际顺序
		Set<String> nameSet = new LinkedHashSet();
		nameSet.add("老大");
		nameSet.add("老二");
		nameSet.add("老三");
		nameSet.add("老四");
		nameSet.add("老五");
		nameSet.add("老大");
		System.out.println("排序如下：");
		nameSet.forEach(str -> System.out.print(str + ", ")); // lambda表达式排序
	}
	
	public static void TreeSetDemo() {
		//可以实现比较器，来排序
		//1.不能有重复
		//2.按照比较器自己规定排序
		//3.TreeSet同时实现了Navigable接口，实现导航功能（操作数字的方式来操作对象）
		TreeSet<String> nameSet = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.compareTo(o2) > 0) return 1;
				if(o1.compareTo(o2) < 0) return -1;
				return 0;
			}
		});
		nameSet.add("ab");
		nameSet.add("cd");
		nameSet.add("ef");
		nameSet.add("gh");
		nameSet.add("ij");
		nameSet.add("ab");
		System.out.println("排序如下：");
		nameSet.forEach(str -> System.out.print(str + ", ")); // lambda表达式排序
		System.out.println();
		
		//实现导航功能（操作数字的方式来操作对象）
		//lower(E e) 返回此 set 中严格小于给定元素的最大元素(小于)；如果不存在这样的元素，则返回null。
		System.out.println("小于a字幕的元素有没有：" + nameSet.lower("a"));
		System.out.println("小于e字幕的元素有没有：" + nameSet.lower("e"));
		
		//higher(E e)返回此 set 中严格大于给定元素的最小元素（大于等于）；如果不存在这样的元素，则返回null。
		System.out.println("大于a字幕的元素有没有：" + nameSet.higher("a"));
		System.out.println("大于i字幕的元素有没有：" + nameSet.higher("i"));
		
		//headSet(E e)返回此 set 中 e 元素之前的元素的集合
		System.out.println("gh之前的元素的集合截取：" + nameSet.headSet("gh"));
		
		//tailSet(E e)返回此 set 中 e 元素之后（包括e）的元素的集合
		System.out.println("gh之后的元素的集合截取：" + nameSet.tailSet("gh"));
		
		//pollFirst() 获取并返回移除的第一个元素；如果此 set 为空，则返回null。
		System.out.println("移除（出列）第一个元素：" + nameSet.pollFirst());
		//EpollLast() 获取并返回移除的最后一个元素；如果此 set 为空，则返回null。
		System.out.println("移除（出列）最后一个元素：" + nameSet.pollLast());
		
		System.out.print("现在集合中的元素：");
		nameSet.forEach(str -> System.out.print(str + ", "));
		
	}

}
