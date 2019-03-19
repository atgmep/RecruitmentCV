package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblCV;
import study.recruit.entity.TblParticipation;
import study.recruit.entity.TblProject;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<TblProject, Integer> {
    List<TblProject> findAllByCv(TblCV cv);
}
