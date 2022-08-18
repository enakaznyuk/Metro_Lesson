import equip.Equip;
import equip.EquipForCleaner;
import equip.EquipForEngineer;
import exception.InvalidSalaryException;
import profession.*;
import station.Station;
import train.Train;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {

        //HashMap<Integer, String> proba = new HashMap<>();

        Metro metro = new Metro();
        BigDecimal bigDecimal = new BigDecimal(150);
        BigInteger bigInteger = new BigInteger("14");

        LOGGER.info("Hello world");
        Machinist ivan = new Machinist("Ivan", "Drozd", "Machinist");
        ivan.setCompany("Metro.job");
        ivan.setCompanyAddress("Pushkin street, house 1");
        ivan.setPay(bigDecimal);
        ivan.setHoliday("14");
        ivan.setVacationSickDays(bigInteger);

        System.out.println(ivan);

        Machinist sergey = new Machinist("Sergey", "Sinica", "Machinist");
        sergey.setCompany("Metro.job");
        sergey.setCompanyAddress("Lenin street, house 2");
        ArrayList<Machinist> machinists = new ArrayList<>();
        machinists.add(ivan);
        machinists.add(sergey);

        Engineer dmitriy = new Engineer("Dmitriy", "Kukushka", "Engineer");
        ArrayList<Engineer> engineers = new ArrayList<>();
        engineers.add(dmitriy);

        Cleaner nikolay = new Cleaner("Nikolay", "Vorobey", "Cleaner");
        ArrayList<Cleaner> cleaners = new ArrayList<>();
        cleaners.add(nikolay);

        ArrayList<Employee> stationNemigaEmloyees = new ArrayList<>();
        stationNemigaEmloyees.add(ivan);
        stationNemigaEmloyees.add(sergey);
        ArrayList<Employee> stationProletarskayaEmployees = new ArrayList<>(Arrays.asList(dmitriy, nikolay));
        ArrayList<Employee> employees = new ArrayList<>(stationNemigaEmloyees);
        employees.addAll(stationProletarskayaEmployees);

        Station nemiga = new Station("Nemiga", LocalDate.of(1985, 7, 21));
        Station proletarskaya = new Station("Proletarskaya", LocalDate.of(1987, 3, 15));
        nemiga.setEmployees(stationNemigaEmloyees);
        proletarskaya.setEmployees(stationProletarskayaEmployees);
        ArrayList<Station> stations = new ArrayList<>(Arrays.asList(nemiga, proletarskaya));

        EquipForCleaner mop = new EquipForCleaner("Mop", "Cleaner Room");
        EquipForEngineer overalls = new EquipForEngineer("Overalls", "Cleaner Room");
        EquipForEngineer setOfTools = new EquipForEngineer("Set of tools", "Engineer Room");
        ArrayList<Equip> cleanerEquips = new ArrayList<>(Arrays.asList(mop, overalls));
        ArrayList<Equip> engineerEquips = new ArrayList<>(Arrays.asList(setOfTools));
        nikolay.setEquips(cleanerEquips);
        dmitriy.setEquips(engineerEquips);

        Train<Integer> train = new Train(1, LocalDate.of(2015, 9, 16), "Shtadler");
        ArrayList<Train> trains = new ArrayList<>(Arrays.asList(train));
        ivan.setTrain(trains.get(0));

        TimeTable timeTable = new TimeTable();
        timeTable.setStartWorking(LocalTime.of(4, 0));
        timeTable.setMiddleWorking(LocalTime.of(10, 0));
        timeTable.setMiddleWorkingEnd(LocalTime.of(16, 0));
        timeTable.setEndWorking(LocalTime.of(23, 59));

        ArrayList<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            passengers.add(new Passenger());
        }

        metro.setStations(stations);
        metro.setEmployees(employees);
        metro.setTimeTable(timeTable);
        metro.setPassengers(passengers);

        PassengerFlowCalculation.isEmployeeWorking("Ivan", stations);
        PassengerFlowCalculation.getInformationAboutTrain(ivan);
        PassengerFlowCalculation.flowDivision(timeTable, passengers);
        PassengerFlowCalculation.useEquip(nikolay);
        PassengerFlowCalculation.toCompare(ivan, sergey);
        PassengerFlowCalculation.getFirstAndLastName(ivan);

        try {
            ivan.getSalary(ivan);
        } catch (InvalidSalaryException e) {
            LOGGER.info("error caught here!");
        } finally {
            LOGGER.info("Operation end!");
        }

        try (ClassForTryCatch classForTryCatch = new ClassForTryCatch()) {
            classForTryCatch.doSmth();
        }
    }
}