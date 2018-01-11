package designPattern;

/**
 * Created by QZidane on 2017/9/1.
 */
public class StrategyClient {

    public static void main(String... args) {
        int a = 100;
        int b = 90;
        int result;
        String symbol = "+";
        for (Calculator calculator : Calculator.values()) {
            if (calculator.getValue().equals(symbol)) {
                result = calculator.exec(a, b);
            }
        }
    }
}
