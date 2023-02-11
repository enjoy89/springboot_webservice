package springboot_webservice.web.dto;

import lombok.*;
import springboot_webservice.web.domain.entity.Post;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Post toEntity() {
        Post post = Post.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .build();
        return post;
    }

    @Builder
    public PostDto(Long id, String title, String content, String author, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
