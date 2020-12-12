public class Dog {

    private String firstName;
    private String lastName;
    private String middleName;

    public Dog(String firstName) {
        this.firstName = firstName;
    }

    public Dog(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Dog(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getName() {
        String name;
        name = this.firstName;
        return name;
    }

    public String getFullName() {
        String fullName;
        fullName = this.firstName + " " + this.lastName;
        return fullName;
    }

    public String getFullNameWithMiddle() {
        String fullNameWithMiddle;
        fullNameWithMiddle = this.firstName + " " + this.middleName + " " + this.lastName;
        return fullNameWithMiddle;
    }

}