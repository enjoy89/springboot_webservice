package springboot_webservice.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot_webservice.web.domain.entity.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
