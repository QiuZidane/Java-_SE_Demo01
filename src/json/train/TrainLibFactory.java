package json.train;

import java.util.HashMap;
import java.util.Map;

public class TrainLibFactory extends TrainLibUtil {


    public static LocationInfo buildLocationInfo(String resolution, int x, int y) {

        return new LocationInfo()
                .setResolution(resolution)
                .setCoordinateX(x)
                .setCoordinateY(y);

    }

    public static SimilarityInfo buildSimilarityInfo(String resolution, double score) {

        return new SimilarityInfo()
                .setResolution(resolution)
                .addScore(score);

    }


    public static ClassInfo buildClassInfo(Class clazz) {

        return new ClassInfo().setName(clazz.getName())
                .setSimpleName(clazz.getSimpleName())
                .setUpdateTime("2018-02-18");

    }

    /**
     * 创建坐标库
     */
    public static LocationLib buildLocationLib(ClassInfo classInfo, String imagePath, LocationInfo locationInfo) {

        Map<String, LocationInfo> locationInfoMap = new HashMap<>();
        locationInfoMap.put(getResolutionDesc(locationInfo.getResolution()), locationInfo);

        return (LocationLib) new LocationLib()
                .putLocationInfoMap(getImageDesc(imagePath), locationInfoMap)
                .setClassInfo(classInfo);


    }

    /**
     * 创建精度库
     */
    public static SimilarityLib buildSimilarityLib(ClassInfo classInfo, String imagePath, SimilarityInfo similarityInfo) {

        Map<String, SimilarityInfo> similarityInfoMap = new HashMap<>();
        similarityInfoMap.put(getResolutionDesc(similarityInfo.getResolution()),similarityInfo);

        return (SimilarityLib) new SimilarityLib()
                .putSimilarityInfoMap(getImageDesc(imagePath), similarityInfoMap)
                .setClassInfo(classInfo);
    }

}
