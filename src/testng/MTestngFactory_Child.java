package testng;

import org.testng.annotations.Test;
import testng.ntt.脚本信息;

@脚本信息(案例数据 = "Test4567.xls")
/**
 * 脚本信息用于指定脚本用到的信息:
 * 1. 案例文件名称 ：不指定则默认为类名.xls(如Test3456.xls), 存放位置为script_src/类名/目录下, 如script_src/Test3456/Test3456.xls
 * 2. ..
 */
public class MTestngFactory_Child extends MTestngFactory{

	@Test
	public void test(){
		System.out.println(this.ScriptClass);
		System.out.println(this.className);
		System.out.println(this.ScriptName);
	}


}
