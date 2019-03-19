package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblCV;
import study.recruit.entity.TblCertificate;
import study.recruit.entity.TblEducation;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<TblEducation, Integer> {
    List<TblEducation> findAllByCv(TblCV cv);
}
