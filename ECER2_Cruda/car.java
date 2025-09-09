public class car {
    private String color;
    private String plateNo;
    private String chassisNo;

    // Default constructor
    public car() {
        this.color = "Unpainted";
        this.plateNo = "No Plate Assigned";
        this.chassisNo = "Chassis Not Available";
    }

    // Constructor with complete details
    public car(String color, String plateNo, String chassisNo) {
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
    }

    // Constructor with chassisNo only
    public car(String chassisNo) {
        this.color = "Standard Grey";
        this.plateNo = "TEMP-222";
        this.chassisNo = chassisNo;
    }

    // Method to display information
    public void displayInfo() {
        String info = "";
        info += "Car Color: " + this.color;
        info += "\nPlate Number: " + this.plateNo;
        info += "\nChassis Code: " + this.chassisNo;
        System.out.println(info);
    }
}
