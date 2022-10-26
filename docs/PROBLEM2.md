## 🚀 기능 요구 사항

- 삽입과 삭제가 반복되므로 배열보다는 List가 낫다고 판단
- 그 중에서도 ArrayList vs LinkedList의 성능을 비교
    - 자료의 삭제가 용이한 LinkedList 채택
  
- feat 2.1: LinkedList에 문자들을 넣는다.
  feat 2.2: List를 순회하면서 i번째 항과 i+1번째 항이 같은지 검사한다.(중복된 값 있는지 검사)
  feat 2.3: 같으면 해당 값들 삭제, i=0으로 초기화한다. 
  
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
