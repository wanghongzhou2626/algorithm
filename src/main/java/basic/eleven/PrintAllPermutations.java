package basic.eleven;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全部排列
 *                                                       [abc]
 *                                    0 a 0              1 b 0                         2 c 0
*                                    [abc]              [bac]                         [cba]
 *                  1 b 1                  1 b 2    1 a 1       1 a 2          1 b 1         1 b 2
 *                  [abc]                  [acb]    [bac]       [bca]          [cba]         [cab]
 *             2 c 2                       2 b 2    2 c 2       2 a 2          2 a 2         2 b 2
 *             [abc]                       [acb]    [bac]       [bca]          [cba]         [cab]
 *             树的每一个分支 就相当于从某一个点出发的所有可能性  然后再回到起点继续这个过程  深度优先遍历
 * @author whz
 */
public class PrintAllPermutations {


    public static List<String> print(String s){
        if(s == null || s.equals("")){
            return null;
        }
        char[] str = s.toCharArray();
        int index = 0;
        ArrayList<String> strList = new ArrayList();
        process(str,index,strList);

        return strList;


    }

    private static void process(char[] str, int index, ArrayList<String> strList) {
        //base case
        if(index == str.length){
            strList.add(String.valueOf(str));
        }

        for (int i = index; i < str.length; i++) {

            swap(str,index,i);

            process(str,index + 1,strList);

            swap(str,index,i);
        }

    }

    private static void swap(char[] str, int index, int i) {

        char tem = str[index];
        str[index] = str[i];
        str[i] = tem;
    }


    public static void main(String[] args) {
        String s = "abcdefhijk";
        List<String> stringList = print(s);

        for (String s1 : stringList){
            System.out.println(s1);
        }
    }
}
