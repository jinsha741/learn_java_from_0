package IOFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 替换歌词中的字
 * 使用字符流（Reader/Writer）
 * 读取-替换-再写入
 * @author ZhangYang
 *
 */
public class LyricsReplaceDemo {
	static final String filePath = "src/IOFile/lyrics.sav";
	static final String filePath2 = "src/IOFile/lyrics2.sav";
	
	
	public static void main(String[] args) {
		//Reader,Writer都是抽象类，实现必须是子类实现（多态）
		Reader reader = null;
		//给Reader加缓存，使其效率更高
		BufferedReader bReader = null;
		
		//每一行读取的字符的临时参数line
		String line = null;
		
		//和String类不同的是,StringBuffer和StringBuilder类的对象能够被多次的修改,并且不产生新的未使用对象
		StringBuffer lyrics = new StringBuffer();
		
		Writer writer = null;
		BufferedWriter bWriter = null;
		try {
			reader = new FileReader(filePath);
			//BufferedReader是装饰器，为Read添加缓存作用
			bReader = new BufferedReader(reader);
			
			/** 读取操作 */
			try {
				//如果读取的次行不为空，则继续
				while((line = bReader.readLine()) != null) {
					lyrics.append(line);
					lyrics.append(System.getProperty("line.separator"));//添加系统分隔符
				}
				
				/** 替换操作 */
				//读取的lyrics只是以字符流形式存在，必须转成String型
				String newLyrics = lyrics.toString().replaceAll("黄河", "会长");
				
				/** 写入操作 */
				writer = new FileWriter(filePath2);
				bWriter = new BufferedWriter(writer);
				bWriter.write(newLyrics);
				System.out.println("替换成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				bReader.close();
				reader.close();
				bWriter.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
