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

### 기능 조건
1. 문자열 제거 조건을 보면 순차적으로 연속 문자 제거
2. 더 이상 제거 할 문자가 없으면 결과 값 반환

### 기능 구현
1. 중복 문자열 제거 - removeRedundantSequence()

### 고려 사항
1. 새로운 문자열 반환을 위한 문자열 처리에서 '+'을 사용한 문자열 합병이 아닌 StringBuilder를 통한 문자열 합병 -> 시간 복잡도 고려
2. 입력값의 제한 사항이 1000자를 넘지 않는다는 점에서 iter를 통한 반복의 시간 복잡도가 크지 않음을 고려
3. 알파벳이 소문자로만 이루어져 있다는 점에서 입력 문자열에 대한 예외 발생 하지 않음을 고
