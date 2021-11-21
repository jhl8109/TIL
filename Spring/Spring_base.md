## Spring 웹 기초

##### 정적 컨텐츠 : 파일을 웹에 띄워줌
##### MVC와 템플릿 엔진 : jsp, php 등 서버에서 프로그래밍 한 것을 html에 접목시켜서 띄움
##### API : json포멧으로 정보를 전달한 것을 클라이언트에서 활용하여 띄움

#### 정적컨텐츠

* static 폴더에서 사용가능함.
* 스프링에서는 요청한 내용 관련 컨트롤러를 먼저 찾고 이와 관련한 컨트롤러가 없으면 static에서 html파일을 찾는다.

#### MVC
* MVC : Model, View, Controller
* View: 화면을 그리는 데 집중
* Model : 화면에 필요한 것을 담아서 넘김
* Controller : 로직을 처리하는 데 집중

#### API

* 템플릿 엔진에서 화면을 조작하는 것이 아닌 text 그대로 사용됨
* 보통 text보다 객체 형태로 넘김(json)
* @ResponseBody를 사용함
-  컨트롤러에서  @ResponseBody가 있으면(API) return으로 템플릿을 찾는 것이 아니라 그대로 return 값을 넘김. 
- 객체가 오면 json으로 문자열이 오면 String으로 넘겨짐. (ViewResolver 대신 HttpMessageConverter에 의해) 
