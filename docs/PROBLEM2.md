#  🚀 기능 목록

### 1. 중복 문자 검사 decode()함수 만들기
### 2. 검사 완료 된 문자열 합쳐서 출력하기



#  🚀 문제를 풀면서

처음 이 문제를 접할 때는 hashMap을 만들면 비교해서 바로 풀수 있겠지 했다. 하지만 expected: brown이 나오지 않고, browanm으로 나와 실패하게 되었다.  
이번에도 구글링을 통해 중복 문자 제거를 어떻게 풀어가는지, 사용방법이 무엇인지에 대한 검색을 시도 했다.
 Arrays.asList() 함수를 왜 쓰는지 new ArrayList() 방식과 어떤 차이점인지에 대해 알아 볼수 있었다.
 그리고, 문자열을 합치는 방법에는 2가지가 있는데 concat과 StringBuilder에 대해 알아 볼수 있었다.


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
