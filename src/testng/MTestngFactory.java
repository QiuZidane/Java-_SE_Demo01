package testng;

import org.testng.annotations.Factory;
import testng.ntt.脚本信息;

import java.lang.annotation.Annotation;

public class MTestngFactory {

    protected Class ScriptClass;
    protected String className;
    protected String ScriptName;

    public MTestngFactory() {

        ScriptClass = this.getClass();
        className=ScriptClass.getSimpleName(); // ----> 这个可以获取到不带报名的类名

        Annotation[] annotations= this.getClass().getAnnotations();
        for (Annotation annotation: annotations){
            if (annotation instanceof 脚本信息){
                ScriptName=((脚本信息)annotation).案例数据().toString(); //-->获得案例名称
            }
        }
    }


    @Factory
    public Object[] createInstances() throws NoSuchFieldException, IllegalAccessException {
        Object[] result = new Object[1];
        result[0] = new MTestngFactory();

//        Field caseFileName =  ScriptClass.getDeclaredField("caseFileName");
//        System.out.println(caseFileName);

        return result;
    }



}
