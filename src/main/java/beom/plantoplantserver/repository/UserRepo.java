package beom.plantoplantserver.repository;

import beom.plantoplantserver.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, String> {
}
