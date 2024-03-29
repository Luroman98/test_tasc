package applic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
public class MyProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyProjectApplication.class, args);
    }
}
