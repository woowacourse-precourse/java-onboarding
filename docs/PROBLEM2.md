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

## 📝 구현 기능 목록
- 중복 체크 기능 구현
    - 연속해서 중복되는 문자 확인


- 중복 제거 기능 구현
    - stack 생성 후 문자열을 돌면서 빈 stack일경우 push
    - 현재 문자와 stack의 맨 위값을 비교해서 같을 경우 변수로 지정 후 continue
    - 다를 경우 지정한 값과 같다면 pop한 뒤에 push, 변수 초기화
    - 마지막으로 지정한 값과 비교 후 같다면 pop


- 결과 출력
    - 중복이 다 제거 될때 까지 제거한 후 return
  
