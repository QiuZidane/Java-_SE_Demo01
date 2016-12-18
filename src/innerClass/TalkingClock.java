package innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

public class TalkingClock {

	private int interval;
	private boolean beep;

	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	public void start() {
		ActionListener listener = new TimePrinter();
		Timer timer = new Timer(interval, listener);
		timer.start();
		
	}
	
	// 可以设置为private
	// 如果设置为private，则不能通过TalkingClock.TimePrinter引用这个内部类
	public class TimePrinter implements ActionListener{ 
		
		@Override
		public void actionPerformed(ActionEvent event){
			Date now = new Date();
			System.out.println("At the tone, the time is "+now);
			if (beep) { // 或者 TalkingClock.this.beep
				Toolkit.getDefaultToolkit().beep();
			}
			
		}
	}
}
