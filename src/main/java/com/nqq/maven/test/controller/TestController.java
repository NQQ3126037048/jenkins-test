package com.nqq.maven.test.controller;

import com.nqq.maven.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author Nie QiQiang
 * @ClassName TestController
 * @Date 2022/7/29 15:24
 * @deprecated 测试控制层
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/show")
    public String show(){
        return "hello word";
    }
    
    @GetMapping("/")
    public String showRoot(){
        return "hello word - root";
    }

    @GetMapping("/asyncTest")
    public String asyncTest(@RequestParam("loopVariable") Integer loopVariable) throws ExecutionException, InterruptedException {
        return testService.asyncTest(loopVariable);
    }

}
