# 파일첨부

```
1. 환경 설정
   WebConfig 클래스 -> 상대경로 설정
   SecurityConfig 클래스 -> 경로 접근제한 설정
   application.properties -> 업로드 파일 용량 제한 설정
2. 도메인 클래스 수정
   BoardDTO -> 파일스트림 필드와파일이름 필드 추가
   Board -> 파일이름 필드 추가
3. 게시물에 파일 이미지를 첨부하는 기능 만들기
   FileUtil -> 특정경로에 파일을 저장하고 저장경로를 반환하는 기능을 가짐
   BoardService -> entityToDto메소드 수정
   BoardServiceImpl -> register 메소드 수정
4. 게시물 등록 및 상세보기 화면 수정
   board/register.html -> 이미지 파일 등록   
   board/read.html -> 이미지 파일 보여주기

* 프로젝트 내부 경로(static)에 저장하면 타이밍이슈가 발생하여 외부경로에 저장해야 한다!  
```

# 조건검색
```
1. 게시물 목록 화면 및 기능 수정
```