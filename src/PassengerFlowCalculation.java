import equip.Equip;
import profession.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import station.Station;

import java.time.LocalTime;
import java.util.ArrayList;

public class PassengerFlowCalculation {

    private static final Logger LOGGER = LogManager.getLogger(PassengerFlowCalculation.class);

    public static void isEmployeeWorking(String firstName, ArrayList<Station> stations) {
        for (int j = 0; j < stations.size(); j++) {
            String stationEmployee = stations.get(j).getEmployees().get(j).getFirstName();
            if (firstName.equals(stationEmployee)) {
                LOGGER.info(stationEmployee + " works at the " + stations.get(j).getName());
            } else {
                LOGGER.info("Employee does not work at the " + stations.get(j).getName() + " station");
            }
        }
    }

    public static void getInformationAboutTrain(Machinist machinist) {
        //T number = machinist.getTrain().getTrainNumber();
        String model = machinist.getTrain().getModelTrain();
        LOGGER.info(machinist.getFirstName() + '\t' + machinist.getTrain().getModelTrain() + '\t' + model);
    }

    public static boolean checkAndRefreshMetroStatus(TimeTable timeTable) {
        boolean work = false;

        LocalTime now = LocalTime.now();
        LocalTime start = timeTable.getStartWorking();
        LocalTime middleStart = timeTable.getMiddleWorking();
        LocalTime middleEnd = timeTable.getMiddleWorkingEnd();
        LocalTime end = timeTable.getEndWorking();

        if (now.isAfter(start) && now.isBefore(end)) {
            if (now.isBefore(middleStart)) {
                timeTable.setPartOfDay("Morning");
            } else if (now.isAfter(middleStart) && now.isBefore(middleEnd)) {
                timeTable.setPartOfDay("Day");
            } else if (now.isAfter(middleEnd)) {
                timeTable.setPartOfDay("Evening");
            }
            work = true;
        }
        return work;
    }

    public static void flowDivision(TimeTable timeTable, ArrayList<Passenger> passengers) {
        boolean work = PassengerFlowCalculation.checkAndRefreshMetroStatus(timeTable);
        int numberOfPassangers = passengers.size();
        if (!work) {
            LOGGER.info("underground is not working");
            return;
        }

        if ("Morning".equals(timeTable.getPartOfDay())) {
            LOGGER.info("you need 3 trains for " + numberOfPassangers/5 + " passangers");
        } else if ("Day".equals(timeTable.getPartOfDay())) {
            LOGGER.info("you need 5 trains for " + numberOfPassangers/10 + " passangers");
        } else if ("Evening".equals(timeTable.getPartOfDay())) {
            LOGGER.info("you need 20 trains for " + numberOfPassangers + " passangers");
        }
    }

    public static void toCompareEngineer(Engineer engineerfirst, Engineer engineersecond) {
        if (engineerfirst.equals(engineersecond)) {
            LOGGER.info("it's the same person");
        } else {
            LOGGER.info("it's the different person");
        }
    }

    public static void toCompare(Machinist machinistfirst, Machinist machinistsecond) {
        LOGGER.info("Hashcode machinist 1 = ");
        LOGGER.info(machinistfirst.hashCode() + "_______" + machinistsecond.hashCode());
    }

    public static void useEquip(Cleaner cleaner) {
        for (int i = 0; i < cleaner.getEquips().size(); i++) {
            Equip equip = cleaner.getEquips().get(i);
            equip.belong(cleaner);
        }
    }

    public static void getFirstAndLastName(Human human){
        LOGGER.info("First Name = " + human.getFirstName());
        LOGGER.info("Last Name =  " + human.getLastName());
    }
}
