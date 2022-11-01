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

> **<기능 1><br>
암호해독을 한다.**<br>
*private static String decrypt(String cryptogram)* <br>

> **<기능 2><br>
암호해독이 모두 끝났는지 확인한다.**<br>
*private static boolean isDone(List<String> duplicatedLetters)*

> **<기능 3><br>
중복문자열을 찾아낸다.**<br>
*private static List<String> findLetters(String cryptogram)*
> - 기능 3-1<br>
    찾아낸 중복문자의 길이만큼 문자열을 만들어낸다.<br>
    *private static String getLetter(int length, char charAt)*

> **<기능 4><br>
중복문자열 리스트가 가진 문자열을 암호문에서 제거한다.**<br>
*private static String removeDuplicatedLetters(String cryptogram,
List<String> duplicatedLetters)*
