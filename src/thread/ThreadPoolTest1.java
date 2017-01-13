package thread;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class ThreadPoolTest1 {

	public static void main(String[] args) {

	}

	class MatchCounter implements Callable<Integer> {

		private File dir;
		private String keyword;
		private ExecutorService pool;
		private int count;

		/**
		 * Searches a file for a given keyword
		 * 
		 * @param file
		 * @return
		 */
		public boolean search(File file) {
			try {
				try (Scanner in = new Scanner(file)) {
					boolean found = false;
					while (!found && in.hasNextLine()) {
						String line = in.nextLine();
						if (line.contains(keyword)) {
							found = true;
						}
					}
					return found;
				}

			} catch (Exception e) {
				return false;
			}

		}
	}

}
