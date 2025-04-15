package testdata;

public class OrderData {

    private static String orderNumber = "";

    private static String country = "South Africa";
    private static String city = "Cape Town";
    private static String address = "1 Automation Street";
    private static String postalCode = "8001";
    private static String phoneNumber = "0721234567";




    public static String getOrderNumber() {
        return orderNumber;
    }
    public static void setOrderNumber(String orderNumber) {
        OrderData.orderNumber = orderNumber;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        OrderData.country = country;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        OrderData.city = city;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        OrderData.address = address;
    }

    public static String getPostalCode() {
        return postalCode;
    }

    public static void setPostalCode(String postalCode) {
        OrderData.postalCode = postalCode;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        OrderData.phoneNumber = phoneNumber;
    }
}
