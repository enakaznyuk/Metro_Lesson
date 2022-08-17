/*package profession;

import exception.InvalidSalaryException;
import impl.ISalary;
import impl.ISick;
import impl.IWork;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;
import java.math.BigInteger;
import exception.InvalidNameException;

public abstract class Profession implements ISalary, ISick, IWork {

    private static final Logger LOGGER = LogManager.getLogger(Profession.class);

    private String personName;
    private String name;
    private BigDecimal pay;
    private BigInteger vacationSickDays;
    private String holiday;

    public Profession(String personName, String name) throws InvalidNameException {
        this.personName = personName;
        this.name = name;

        if (!name.matches("^\\D*$")) {
            throw new InvalidNameException("name must not contain numbers");
        }
    }

    public String getName() {
        return name;
    }

    public abstract void company(String company);

    public void companyAddress(String companyAddress) {

        LOGGER.info("Company address = " + companyAddress);
    }

    public BigDecimal getPay() {
        return pay;
    }

    public BigInteger getVacationSickDays() {
        return vacationSickDays;
    }

    public String getHoliday() {
        return holiday;
    }

    public abstract void salary(Profession profession) throws InvalidSalaryException;

    public abstract void socialPackage(Profession profession);

    public abstract void timeWorking(Object obj);

    public abstract void weekend(Object obj);

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public void setVacationSickDays(BigInteger vacationSickDays) {
        this.vacationSickDays = vacationSickDays;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getPersonName() {
        return personName;
    }
}*/
