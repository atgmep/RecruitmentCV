package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblRecruit;

@Repository
public interface RecruitRepository  extends JpaRepository<TblRecruit, Integer> {


}
