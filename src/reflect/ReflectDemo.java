package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by QZidane on 2017/11/6.
 */
public class ReflectDemo {


    public static void callMethod(){

        try {
            Class GoldAppPlugin = Class.forName("com.icbc.ntt.plugin.pga.GoldAppPlugin");
            Method indexGen = GoldAppPlugin.getMethod("indexGen");
            Object o = GoldAppPlugin.newInstance();
            System.out.println(indexGen.invoke(o));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void main(String...args){

        callMethod();

    }

}
