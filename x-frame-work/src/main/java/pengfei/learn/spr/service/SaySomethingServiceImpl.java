package pengfei.learn.spr.service;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SaySomethingServiceImpl implements SaySomethingService {

    @Resource
    private DoService doService;

    public SaySomethingServiceImpl() {
        System.out.println("====== say something init ============");
    }

    @Override
    public String sayHello() {
        return "Hello" + doService.doSomething();
    }
}
