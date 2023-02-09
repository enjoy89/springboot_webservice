package springboot_webservice.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot_webservice.web.domain.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
