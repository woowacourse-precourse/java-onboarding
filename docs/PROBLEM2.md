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

# ----------
## 문제2

1. cryptogram 문자열을 String 배열에 넣는다.
2. 세가지 경우(첫 글자, 마지막 글자, 중간 글자)로 나누어 한글자씩 검사한다. 중복글자가 아닌 경우 sb에 넣는다. 모든 글자 검사가 끝나면 cryptogram 문자열을 중복을 한번 제거한 결과인 sb로 대체한다. 
3. cryptogram 문자열에 중복값이 더이상 없으면 break;

# ----------
