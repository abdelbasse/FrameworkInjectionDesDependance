import dao.DaoImpl;
import dao.IDao;

public class Main {
    public static void main(String[] args) {
        IDao my_object = new DaoImpl();
        System.out.println(my_object.getData());
    }
}