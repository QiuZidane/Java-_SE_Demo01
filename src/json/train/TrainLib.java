package json.train;

public abstract class TrainLib {

    protected ClassInfo classInfo;
    protected boolean isModified;  // 是否有修改， 有修改则在动作完毕后反写文件

    TrainLib(){
        isModified = false;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public TrainLib setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
        return this;
    }

    public boolean isModified() {
        return isModified;
    }

    public TrainLib setModified(boolean modified) {
        isModified = modified;
        return this;
    }

}
