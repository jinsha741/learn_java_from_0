package JavaOO_PrintDemo.iface;

/**
 * 打印机类，实现接口墨水和纸张的功能
 * 
 * @Description:
 * @Title: Printer.java
 * @Package JavaOO_PrintDemo.iface
 * @author: ZhangYang
 * @date: 2018年11月22日 下午9:28:22
 */
public class Printer{

	// 打印机里面的变量是 墨水和纸张
	private IInkbox inkbox;
	private IPaper paper;
	
	public void print() {
		if(null == inkbox.getColor() || null == paper.getSize()) {
			System.out.println("没有装墨水或者没有设置纸张大小");
			return;
		}
		System.out.println("墨水和纸张设置完成");
		System.out.println("纸张颜色为：" + inkbox.getColor());
		System.out.println("纸张大小为：" + paper.getSize());
	}

	public IInkbox getInkbox() {
		return inkbox;
	}

	public void setInkbox(IInkbox inkbox) {
		this.inkbox = inkbox;
	}

	public IPaper getPaper() {
		return paper;
	}

	public void setPaper(IPaper paper) {
		this.paper = paper;
	}

}
