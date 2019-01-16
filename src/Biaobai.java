
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author 张洋
 * @version 2019年1月1日
 * @copyright
 */
public class Biaobai {
	private static final String String = null;

	public static void main(String[] args) {

		try {// 设置显示效果
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		for (int i = 0;; i++) { // 外层循环控制首选项
			Object[] possibleValues = { "可以", "不行" };
			int m = JOptionPane.showOptionDialog(null, "雅铃，喜欢你好久了\n2019继续做我女朋友好吗？", "来自喜欢你的男生   作者：张洋     ",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("images\\love.gif"), possibleValues, possibleValues[0]);
			if (m == 0) {
				JOptionPane.showMessageDialog(null, "这才对嘛！别急，后面还有...");
				for (int j = 0;; j++) { // 内层循环控制输入密码
					String password = JOptionPane.showInputDialog(null, "微信问我密码，" + "不然无法关闭！\n请输入密码",
							"转至微信联系哦", JOptionPane.PLAIN_MESSAGE);
					if (!("1234").equals(password)) {
						JOptionPane.showMessageDialog(null, ("密码不正确！" + "你已经错了" + (j + 1) + "次"), "警告！！！",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "啦啦啦！成功拿下雅铃！！！");
						break;
					}
				}
				break;
			} else {
				JOptionPane.showMessageDialog(null, "你的选择不正确！", "警告，你选错了" + (i + 1) + "次", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}