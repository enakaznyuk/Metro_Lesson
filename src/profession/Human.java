package profession;

public abstract class Human {

    private String firstName;
    private String lastName;
    //private <T> idPassport;


    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Human() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}
