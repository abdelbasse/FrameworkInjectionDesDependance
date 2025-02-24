package metier;

import dao.DaoImpl;
import dao.IDao;

/**
 * Business logic implementation class that depends on an IDao instance
 * to fetch data and perform calculations.
 */
public class MetierImpl implements IMetier {

    // Dependency on IDao for data retrieval
    private IDao dao;

    /**
     * Default constructor: Initializes with a new instance of DaoImpl.
     * This makes the class tightly coupled with DaoImpl.
     */
    public MetierImpl() {
        this.dao = new DaoImpl();
    }

    /**
     * Constructor with dependency injection: Allows setting a custom implementation of IDao.
     * This promotes flexibility, enabling different data sources (e.g., JDBC, MongoDB).
     *
     * @param dao The IDao implementation to use.
     */
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    /**
     * Performs a calculation using data retrieved from the DAO.
     * Multiplies the retrieved value by 2.1.
     *
     * @return The computed result.
     * @throws IllegalStateException If no DAO is assigned.
     */
    @Override
    public double calcul() throws IllegalStateException {
        if (this.dao == null) {
            throw new IllegalStateException("No Dao assigned!");
        }

        double temp = this.dao.getData();
        return temp * 2.1;
    }

    /**
     * Sets a new DAO implementation.
     * Useful for dependency injection and switching data sources dynamically.
     *
     * @param dao The new IDao implementation.
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
