import utils.QueryUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by andriusbaltrunas on 2/12/2018.
 */
public class CreateTableExample {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jbdc:mysql://127.0.0.1:3306/kcs","root", "MySQL");
            if(connection != null){
                Statement statement = connection.createStatement();

                if(!QueryUtils.isTableExist(connection, "students")){
                    statement.execute("CREATE TABLE STUDENTS(\n" +
                            "  ID int not null AUTO_INCREMENT,\n" +
                            "  name VARCHAR(50) not NULL ,\n" +
                            "  surname VARCHAR(50) not null,\n" +
                            "  phone VARCHAR(30) not null,\n" +
                            "  email VARCHAR(50) not NULL ,\n" +
                            "  PRIMARY KEY (id)\n" +
                            ")");
                }else{
                    System.out.println("Lentele jau yra");
                }
            }
        } catch (SQLException e) {
            System.out.println("Neprisijungem");
        }
    }
}
