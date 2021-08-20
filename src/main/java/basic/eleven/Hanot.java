package basic.eleven;


/**
 * @author whz
 */
public class Hanot {


    public static void hanoi1(int n){
        //你想干啥 从左移动到右
        leftToRight(n);
    }

    private static void leftToRight(int n) {
        if(n == 1){
            System.out.println("move 1 from left to right");
            return;
        }
        // 1-n-1 左移动到中间
        leftToMid(n-1);
        // n 左移动到右
        System.out.println("move " + n + "from left to right");
        //1 - n-1中间移动到右边
        midToRight(n-1);


    }



    private static void leftToMid(int n) {
        //怎么把n 从左移动到中间
        if(n == 1){
            System.out.println("move 1 from left to mid");
            return;
        }
        // 1 -> n-1 从左移动到右
        leftToRight(n-1);
        System.out.println("move " + n + "from left to mid");
        //1 -> n-1 从右移动到中间
        rightToMid(n-1);


    }

    private static void rightToMid(int n) {
        //怎么把n从 右移动到中间
        if(n == 1){
            System.out.println("move 1 from right to mid");
            return;
        }
        // 1 -> n-1 从右 移动到 左
        rightToLeft(n-1);
        System.out.println("move " + n + "from right to mid");
        leftToMid(n - 1);


    }

    private static void rightToLeft(int n) {
        //怎么把 n 从 右 移动 到左
        if(n == 1){
            System.out.println("move 1 from right to left");
            return;
        }
        // 1 -> n-1 从右移动到中间
        rightToMid(n - 1);
        System.out.println("move " + n + "right to left");
        midToLeft(n - 1);

    }

    private static void midToLeft(int n) {
        //怎么把 n 从 中间 移动到 左边
        if(n == 1){
            System.out.println("move 1 from mid to left");
            return;
        }
        // 1-> n-1 中间移动到右边
        midToRight(n-1);
        System.out.println("move " + n + "from mid to left");
        rightToLeft(n -1 );

    }

    private static void midToRight(int n) {
        //怎么把 n 从 中间 移动到 右边
        if(n == 1){
            System.out.println("move 1 from mid to right");
            return;
        }
        // 1-> n-1 中间移动到左边
        midToLeft(n-1);
        System.out.println("move " + n + "from mid to right");
        leftToRight(n -1 );

    }

    public static void hanoi2(int n) {
        if (n > 0) {
            func(n, "left", "right", "mid");
        }
    }

    public static void func(int N, String from, String to, String other) {
        if (N == 1) { // base
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            func(N - 1, from, other, to);
            System.out.println("Move " + N + " from " + from + " to " + to);
            func(N  - 1, other, to, from);
        }
    }


    public static void main(String[] args) {
        int n = 10;
        hanoi1(n);
    }
}
