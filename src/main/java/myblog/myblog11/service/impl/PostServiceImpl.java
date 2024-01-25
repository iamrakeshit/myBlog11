package myblog.myblog11.service.impl;

import myblog.myblog11.entity.Post;
import myblog.myblog11.payLoad.PostDto;
import myblog.myblog11.repository.PostRepository;
import myblog.myblog11.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository repository;
    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }
    @Override
    public PostDto createRegistration(PostDto postDto) {
        Post post = new Post();
        post.setName(postDto.getName());
        post.setEmail(postDto.getEmail());
        post.setMobile(postDto.getMobile());
        Post spost = repository.save(post);

        PostDto dto = new PostDto();
        dto.setId(spost.getId());
        dto.setName(spost.getName());
        dto.setEmail(spost.getEmail());
        dto.setMobile(spost.getMobile());
        return dto;
    }
}
