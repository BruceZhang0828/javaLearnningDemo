package lang;

/**
 * @ClassName: String
 * @Description: 双亲委派机制的作用
 * @auther: zhy
 * @Date: 2019/11/22 10:38
 * @Version: 1.0
 **/
public class String {
    public static void main(String[] args) {
        //可以正常编译，但是永远无法被加载运行
        String s = new String();
    }
}
