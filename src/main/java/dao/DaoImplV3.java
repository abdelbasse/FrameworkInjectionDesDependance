package dao;

public class DaoImplV3 implements IDao{
    @Override
    public double getData(){
        System.out.println("Version XML (v3)");
        double tmp = 12;
        return tmp;
    }
}
