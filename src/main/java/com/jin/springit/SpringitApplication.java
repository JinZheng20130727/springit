package com.jin.springit;

import com.jin.springit.config.SpringitProperties;
import com.jin.springit.domain.Comment;
import com.jin.springit.domain.Link;
import com.jin.springit.repository.CommentRepository;
import com.jin.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
@EnableJpaAuditing
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    @Autowired
    ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}

//	@Bean
    CommandLineRunner run(LinkRepository linkRepository, CommentRepository commentRepository){
	    return args -> {
            Link link = new Link("Getting started with spring boot 2", "https://therealdanvega.com/spring-boot-2");
            linkRepository.save(link);

            Comment comment = new Comment("This spring boot 2 link  is awesome!", link);
            commentRepository.save(comment);

            link.addComment(comment);


        };
    }
}
