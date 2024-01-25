package myblog.myblog11.service;

import myblog.myblog11.payLoad.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostDto createRegistration(PostDto postDto);

    PostDto getRegistrationById(long id);
}
