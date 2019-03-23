package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblCV;
import study.recruit.entity.TblCandidate;

import java.util.List;

@Repository
public interface CVRepository extends JpaRepository<TblCV, Integer> {

    List<TblCV> findAllByCandidate(TblCandidate tblCandidate);
}
