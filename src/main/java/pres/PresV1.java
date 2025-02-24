package pres;

import dao.DaoImpl;
import dao.DaoImplV2;
import metier.IMetier;
import metier.MetierImpl;

public class PresV1 {

    public static void main(String[] args) {
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
        double callRes;
        try {
            callRes = metier.calcul();
            System.out.println("Calculation Result is: " + callRes);
        }catch (Exception e){
            System.out.println("Somthing went wrong! \n>Erreur : ");
            System.out.println(e.getMessage());
        }
    }
}
