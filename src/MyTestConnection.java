import java.sql.*;

/**
 * Created by andriusbaltrunas on 2/12/2018.
 */
public class MyTestConnection {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs", "root", "MySQL");
            if(connection != null){
                System.out.println("Prisijungeme prie KCS");

                Statement statement = connection.createStatement();//pasiruosimas uzklausoms

                ResultSet resultSet = statement.executeQuery("select * from students");
                while (resultSet.next()){
                    System.out.println("ID " + resultSet.getInt("id") + " " + resultSet.getString("name") + " "
                            + resultSet.getString("surname") + " " + resultSet.getString(4));
                }

                statement.execute("insert into students(name, surname,email, phone)" +
                        "VALUES('Pertras', 'Petrauskas', 'p.petraukas@kcs.com', '+37082364962398')");
            }

        } catch (SQLException e) {
            System.out.println("Nepavyko prisijungti "+ e);
        }
    }
}
