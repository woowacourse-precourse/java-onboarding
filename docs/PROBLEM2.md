## 🚀 기능 요구 사항

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"

임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |

### 접근방법

- 정규표현식을 이용해서 연속하는 중복 문자패턴이 있으면 그 부분은 빈 문자열로 변경한다.

### 기능목록

- [x] 정규식을 갖는 패턴으로 생성해주는 기능.
- [x] 패턴에 매칭할 문자열을 입력해주는 기능.
- [x] 해당 패턴에 맞는 문자열이 있는지 확인하는 기능. 
- [x] 중복 문자 기준으로 replace해주는 기능.