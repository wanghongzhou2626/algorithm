package basic.eight;

import java.util.List;

/**
 * @author whz
 *
 *派队最大快乐值
 *
 * ​	公司的每个员工都符合Employee类的描述。整个公司的人员结构可以看作是一颗标准的，没有环的多叉树、树的头节点是公司唯一的老板。除老板之外的每个员工都有唯一的直接上级。叶节点是没有任何下属的基层员工，除了基层员工外，每个员工都有一个或者多个直接下级。
 *
 * ​	这个公司现在要办party 你可以决定哪些员工来，哪些员工不来，规则：
 *
 * ​	1.如果某个员工来了。那么这个员工所有直接下级都不能来
 *
 * ​	2.派对的整体快乐值是所有到场员工快乐值的累加
 *
 * ​	3.你的目标是让派对的整体快乐值尽量大
 *
 * ​	给定一颗多叉树的头节点boss，请返回派对的最大快乐值。
 *
 * ​	结构如下：class Employee{
 *
 * ​						public int happy;
 *
 * ​						List<Employee> suborfinates;
 *
 * ​					}
 *
 */
public class Review_MaxHappyValue {


    public static class Employee{

        public int happy;
        //员工对应的下属
        List<Employee> subordinates;
    }


    public static class Info{
        /**
         * 去或者不去获得的最大快乐值
         */
        int yes;
        int no;

        public Info(int yes,int no){
            this.yes = yes;
            this.no = no;
        }
    }


    public static int getMaxHappy(Employee employee){
        Info info = process(employee);
        return Math.max(info.yes,info.no);
    }

    private static Info process(Employee employee) {
        if(employee.subordinates == null){
            return new Info(0,0);
        }
        int no = 0;
        int yes = employee.happy;
        for (Employee nextEmp : employee.subordinates) {
            Info info = process(nextEmp);
            yes += info.no;
            no += Math.max(info.yes,info.no);
        }
        return new Info(yes,no);

    }
}
