package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    // HTML <Form> 태그, ajax 검색 등에 POST 사용 ==> 여러 개의 검색 Parameter가 존재한다는 의미.
    // http통신 시 post body에 data를 넣어서 보내겠다는 의미이므로 RequestBody로 받는다.
    // json, xml, multipart-form, text형태 등을 POST 방식에서 지원.

    // 아래 적은 PostMapping과 같음 : @RequestMapping(method=RequestMehod.POST, path = "/postMethod")
    @PostMapping("/postMethod") // api/postMethod
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        // SearchhParam 객체에서 Mapping.
        // Mapping 된 값을 다시 json형태로 바꾸어 return해준다.

        return searchParam;
    }
}
