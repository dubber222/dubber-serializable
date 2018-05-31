package com.dubber.serializable.clone;

/**
 *
 * @author dubber
 * @date 2018/5/31
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //浅克隆
        new CloneTest().shallowclone();

        //深度克隆
        new CloneTest().deepclone();
    }


    private void shallowclone() throws CloneNotSupportedException {
        Email email = new Email();
        email.setContent("今晚上线！");

        Leader leader = new Leader();
        leader.setTaskName("测试人员");
        leader.setEmail(email);

        //浅克隆
        Leader leader1 = leader.clone();
        leader1.setTaskName("开发人员");
        leader1.getEmail().setContent("可以回家！");

        /**
         *  浅克隆造成的结果：  测试人员 可以回家
         *                   开发人员 可以回家
         *
         *
         *  ……
         *  老板： fuck ,谁他妈上线。 都滚犊子了。
         */
        System.out.println(leader.toString());
        System.out.println(leader1.toString());
    }


    private void deepclone() throws CloneNotSupportedException {
        Email email = new Email();
        email.setContent("今晚上线！");

        Leader leader = new Leader();
        leader.setTaskName("测试人员");
        leader.setEmail(email);

        //浅克隆
        Leader leader1 = leader.deepClone();
        leader1.setTaskName("开发人员");
        leader1.getEmail().setContent("可以回家！");
        System.out.println(leader.toString());
        System.out.println(leader1.toString());
    }
}
