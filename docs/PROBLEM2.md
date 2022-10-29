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

## PROBLEM2 구현 기능 정리
#### 1. Cryptogram 문자열 분리
<br><br>
#### 2. 문자열 검사 
    - 0번 문자부터 순차적으로 검사
    - 현재 문자열 before변수에 담기
    - 다음 문자열 탐색
        - 문자열이 같은 경우
            - 현재 문자와 다음 문자열 제거
            - 다음 문자열 탐색 후 같으면 계속 제거
            - 연결된 같은 문자가 모두 지워지면 문자열 다시 처음부터 탐색
        - 문자열이 다른 경우
            - before에 다음 문자열 삽입
            - 순서 넘어가기
<br><br>
#### 3. 검사를 통해 최종적으로 얻은 문자열 리턴
    - 문자 배열 String으로 병합
    - answer에 저장하여 return
