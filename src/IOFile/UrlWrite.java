package IOFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网页上的index.html文件读取再写入本地
 * @author ZhangYang
 *
 */
public class UrlWrite {
	static final String filePath = "src/IOFile/test.html";
	
	/**
	 * 写入的方法
	 * @param content
	 */
	public static void WriteUrl(String content) {
		Writer writer = null;
		BufferedWriter bWriter = null;
		try {
			writer = new FileWriter(filePath);
			bWriter = new BufferedWriter(writer);
			bWriter.write(content);
			System.out.println("网页源代码获取成功,在test.html里");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bWriter.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.xnpz365.com/index.html");
		StringBuffer htmlContents = new StringBuffer();
		//1.BufferedReader：装饰器，需要装饰Reader，读流
		//2.url.openStream：打开网页数据流
		//3.InputStreamReader：读取输入流的方法
		try(BufferedReader bReader = 
				new BufferedReader(new InputStreamReader(url.openStream()))){
			String line = null;
			//如果次行不为空，则继续
			while((line = bReader.readLine()) != null) {
				htmlContents.append(line);
				htmlContents.append(System.getProperty("line.separator"));
//				System.out.println(htmlContents);
			}
			
			/** 写入 */
			WriteUrl(htmlContents.toString());
		}

	}

}
