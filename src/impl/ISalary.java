package impl;

import exception.InvalidSalaryException;
import profession.Employee;

public interface ISalary {

    void getSalary(Employee employee) throws InvalidSalaryException;

}
