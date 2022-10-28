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

## 구현 기능 목록

- (1) String을 StringBuilder로 변환하는 기능

  ```java
  private static StringBuilder changeToStringBuilder(String crpytogram)
  ```

- (2) 중복 체크 기능

  ```java
  private static boolean isDuplicate(StringBuilder cryptogram, int index)
  ```

  - true : 같은 알파벳 소문자가 2번 이상 붙어 나열되면 중복

- (3) 중복 범위 계산 기능

  ```java
  private static int getDuplicateRange(StringBuilder cryptogram, int start)
  ```

- (4) 중복 문자 제거 기능

  ```java
  private static StringBuilder removeDuplicate(StringBuilder crpytogram, int start, int range)
  ```

- (5) 암호 해독 기능

  ```java
  private static StringBuilder decrypt(String cryptogram)
  ```

  - (2), (3), (4) 기능을 이용해 암호 해독

- (6) StringBuilder를 String로 변환하는 기능

  ```java
  private static String changeToString(StringBuilder stringBuilderCryptogram)
  ```
