##thymeleaf 템플릿엔진 동작 확인

Spring 은 tomcat 서버를 내장하고 있음

@GetMapping("") 을 통해 Get방식으로 넘어오는 url에 매칭 되어 바로 아래에 있는 method가 실행됨.

컨트롤러에서 리턴 값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리함.

즉, @GetMapping("hello") 바로 아래 method의 return 값이 hello 이면 /hello에 접속할 때 리턴 값인 hello의 이름을 가진 html을 resources/templates에서 찾는다. (hello.html)

attributeName에 맞는 attributeValue를 가져와 이를 렌더링 함.

+ spring-boot-devtools 라이브러리를 추가하면 html파일을 컴파일만 해주면 서버 재시작 없이 view파일 변경이 가능
