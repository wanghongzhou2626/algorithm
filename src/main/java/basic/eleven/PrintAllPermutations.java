package basic.eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 打印一个字符串的全部排列
 * 打印一个字符串的全部排列 并去重 分支限界的方式（提前杀死之路） 还是暴力递归之后用hashSet 去重
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

    /**
     * str[0..i-1] 已经做好了决定
     * str[i...] 后续都有机会来到i位置
     * i位置终止后 str当前的样子 就是一种结果 加入result
     * @param str
     * @param index
     * @param strList
     */

    private static void process(char[] str, int index, ArrayList<String> strList) {
        //base case
        if(index == str.length){
            strList.add(String.valueOf(str));
        }

        for (int i = index; i < str.length; i++) {

            swap(str,index,i);

            process(str,index + 1,strList);
            //因为是递归 最后需要回去  回到定以后 你要要字符串恢复原貌 继续搞搞搞搞  搞事情~~~~
            swap(str,index,i);
        }

    }

    private static void swap(char[] str, int index, int i) {

        char tem = str[index];
        str[index] = str[i];
        str[i] = tem;
    }


    /**
     * 去重的code
     */
    public static List<String> print2(String s){
        if(s == null || s.equals("")){
            return null;
        }
        char[] str = s.toCharArray();
        int index = 0;
        ArrayList<String> strList = new ArrayList();
        process2(str,index,strList);

        return strList;


    }

    /**
     * str[0..i-1] 已经做好了决定
     * str[i...] 后续都有机会来到i位置
     * i位置终止后 str当前的样子 就是一种结果 加入result
     * @param str
     * @param index
     * @param strList
     */

    private static void process2(char[] str, int index, ArrayList<String> strList) {
        //base case
        if(index == str.length){
            strList.add(String.valueOf(str));
        }
        boolean[] visit = new boolean[25];

        for (int i = index; i < str.length; i++) {
            if( ! visit[str[i] - 'a']){
                visit[str[i] - 'a'] = true;
                swap(str,index,i);

                process2(str,index + 1,strList);
                //因为是递归 最后需要回去  回到定以后 你要要字符串恢复原貌 继续搞搞搞搞  搞事情~~~~
                swap(str,index,i);
            }

        }

    }



    /**
     * str[0..i-1] 已经做好了决定
     * str[i...] 后续都有机会来到i位置
     * i位置终止后 str当前的样子 就是一种结果 加入result
     */


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> strList = new ArrayList();
        process2(nums,0,strList);
        return strList;
    }
    private static void process2(int[] str, int index, List<List<Integer>> strList) {
        //base case
        List<Integer> list1 = new ArrayList<Integer>();
        if(index == str.length){
            for (int j = 0; j < str.length; j ++){
                list1.add(str[j]);
            }
            strList.add(list1);
        }

        List<Integer> list = new ArrayList();
        for (int i = index; i < str.length; i++) {
            if(visit(str,i,list)){
                list.add(str[i]);
                swap(str,index,i);

                process2(str,index + 1,strList);
                //因为是递归 最后需要回去  回到定以后 你要要字符串恢复原貌 继续搞搞搞搞  搞事情~~~~
                swap(str,index,i);
            }

        }

    }

    private static void swap(int[] str, int index, int i) {

        int tem = str[index];
        str[index] = str[i];
        str[i] = tem;
    }

    public static boolean visit(int[] str, int i ,List<Integer> list){
        if(list.contains(str[i])){
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
        int[] s = {1,1,2};
         List<List<Integer>> stringList = permuteUnique(s);


        for (List<Integer> s1 : stringList){
            System.out.println(s1);
        }
    }
}
