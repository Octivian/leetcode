package interview;

public class SwapTwoVariablesWithoutTemp {

    public static void main(String[] args) {
        int x = 1;
        int y = 23;

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println(x);
        System.out.println(y);
    }
}
