package aim.boot.elastic.repository;

import aim.boot.elastic.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, Long> {
}
