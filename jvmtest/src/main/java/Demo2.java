// -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
// 模拟对下该如何从新生代进入老年代
public class Demo2 {

    public static void main(String[] args) {
        byte[] array1 = new byte[2*1024*1024];
        array1 = new byte[2*1024*1024];
        array1 = new byte[2*1024*1024];
        array1 = null;

        byte[] array2 = new byte[128*1024];

        /*触发Yong GC*/
        byte[] array3 = new byte[2*1024*1024];

        /* 此时s1区域总大小是1MB  存活对象已经超过了50% */
        /* Eden区域有array3的2MB */


        array3 = new byte[2*1024*1024];
        array3 = new byte[2*1024*1024];
        array3 = new byte[128*1024];
        array3 = null;

        /*  此时装不下array4  触发Young GC */
        byte[] array4 = new byte[2*1024*1024];
    }
}
