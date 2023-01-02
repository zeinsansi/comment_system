package comment_system.comment_system.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class commentDAO {
    @JsonProperty(namespace = "message")
    private String message;
    @JsonProperty(namespace = "username")
    private String username;
    @JsonProperty(namespace = "postId")
    private int postId;
}
