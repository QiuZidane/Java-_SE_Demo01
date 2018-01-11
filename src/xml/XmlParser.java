package xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.nio.file.Path;
import java.util.*;

/**
 * Created by QZidane on 2017/10/20.
 */
public class XmlParser {

    public static List<Map<String,String>> getNodeInfo(Path xmlPath) throws Exception {

        List<Map<String,String>> NodeInfoList = new ArrayList<>();

        SAXReader reader = new SAXReader();
        Document document = reader.read(xmlPath.toUri().toURL());
        Element root = document.getRootElement();
        Map<String,String> NodeMap;
        for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
            Element element = it.next();

            NodeMap = new HashMap<>();
            NodeMap.put("app",element.elementTextTrim("app"));
            NodeMap.put("name",element.elementTextTrim("name"));
            NodeMap.put("class",element.elementTextTrim("class"));
            NodeMap.put("method",element.elementTextTrim("method"));

            NodeInfoList.add(NodeMap);
            // do something
            System.out.println();
        }
        System.out.println();
        return null;

    }


}
