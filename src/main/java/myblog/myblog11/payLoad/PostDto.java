package myblog.myblog11.payLoad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private long id;
    private String name;
    private String email;
    private long mobile;
}
