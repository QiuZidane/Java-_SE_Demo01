package innerClass;

import javax.swing.JOptionPane;

public class InnerClassTest {

	public static void main(String[] args) {

		TalkingClock clock = new TalkingClock(1000, true);
		// 普通内部类
		// clock.start();
		// 局部内部类
		clock.start_inner(2000, true);
		clock.start_anonymous_inner(3000, true);
		
		JOptionPane.showMessageDialog(null, "Quit？");
		System.exit(0);

	}

}
