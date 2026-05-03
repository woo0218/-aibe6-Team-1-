package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    private static TestFacadePostService testFacadePostService;
    private static TestPostRepository testPostRepository;
    private static TestPostService testPostService;

    public ApplicationContext() {
        testFacadePostService = new TestFacadePostService();
        testPostRepository = testFacadePostService.testPostRepository;
        testPostService = testFacadePostService.testPostService;
    }

    public <T> T genBean(String beanName) {
        return (T) switch(beanName){
            case("testPostService") -> testPostService;
            case("testPostRepository") -> testPostRepository;
            case("testFacadePostService") -> testFacadePostService;
            default -> null;
        };
    }
}
