package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // 모든 매개변수를 가지는 생성자가 추가된다. -> java code를 줄여줌으로써 생산성을 높여줌.
public class SearchParam {
    //getMultiParameter에 사용할 객체.
    private String account;
    private String email;
    private int page;

    //{"account" : "", "email" : "", "page": 0}

}