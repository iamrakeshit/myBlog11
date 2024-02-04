package myblog.myblog11.service.impl;

import myblog.myblog11.entity.Comment;
import myblog.myblog11.entity.Post;
import myblog.myblog11.exception.ResourceNotFoundException;
import myblog.myblog11.payLoad.CommentDto;
import myblog.myblog11.repository.PostRepository;
import myblog.myblog11.repository.CommentRepository;
import myblog.myblog11.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    public CommentServiceImpl(PostRepository postRepository,CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id: " + postId)
        );
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setPost(post);

        Comment savedcomment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setId(savedcomment.getId());
        dto.setText(savedcomment.getText());
        return dto;
    }
}
