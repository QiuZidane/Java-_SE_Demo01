package json.train;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import json.JsonObjectTest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TrainTest {

    private static Map<ClassInfo, LocationLib> locationLibCache = new HashMap<>();
    private static Map<ClassInfo, SimilarityLib> SimilarityLibCache = new HashMap<>();


    private static String createByBean(Object beanObj) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(beanObj);
        System.out.println(jsonString); // {"name":"Zidane","age":25}
        return jsonString;

    }

    /**
     * 格式化过的json字符串
     */
    private static String createByBean_pretty(Object beanObj) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String jsonString = gson.toJson(beanObj);
        System.out.println(jsonString);
        return jsonString;

    }

    /**
     * GSON解析 通过文件读取json数据，并序列化为Bean对象
     */
    private static void readJsonFromFile() throws IOException {

        File file = new File(JsonObjectTest.class.getResource("./train/train.json").getFile());
        String content = new String(Files.readAllBytes(file.toPath()));
        Gson gson = new Gson();
        LocationLib trainLib = gson.fromJson(content, LocationLib.class);
//        System.out.println();

    }

    /**
     * GSON解析 通过文件读取json数据，并序列化为Bean对象
     */
    private static void readJsonFromFile(String path) throws IOException {

        byte[] contentByte = Files.readAllBytes(Paths.get(path));
        String content = new String(contentByte);
        Gson gson = new Gson();
        LocationLib trainLib = gson.fromJson(content, LocationLib.class);
        System.out.println(trainLib);

    }

    /**
     * 查缓存---查是否有trainLib文件, 载入缓存---载入成功, 读取; 载入失败, 生成并缓存和写文件
     */
    public static LocationInfo getLocation(Class clazz, String imagePath, String resolution){

        //
        ClassInfo classInfo = new ClassInfo().setName(clazz.getName()).setSimpleName(clazz.getSimpleName());

        LocationLib trainLib = locationLibCache.get(classInfo);

        // 有缓存, 直接返回
        if (trainLib!=null){
            return trainLib.getLocationInfo(imagePath,resolution);
        }
        // 无缓存
        else{

            // 查找是否有trainLib文件

        }


        return null;
    }

    /**
     *
     *
     *
     */
    private static LocationLib createLocationLib(Class clazz, String imagePath, String resolution, int x, int y) {

        ClassInfo classInfo = TrainLibFactory.buildClassInfo(clazz);
        LocationInfo locationInfo = TrainLibFactory.buildLocationInfo(resolution,x,y);
        LocationLib locationLib = TrainLibFactory.buildLocationLib(classInfo,imagePath, locationInfo);
        return locationLib;

    }

    private static SimilarityLib createSimilarityLib(Class clazz, String imagePath, String resolution,double score) {

        ClassInfo classInfo = TrainLibFactory.buildClassInfo(clazz);
        SimilarityInfo similarityInfo = TrainLibFactory.buildSimilarityInfo(resolution,score);
        SimilarityLib similarityLib = TrainLibFactory.buildSimilarityLib(classInfo,imagePath, similarityInfo);
        return similarityLib;

    }


    private static void init(){

        LocationLib locationLib1 = createLocationLib(TrainLibFactory.class,"A1/BB/C1.png","1920*1080",1024,768);
        LocationLib locationLib2 = createLocationLib(TrainTest.class,"A2/BB/C2.png","1920*1080",1024,768);


        locationLibCache.put(locationLib1.getClassInfo(),locationLib1);
        locationLibCache.put(locationLib2.getClassInfo(),locationLib2);


        SimilarityLib similarityLib1 = createSimilarityLib(TrainLibFactory.class,"A1/BB/C1.png","1920*1080",0.911);
        SimilarityLib similarityLib2 = createSimilarityLib(TrainTest.class,"A2/BB/C2.png","1920*1080",0.899);

        SimilarityLibCache.put(similarityLib1.getClassInfo(),similarityLib1);
        SimilarityLibCache.put(similarityLib2.getClassInfo(),similarityLib2);

    }

    public static void main(String[] args) {


        try {

            init();

            String path = "temp/LocationLib.json";
            String content = createByBean(createLocationLib(LocationLib.class,"A1/BB/C1.png","1920*1080",1024,768));
            FileUtils.write(new File(path),content);

            path = "temp/SimilarityLib.json";
            content = createByBean(createSimilarityLib(TrainLibFactory.class,"A1/BB/C1.png","1920*1080",0.911));
            FileUtils.write(new File(path),content);

            System.out.println("**********************");

//            long start = System.currentTimeMillis();
//            readJsonFromFile(path);
//            System.out.println(System.currentTimeMillis()-start);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
