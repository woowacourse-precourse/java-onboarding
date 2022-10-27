# 자바 컨벤션(Java Convention)
참고
- https://naver.github.io/hackday-conventions-java/
- https://github.com/woowacourse/woowacourse-docs/blob/main/cleancode/pr_checklist.md

### 공통(Common)
- 변수명, 클래스명, 메서드명 등에는 영문/숫자/언더스코어만 허용
- 한국어 발음대로 표기 금지
    - 좋은 예 - asset(자산)
    - 나쁜 예 - jasan(자산)

### 패키지(Package)
- 패키지 이름은 소문자로 구성
  - ex) package com.mu.apigateway

### 인터페이스(Interface)
- 인터페이스 이름에 대문자 카멜표기법 적용
    - ex) CamelCase
- 인터페이스 이름에 명사/형용사 사용

### 클래스(Class)
- 클래스 이름에 대문자 카멜표기법 적용
    - ex) CamelCase
- 클래스 이름에 명사 사용
- 테스트 클래스는 ‘Test’로 끝맺음

### 메서드(Method)
- 메서드 이름에 소문자 카멜표기법 적용
    - camelCase
- 메서드 이름은 동사/전치사로 시작
    - ex) toString(), renderHtml()

### 변수(Variable)
- 상수는 대문자와 언더스코어로 구성
    - ex) public final int CHECK = 1;
    - ex) public final String SECRET_KEY = “secret”;
- 변수에 소문자 카멜표기법 적용
    - ex) private int accessToken;
  
### 추가 체크리스트
- 한 메서드에 오직 한 단계의 들여쓰기(indent)만 허용했는지?
- else 예약어를 쓰지 않았는가?
- 모든 원시값과 문자열을 포장했는가? 
- 콜렉션에 대해 일급 콜렉션을 적용했는가?
- 3개 이상의 인스턴스 변수를 가진 클래스를 구현하지 않았는가?
- getter/setter 없이 구현했는가?
  - 단, DTO는 허용
- 메소드의 인자 수를 제한했는가?
  - 최대 3개 까지 허용, 가능하면 줄이기 위해 노력
- 코드 한 줄에 점(.)을 하나만 허용했는가?
- 메소드가 한가지 일만 담당하도록 구현했는가?
- 클래스를 작게 유지하기 위해 노력했는가?

--- 

# 깃 컨벤션(Git Convention)
참고: https://gist.github.com/stephenparish/9941e89d80e2bc58a153

## 커밋 메시지 형식
```
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

커밋 메시지의 기본형식은 위와 같고 100자를 넘을 수 없습니다.

### type
- feat : 새로운 기능 추가
- fix : 버그 수정
- docs : 문서 수정
- style: 코드 포맷 변경
- refactor : 코드 리팩토링
- test : 테스트 코드 추가
- chore : 빌드, 패키지 매니저 수정

### scope
커밋 변경 위치를 지정
- ex) $location, $browser, $compile, $rootScope, ngHref, ngClick, ngView, etc...

### subject
코드 변경 사항에 대한 짧은 요약
- 현재 시제의 명령어 사용
- 첫글자 대문자 사용 X
- 끝에 점(.) 사용 X

### body
변화에 대한 동기와 이전 행동과의 대조를 포함
- 현재 시제의 명령어 사용

### footer
모든 주요 변경 사항에 대한 설명, 정당성 및 마이그레이션 참고사항

## 참고 예제
```
feat($browser): onUrlChange event (popstate/hashchange/polling)

Added new event to $browser:
- forward popstate event if available
- forward hashchange event if popstate not available
- do polling when neither popstate nor hashchange available

Breaks $browser.onHashChange, which was removed (use onUrlChange instead)
```

```
docs(guide): updated fixed docs from Google Docs

Couple of typos fixed:
- indentation
- batchLogbatchLog -> batchLog
- start periodic checking
- missing brace
```

```
style($location): add couple of missing semi colons
```