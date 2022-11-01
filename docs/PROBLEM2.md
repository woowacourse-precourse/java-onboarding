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

### 기능목록
- 현재 문자열 형태에서 연속하는 중복 문자열들을 발견하는 함수
    - 기준문자와 기준문자의 인덱스를 저장
    - 다음 문자를 확인해서 기준문자와 같으면 다음문자를 탐색
    - 기준문자와 다르다면 찾은 모든 인덱스를 결과 list에 추가하고 다시 반복한다.
        - 단, 인덱스가 2개 이상일 때만 list에 저장함
- 문자열에 특정 부분을 제거하는 함수 (문자열과 시작인덱스, 끝인덱스를 전달)
    - 뒤쪽 인덱스 부터 제거해야 인덱스가 뒤틀리지 않음
    - 즉, list를 pop 해야함

### 참고자료
- Java String Index 다루기 : https://jhnyang.tistory.com/335


