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
    private String category;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public Post toEntity() {
        Post post = Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .category(category)
                .build();
        return post;
    }

    @Builder
    public PostDto(String title, String content, String author, String category, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
