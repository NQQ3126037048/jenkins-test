package com.nqq.maven.test.service.impl;

import com.nqq.maven.test.service.AsyncService;
import com.nqq.maven.test.service.AsyncTestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.concurrent.Future;

/**
 * @author Nie QiQiang
 * @ClassName AsyncServiceImpl
 * @Date 2022/8/1 14:52
 * @deprecated
 */
@Service
public class AsyncServiceImpl implements AsyncService, AsyncTestService {

    @Override
    @Async
    public Future<String> testSleepResult() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(LocalTime.now() + "  testSleep 执行结束");
        return new AsyncResult<>("hello");
    }

    @Override
    @Async
    public void testSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(LocalTime.now() + "  testSleep 执行结束 -- 接口隔离");
    }
}
