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
  - 중복의 제거 순서는 상관 없음
1. 문자열을 입력 받고 중복을 찾고 제거하는 함수 필요
2. 중복 확인 및 제거 기능
   - 입력 문자열의 문자를 하나씩 받아옴
     - 받아온 문자를 이전, 현재, 다음 이라는 변수에 적절히 저장
     - 현재와 다음의 문자열이 같은 경우 
       - 현재를 이전으로, 다음을 다음의 다음 문자로 지정 -> 중복 제거 효과
       - 다시 현재와 다음 비교
       - 현재와 다음이 다를때 까지 반복
     - 현재와 다음이 다른 경우 answer에 문자 저장

### 기능 목록
1. checkEdgeCase 
   - 입력 문자열의 길이가 1, 2, 3인 경우에 대한 함수
   - parameter: String
   - return: 중복이 제거된 문자열
2. findNotEqualCharIndex
   - parameter: String str, int startIdx
   - return: int idx1, idx2
   - 문자열과 비교를 시작할 인덱스를 입력으로 받음
   - 시작 인덱스 위치에 있는 문자와 idx+1 에 위치한 문자가 다를때까지 idx+1 을 진행
   - 입력으로 받은 검색 시작 인덱스와 다음 인덱스를 리턴
   