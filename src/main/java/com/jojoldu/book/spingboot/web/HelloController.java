package com.jojoldu.book.spingboot.web;
import com.jojoldu.book.spingboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * RestController : 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌.
 */
@RestController
public class HelloController {
    /**
    * HTTP Method의 GET의 요청을 받을 수 있는 API 만들어 준다.
    */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    /**
     * RequestParam
     * 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
     * 외부에서 name이란 이름으로 넘긴 파라미터를 메소드 파라미터에 저장하게 된다.
     */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
