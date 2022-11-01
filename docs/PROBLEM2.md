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

## 기능 요구사항 및 체크리스트 정리(1차)

### 1. 문제풀이 기본 요구사항 정리
- ✅ solution 메소드 구현
  - ✅ decrypt 메소드를 사용하여 cryptogram을 입력했을 때 결과값이 동일하다면 복호화가 다 된 것이므로 해당 값을 반환
  - ✅ compareTwoGram 메소드를 사용하여 cryptogram과 decryptgram을 비교 후 복호화 과정이 더 필요한 지 참/거짓 값을 반환

- ✅ decrypt 메소드 구현
  - ✅ countDuplication 메소드를 사용하여 Stack에 문자들을 삽입하면서 중복 여부 및 중복 문자의 개수 확인 및 제거
  - ✅ 남은 문자들을 문자열로 만들어 반환

- ✅ compareTwoGrams 메소드 구현
  - ✅ 두 개의 문자열이 동일한 문자열인지 확인하여 참/거짓 값을 반환 

- ✅ countDuplication 메소드 구현
  - ✅ 문자를 하나씩 Stack에 삽입
  - ✅ 중복문자 식별 시 Stack에 삽입하며 개수 체크
  - ✅ 중복되지 않는 문자 식별 시 Stack에 삽입하기 전에 중복 문자 개수가 2 이상이면 0이 될 때까지 stack에서 pop 처리
  - ✅ 마지막에 중복문자 개수를 확인하고 2이상이면 0이 될 때까지 stack에서 pop처리

- ✅ removeStackDuplication 메소드 구현
  - ✅ 중복문자 개수를 저장하는 dupCount 값이 0이 될 때까지 Stack에서 pop 처리

---

## 기능 요구사항 및 체크리스트 정리(2차)

### 1. 추가 구현사항
- ✅ 세 번 이상 반복되는 문자에 대한 처리 고려

### 2. 리펙토링
- ✅ 메소드 기능별로 구분해서 구현