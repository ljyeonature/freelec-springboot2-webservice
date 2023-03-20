package com.jojoldu.book.spingboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
/**
 * @SpringBootApplication
 * 스프링부트의 자동 설정, 스프링Bean 읽기와 생성을 모두 자동으로 설정
 * 항상 프로젝트의 최상단에 위치
 *
 * 내장 WAS(Web Application Server)
 * 언제 어디서나 같은 환경에서 스프링 부트를 배포
 */