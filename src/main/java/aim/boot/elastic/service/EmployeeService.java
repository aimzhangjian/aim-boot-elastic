package aim.boot.elastic.service;

import aim.boot.elastic.entity.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * 创建员工
     * @param employee
     * @return
     */
    Employee createEmployee(Employee employee);

    /**
     * 查询所有员工
     * @return
     */
    List<Employee> queryAll();

    /**
     * 更新员工
     * @param employee
     * @return
     */
    Employee updateEmployee(Employee employee);

    /**
     * 根据员工Id查询员工
     * @param id
     * @return
     */
    Employee queryById(Long id);

    /**
     *多条件排序查询
     * @return
     */
    List<Employee> queryByOrders();

    /**
     * 全文搜索
     * @return
     */
    List<Employee> searchByFirstName(String firstName);

    List<Employee> searchByParam(String firstName, String lastName, Integer age);

    /**
     * 删除员工
     * @param employee
     */
    void deleteEmployee(Employee employee);

    /**
     * 删除员工
     * @param employeeId
     */
    void deleteEmployeeById(Long employeeId);

    /**
     * 批量删除员工
     * @param employees
     */
    void batchDeleteEmployee(List<Employee> employees);
}
