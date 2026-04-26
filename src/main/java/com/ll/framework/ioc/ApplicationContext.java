package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    private TestPostService testPostService;
    private TestPostRepository testPostRepository;

    public ApplicationContext() {

    }

    @SuppressWarnings("unchecked")
    public <T> T genBean(String beanName) {
        if ("testPostRepository".equals(beanName)) {
            if (testPostRepository == null) {
                testPostRepository = new TestPostRepository();
            }

            return (T) testPostRepository;
        }

        if ("testPostService".equals(beanName)) {
            if (testPostService == null) {
                testPostService = new TestPostService(genBean("testPostRepository"));
            }

            return (T) testPostService;
        }

        if ("testFacadePostService".equals(beanName)) {
            return (T) new TestFacadePostService(
                    genBean("testPostService"),
                    genBean("testPostRepository")
            );
        }


        return null;
    }
}
