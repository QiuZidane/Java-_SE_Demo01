package file;

import java.net.URI;

public class FileUtil {
	
	/**
	 * 根据类名返回类路径-在电脑中的路径
	 * @param classname 记得连包名一起传递进来
	 * @return
	 */
	@Deprecated
	public static String getClassPath(String classname){
		
		String classPath;
		
		try {
			classPath = Class.forName(classname).getResource("").getFile();
			return classPath;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 通过URI方式查找路径<br>
	 * 根据类名返回类路径-在电脑中的路径<br>
	 * @param classname 记得连包名一起传递进来
	 * @return
	 */
	public static String getClassPathByUri(String classname){
		
		String classPath;
		
		try {
			
			URI uri = new URI(Class.forName(classname).getResource("").getFile());
			classPath = uri.getPath(); 
			return classPath;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
