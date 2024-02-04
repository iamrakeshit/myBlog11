package myblog.myblog11.service;

import myblog.myblog11.payLoad.CommentDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    CommentDto createComment(CommentDto commentDto,long postId);
}
