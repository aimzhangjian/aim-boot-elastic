package aim.boot.elastic.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.annotation.Generated;
import java.util.List;

@Document(indexName = "employee_index", type = "employee", shards = 1)
public class Employee {
    public static String EMPLOYEE_ID = "employeeId";
    public static String FIRST_NAME = "firstName";
    public static String LAST_NAME = "lastName";
    public static String AGE = "age";
    public static String ABOUT = "lastName";
    public static String INTERESTS = "interests";

    @Id
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String about;
    private List<String> interests;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
