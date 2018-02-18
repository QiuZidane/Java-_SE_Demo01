package json.train;

import java.util.HashMap;
import java.util.Map;

/**
 * 坐标库对象
 */
public class LocationLib extends TrainLib{

    // 第一个key=图片信息(默认为image#[图片路径])， 第二个key=分辨率信息(默认为res#[分辨率])
    private Map<String, Map<String, LocationInfo>> locationInfos;


    LocationLib() {
        this.locationInfos = new HashMap<>();

    }

    /**
     * 获取对应图片路径+分辨率的坐标信息
     * @param imagePath
     * @param resolution
     * @return
     */
    public LocationInfo getLocationInfo(String imagePath, String resolution){
        return this.locationInfos.get(TrainLibFactory.getImageDesc(imagePath)).get(TrainLibFactory.getResolutionDesc(resolution));
    }

    public Map<String, Map<String, LocationInfo>> getLocationInfos() {
        return locationInfos;
    }

    public LocationLib putLocationInfoMap(String resolutionDesc, Map<String, LocationInfo> infoMap) {
        this.locationInfos.put(resolutionDesc, infoMap);
        return this;
    }


}
