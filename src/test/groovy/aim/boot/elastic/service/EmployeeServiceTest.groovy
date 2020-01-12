package aim.boot.elastic.service

import aim.boot.elastic.config.ElasticSearchConfig
import aim.boot.elastic.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification
import spock.lang.Stepwise

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(ElasticSearchConfig)
@ActiveProfiles("test")
@Stepwise
class EmployeeServiceTest extends Specification {

    @Autowired
    private EmployeeService employeeService;

    def "CreateEmployee"() {
        given:
        Employee employee = new Employee();
        List<String> interests = new ArrayList<>();
        interests.add("网球");
        interests.add("足球");
        employee.setAbout("我喜欢")
        employee.setAge(20);
        employee.setFirstName("张");
        employee.setLastName("三");
        employee.setInterests(interests);
        when:
        employeeService.createEmployee(employee);
        then:
        List<Employee> employees = employeeService.queryAll();
        employees.get(0).getAbout() == "我喜欢";
    }

    def "QueryAll"() {
    }

    def "UpdateEmployee"() {
    }

    def "QueryById"() {
    }

    def "QueryByOrders"() {
    }

    def "SearchByFirstName"() {
    }

    def "SearchByParam"() {
    }
}
