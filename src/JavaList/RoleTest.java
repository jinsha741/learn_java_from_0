package JavaList;

public class RoleTest {

	public static void main(String[] args) {
		RoleBiz roleBiz = new RoleBiz();
		
		/**
		 * 添加对象测试
		 */
		System.out.println("添加对象测试");
		roleBiz.add(new Role("孙悟空" , "齐天大圣" , 100 , 1000));
		roleBiz.add(new Role("猪八戒" , "天蓬元帅" , 200 , 1432));
		roleBiz.add(new Role("沙悟净" , "卷帘大将" , 300 , 132));
		roleBiz.add(new Role("唐僧" , "金蝉子" , 400 , 3243));
		
		roleBiz.show();
		System.out.println();
		
		/**
		 * 删除对象测试
		 */
		System.out.println("删除对象测试");
		Role role1 = new Role("猪八戒");
		roleBiz.delete(role1);
		roleBiz.show();
		System.out.println();
		
		/**
		 * 修改对象测试
		 */
		System.out.println("修改对象测试");
		Role role2 = new Role("孙悟空" , "弼马温" , 100 , 1000);
		roleBiz.updete(role2);
		roleBiz.show();
		System.out.println();
		
		/**
		 * 排序测试
		 */
		System.out.println("排序测试");
		roleBiz.sort();
		roleBiz.show();
	}

}
