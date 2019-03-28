package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblApply;
import study.recruit.entity.TblRecruit;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<TblApply, Integer> {
    List<TblApply> findAllByRecruit(TblRecruit tblRecruit);
}
