
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author ����
 * @version 2019��1��1��
 * @copyright
 */
public class Biaobai {
	private static final String String = null;

	public static void main(String[] args) {

		try {// ������ʾЧ��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		for (int i = 0;; i++) { // ���ѭ��������ѡ��
			Object[] possibleValues = { "����", "����" };
			int m = JOptionPane.showOptionDialog(null, "���壬ϲ����þ���\n2019��������Ů���Ѻ���", "����ϲ���������   ���ߣ�����     ",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("images\\love.gif"), possibleValues, possibleValues[0]);
			if (m == 0) {
				JOptionPane.showMessageDialog(null, "��Ŷ���𼱣����滹��...");
				for (int j = 0;; j++) { // �ڲ�ѭ��������������
					String password = JOptionPane.showInputDialog(null, "΢���������룬" + "��Ȼ�޷��رգ�\n����������",
							"ת��΢����ϵŶ", JOptionPane.PLAIN_MESSAGE);
					if (!("1234").equals(password)) {
						JOptionPane.showMessageDialog(null, ("���벻��ȷ��" + "���Ѿ�����" + (j + 1) + "��"), "���棡����",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "���������ɹ��������壡����");
						break;
					}
				}
				break;
			} else {
				JOptionPane.showMessageDialog(null, "���ѡ����ȷ��", "���棬��ѡ����" + (i + 1) + "��", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}