package testng.ntt;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by QZidane on 2017/7/9.
 */
public class Ntt_Parameter {

    @Test
    @Parameters("excelPath")
    public void doThings(String excelPath) throws IOException {
        System.out.println(excelPath);

    }

    @Test
    @Parameters("excelFile")
    public void doThings2(File excelFile) throws IOException {
        System.out.println(excelFile.getCanonicalPath());

    }
}
