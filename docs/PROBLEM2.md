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
    - 스택 생성
    - 0번 문자 스택에 저장
    - 이전에 삭제된 문자 저장 변수 beforeRemovedChar 선언

    - 1번 문자부터 순차적으로 검사
    - 문자 탐색
    
    beforeRemovedChar가 null이 아닌 경우
        - beforeRemovedChar와 문자가 같은 경우
            문자를 저장하지 않고 continue
    beforeRemovedChar가 null인 경우    
        stack.peek()과 문자 비교 
            stack.peek()와 문자가 같은 경우
                -stack.pop()해서 beforeRemovedChar에 저장
            stack.peek()와 문자가 다른 경우
                - beforeRemovedChar=null
                - stack.push(char)
<br><br>
#### 3. 검사를 통해 최종적으로 얻은 문자열 리턴
    - 문자 배열 String으로 병합
    - answer에 저장하여 return
