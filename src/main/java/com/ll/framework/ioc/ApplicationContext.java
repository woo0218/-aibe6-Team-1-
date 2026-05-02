package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private final TestPostService testPostService;
    private final TestPostRepository testPostRepository;
    private final TestFacadePostService testFacadePostService;
    private final Map<String, Object> beans = new HashMap<>();

    public ApplicationContext() {

        testPostRepository = new TestPostRepository();
        testPostService = new TestPostService(testPostRepository);
        testFacadePostService = new TestFacadePostService(testPostService, testPostRepository);


        beans.put("testPostRepository", testPostRepository);
        beans.put("testPostService", testPostService);
        beans.put("testFacadePostService", testFacadePostService);
    }

//    public <T> T genBean(String beanName) {
//        if(beanName.equals("testPostService")){
//            return (T) testPostService;
//        }
//        return null;
//    }

    //genBean을 단순화하기 위해 Map을 도입하여 beanName과 객체를 매핑하는 방식으로 변경
    public <T> T genBean(String beanName){
        return (T) beans.get(beanName);
    }
}
