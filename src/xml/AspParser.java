package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AspParser {

    private Element root;
    private Map<String, String> propertiesMap;
    private List<AspEntity> AspEntities;

    public AspParser() {
        try {

            root = getXMLroot();
            propertiesMap = getProperties();
            AspEntities = getAspEntities();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Element getXMLroot() throws URISyntaxException, DocumentException {
        URL aopUrl = this.getClass().getResource("/aspConfig.xml");
        SAXReader reader = new SAXReader();
        Document document = reader.read(aopUrl);
        root = document.getRootElement();
        return root;

    }

    public Map<String, String> getProperties() {

        Map<String, String> ppMap = new HashMap<>();
        Element propertiesNode = root.element("properties");
        List<Element> pps = propertiesNode.elements();
        for (Element pp : pps) {
            String ppName = pp.getName();
            String ppValue = pp.getText();
            ppMap.put(ppName, ppValue);
        }
        return ppMap;
    }

    public List<AspEntity> getAspEntities() {

        AspEntity aspEntity;

        List<AspEntity> aspEntities = new ArrayList<>();
        List<Element> elements = root.elements("pointCut");
        for (Element e : elements) {

            System.out.println();

            String classSimpleName;
            String className = e.attribute("className").getValue();
            String methodName = e.attribute("methodName").getValue();
            String tempArgs = e.attribute("args").getValue();
            String advice = e.attribute("advice").getValue();
            int priority = Integer.parseInt(e.attribute("priority").getValue());

            className = replaceParam(className);
            String[] classNameArr = className.split("\\.");
            classSimpleName = classNameArr[classNameArr.length - 1];
            methodName = replaceParam(methodName);
            String[] args = tempArgs.split(",");
            advice = replaceParam(advice);

            aspEntity = new AspEntity();
            aspEntity.setClassName(className)
                    .setClassSimpleName(classSimpleName)
                    .setMethodName(methodName)
                    .setArgs(args)
                    .setAopAdice(advice)
                    .setPriority(priority);

            aspEntities.add(aspEntity);
        }

        return aspEntities;
    }

    private String replaceParam(String text) {
        if (text.startsWith("${")) {
            String key = text.replace("${", "");
            key = key.substring(0, key.length() - 1);
            return propertiesMap.get(key);
        } else {
            return text;
        }
    }


    public static void main(String[] args) {

        new AspParser();

    }
}
