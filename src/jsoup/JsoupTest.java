package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import java.io.File;
import java.io.IOException;

/**
 * Created by QZidane on 2017/7/12.
 */
public class JsoupTest {

    public static void main(String[] args) throws IOException {

        File htmlFile = new File("temp/raw.html");
        Document doc = Jsoup.parse(htmlFile,"UTF-8");
//        System.out.println(doc.toString());

//        Elements allElements = doc.getAllElements();
//        for (Element element: allElements){
//            if (!element.tagName().toLowerCase().equals("script")){
//                System.out.println(element.toString());
//            }
//        }

        // 清理文本
//        String cleanText = Jsoup.clean(doc.toString(), Whitelist.none());
        Whitelist whitelist = new Whitelist();
        whitelist.addTags("div","li","span","tr","td");
//        String cleanText = Jsoup.clean(doc.toString(), whitelist);
        String cleanText = Jsoup.clean(doc.toString(), Whitelist.relaxed());
        System.out.println(cleanText);

    }

}
