package IOFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.plaf.FileChooserUI;

/**
 * java文件IO的基本操作认识
 * @author: ZhangYang
 * @date:   2018年11月25日 下午8:36:26       
 * @Copyright: 2018
 *
	 * ┌───┐   ┌───┬───┬───┬───┐ ┌───┬───┬───┬───┐ ┌───┬───┬───┬───┐ ┌───┬───┬───┐
	 * │Esc│   │ F1│ F2│ F3│ F4│ │ F5│ F6│ F7│ F8│ │ F9│F10│F11│F12│ │P/S│S L│P/B│  ┌┐    ┌┐    ┌┐
	 * └───┘   └───┴───┴───┴───┘ └───┴───┴───┴───┘ └───┴───┴───┴───┘ └───┴───┴───┘  └┘    └┘    └┘
	 * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───────┐ ┌───┬───┬───┐ ┌───┬───┬───┬───┐
	 * │~ `│! 1│@ 2│# 3│$ 4│% 5│^ 6│& 7│* 8│( 9│) 0│_ -│+ =│ BacSp │ │Ins│Hom│PUp│ │N L│ / │ * │ - │
	 * ├───┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─────┤ ├───┼───┼───┤ ├───┼───┼───┼───┤
	 * │ Tab │ Q │ W │ E │ R │ T │ Y │ U │ I │ O │ P │{ [│} ]│ | \ │ │Del│End│PDn│ │ 7 │ 8 │ 9 │   │
	 * ├─────┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴─────┤ └───┴───┴───┘ ├───┼───┼───┤ + │
	 * │ Caps │ A │ S │ D │ F │ G │ H │ J │ K │ L │: ;│" '│ Enter  │               │ 4 │ 5 │ 6 │   │
	 * ├──────┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴────────┤     ┌───┐     ├───┼───┼───┼───┤
	 * │ Shift  │ Z │ X │ C │ V │ B │ N │ M │< ,│> .│? /│  Shift   │     │ ↑ │     │ 1 │ 2 │ 3 │   │
	 * ├─────┬──┴─┬─┴──┬┴───┴───┴───┴───┴───┴──┬┴───┼───┴┬────┬────┤ ┌───┼───┼───┐ ├───┴───┼───┤ E││
	 * │ Ctrl│    │Alt │         Space         │ Alt│    │    │Ctrl│ │ ← │ ↓ │ → │ │   0   │ . │←─┘│
	 * └─────┴────┴────┴───────────────────────┴────┴────┴────┴────┘ └───┴───┴───┘ └───────┴───┴───┘
 */
public class FileDemo {
	
	//文件目录指定
	//"."是指在此根目录
//	private static final String filePath = ".";	
	

	public static void main(String[] args) throws IOException {
		/** 设置一个高级的文件选择器 */
		JFileChooser fileChooser = new JFileChooser(new File("."));  //. 设置文件对话框打开时的目录
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  //既可以选择文件，也可以选择文件夹
		fileChooser.showOpenDialog(null);       //对话框
		
		//对File类进行实例化,并传入一个path
		File file =  fileChooser.getSelectedFile();  //获取对话框里自己选择的文件
		System.out.println("文件/文件夹是否存在：" + file.exists());
		System.out.println("是不是一个文件：" + file.isFile());
		System.out.println("是不是一个文件夹：" + file.isDirectory());
		System.out.println("文件名/目录名：" + file.getName());
		System.out.println("绝对路径：" + file.getAbsolutePath());
		System.out.println("相对路径：" + file.getPath());
		System.out.println("是否隐藏：" + file.isHidden());
		System.out.println("是否可读：" + file.canRead());
		System.out.println("是否可写：" + file.canWrite());
		
		//默认字节，只能算文件大小，文件夹大小默认0
		System.out.println("所占空间大小：" + file.length());
		
		System.out.println("最后的修改时间(long)：" + file.lastModified());
		//因为file.lastModified返回的是long型的时间，需要转换成Date格式的时间
		System.out.println("最后的修改时间(date)：" + new Date(file.lastModified()).toLocaleString());
		
		System.out.println();
		
//		//创建文件/文件夹
//		if(!file.exists()) {
//			if(file.isFile()){
//				//这里的方法会抛出异常，要么处理（try/catch），要么继续抛出
//				file.createNewFile();
//				System.out.println("文件已创建");
//			}else {
//				file.mkdir();
//				System.out.println("文件夹已创建");
//				//mkdir() 创建此抽象路径名称制定的目录（及只能创建一级的目录，且需要存在父目录）
//				//mkdirs() 创建此抽象路径制定的目录，包括有必须但不存在的父目录，（及可以创建多级目录，无论是否存在父目录）-多级目录时候时使用
//			}
//		}
//		
//		//文件/文件夹删除
//		if(file.exists()) {
//			file.delete();
//			System.out.println("已删除");
//		}
		
//		/**
//		 * 列出当前目录下的所有文件/文件夹
//		 * file.list() 返回一个String数组
//		 */
//		String[] fileNames = file.list(new DirFilter());
//		for (int i = 0; i < fileNames.length; i++) {
//			System.out.println(fileNames[i]);
//		}
//		
//	}
//	
//	
//	/**
//	 * 过滤器
//	 * 自定义的文件名过滤器，必须实现FilenameFileter接口
//	 * @author: ZhangYang
//	 * @date:   2018年11月25日 下午10:13:45    
//	 * @Copyright: 2018
//	 */
//	
//	//因为main方法也在FileDemo类里面，需要静态表示
//	static class DirFilter implements FilenameFilter{
//
//		@Override
//		public boolean accept(File dir, String name) {
//			//假设只要求显示git后缀的文件，其他全部过滤掉
//			if(name.endsWith("git")) {
//				return true;
//			}
//			return false;
//		}
//		
	}
	

}
