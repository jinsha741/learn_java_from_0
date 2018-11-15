package JavaProduct;

/**
 * 学习使用对象数组  , *******对象数组中的元素使用之前，一定要记得分配空间******
 * 学习使用JOptionpane.showInputDialog(); -> 返回的数据类型是String 学习数据类型之间的转换 :
 * String -> double Double.parseInt(string);
 * 
 * 要求： 输入3个商品的名字，单价，数量 并打印结算和总价
 * 
 * @Description:
 * @Title: ProductDemo.java
 * @Package JavaProduct
 * @author: ZhangYang
 * @date: 2018年11月13日 下午9:03:42
 */
public class ProductDemo {
	private String name;
	private double price;
	
	public ProductDemo() {}
	
	public ProductDemo(String name , double price) {
		setName(name);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
