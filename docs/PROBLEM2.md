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

### 기능 목록
- continuityToZero method : 시작 인덱스와 끝 인덱스를 입력받아 cryptogramArray의 해당 인덱스 문자를 0으로 바꾼다.
- howManyZero method : 시작 인덱스와 세는 방향을 입력받아 cryptogramArray의 연속된 0이 몇 개인지 반환한다.
- -concatToAnswer method : cryptogramArray의 문자를 0을 제외하고 answer에 추가한다.
- zeroChecker method : 연속되는 문자 여부를 체크하면서 cryptocramArray의 어디까지 0으로 만들지 continiotyEnd를 갱신한다.