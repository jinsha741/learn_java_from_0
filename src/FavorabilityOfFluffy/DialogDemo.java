package FavorabilityOfFluffy;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Java的选项面板示列
 * @author ZhangYang
 * @date Sep 30, 2018 1:20:31 AM
 * @remarks TODO
 */
public class DialogDemo {

	public static void main(String[] args) {
		//参数1:对话框的父窗体对象
//		JOptionPane.showMessageDialog(null, "提示信息");
		
		//参数2:对话框中的提示信息
		//参数3:对话框的标题信息
		//参数4:对话框的消息类型
//		JOptionPane.showMessageDialog(null, "今天你吃了吗" , "嘘寒问暖" , JOptionPane.WARNING_MESSAGE);
		
		//参数5:对话框中插入的图片路径
//		JOptionPane.showMessageDialog(null, "今天你吃了吗", "今天你吃了吗" , JOptionPane.WARNING_MESSAGE, new ImageIcon("images/番茄炒蛋.jpg"));
        
		
		//可以输入的对话框
		//selectionValues：写成数组，在输入框表示选项菜单
		JOptionPane.showInputDialog(null, "表示的信息", "标题", 0, new ImageIcon("images/番茄炒蛋.jpg"),
				new String[] {"选项1" , "选项2" , "选项3"}, "输入框中的默认值");
	}

}
