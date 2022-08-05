package com.nqq.maven.test.service;

import java.util.concurrent.Future;

/**
 * @author Nie QiQiang
 * @InterfaceName AsyncService
 * @Date 2022/8/1 14:51
 * @deprecated 测试异步服务层接口
 */
public interface AsyncService {

    /**
     * 睡眠 返回String
     */
    public Future<String> testSleepResult();

}
