package com.fu.springbootdemo;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作用域值
 * JEP 506 提供了轻量级、不可变、线程安全的 ThreadLocal 替代方案。专为与虚拟线程协同工作设计
 * 作用域值设计用于以安全、高性能、不可变的方式在调用链中传递上下文。
 * 它们特别适合虚拟线程和结构化并发，通过避免内存泄漏和同步开销，提供了比 ThreadLocal 更高效的替代方案。
 * 注意：当作用域值与虚拟线程一起使用时，访问作用域值的逻辑必须包装在 ScopedValue.where(...).run(...) 作用域内。
 * 仅将任务提交到作用域内的执行器是不够的，任务本身必须在作用域内创建以保留绑定。
 */
public class ScopedValueTests {
    private static final ScopedValue<Map<String, Object>> USER_INFO = ScopedValue.newInstance();
    private static final Map<String, Object> Meta39 = Map.of("userId", 1,"name", "Meta39");
    private static final Map<String, Object> ZhangSan = Map.of("userId", 2,"name", "ZhangSan");

    @Test
    void scopedValueTest(){
        ScopedValue.where(USER_INFO, Meta39).run(() -> {
            System.out.println("Thread: " + Thread.currentThread());
            System.out.println("User: " + USER_INFO.get());
        });
        System.out.println(USER_INFO.get());
    }

    @Test
    void scopedValueVirtualThreadTest() {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            executorService.submit(() -> ScopedValue.where(USER_INFO, Meta39).run(() -> {
                System.out.println("Thread: " + Thread.currentThread());
                System.out.println("User: " + USER_INFO.get().toString());
            }));

            executorService.submit(() -> ScopedValue.where(USER_INFO, ZhangSan).run(() -> {
                System.out.println("Thread: " + Thread.currentThread());
                System.out.println("User: " + USER_INFO.get());
            }));
        }
    }

}
