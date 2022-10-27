## 🚀 기능 요구 사항

어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었다. 청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였다.

엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.

| A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Z | Y | X | W | V | U | T | S | R | Q | P | O | N | M | L | K | J | I | H | G | F | E | D | C | B | A |

### 제한사항

- word는 길이가 1 이상 1,000 이하인 문자열이다.
- 알파벳 외의 문자는 변환하지 않는다.
- 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.

### 실행 결과 예시

| word | result |
| --- | --- |
| "I love you" | "R olev blf" |

<br>

---

## 📄 기능 정리

### 0. WordConverter class

- 외부에서 객체 생성 없이 멤버 상수, 메소드에 접근할 수 있도록 전부 static으로 선언
- 객체 생성을 위한 클래스보다 word 변환을 위한 메소드 묶음으로 설계
- 클래스 내부에서만 활용되는 CharacterCategory만 private으로 설정

##### <멤버 필드(변수, 상수)>

- public static final int ASCII_OF_LOWERCASE_A = 97
- public static final int ASCII_OF_LOWERCASE_Z = 122
- public static final int ASCII_OF_UPPERCASE_A = 65
- public static final int ASCII_OF_UPPERCASE_Z = 90
- private enum CharacterCategory { LOWERCASE, UPPERCASE, NOT_ALPHABET }

##### <멤버 메소드>

- public static String convertWord(String word) : 문자열 전체 변환
- public static CharacterCategory checkCharacterCategory(char character) : 소문자, 대문자, 알파벳 아님 중 하나를 반환
- public static char convertLowerCharacter(char character) : 소문자 변환
- public static char convertUpperCharacter(char character) : 대문자 변환

### 1. 전체 동작 과정

(1) WordConverter.convertWord() 호출. 해당 메소드 내부에 나머지 멤버 메소드 모두 활용.

(2) 변환한 문자를 담을 리스트 (= List<Character> convertedWordList) 생성

(3) word를 한 문자씩 탐색하며 다음 과정 수행

- 멤버 상수를 토대로 문자 분류 확인 : checkCharacterCategory()
- 소문자일 경우 convertLowerCharacter() 호출
- 대문자일 경우 convertUpperCharacter() 호출
- 변환된 문자 convertedWordList에 add
- 알파벳이 아닌 경우, 바로 convertedWordList에 add

(4) convertedWordList를 String으로 변환 후 반환



### 2. 함수 별 입/출력 및 동작 과정

##### <=== 참고 ===>

- 함수의 입/출력은 다음과 같다.
- 입력 : 함수가 호출될 때 전달되는 파라미터.
- 출력 : 함수 기능 후, 최종적으로 **반환되는 값**. **print가 아님.**

##### <==========>

- convertWord()
    - 입력 : 입력된 word (= String word)
    - 한 문자씩 탐색하며 "전체 동작 과정 (3)" 수행 : String.charAt()
    - 출력 : 변환된 word (= String convertedWord)
- checkCharacterCategory()
    - 입력 : 문자 하나(= char oneCharacter)
    - 멤버 상수를 토대로 문자 분류를 파악 (소문자, 대문자, 알파벳 아님)
    - 출력 : 문자 분류 (CharacterCategory characterCategory)
- convertLowerCharacter()
    - 입력 : 소문자 하나 (= char lowercaseCharacter)
    - ASCII 코드를 활용하여 다음 공식 적용
        - convertedCharacter = lowercaseCharacter + ((109 - lowercaseCharacter)x2 + 1 )
    - 출력 : 변환된 문자 (= char convertedCharacter)
- convertUpperCharacter()
    - 입력 : 대문자 하나 (= char uppercaseCharacter)
    - ASCII 코드를 활용하여 다음 공식 적용
        - convertedCharacter = uppercaseCharacter + ((77 - uppercaseCharacter)x2 + 1 )
    - 출력 : 변환된 문자 (= char convertedCharacter)

------

## ✋ 예외 사항

- 1 <= word <= 1000