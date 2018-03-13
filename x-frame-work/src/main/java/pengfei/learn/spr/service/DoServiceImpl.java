package pengfei.learn.spr.service;


import org.springframework.stereotype.Service;

@Service
public class DoServiceImpl implements DoService{

    public DoServiceImpl() {
        System.out.println(">>>>>>>>>>>>>>>>> do something init >>>>>>>>>>>>");
    }

    @Override
    public String doSomething() {
        return "done";
    }
}
