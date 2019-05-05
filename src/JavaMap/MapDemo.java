package JavaMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Map：以键（key）值（value）储存元素的容器
 * 根据关键字（key）找到对应的数据（value）
 * 方法：
 * V put(key,value); : 将一个key/value映射（键值对）放入图中
 * V get(key); : 根据键key获得对应的value值
 * Set<K> KeySet(); : 返回包含键key的规则集
 * Collection<V> values(); : 返回包含值value的集合
 * boolean containsKey(key); : 返回图中是否包含键key
 * Set<Map.Entry<K,V>> entrySet(); : 返回一个图中包含条目的规则集
 * int size(); : 返回图中的键值对个数
 * V remove(key); : 删除指定键对应的条目
 * 
 * 注意：
 * 1.HashMap的查询，插入和删除比较高效，但插入顺序和真实顺序不一致
 * 2.LinkedHashMap支持元素的排序
 * 3.TreeMap在遍历有序的键值是非常高效
 * Properties一般用于操作属性文件
 * @author jinsh
 *
 */
public class MapDemo {

	public static void main(String[] args) {
		//1.HashMap
		//排序不序
		Map<String,Integer> hashMap = new HashMap<>();
		hashMap.put("Robb", 25);
		hashMap.put("Sansa", 23);
		hashMap.put("Arya", 21);
		hashMap.put("Bran", 12);
		hashMap.put("Rickon", 10);
		hashMap.put("Jon", 24);
		System.out.println("HashMap:" + hashMap);
		
		//2.LinkedHashMap
		//按照put顺序排序
		Map<String,Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		linkedHashMap.put("Robb", 25);
		linkedHashMap.put("Sansa", 23);
		linkedHashMap.put("Arya", 21);
		linkedHashMap.put("Bran", 12);
		linkedHashMap.put("Rickon", 10);
		linkedHashMap.put("Jon", 24);
		System.out.println("LinkedHashMap:" + linkedHashMap);
		
		//2.TreeMap（默认只能对键进行排序）
		//按照一定规定自动排序abcdefg
		
		//按照TreeMap规定自动排序
//		Map<String,Integer> treeMap = new TreeMap<String, Integer>();
		
		//按照自己写的比较规定自动排序
//		Map<String,Integer> treeMap = new TreeMap<String, Integer>(new MyTreeMapComparator());
		
		//按照自己写的比较value值来排序,这里一定需要传一个写好的map进来
		Map<String,Integer> treeMap = new TreeMap<String, Integer>(new MyTreeMapComparatorByValue(hashMap));
		
		//复制（导入）一个map的所有键值
		treeMap.putAll(hashMap);
		System.out.println("TreeMap:" + treeMap);
		System.out.println();
		
		
		
		/**
		 * Map的遍历方式
		 */
		//1.通过遍历key，找出对应的value（需要二次取值）
		System.out.println("通过遍历key，找出对应的value");
		for(String key : treeMap.keySet()) { //获取key
			System.out.println(key + "---" + treeMap.get(key)); //获取key对应的value
		}
		System.out.println();
		
		//2.迭代器遍历,Entry就是一个键值对，或者Entry里存放了一个键值对(最麻烦)
		System.out.println("通过Map.entrySet使用迭代器遍历key和value");
		
			//entrySet的返回值是Set，里面存放很多获取到的键值对
			//EntrySet是Map接口里的子接口
			//Set里面放的是Entry对象
			//Set<Entry<String,Integer>> set = treeMap.entrySet();也行，下面更专业
		Set<Map.Entry<String,Integer>> entrySet = treeMap.entrySet();
		
		//获取迭代器
		Iterator<Map.Entry<String,Integer>> it = entrySet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
//		while(it.hasNext()) {
//			Map.Entry<String, Integer> entry = it.next();
//			System.out.println(entry.getKey() + "---" + entry.getValue());
//		}
		System.out.println();
		
		//3.直接遍历Map.entrySet集合(最优)
		System.out.println("直接遍历Map.entrySet集合");
		for(Entry<String,Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + "---" + entry.getValue());
		}
		
	}

}

/**
 * 自己修改TreeMap的排序规则
 * 这里写为逆序
 * @author jinsh
 *
 */
class MyTreeMapComparator implements Comparator<String>{

	@Override
	public int compare(String key1, String key2) {
		if(key1.compareTo(key2) > 0) return -1;
		if(key1.compareTo(key2) < 0) return 1;
		return 0;
	}
}

/**
 * 自己修改TreeMap的排序规则
 * 通过value值进行比较的写法
 * @author jinsh
 *
 */
class MyTreeMapComparatorByValue implements Comparator<String>{
	private Map<String,Integer> map;
    
	//通过构造方法获取传进来的map对象
	public MyTreeMapComparatorByValue(Map<String,Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(String key1, String key2) {
		if(map.get(key1).intValue() > map.get(key2).intValue()) return 1;
		if(map.get(key1).intValue() < map.get(key2).intValue()) return -1;
		return 0;
	}
	
}
	

