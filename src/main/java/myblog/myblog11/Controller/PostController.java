package myblog.myblog11.Controller;

import myblog.myblog11.payLoad.PostDto;
import myblog.myblog11.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//      http://localhost:8080/rest/api
@RestController
@RequestMapping("rest/api")
public class PostController {
    private PostService service;
    public PostController(PostService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<PostDto>createRegistration(@RequestBody PostDto postDto){
        PostDto registration = service.createRegistration(postDto);
        return new ResponseEntity<>(registration, HttpStatus.CREATED);
    }
    //      http://localhost:8080/rest/api/byId?id=1
    @GetMapping("/byId")
    public ResponseEntity<PostDto>getRegistrationById(@RequestParam long id){
        PostDto dtoid = service.getRegistrationById(id);
        return new ResponseEntity<>(dtoid,HttpStatus.ACCEPTED);
    }
    //      http://localhost:8080/rest/api/getall
    @GetMapping("getall")
    public List<PostDto> getAllPosts(){
        List<PostDto> postDtos = service.getAllPosts();
        return postDtos;
    }
}