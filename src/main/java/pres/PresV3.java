package pres;

import dao.DaoImpl;
import dao.DaoImplV2;
import metier.IMetier;
import metier.MetierImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class PresV3 {

    public static void main(String[] args) {
        // Initialize Spring Application Context
        ApplicationContext context = new AnnotationConfigApplicationContext("dao", "metier");

        // Get the MetierImpl bean managed by Spring
        IMetier metier = context.getBean(IMetier.class);

        // Perform calculation and print result
        double callRes;
        try {
            callRes = metier.calcul();
            System.out.println("Calculation Result is: " + callRes);
        } catch (Exception e) {
            System.out.println("Something went wrong! \n> Error: ");
            System.out.println(e.getMessage());
        }
    }
}
