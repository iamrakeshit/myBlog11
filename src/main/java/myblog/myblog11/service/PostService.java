package myblog.myblog11.service;

import myblog.myblog11.payLoad.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostDto createRegistration(PostDto postDto);

    PostDto getRegistrationById(long id);

    List<PostDto> getAllPosts();
}
