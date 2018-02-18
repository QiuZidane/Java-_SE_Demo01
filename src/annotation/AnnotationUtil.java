package annotation;

public class AnnotationUtil {


    public static void getInfo(Class fruitclass){
        fruitclass.getDeclaringClass();
    }


    public static void main(String...args){

        getInfo(Apple.class);


    }

}
