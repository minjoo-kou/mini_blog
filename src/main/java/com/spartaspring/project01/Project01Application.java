package com.spartaspring.project01;
import com.spartaspring.project01.domain.Article;
import com.spartaspring.project01.domain.ArticleRepository;
import com.spartaspring.project01.domain.ArticleRequestDto;
import com.spartaspring.project01.service.ArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class Project01Application {

    @PostConstruct
    public void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }
    public static void main(String[] args) {
        SpringApplication.run(Project01Application.class, args);
    }
}
