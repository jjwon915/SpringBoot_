package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //Localhost:8080/api 로 주소 매칭.

// GET 방식은 주소창에 파라미터가 노출된다.
public class GetController {
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // Localhost:8080/api/getMethod 주소 호출하면 사용자의 요청이 들어온다.
    public String getRequest(){

         return "Hi getMethod";
    }

    @GetMapping("/getParameter") // Localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){
        // pwd는 password를 붙여서 들어오게 될 것임을 알려줌.
        String password = "bbbb";
        System.out.println("id : " +id);
        System.out.println("pwd : " +pwd);

        return id + pwd;
    }

    // Localhost:8080/api/getmultiParameter?account=abcd&email=study@gmail.com&page=10
    // 이렇게 Prameter가 많이 발생하는 경우. ==> 객체를 생성해 받아온다.
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiPrameter(SearchParam searchParam) {
        //System.out.println(searchParam.getAccount());
        //System.out.println(searchParam.getEmail());
        //System.out.println(searchParam.getPage());

        // {"account" : "", "email" : "", "page": 0}
        // 객체를 return 할때 스프링부트는 자동적으로 json형태로 return함.

        return searchParam;
    }

}
