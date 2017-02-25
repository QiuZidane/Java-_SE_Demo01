package utils;

import java.util.Collection;
import java.util.Iterator;

public class MyUtil {
	
	public static void traverseAndPrint(Collection<?> c){
		
		String cName = c.getClass().getName();
		cName = c.getClass().getName().substring(cName.lastIndexOf(".")+1);
		
		
		Iterator<?> iterator =  c.iterator();
		System.out.printf("开始遍历<%s>: \n",cName);
		while(iterator.hasNext()){
			System.out.println(iterator.next());			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
