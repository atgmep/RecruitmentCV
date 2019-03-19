package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblCV;
import study.recruit.entity.TblEducation;
import study.recruit.entity.TblExp;

import java.util.List;

@Repository
public interface ExpRepository extends JpaRepository<TblExp, Integer> {
    List<TblExp> findAllByCv(TblCV cv);
}
