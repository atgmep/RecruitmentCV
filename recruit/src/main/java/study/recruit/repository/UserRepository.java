package study.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.recruit.entity.TblUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<TblUser,Integer> {

    Optional<TblUser> findByUsername(String username);
}
