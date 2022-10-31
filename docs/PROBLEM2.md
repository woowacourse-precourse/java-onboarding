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

***
## 기능 목록

### 메소드 목록
* removeDuplicated
    * String을 charArray로 변환
    * 이전 index의 character를 담은 prev와 현재 index의 character를 비교
    * 다르다면 현재 index의 character를 charArray에 삽입
    * prev를 현재 index의 character로 갱신하고, index 증가
    * 같다면 index 감소

### 작동 과정
* 더 이상 중복되는 문자가 없어 removeDuplicated를 수행하여도 String의 길이가 변하지 않을 때까지 수행