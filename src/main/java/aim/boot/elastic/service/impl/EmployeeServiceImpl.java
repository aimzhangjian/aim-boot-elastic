package aim.boot.elastic.service.impl;

import aim.boot.elastic.entity.Employee;
import aim.boot.elastic.repository.EmployeeRepository;
import aim.boot.elastic.service.EmployeeService;
import org.assertj.core.util.Lists;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> queryAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, Employee.EMPLOYEE_ID);
        return Lists.newArrayList((employeeRepository.findAll(sort)));
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee queryById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> queryByOrders() {
        List<Sort.Order> sortList = new ArrayList<>();
        Sort.Order sort1 = new Sort.Order(Sort.Direction.ASC, Employee.FIRST_NAME);
        Sort.Order sort2 = new Sort.Order(Sort.Direction.DESC, Employee.AGE);
        sortList.add(sort1);
        sortList.add(sort2);
        Sort orders = Sort.by(sortList);
        return Lists.newArrayList(employeeRepository.findAll(orders));
    }

    @Override
    public List<Employee> searchByFirstName(String firstName) {
        return Lists.newArrayList(employeeRepository.search(new QueryStringQueryBuilder(firstName)));
    }

    @Override
    public List<Employee> searchByParam(String firstName, String lastName, Integer age) {
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery(Employee.FIRST_NAME, firstName))
                .must(QueryBuilders.matchQuery(Employee.LAST_NAME, lastName))
                .must(QueryBuilders.matchQuery(Employee.AGE, age));
        return Lists.newArrayList(employeeRepository.search(queryBuilder));
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public void batchDeleteEmployee(List<Employee> employees) {
        employeeRepository.deleteAll(employees);
    }
}
