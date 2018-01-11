package classpathkit;

import file.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QZidane on 2017/11/7.
 */
public class CPKit {

    // 生成以当前目录为根目录的CLASSPATH，入参为jar文件所在目录，支持多个
    public static void genClassPath(String... dirPaths) {

        List<File> jarList = new ArrayList<>();

        for (String dir : dirPaths) {
            File file = new File(dir);
            getJarsIntoList(file,jarList);
        }

        System.out.println(jarList);

        StringBuilder builder = new StringBuilder();
        for(File jar:jarList){
            builder.append(jar.toString());
            builder.append(" ");
        }

        FileUtil.writeStrToFile_buffer(builder.toString(),"classpath.txt");

    }

    /**
     * 获取所有jar文件到list
     */
    public static void getJarsIntoList(File dir, List<File> jarList) {

        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getJarsIntoList(file, jarList);
            } else {
                if (file.getName().endsWith(".jar")){
                    jarList.add(file);
                }
            }
        }
    }


    public static void main(String...args){

        // 例子：java -cp JSE.jar classpathkit.CPKit lib

        genClassPath("lib");



    }
}
