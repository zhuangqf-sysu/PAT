package test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;

/**
 * @author zhuangqf
 * @date 2018/8/9
 */
public class MemoryTest {

    static String mb(long s) {
        return String.format("%d (%.2f M)", s, (double) s / (1024 * 1024));
    }

    public static void main(String[] args) {
        System.out.println("Runtime Memory:");
        System.out.println("Max:  " + mb(Runtime.getRuntime().maxMemory()));
        System.out.println("Total:" + mb(Runtime.getRuntime().totalMemory()));
        System.out.println("Free:" + mb(Runtime.getRuntime().freeMemory()));

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        MemoryUsage headUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.println("Heap Memory:");
        System.out.println("Max:  " + mb(headUsage.getMax()));
        System.out.println("Committed:" + mb(headUsage.getCommitted()));
        System.out.println("Usage:" + mb(headUsage.getUsed()));
        System.out.println("Init:" + mb(headUsage.getInit()));

        MemoryUsage nonHeadUsage = memoryMXBean.getNonHeapMemoryUsage();
        System.out.println("Non-Heap Memory:");
        System.out.println("Max:  " + mb(nonHeadUsage.getMax()));
        System.out.println("Committed:" + mb(nonHeadUsage.getCommitted()));
        System.out.println("Usage:" + mb(nonHeadUsage.getUsed()));
        System.out.println("Init:" + mb(nonHeadUsage.getInit()));

        for (MemoryPoolMXBean mp : ManagementFactory.getMemoryPoolMXBeans()) {
            System.out.println("Pool: " + mp.getName() + " (type " + mp.getType() + ")" + " = " + mb(mp.getUsage().getMax()));
        }
    }

}
