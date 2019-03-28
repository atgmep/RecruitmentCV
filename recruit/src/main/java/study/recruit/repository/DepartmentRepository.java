package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblDepartment;

@Repository
public interface DepartmentRepository extends JpaRepository<TblDepartment, Integer> {
}
