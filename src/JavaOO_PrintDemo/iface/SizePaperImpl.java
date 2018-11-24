package JavaOO_PrintDemo.iface;

public class SizePaperImpl implements IPaper{
	
	/**
	 * 实现纸张的接口
	 */
	@Override
	public String getSize() {
		return "B4";
	}

}
