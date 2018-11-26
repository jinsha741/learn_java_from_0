package IOFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 使用FileInputStream来实现文件复制
 * @author: ZhangYang
 * @date:   2018年11月26日 下午6:37:47    
 * @Copyright: 2018
 */
public class CopyByFile {
	private String filePath1 = "E:/BufferedTest/WeChatSetup.exe";
	private String filePath2 = "E:/BufferedTest/WeChatSetup(File复制版).exe";
	
	public void FileReadWrite() {
		File file1 = new File(filePath1);
		File file2 = new File(filePath2);
		InputStream inS = null;
		OutputStream outS = null;
		
		try {
			inS = new FileInputStream(file1);
			outS = new FileOutputStream(file2);
			try {
				byte[] bytes = new byte[inS.available()];//分配字节数组大小
				inS.read(bytes);
				outS.write(bytes);         //写入已读取的字节          
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				outS.close();
				inS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
}
