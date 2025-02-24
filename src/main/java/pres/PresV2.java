package pres;

import dao.DaoImpl;
import dao.DaoImplV2;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PresV2 {

    public static void main(String[] args) {
        // Create a Scanner object to capture user input
        Scanner scanner = new Scanner(System.in);

        // Ask user to select the code version to execute
        System.out.println("Please select which version you want to run:");
        System.out.println("1. Static Version");
        System.out.println("2. Dynamic Version (Reflection)");
        System.out.println("3. Spring Version (XML)");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = scanner.nextInt();

        // Run corresponding code based on user choice
        switch (choice) {
            case 1:
                // Run Static Version (Instantiating Dao directly)
                runStaticVersion();
                break;

            case 2:
                // Run Dynamic Version (Reflection-based)
                runDynamicVersion();
                break;

            case 3:
                // Run Spring Version (assuming Spring config is set up properly)
                runSpringVersionXml();
                break;

            default:
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
        }
    }

    // Static Version Method: Directly creating instances of Dao and Metier
    private static void runStaticVersion() {
        // Create an instance of MetierImpl
        MetierImpl metierInst = new MetierImpl();

        // Inject a DaoImpl instance
        // old code using DAO v1
        metierInst.setDao(new DaoImpl());
        // new code using DAO v2
        metierInst.setDao(new DaoImplV2());

        // Use the IMetier interface reference
        IMetier metier = metierInst;

        // Perform calculation and print result
        try {
            double callRes = metier.calcul();
            System.out.println("Calculation Result (Static Version): " + callRes);
        } catch (Exception e) {
            System.out.println("Something went wrong in Static Version! \n>Erreur: " + e.getMessage());
        }
    }

    // Dynamic Version Method: Using reflection to instantiate Dao and Metier classes
    private static void runDynamicVersion() {
        try {
            // Create Scanner to read configuration from file
            Scanner cn = new Scanner(new File("config.txt"));
            String daoClassName = cn.nextLine();
            String metierClassName = cn.nextLine();

            // Load Dao class dynamically using reflection
            Class cDao = Class.forName(daoClassName);
            IDao oDao = (IDao) cDao.getDeclaredConstructor().newInstance();

            // Load Metier class dynamically and inject Dao instance using constructor
            Class cMetier = Class.forName(metierClassName);
            IMetier oMetier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(oDao);

            // Perform calculation and print result
            double callRes = oMetier.calcul();
            System.out.println("Calculation Result (Dynamic Version): " + callRes);
        } catch (Exception e) {
            System.out.println("Something went wrong in Dynamic Version! \n>Erreur: " + e.getMessage());
        }
    }

    // Spring Version Method: Assuming Spring configuration XML is set up
    private static void runSpringVersionXml() {
        try {
            // Load Spring context from XML configuration
            ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

            // Retrieve the 'metier' bean from the Spring context
            IMetier metier = context.getBean("metier", IMetier.class);

            // Perform calculation and print result
            double callRes = metier.calcul();
            System.out.println("Calculation Result (Spring Version): " + callRes);
        } catch (Exception e) {
            System.out.println("Something went wrong in Spring Version! \n>Erreur: " + e.getMessage());
        }
    }

}
