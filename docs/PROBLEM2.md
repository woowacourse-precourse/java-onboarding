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

---
## 📮 기능 구현

### 1. 연속적 중복문자 제거
 - [x] `StringBulider`, `Stack` 자료구조 이용
 - [x] 읽은 문자들을 Stack에 저장 후, 연속적으로 반복되지 않는 경우에 한해 `StringBulider`에 추가
 - [x] `process(String str)` : 주어진 문자열에서 연속적으로 반복되는 문자들을 제거 후, 제거 된 문자열을 반환하는 메서드

### 2. Logic
 - [x] `solution(String cryptogram)` :
   - 입력된 문자열을 `process` 메서드를 통해 연속반복되는 문자열 제거
   - 여기서, 비교를 위하여 `process`메서드를 사용하기 전 문자열과 사용 후 문자열을 분리
   - 위 과정을 while문을 통한 반복 실행
   - while문 종료 조건 : `process` 적용 전후 문자열이 동일할 경우 종료
   - 최종 문자열 반환