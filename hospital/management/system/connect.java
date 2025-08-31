package hospital.management.system;
//This will connect our program with JDBC and SQL make sure to add proper details.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connect {

    Connection connection;
    Statement statement;

    public connect() {
        try {
            // add the password of your MYSQL in place of password.
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root", "password");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//Run the login.java after completion.
}
