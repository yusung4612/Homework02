package com.sparta.homework;

import com.sparta.homework.repository.BoardRepository;
import com.sparta.homework.entity.Board;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);

	}
	@Bean
	public CommandLineRunner demo(BoardRepository boardRepository) {
		return (args) -> {
			boardRepository.save(new Board("제목","작성자1","1234","내용1"));
		};
	}
}
