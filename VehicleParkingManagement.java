import java.sql.*;
import java.util.Scanner;
public class VehicleParkingManagement {
    static final String URL = "jdbc:mysql://localhost:3306/parking";
    static final String USER = "root";
    static final String PASSWORD = "test@123";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            try ( // Establish Connection
                    Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
                int choice;
                do {
                    System.out.println("\n========== Vehicle Parking Management ==========");
                    System.out.println("1. Add Vehicle");
                    System.out.println("2. View Vehicles");
                    System.out.println("3. Update Parking Slot");
                    System.out.println("4. Delete Vehicle");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");    
                    choice = sc.nextInt();
                    switch(choice) {
                        case 1:
                            System.out.print("Enter Vehicle ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();                            
                            System.out.print("Enter Owner Name: ");
                            String owner = sc.nextLine();             
                            System.out.print("Enter Vehicle Type: ");
                            String type = sc.nextLine();
                            System.out.print("Enter Vehicle Number: ");
                            String number = sc.nextLine();               
                            System.out.print("Enter Parking Slot: ");
                            String slot = sc.nextLine();
                            String insert = "INSERT INTO vehicle VALUES(?,?,?,?,?)";
                            PreparedStatement ps = con.prepareStatement(insert);
                            ps.setInt(1, id);
                            ps.setString(2, owner);
                            ps.setString(3, type);
                            ps.setString(4, number);
                            ps.setString(5, slot);
                            int row = ps.executeUpdate();                           
                            if(row > 0)
                                System.out.println("Vehicle Added Successfully.");
                            break;
                        case 2:
                            Statement st = con.createStatement();
                            ResultSet rs = st.executeQuery("SELECT * FROM vehicle");
                            System.out.println("\n--------------------------------------------------------------");
                            System.out.println("ID\tOwner\tType\tVehicle No\tParking Slot");
                            System.out.println("--------------------------------------------------------------");
                            while(rs.next()) {
                                
                                System.out.println(
                                        rs.getInt("vehicle_id") + "\t" +
                                                rs.getString("owner_name") + "\t" +
                                                rs.getString("vehicle_type") + "\t" +
                                                rs.getString("vehicle_number") + "\t" +
                                                rs.getString("parking_slot"));                                
                            }
                            break;
                        case 3:                            
                            System.out.print("Enter Vehicle ID: ");
                            int vid = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter New Parking Slot: ");
                            String newslot = sc.nextLine();
                            String update = "UPDATE vehicle SET parking_slot=? WHERE vehicle_id=?";
                            PreparedStatement ps2 = con.prepareStatement(update);
                            ps2.setString(1, newslot);
                            ps2.setInt(2, vid);                            
                            int updateRow = ps2.executeUpdate();
                            if(updateRow > 0)
                                System.out.println("Parking Slot Updated Successfully.");
                            else
                                System.out.println("Vehicle Not Found.");                          
                            break;
                        case 4:
                            System.out.print("Enter Vehicle ID: ");
                            int did = sc.nextInt();                            
                            String delete = "DELETE FROM vehicle WHERE vehicle_id=?";
                            PreparedStatement ps3 = con.prepareStatement(delete);
                            ps3.setInt(1, did);                         
                            int deleteRow = ps3.executeUpdate();                            
                            if(deleteRow > 0)
                                System.out.println("Vehicle Deleted Successfully.");
                            else
                                System.out.println("Vehicle Not Found.");
                            break;
                        case 5:                          
                            System.out.println("Thank You...");
                            break;                            
                        default:                            
                            System.out.println("Invalid Choice.");
                    }
                } while(choice != 5);
            }
            sc.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("MySQL Driver Not Found.");
        }
        catch(SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}

