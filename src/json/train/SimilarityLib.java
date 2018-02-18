package json.train;

import java.util.HashMap;
import java.util.Map;

public class SimilarityLib extends TrainLib {

    // 第一个key=图片信息(默认为image#[图片路径])， 第二个key=分辨率信息(默认为res#[分辨率])
    private Map<String, Map<String, SimilarityInfo>> similarityInfos;

    SimilarityLib() {
        this.similarityInfos = new HashMap<>();
    }


    public Map<String, Map<String, SimilarityInfo>> getSimilarityInfos() {
        return similarityInfos;
    }

    public SimilarityLib setSimilarityInfos(Map<String, Map<String, SimilarityInfo>> similarityInfos) {
        this.similarityInfos = similarityInfos;
        return this;
    }

    public SimilarityLib putSimilarityInfoMap(String resolutionDesc, Map<String, SimilarityInfo> infoMap) {
        this.similarityInfos.put(resolutionDesc, infoMap);
        return this;
    }


}
