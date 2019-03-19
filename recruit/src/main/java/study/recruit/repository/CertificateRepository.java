package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblAward;
import study.recruit.entity.TblCV;
import study.recruit.entity.TblCertificate;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<TblCertificate, Integer> {
    List<TblCertificate> findAllByCv(TblCV cv);
}
