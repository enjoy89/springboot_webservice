package springboot_webservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot_webservice.web.dto.PostDto;
import springboot_webservice.web.service.PostService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("post", postService.findAllPosts());
        return "post/postList";
    }

    @GetMapping("/add")
    public String addForm(PostDto postDto, Model model) {
        model.addAttribute("postDto", postDto);
        return "post/createPostForm";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute PostDto postDto) {
        postService.save(postDto);
        return "redirect:/post/list";
    }

    @GetMapping("/{postId}")
    public String detail(@PathVariable Long postId, Model model) {
         PostDto postDto = postService.findById(postId);
         model.addAttribute("postDto", postDto);
         return "post/postDetail";
    }

    @GetMapping("/update/{postId}")
    public String updateForm(@PathVariable Long postId, Model model) {
        PostDto postDto = postService.findById(postId);
        model.addAttribute("postDto", postDto);
        return "post/updatePostForm";
    }

    @PostMapping("/update/{postId}")
    public String update(@PathVariable Long postId, PostDto postDto) {
         postService.update(postId, postDto);
         return "redirect:/post/{postId}";
    }

    @PostMapping("/delete/{postId}")
    public String delete(@PathVariable Long postId) {
        postService.deleteById(postId);
        return "redirect:/post/list";
    }

}
