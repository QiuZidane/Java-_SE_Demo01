package testng.ntt;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface 脚本信息 {

    String 案例数据() default "";  // 默认public
    String 环境() default "";

}
