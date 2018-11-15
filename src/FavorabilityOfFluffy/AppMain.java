package FavorabilityOfFluffy;

import java.util.Date;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * 用来存放输入的姓名
 * String name
 * 用来存放为雅铃做的某事
 * String[] names = {"四川火锅" , "番茄炒蛋" , "牛肉面" , "水煮肉片" , "土豆烧肉" , ""}
 * 用来存放雅铃对我的评价
 * String[] levelNames = {"菜鸟" , "普通" , "棒棒" , "高人" , "大神"}
 * 用来存放每个评价的等级
 * int[] level = {0,0,0,0,0,-1}
 * 用来存放对每一个菜的好感度
 * int[] loves = {100,100,100,100,100,-1}
 * 
 * 
 * @author ZhangYang
 * @date Sep 29, 2018 10:16:41 PM
 * @remarks TODO
 */
public class AppMain {

	public static void main(String[] args) {
		//功能1.雅铃新增菜
		//功能2.雅铃选择喜欢的佳肴：+20好感度，其他菜-10好感度
		//功能3.雅铃选择不喜欢的佳肴：直接删除此菜和对应的好感度，如果删除菜超过4个，张洋卒
		//功能4.雅铃查找佳肴
		Scanner input = new Scanner(System.in);
		
		//候选的菜系数组
		String[] newFood = {"蚂蚁上树" , "麻婆豆腐" , "回锅肉" , "卤肉饭" , "六婆炒面"};
		int newFoodCount = newFood.length;
		
		//不喜欢的菜肴数组
		String[] disslikeNames = {"" , "" , "" , "" , "" , "" , "" , "" , "" , ""};
		
		String[] names = {"四川火锅" , "番茄炒蛋" , "牛肉面" , "水煮肉片" , "土豆烧肉" , "" , "" , "" , "" , ""};
		
		String[] levelNames = {"菜鸟" , "普通" , "棒棒" , "高人" , "大神"};
		
		int[] level = new int[10];
		
		int[] loves = new int[10];
		
		int count = 1;
		int jyCount = 5;
		
		//好感度初始化100
		for (int i = 0; i < jyCount; i++) {
			loves[i] = 100;
		}
		
		while(count <= 10) {
//			System.out.println("第" + count + "餐");
//			System.out.println("------");
//			System.out.println("1.雅铃新增佳肴");
//			System.out.println("2.雅铃选择喜欢的佳肴");
//			System.out.println("3.雅铃选择不喜欢的佳肴");
//			System.out.println("4.雅铃查找佳肴");
//			System.out.println();
//			System.out.print("请雅铃选择：");
//			int choice = input.nextInt();
			
			//选择菜单改为数组类型打印
			String strMenu = "1.雅铃新增佳肴\n";
			strMenu += "2.雅铃选择喜欢的佳肴\n";
			strMenu += "3.雅铃选择不喜欢的佳肴\n";
			strMenu += "4.雅铃查找佳肴\n";
			strMenu += "请雅铃选择：";
			
			//图形交互
			Object objChoice = JOptionPane.showInputDialog(null, strMenu, "第" + count + "餐", 0, new ImageIcon("images/菜单.jpg"),
					new String[] {"1" , "2" , "3" , "4"}, null
			);
			
			//返回值转换成整数型
			int objChoiceNum = Integer.parseInt(objChoice.toString());
			
			switch (objChoiceNum) {
			case 1: //增加算法
				if(jyCount >= names.length) {
					System.out.println("增加的菜太多啦，张洋要累死了！");
					break;
				}
//				System.out.print("输入需要增加的佳肴:");
//				String newName = input.next();
				
				//输入需要增加的佳肴 图形界面
//				JOptionPane.showInputDialog(null, "请选择需要新增的菜肴" , "雅铃新增佳肴" , 0, new ImageIcon("images/猪.jpg"), 
//						newFood, null
//				);
				
				//需要增加的菜肴jop返回值是一个object
				Object objResult = JOptionPane.showInputDialog(null, "请选择需要新增的菜肴" , "雅铃新增佳肴" , 
						0, new ImageIcon("images/猪.jpg"), 
						newFood, null
				);
				
				//用户选择如果取消的话
				if(objResult == null) {
					continue;
				}
				
				//显示选择的菜肴
				JOptionPane.showMessageDialog(null, objResult.toString() , "雅铃新选择的菜肴", 0, 
						new ImageIcon("images/" + objResult.toString() + ".jpg"));
				
				//增加：姓名数组，好感度数组
				names[jyCount] = objResult.toString(); //object类型返回值转换成string  
				loves[jyCount] = 100;
				
				//选择了餐品后，其他餐品好感度-10
				for (int i = 0; i < jyCount; i++) {
					loves[i] -= 10;
				}
				
				jyCount++;
				break;
			case 2: //查找菜肴，好感度+20 ，其他-10
//				System.out.print("请输入菜肴的名字：");
//				String name = input.next();
				
				objResult = JOptionPane.showInputDialog(null, "请输入菜肴的名字：", "雅铃选择喜欢的佳肴", 
						0, new ImageIcon("images/猪.jpg"), names, null);
				if(objResult == null) {
					continue;
				}
				String name = objResult.toString();
				
				int searchIndex = Integer.MIN_VALUE; //初始化查找菜肴的下标
				for (int i = 0; i < jyCount; i++) {
					if(name.compareTo(names[i]) == 0) {  //字符串查找时，相等的情况
						//找到的话，标记出来
						searchIndex = i;
						break;
					}
				}
				
				//没有找到佳肴的情况
				if(searchIndex == Integer.MIN_VALUE) {
					System.out.println("张洋还不会此菜肴，不要活在梦里！醒醒吧");
					break;
				}
				//好感度+20评价+1，其他-10
				loves[searchIndex] += 20;
				
				//不能超过评价等级
				/**
				 *这里level的数字表示levelNames里的评价
				 *levelNames[level[i]]表示
				 */
				if(level[searchIndex] == levelNames.length - 1) {
					System.out.println(names[searchIndex] + "已经练的炉火纯青了，没有比张洋做得更好了！不能再喜欢了");
					loves[searchIndex] += 10;
				}else {
					level[searchIndex]++;
					
				    for (int i = 0; i < jyCount; i++) {
						if(i == searchIndex) {
						    continue;
						}
						loves[i] -= 10;
					}
				}
				
				
				
//			    System.out.println("雅铃喜欢" + names[searchIndex] + ",好感度+20,评价并且升级到" + levelNames[level[searchIndex]] + "，其他佳肴好感度-10");
//			    System.out.println();
			    
			    JOptionPane.showMessageDialog(null, "雅铃喜欢" + names[searchIndex] + ",好感度+20,对此菜肴的评价升级到" + 
			            levelNames[level[searchIndex]] + "，其他菜肴好感度-10", 
			    		"雅铃选择喜欢的菜肴", 0, new ImageIcon("images/" + names[searchIndex] + ".jpg"));
			    
				break;
			case 3:
			case 4:
			default:
				System.out.println("选择错误，请选择1-4之间的整数！");
				continue;
			}
			
			/**
			 * 游戏结束的逻辑
			 * 如果有两个菜的好感度低于60的话
			 * 就降低了张洋的做菜兴趣
			 * 张洋就不愿意再做菜了
			 */
			
			int disslikeCount = 0;			
			for (int i = 0; i < jyCount; i++) {
				if(loves[i] <= 60) {
					disslikeNames[disslikeCount] = names[i];
					disslikeCount++;
				}
			}
			
			String disslikeValue = "雅铃不喜欢两个菜以上了\n降低了张洋的做菜兴趣\n于日本时间";
			disslikeValue += new Date().toLocaleString();
			disslikeValue += "卒\n-------\n不喜欢的菜有：\n";
			for (int i = 0; i < disslikeCount; i++) {
				disslikeValue += String.format("%s\n", disslikeNames[i]);
			}
			
			if(disslikeCount >= 2) {
				JOptionPane.showMessageDialog(null, disslikeValue , "游戏结束" , 0 , new ImageIcon("images/卒.jpg"));
				System.exit(0);
			}
			
			//打印现在菜品的状态
//			System.out.println("菜品\t评价\t好感度");
//			for (int i = 0; i < jyCount; i++) {
//				System.out.println(names[i] + "\t" + levelNames[level[i]] + "\t" + loves[i]);
//			}
//			System.out.println("-----------------------------------");
			
			String value = "菜品   评价   好感度\n";
			for (int i = 0; i < jyCount; i++) {
//				System.out.println(names[i] + "\t" + levelNames[level[i]] + "\t" + loves[i]);
				value += String.format("%s   %s   %d\n", names[i] , levelNames[level[i]] , loves[i]);
			}
			JOptionPane.showMessageDialog(null, value , "每餐的结算" , 0 , new ImageIcon("images/猪.jpg"));
			
			//餐数增加
			count++;
		}
	}
}