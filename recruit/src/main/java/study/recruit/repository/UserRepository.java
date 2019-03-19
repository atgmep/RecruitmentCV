package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.recruit.entity.TblUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<TblUser,Integer> {

    Optional<TblUser> findByUsername(String username);
}
