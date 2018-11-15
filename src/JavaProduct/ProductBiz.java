package JavaProduct;

import javax.swing.JOptionPane;

/**
 * 
 * @Description:  
 * @Title:  ProductBiz.java   
 * @Package JavaProduct   
 * @author: ZhangYang     
 * @date:   2018年11月13日 下午9:13:53
 */
public class ProductBiz {

	public static void main(String[] args) {
		
		ProductDemo product = new ProductDemo();
		
		//设置循环次数 -> 多少个需要计算的商品
		String strTitalCount = JOptionPane.showInputDialog("请输入本次需要计入的商品总数量");
		int titalCount = (Integer.parseInt(strTitalCount));
		
		double tital = 0; //总价格
		
		int[] counts = new int[titalCount];
		

        //对象数组 来保存对象的信息
		ProductDemo[] products = new ProductDemo[titalCount];
		
		
		for (int i = 0; i < titalCount; i++) {
			
			//****对象数组中的元素使用之前，一定要记得分配空间 ****
			products[i] = new ProductDemo();
			
			//接受窗口输入的信息,一定是String类型
			String strName = JOptionPane.showInputDialog("请输入商品的名字");
			products[i].setName(strName);
			String strPrice = JOptionPane.showInputDialog("请输入商品的单价");
			products[i].setPrice(Double.parseDouble(strPrice));
			String strCount = JOptionPane.showInputDialog("请输入商品的数量");
			counts[i] = Integer.parseInt(strCount);
		}
		System.out.println("商品价目标如下");
		for (int i = 0; i < titalCount; i++) {
			tital += products[i].getPrice() * counts[i];
			System.out.println("商品名字" + "\t" + "商品单价" + "\t" + "商品数量");
			System.out.println(products[i].getName() + "\t" + products[i].getPrice() 
			+ "\t" + counts[i]);
			
		}
		System.out.println("一共总价格为：" + tital);

	}

}
