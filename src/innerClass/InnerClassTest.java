package innerClass;

import javax.swing.JOptionPane;

public class InnerClassTest {

	public static void main(String[] args) {

		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();
		
		JOptionPane.showMessageDialog(null, "Quit？");
		System.exit(0);
		
	}

}
