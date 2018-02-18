package json.train;

import java.util.ArrayList;
import java.util.List;

public class SimilarityInfo {

    private String resolution; // 分辨率
    private List<Double> scores;

    public SimilarityInfo(){
        this.scores = new ArrayList<>();
    }

    public String getResolution() {
        return resolution;
    }

    public SimilarityInfo setResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }

    public List<Double> getScores() {
        return scores;
    }

    public SimilarityInfo addScore(double score) {
        this.scores.add(score);
        return this;
    }
}
