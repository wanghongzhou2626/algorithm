package basic.eleven;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * /**
 *  *
 *  * n 皇后问题  n=4 以后才有解
 *
 * @author whz
 */
public class NQueens {


    public static int operationNum(int n){

        int[] record = new int[n];
        return process(0,record,n);
    }

    private static int process(int i, int[] record, int n) {
        //走到数组末尾了 算一种解法
        if(i == n){
           return 1;
        }
        int res = 0;
        for (int j = 0; j < n;j++){
            //i代表行 j代表列
            if(validate(record,i,j)){
                record[i] = j;
                res = res + process(i+1,record,n);
            }

        }
        return res;


    }

    private static boolean validate(int[] record, int i,int j) {

        for (int k = 0; k < i; k++){
            if(record[k] == j || Math.abs(k - i ) == Math.abs(record[k] - j)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int i = operationNum(3);
        System.out.println(i);
    }

}
