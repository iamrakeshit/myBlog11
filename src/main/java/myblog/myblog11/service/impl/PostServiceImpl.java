package myblog.myblog11.service.impl;

import myblog.myblog11.entity.Post;
import myblog.myblog11.exception.ResourceNotFoundException;
import myblog.myblog11.payLoad.PostDto;
import myblog.myblog11.repository.PostRepository;
import myblog.myblog11.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository repository;
    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }
    @Override
    public PostDto createRegistration(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post spost = repository.save(post);
        PostDto dto = mapToDto(spost);
        return dto;
    }

    @Override
    public PostDto getRegistrationById(long id) {
        Post post = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Registration is not found with id=" +id)
        );
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setName(post.getName());
        dto.setEmail(post.getEmail());
        dto.setMobile(post.getMobile());
        return dto;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = repository.findAll();
        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;
    }

    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setName(post.getName());
        dto.setEmail(post.getEmail());
        dto.setMobile(post.getMobile());
        return dto;
    }
    Post mapToEntity(PostDto dto){
        Post post = new Post();
        post.setName(dto.getName());
        post.setEmail(dto.getEmail());
        post.setMobile(dto.getMobile());
        return post;
    }
}
