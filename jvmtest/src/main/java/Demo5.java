import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 用cglib动态生成类，模拟Metaspace触发垃圾回收
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 */
public class Demo5 {
    public static void main(String[] args) {
        long counter = 0;
        while (true) {
            System.out.println("目前创建了" + (++counter) + "个Car类的子类；");
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if (method.getName().equals("run")) {
                        System.out.println("启动汽车之前，先进行自动的安全检查......");
                    }
                    return methodProxy.invokeSuper(o, objects);
                }
            });

            Car car = (Car) enhancer.create();
            car.run();
        }
    }

    static class Car {
        public void run() {
            System.out.println("汽车启动，开始行使......");
        }
    }

    static class SafeCar extends Car {
        @Override
        public void run() {
            System.out.println("汽车启动，开始行使......");
            super.run();
        }
    }
}
