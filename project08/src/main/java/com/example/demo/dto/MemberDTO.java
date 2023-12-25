package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    private String id; //아이디
    
    private String password; //패스워드
    
    private String name; //이름
    
    private LocalDateTime regDate; //등록일
    
    private LocalDateTime modDate; //수정일
    
}
