package station;

import exception.InvalidDataException;
import impl.IMajorRenovation;
import impl.IWork;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import profession.Employee;

import java.time.LocalDate;
import java.util.ArrayList;

public class Station implements IMajorRenovation, IWork<Station> {

    private static final Logger LOGGER = LogManager.getLogger(Station.class);

    private LocalDate dateBasis;
    private String name;
    private ArrayList<Employee> employees;

    public Station(String name, LocalDate dateBasis) {
        this.name = name;
        this.dateBasis = dateBasis;
        if (dateBasis.getYear() < 1980) {
            throw new InvalidDataException("Date must be > 1980!");
        }
    }

    public void getDateMajorRenovation(Station station) {
        LocalDate renovation = getDateBasis().plusYears(50);
        int date = renovation.getYear();
        LOGGER.info("Date of major Renovation: " + date);
    }

    @Override
    public void getTimeWorking(Station station) {
        LOGGER.info("Station is working from 5:00 to 23:59");
    }

    @Override
    public void getWeekend(Station station) {
        LOGGER.info("Station is working everyday");
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateBasis() {
        return dateBasis;
    }
}
