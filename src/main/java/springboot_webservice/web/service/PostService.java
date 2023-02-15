package springboot_webservice.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot_webservice.web.domain.entity.Post;
import springboot_webservice.web.domain.repository.PostRepository;
import springboot_webservice.web.dto.PostDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostDto postDto) {
        return postRepository.save(postDto.toEntity()).getId();
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public PostDto findById(Long id) {
        Optional<Post> postWrapper = postRepository.findById(id);
        Post post = postWrapper.get();
        PostDto postDto = PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .author(post.getAuthor())
                .content(post.getContent())
                .createdDate(post.getCreatedDate())
                .modifiedDate(post.getModifiedDate())
                .build();
        return postDto;
    }

    @Transactional
    public Long update(Long id, PostDto updateParam) {
        Optional<Post> postWrapper = postRepository.findById(id);
        Post post = postWrapper.get();
        post.update(updateParam.getTitle(), updateParam.getContent(), updateParam.getAuthor());
        return id;
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Post> postWrapper = postRepository.findById(id);
        if (postWrapper.isPresent()) {
            Post post = postWrapper.get();
            postRepository.deleteById(id);
        }
    }
}
