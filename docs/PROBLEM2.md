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

### 문제 분석
- 문자열에서 중복이 동시에 2개 이상인 경우 제거 순서가 다른가?
  - 다를수 있다
  - 따라서, 절차를 정해야함
- 예시로 확인해볼떄,
  1. 우선 문자열의 중복된 문자들을 확인
  2. 중복된 문자들을 삭제 작업을 모두 진행 후
  3. 다시 중복 검사와 같은 순서로 진행  

### 기능 목록
1. findSameCharsIdx
   - 입력으로 받은 문자열 중 중복된 문자열들을 찾는 함수
   - parameter: 문자열
   - return: 중복되어 삭제 되어야 할 문자들의 인덱스
2. removeCharUsingIdx
   - parameter: 문자열과 삭제할 문자들의 인덱스 리스트
   - return: 삭제가 진행된 문자열

   