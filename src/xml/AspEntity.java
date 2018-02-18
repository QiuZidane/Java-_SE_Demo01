package xml;

public class AspEntity {
    private String className;
    private String classSimpleName;
    private String methodName;
    private String[] args;
    private String aopAdice;
    private int priority;

    public String getClassName() {
        return className;
    }

    public AspEntity setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getClassSimpleName() {
        return classSimpleName;
    }

    public AspEntity setClassSimpleName(String classSimpleName) {
        this.classSimpleName = classSimpleName;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public AspEntity setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public String[] getArgs() {
        return args;
    }

    public AspEntity setArgs(String[] args) {
        this.args = args;
        return this;
    }

    public String getAopAdice() {
        return aopAdice;
    }

    public AspEntity setAopAdice(String aopAdice) {
        this.aopAdice = aopAdice;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public AspEntity setPriority(int priority) {
        this.priority = priority;
        return this;
    }
}
