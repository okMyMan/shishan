// -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log

// 输出GC日志
// 模拟因为Survior放不下  直接放入老年代的场景
public class Demo3 {

    public static void main(String[] args) {
        byte[] array1 = new byte[2*1024*1024];
        array1 = new byte[2*1024*1024];
        array1 = new byte[2*1024*1024];

        byte[] array2 = new byte[128*1024];
        array2 = null;

        byte[] array3 = new byte[2*1024*1024];
    }
}
