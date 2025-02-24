package dao;

import org.springframework.stereotype.Component;

@Component
public class DaoImplV2 implements IDao{
    @Override
    public double getData(){
        System.out.println("Version web service (v2)");
        double tmp = 12;
        return tmp;
    }
}
