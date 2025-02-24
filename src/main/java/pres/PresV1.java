package pres;

import dao.DaoImpl;
import metier.IMetier;
import metier.MetierImpl;

public class PresV1 {

    public static void main(String[] args) {
        // Create an instance of MetierImpl
        MetierImpl metierInst = new MetierImpl();

        // Inject a DaoImpl instance
        metierInst.setDao(new DaoImpl());

        // Use the IMetier interface reference
        IMetier metier = metierInst;

        // Perform calculation and print result
        double callRes = metier.calcul();
        System.out.println("Calculation Result is: " + callRes);
    }
}
