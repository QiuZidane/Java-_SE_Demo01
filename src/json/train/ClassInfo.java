package json.train;

public class ClassInfo {
    private String name;
    private String simpleName;
    private String updateTime;

    public String getName() {
        return name;
    }

    public ClassInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public ClassInfo setSimpleName(String simpleName) {
        this.simpleName = simpleName;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public ClassInfo setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
}
