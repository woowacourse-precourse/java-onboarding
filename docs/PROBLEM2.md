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

### 기능 구현
1. cryptogram을 list로 변경해준다.
2. 반복이 시작되는 인덱스(startIdx)와 반복이 끝나는 인덱스(endIdx)를 구해준다.
3. 연속 중복 문자열이 존재한다는 것을 확인하기 위해 startIdx를 구할 때 cnt에 1을 더해준다. 
4. list에서 startIdx에 든 알파벳을 제거해준다. 
5. 3번을 endIdx에서 startIdx를 빼준 값만큼 반복해준다. 
6. 또 다른 연속 중복 문자열이 있는지 확인하기 위해 반복문을 재실행하기 전, cnt를 0으로 바꿔준다. 
7. 2번부터 6번을 연속 중복 문자열이 없을 때까지 반복해준다. 
8. 만약 cnt값이 0이라면 연속 중복 문자열이 없는 것이므로 반복문을 종료해주고 결과값을 리턴해준다.