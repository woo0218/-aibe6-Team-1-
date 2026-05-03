package com.ll.domain.testPost.testPost.service;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.framework.ioc.ApplicationContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestFacadePostService {
    public final TestPostRepository testPostRepository;
    public final TestPostService testPostService;

    public TestFacadePostService(){
        testPostRepository = new TestPostRepository();
        testPostService = new TestPostService(testPostRepository);
    }
}
