package springboot_webservice.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import springboot_webservice.web.domain.entity.Posts;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class PostsDto {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public Posts toEntity() {
        Posts posts = Posts.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();

        return posts;
    }

    @Builder
    public PostsDto(String title, String content, String writer, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
