package comment_system.comment_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class CommentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentSystemApplication.class, args);
	}

}
