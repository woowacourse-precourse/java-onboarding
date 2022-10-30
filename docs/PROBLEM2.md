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


## 기능 목록
### 입력으로 주어진 문자열을 압축하는 기능
- 현재 문자열을 대상으로, 연속으로 등장하는 부분 문자열을 삭제하는 기능
  - 현재 문자의 앞 뒤에 동일한 문자가 있는지 판단하는 기능

## 도메인 목록
### StringZipper
- 주어진 문자열의 압축 기능을 수행하는 메서드를 구현하는 클래스

    
    boolean checkContinuity(String string, int index)
- 주어진 문자열의 index 위치의 문자가 이전 / 이후 문자와 같은지의 여부를 반환하는 메서드

    
    String zipStringOneTime(String string)
- 주어진 문자열에서 동일한 문자가 연속되는 부분 문자열을 제거하고 반환하는 메서드


    String zipString(String string)
- 주어진 문자열에 더이상 삭제할 부분이 없어질 때까지 삭제를 반복하는 메서드