package json.train;

public class LocationInfo {

    private String resolution; // 分辨率
    private int coordinateX;
    private int coordinateY;


    public String getResolution() {
        return resolution;
    }

    public LocationInfo setResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public LocationInfo setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
        return this;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public LocationInfo setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
        return this;
    }
}
