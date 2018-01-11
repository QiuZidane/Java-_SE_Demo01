package testng.ntt;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * Created by QZidane on 2017/7/9.
 */
public class Ntt_DataProvider {

    @DataProvider(name = "excelFileList")
    public Object[][] getFileList(){
        File dir = new File("temp");
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                try {
                    if (pathname.getCanonicalPath().endsWith("xls")){
                        return true;
                    } else {
                        return false;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        });

        Object[][] retObj;
        try {
            retObj = new Object[files.length][1];

            for(int i = 0, len = files.length; i<len;i++){

                // 第一维[]对应有多少组参数提供给@Test
                // 第二维[]对应每组参数内有多少个参数给@Test, 那么@Test的参数就得有多少个
                retObj[i][0] = files[i];

            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }


        return retObj;
    }

    @Test(dataProvider = "excelFileList")
    public void nttTest1(File file){
        System.out.println(file.getName());
    }


}
