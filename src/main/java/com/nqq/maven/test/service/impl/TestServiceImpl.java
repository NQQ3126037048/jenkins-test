package com.nqq.maven.test.service.impl;

import com.nqq.maven.test.service.AsyncService;
import com.nqq.maven.test.service.AsyncTestService;
import com.nqq.maven.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Nie QiQiang
 * @ClassName TestServiceImpl
 * @Date 2022/8/1 14:53
 * @deprecated
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private AsyncTestService asyncTestService;

    @Override
    public String asyncTest(Integer loopVariable) throws ExecutionException, InterruptedException {
        System.out.println("参数 - " + loopVariable);
        long start = System.currentTimeMillis();
        List<Future<String>> futureList = new ArrayList<>();
        loopVariable = Math.max(loopVariable,1);
        for (int i = 0; i < loopVariable; i++) {
            futureList.add(asyncService.testSleepResult());
        }
        StringBuilder result = new StringBuilder();
        for (Future<String> future : futureList) {
            result.append("-").append(future.get());
        }
//        asyncService.testSleep();
        System.out.println(LocalTime.now() + " - " + result);
        result.append("<br/><br/>耗时 毫秒：" + (start - System.currentTimeMillis()));
        asyncTestService.testSleep();
        return result.substring(1);
    }
}
