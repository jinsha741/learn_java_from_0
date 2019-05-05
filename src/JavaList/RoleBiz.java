package JavaList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Role的业务类
 * 方法写入
 * @author jinsh
 *
 */
public class RoleBiz {
	
	List<Role> roleList = null;
	
	/**
	 * 构造方法创建对象
	 */
	public RoleBiz() {
		roleList = new ArrayList<>();
	}
	
	/**
	 * 增加Role对象方法
	 * @param role
	 */
	public void add(Role role) {
		if(role != null) {
			roleList.add(role);
		}
	}
	
	/**
	 * 删除Role对象方法
	 * @param role
	 */
	public void delete(Role role) {
		if(role != null) {
			roleList.remove(role);
		}
	}
	
	/**
	 * 修改Role对象方法
	 * @param role
	 */
	public void updete(Role role) {
		//1.找到对象的下标
		//2.修改set
		int index = roleList.indexOf(role);
		if(index != -1) {
			roleList.set(index, role);
		}
	}
	
	/**
	 * 排序
	 * 可以自己写排序方法：冒泡，插入，快速排序
	 * 也可以用自带方法Collections.sort() 方法：不灵活，只能按照摸一个属性来排序
	 * 
	 * 自定义比较器Collections.sort(roleList, new RoleComparator_Hp());方法灵活，想用什么属性比较都可以自由切换
	 * 自己写一个比较器的方法
	 * 
	 * class Comparetor_Hp implements Comparator<Role>{

	   @Override
	       public int compare(Role role1, Role role2) {
		       if(role1.getHp() > role2.getHp()) return 1;
		       if(role1.getHp() < role2.getHp()) return -1;
		       return 0;
	       }
	   }
	 * 
	 * 方法调用	   
	 * Collections.sort(roleList, new RoleComparator_Hp());    
	 * 逆序:基于比较器RoleComparator_Hp的逆序
	 * Collections.sort(roleList, Collections.reverseOrder(new RoleComparator_Hp()));
	 * 
	 * 
	 * @param role
	 */
	public void sort() {
		//Collections.sort(roleList);
		//Collections.shuffle(roleList); //乱序（不需要实现Compareble接口）
		Collections.reverse(roleList); //逆序
	}
	
	/**
	 * 打印信息方法
	 * 用迭代器遍历打印
	 */
	public void show() {
		
		System.out.println("名称\t称号\t血量\t攻击");
		System.out.println("===============================");
		
		Iterator<Role> it = roleList.iterator();
		while(it.hasNext()) {
			Role role = it.next();//迭代器获取的对象信息保存在role里
			System.out.println(role.getName() + "\t" + role.getTitle() + "\t" + 
					role.getHp() + "\t" + role.getAttack());
		}
		
		
		
		
		
		
		
		
	}
}
