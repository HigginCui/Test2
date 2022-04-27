package com.higgincui.DesignMode;

/**
 * @author cuixinjie
 * @date 2022/4/12 下午4:53
 */
public class Single {

    public static void main(String[] args) {
        DoubleCheckSingle single1 = DoubleCheckSingle.getInstance();
        DoubleCheckSingle single2 = DoubleCheckSingle.getInstance();

        System.out.println(single1);
        System.out.println(single2);

    }

}

/**
 * 双重检查单例模式
 * 使用volatile关键字的2个好处
 * 1.保证可见性
 * 2.禁止指令重排序
 * 对象创建过程有3个步骤
 *  a.分配内存空间
 *  b.调用构造器，初始化实例
 *  c.返回内存地址给引用
 *  在没有禁止指令重排序的情况下，"调用构造器，初始化实例"和"返回内存地址给引用"了能会错乱，导致线程直接返回空值
 */
class DoubleCheckSingle {


    private static volatile DoubleCheckSingle instance= null;

    private DoubleCheckSingle(){}

    public static DoubleCheckSingle getInstance(){
        if(instance==null){
            /** 为什么要双重检查，因为两个线程A，B可能同时到达这里，
             * 如果A线程创建完成后，并且完成了实例化，释放锁，
             * 过一会B线程获取锁之后，因为不可见没有看到实例化，B线程依然会去实例化**/
            synchronized (DoubleCheckSingle.class){
                if(instance==null){
                    instance = new DoubleCheckSingle();
                }
            }
        }
        return instance;
    }
}
