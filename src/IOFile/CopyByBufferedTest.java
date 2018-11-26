package IOFile;

public class CopyByBufferedTest {

	public static void main(String[] args) {
		CopyByBuffered copy1 = new CopyByBuffered();
		CopyByFile copy2 = new CopyByFile();
		
		long time1 = System.currentTimeMillis();
		copy1.BufferedReadWrite();
		long time2 = System.currentTimeMillis();	
		System.out.println("Buffer文件复制用时：" + (time2 - time1) + "毫秒");
		
		long time3 = System.currentTimeMillis();
		copy2.FileReadWrite();
		long time4 = System.currentTimeMillis();
		System.out.println("File文件复制用时：" + (time4 - time3) + "毫秒");
		

	}

}
