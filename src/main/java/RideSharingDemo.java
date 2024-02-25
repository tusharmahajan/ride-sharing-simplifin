import controller.*;
import models.*;
import service.RideService;
import service.UserService;
import service.VehicleService;

public class RideSharingDemo {

    private static UserService userService = new UserService();
    private static VehicleService vehicleService = new VehicleService();
    private static RideService rideService = new RideService();

    private static AddUserAPI addUserAPI = new AddUserAPI(userService);
    private static AddVehicleAPI addVehicleAPI = new AddVehicleAPI(vehicleService);
    private static OfferRideAPI offerRideAPI = new OfferRideAPI(rideService);
    private static SearchSelectRideAPI searchSelectRideAPI = new SearchSelectRideAPI();
    private static RidesStatsAPI ridesStatsAPI = new RidesStatsAPI(rideService);
    private static EndRideAPI endRideAPI = new EndRideAPI(rideService);


    public static void main(String[] args) {
        addUsers();
        addVehicles();
        offerRides();
        searchSelectRides();
        endRide();
        printRidesStats();
    }

    private static void addUsers() {
        System.out.println(addUserAPI.addUser(new User("Rohan", Gender.M, 36)));
        System.out.println(addUserAPI.addUser(new User("Shashank", Gender.M, 29)));
        System.out.println(addUserAPI.addUser(new User("Nandini", Gender.F, 29)));
        System.out.println(addUserAPI.addUser(new User("Shipra", Gender.F, 27)));
        System.out.println(addUserAPI.addUser(new User("Gaurav", Gender.M, 29)));
        System.out.println(addUserAPI.addUser(new User("Rahul", Gender.M, 35)));
    }

    private static void addVehicles() {
        System.out.println(addVehicleAPI.addVehicle(new Vehicle("Rohan", "Swift", "KA-01-12345")));
        System.out.println(addVehicleAPI.addVehicle(new Vehicle("Shashank", "Baleno", "TS-05-62395")));
        System.out.println(addVehicleAPI.addVehicle(new Vehicle("Shipra", "Polo", "KA-05-41491")));
        System.out.println(addVehicleAPI.addVehicle(new Vehicle("Shipra", "Activa", "KA-12-12332")));
        System.out.println(addVehicleAPI.addVehicle(new Vehicle("Rahul", "XUV", "KA-05-1234")));
    }

    private static void offerRides() {

        System.out.println(offerRideAPI.offerRide(new RideDetails("Rohan", "Hyderabad", 1, "Swift", "KA-01-12345", "Bangalore")));
        System.out.println(offerRideAPI.offerRide(new RideDetails("Shipra", "Bangalore", 1, "Activa", "KA-12-12332", "Mysore")));
        System.out.println(offerRideAPI.offerRide(new RideDetails("Shipra", "Bangalore", 2, "Polo", "KA-05-41491", "Mysore")));
        System.out.println(offerRideAPI.offerRide(new RideDetails("Shashank", "Hyderabad", 2, "Baleno", "TS-05-62395", "Bangalore")));
        System.out.println(offerRideAPI.offerRide(new RideDetails("Rahul", "Hyderabad", 5, "XUV", "KA-05-1234", "Bangalore")));
        System.out.println(offerRideAPI.offerRide(new RideDetails("Rohan", "Bangalore", 1, "Swift", "KA-01-12345", "Pune")));
    }

    private static void searchSelectRides() {
        System.out.println(searchSelectRideAPI.searchAndSelectRide(new RideRequest("Nandini", "Bangalore", "Mysore", 1, null), RideSelection.MOST_VACANT));
        System.out.println(searchSelectRideAPI.searchAndSelectRide(new RideRequest("Gaurav", "Bangalore", "Mysore", 1, "Activa"), RideSelection.VEHICLE_PREFERENCE));
        System.out.println(searchSelectRideAPI.searchAndSelectRide(new RideRequest("Shashank", "Mumbai", "Bangalore", 1, null), RideSelection.MOST_VACANT));
        System.out.println(searchSelectRideAPI.searchAndSelectRide(new RideRequest("Rohan", "Hyderabad", "Bangalore", 1, "Baleno"), RideSelection.VEHICLE_PREFERENCE));
        System.out.println(searchSelectRideAPI.searchAndSelectRide(new RideRequest("Shashank", "Hyderabad", "Bangalore", 1, "Polo"), RideSelection.VEHICLE_PREFERENCE));
    }

    private static void endRide() {
        System.out.println(endRideAPI.endRide("Rohan", "KA-01-12345"));
        System.out.println(endRideAPI.endRide("Shipra", "KA-12-12332"));
        System.out.println(endRideAPI.endRide("Shipra", "KA-05-41491"));
        System.out.println(endRideAPI.endRide("Shashank", "TS-05-62395"));
    }

    private static void printRidesStats() {
       ridesStatsAPI.printRideStats();
    }
}
