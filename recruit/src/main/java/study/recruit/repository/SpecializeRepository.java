package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblCV;
import study.recruit.entity.TblParticipation;
import study.recruit.entity.TblSpecialize;

import java.util.List;

@Repository
public interface SpecializeRepository extends JpaRepository<TblSpecialize, Integer> {
    List<TblSpecialize> findAllByCv(TblCV cv);
}
