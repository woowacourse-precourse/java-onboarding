## 🤷🏻‍ ️접근 방법
* cryptogram의 i번째 문자를 i-1번째 문자와 비교한 뒤 다르면 answer에 문자를 추가한다.
* cryptogram의 i번째 문자를 i-1번째 문자와 비교한 뒤 같으면 answer의 마지막 문자를 제거하고 추가하지 않는다.
* answer이 cryptogram과 같아지거나 정답이 빈 문자열인 경우 종료한다.

## 💭 느낀 점
* Stack을 활용하여 풀면 더욱 간단하고 깔끔하게 풀 수 있었지만, 반복문과 조건문만을 활용하여 풀어보고 싶어서 도전해보았는데 생각보다 코드를 작성하기가 까다로웠다.

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
