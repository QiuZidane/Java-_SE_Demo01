package thread;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.*;

import javax.naming.directory.SearchControls;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * This task counts the files in a directory and its subdirectories that contain
 * a given keyword
 * 
 * @author QZidane
 *
 */
class MatchCounter implements Callable<Integer> {

	private File directory;
	private String keyword;
	private ExecutorService pool;
	private int count;

	/**
	 * constructs a MatchCounter
	 * 
	 * @param dir
	 * @param key
	 * @param pool
	 */
	public MatchCounter(File dir, String key, ExecutorService pool) {

		this.directory = dir;
		this.keyword = key;
		this.pool = pool;
	}

	@Override
	public Integer call() {
		count = 0;
		try {

			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();

			// 遍历所有文件/文件夹
			for (File file : files) {
				if (file.isDirectory()) {
					MatchCounter counter = new MatchCounter(file, keyword, pool);
					// 将MatchCounter实例submit到pool，返回future结果
					Future<Integer> result = pool.submit(counter);
					// 将结果放入list，待后续处理
					results.add(result);
				} else {
					// if (search(file)) {
					// count++;
					// }
				}
			}
			for (Future<Integer> result : results) {
				try {
					count += result.get();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return count;
	}

}
