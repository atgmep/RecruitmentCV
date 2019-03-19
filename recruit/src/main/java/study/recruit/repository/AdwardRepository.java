package study.recruit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblAward;
import study.recruit.entity.TblCV;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdwardRepository extends JpaRepository<TblAward, Integer> {

    List<TblAward> findAllByCv(TblCV cv);
}
