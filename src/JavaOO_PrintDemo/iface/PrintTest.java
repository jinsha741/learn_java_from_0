package JavaOO_PrintDemo.iface;

public class PrintTest {

	public static void main(String[] args) {
		Printer printer = new Printer();
		
		ColorInkboxImpl color = new ColorInkboxImpl();
		
		//加墨水和设置纸张
//		SizePaperImpl size = new SizePaperImpl();
//		printer.setInkbox(color);
//		printer.setPaper(size);
//		printer.print();
		
		//加墨水和设置纸张
		printer.setInkbox(new ColorInkboxImpl());
		printer.setPaper(new SizePaperImpl());
		printer.print();
	}

}
