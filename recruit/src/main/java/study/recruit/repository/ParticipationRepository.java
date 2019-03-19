package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblCV;
import study.recruit.entity.TblParticipation;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<TblParticipation, Integer> {
    List<TblParticipation> findAllByCv(TblCV cv);
}
