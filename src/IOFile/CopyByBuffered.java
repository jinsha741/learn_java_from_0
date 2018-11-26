package IOFile;
/**
 * 使用缓存方法来实现文件的复制
 * @author: ZhangYang
 * @date:   2018年11月26日 下午5:24:05    
 * @Copyright: 2018
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyByBuffered {
	private String filePath1 = "E:/BufferedTest/WeChatSetup.exe";
	private String filePath2 = "E:/BufferedTest/WeChatSetup(Buffered复制版).exe";
	
	public void BufferedReadWrite() {
		File file1 = new File(filePath1);  //要复制的文件对象
		File file2 = new File(filePath2);
		InputStream in = null;
		BufferedInputStream bIn = null;
		BufferedOutputStream bOut = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(file1);
			bIn = new BufferedInputStream(in);
			out = new FileOutputStream(file2);
			bOut = new BufferedOutputStream(out);
			byte[] bytes = null;
			
			int i = -1;           //读取时的临时变量
			
			try {
				/** 读一个写一个 */
				while((i = bIn.read()) != -1) {    //i=-1说明已经读完
					bOut.write(i);                 
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				bIn.close();  //关闭缓存输入流
				bOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				out.close();
				in.close();   //关闭输入流
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}	
}
