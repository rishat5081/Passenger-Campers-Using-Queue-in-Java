package passenger.train;

public class Camper {

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryPrefix() {
        return countryPrefix;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getContact() {
        return contact;
    }

    public String getStatus() {
        return status;
    }

    private String firstName, middleName, lastName, age, gender, address, country, countryPrefix, countryCode, contact, status;

    public Camper(String firstName, String middleName, String lastName, String age, String gender, String address, String country, String countryPrefix, String countryCode, String contact, String status) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.country = country;
        this.countryPrefix = countryPrefix;
        this.countryCode = countryCode;
        this.contact = contact;
        this.status = status;
    }
}
