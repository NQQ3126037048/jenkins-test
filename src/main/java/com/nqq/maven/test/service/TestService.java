package com.nqq.maven.test.service;

import java.util.concurrent.ExecutionException;

/**
 * @author Nie QiQiang
 * @ClassName TestService
 * @Date 2022/8/1 14:48
 * @deprecated 测试服务层接口
 */
public interface TestService {

    String asyncTest(Integer loopVariable) throws ExecutionException, InterruptedException;

}
