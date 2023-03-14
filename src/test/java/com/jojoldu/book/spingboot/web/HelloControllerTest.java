package com.jojoldu.book.spingboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @RunWith
 * 스프링 부트 테스트와 JUnit 사이에 연결자 역할
 * @WebMvcTest
 * Web(Spring MVC)에 집중할 수 있는 어노테이션
 * 선언 - @Controller, @ControllerAdvice 등 사용 - 컨트롤러만 사용
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    /**
     * @Autowired
     * 스프링이 관리하는 빈(Bean) 주입 받는다.
     * private MockMvc mvc;
     * 웹 API 테스트할 때 사용
     * 스피일 MVC 테스트의 시작점
     * 이 클래스로 HTTP GET, POST 등에 대한 API 테스트 할 수 있다.
     */
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        /**
         * MockMVC를 통해 /hello 주소로 HTTP GET 요청을 한다.
         * 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언 가능
         * mvc perform의 결과를 검증
         * HTTP Header의 Status를 검증, 200, 400, 500 등의 상태
         * isOk() -> 200인지 아닌지 검증
         * mvc perform의 결과를 검증, 응답 본문의 내용 검증
         * Controller에서 hello를 리턴 -> 이 값이 맞는지 검증
         */
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;
        /**
         * param => api 테스트할 때 사용될 요청 파라미터를 설정한다. 단 String 만 허용
         * 숫자/날짜 등의 데이터도 등록할 때는 문자열로 변경해야만 한다.
         * jsonPath => JSON 응답값을 필드별로 검증할 수 있는 메소드이다. $를 기준으로 필드명을 명시한다.
         * 여기서는 name과 amount를 검증하니, $.name, $.amount로 검증
         */
        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
