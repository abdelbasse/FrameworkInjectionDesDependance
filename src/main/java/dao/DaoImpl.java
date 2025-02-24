package dao;

public class DaoImpl implements IDao{
    @Override
    public double getData(){
        System.out.println("Version base de donne (v1)");
        double tmp = 23;
        return tmp;
    }
}
