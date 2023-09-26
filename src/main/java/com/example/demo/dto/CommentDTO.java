package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    
	private int commentNo; //댓글번호
	private int boardNo; //글번호
	private String content; // 댓글내용
	private String writer; // 작성자
    private LocalDateTime regDate; //등록일자
    private LocalDateTime modDate; //수정일자
}
