package exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

import org.omg.CORBA.portable.UnknownException;

public class MultException {

	public MultException() {

	}

	public void getString() throws Throwable {

		/**
		 * 捕获多个异常
		 */

		try {

		} catch (Exception e) {

			e.getClass().getName();
			Throwable se = new IOException("test");
			se.initCause(e); // 这种方法可以得到原始异常			
			throw se;

		} catch (Error e) {

		}

	}

}
