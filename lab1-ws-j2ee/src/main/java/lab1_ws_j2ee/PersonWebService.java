package lab1_ws_j2ee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;

@WebService(serviceName = "PersonService")
public class PersonWebService {
    @Resource(lookup = "jdbc/lab1")
    private DataSource dataSource;
    @WebMethod(operationName = "getAllPersons")
    public List<Person> getAllPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getAllPersons();
    }
    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons(@WebParam(name = "name") String name,
                                         @WebParam(name = "surname") String surname,
                                         @WebParam(name = "age") Integer age,
                                         @WebParam(name = "phone") Integer phone,
                                         @WebParam(name = "gender") String gender){
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersons(name, surname, age, phone, gender);
    }
    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}