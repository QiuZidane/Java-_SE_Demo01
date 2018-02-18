package testng;

import org.testng.annotations.Test;

public class TestData {

    private String name;
    private int order;

    public String getName() {
        return name;
    }

    public TestData setName(String name) {
        this.name = name;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public TestData setOrder(int order) {
        this.order = order;
        return this;
    }

    @Test
    public void test(){
        System.out.println("order="+order);
        System.out.println("Name="+name);
    }
}
