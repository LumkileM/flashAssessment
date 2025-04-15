package testdata;

public class RegistrationData {


    private static String firstName = "AutoName";
    private static String lastName = "AutoLast";
    private static String email = "email10101@tester.com";
    private static String password = "Password01";


    public static String getFirstName() {
        return firstName;
    }
    public static void setFirstName(String firstName) {
        RegistrationData.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        RegistrationData.lastName = lastName;
    }

    public static  String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        RegistrationData.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        RegistrationData.password = password;
    }
}
