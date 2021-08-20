package basic.eleven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author whz
 *
 * 打印一个字符串的全部子序列
 *
 * 子串 与 子序列 有什么区别
 *
 * 字串指的是必须为连续的一串  比如 abcd 的字串 已0位置为开始  a ab  abc abcd  已b开头  b bc bcd  以c开头 c cd  以d开头 d
 *
 * 子序列并不是全排列  每个位置字符要不要都走一遍 但是元素的相对位置不能改动   abc 中 ba不是子序列
 *
 *                            a（0）
 *                要b（1）              b不要（1）
 *          要c（2）     不要c（2）  要c（2）     不要c（2）
 *
 *                      其实就是深度优先遍历
 *
 */
public class PrintAllSubSquences {

    public static List print(String s){
        //字符串转数组
        char[] chars = s.toCharArray();
        List<String> ans = new ArrayList();
        int index = 0;
        String path = "";
        process(chars,index, ans, path);
        return ans;


    }

    public static void process(char[] chars, int index, List<String> ans,String path){
        if(index == chars.length){
            if(path != ""){
                ans.add(path);
            }
            return;
        }
        //不选择当前这条路的情况下  说白了 先走一条不选择的路到底 只想不下去了 在走选择的路  然后在网上返
        String no = path;
        process(chars,index + 1,ans,no);
        String yes = path + String.valueOf(chars[index]);
        process(chars,index + 1,ans,yes);
    }




    public static List print2(String s){
        //字符串转数组
        char[] chars = s.toCharArray();
        HashSet<String> ans = new HashSet();
        int index = 0;
        String path = "";
        process2(chars,index, ans, path);
        List<String> list = new ArrayList<String>();
        for (String s1: ans) {
            list.add(s1);

        }
        return list;


    }

    public static void process2(char[] chars, int index, HashSet<String> ans,String path){
        if(index == chars.length){
            if(path != ""){
                ans.add(path);
            }
            return;
        }
        //不选择当前这条路的情况下  说白了 先走一条不选择的路到底 只想不下去了 在走选择的路  然后在网上返
        String no = path;
        process2(chars,index + 1,ans,no);
        String yes = path + String.valueOf(chars[index]);
        process2(chars,index + 1,ans,yes);
    }





    public static void main(String[] args) {
        String s = "abcccc";
        List<String> print = print2(s);

        for (String str : print) {
            System.out.println(str);
        }
    }





}
