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
- convertLowerCharacter() : 소문자 알파벳만 가능
- convertUpperCharacter() : 대문자 알파벳만 가능



---

## ✏️ 새로 배운 내용

### 1. static, final, static final

##### < static >

- static 키워드는 ''정적' 이라는 의미이며, 주로 변수와 상수, 메소드에 적용된다.

(1) static 변수, 상수

- 클래스 내에서 static 변수 혹은 상수를 선언할 경우, 클래스가 로드되는 시점에 공간이 할당된다.

- 즉, 객체를 생성하기 전에 할당된다.

- 이에 따라 '클래스 변수' 라고도 불린다.

  - 따라서 static 변수, 상수에 접근할 때는 객체가 아닌 클래스를 통해 접근하는게 좋다.

  ```java
  WordConverter wordConverter = new WordConverter();
  wordConverter.ASCII_LOWER_A; // X
  WordConverter.ASCII_LOWER_A; // O
  ```

- 같은 클래스 타입인 여러 객체들이 공용으로 쓴다.

  - A 클래스에서 static 변수 값을 변경하면, B 클래스에서 이를 가져와도 변경된 값으로 가져와진다.

(2) static 메소드

- static 변수, 상수와 동일하게 클래스가 로드되는 시점부터 활용할 수 있다. : 객체를 생성하지 않아도 호출할 수 있다.
- static 메소드도 동일하게 객체가 아닌 클래스를 통해 호출하는 것이 좋다.
- static 메소드는 객체를 생성하지 않아도 호출될 수 있으므로, 메소드 내부에서 super, this 또는 non-static 멤버변수에 접근할 수 없다.
  - 객체가 생성되었는지 안되었는지 알 수 없기 때문
- 따라서 static 메소드에서는 static 변수, 상수, 메소드에만 접근할 수 있다.
- Math.sqrt(), Math.max() 등과 같은 Utils, Helper 클래스에 활용된다.
- 특정 분류와 관련된 메소드들을 하나의 클래스 안에 모아둘 수 있는 효과가 있다.

##### < final >

- final은 상수 정의, 메소드, 클래스에 사용될 수 있다.

(1) 상수 정의

- final 키워드를 통해 상수를 선언할 수 있다. (첫번째 정의 이후 수정할 수 없다.)
- static 없이 final만 활용할 경우, 생성자에서 첫번째 초기화를 해줌으로써 객체마다 서로 다른 상수 값을 가지게 할 수 있다.

(2) final 메소드

- 오버라이딩(재정의)을 못하게 막는 역할이다. (상수처럼 첫번째 정의 이후 수정이 불가하므로)

```java
public final void testMethod() {}
```

(3) final 클래스

- 상속을 못하게 막는 역할이다.

```java
public final class TestClass() {}
```

##### < static final >

- 상수 정의

  - static final로 상수를 정의할 경우, 모든 객체에서 동일한 상수 값을 갖게 된다.
  - static은 클래스 변수이며, final은 첫 정의 이후 수정할 수 없다.
  - 따라서 모든 객체들이 공유하고, 수정할 수 없는 진정한 상수가 되는 것.

  ```java
  public static final int ASCII_LOWER_A = 97;
  ```



### 2. enum

- WordConverter 클래스의 CharacterCategory의 내용도 멤버 상수로 선언하려다 enum에 대해 알게 되었다.
- enum은 관련있는 상수들 끼리 모아둘 수 있는 기능이다.
- 본 문제에서는 단순 열거로만 구현했지만, 더 많은 기능이 있는 것 같다.
- WordConverter 클래스의 멤버 상수들도 enum 타입으로 정의했으면 어땠을까 했지만, static final 경험을 위해 아껴두었다.
- 아마 다음과 같이 정의될 수 있을 것이다.

```java
public enum AsciiOfAZ {
  LOWERCASE_A(97), LOWERCASE_Z(122), UPPERCASE_A(65), UPPERCASE_Z(90);
  
  private int asciiNumber;
  
  AsciiOfAZ(int asciiNumber) {
    this.asciiNumber = asciiNumber;
  }
  
  public int getAsciiNumber() {
    return asciiNumber;
  }
}
```



### 3. 기능 별 클래스 생성

- 비록 하나의 클래스만을 생성했지만, 본 문제를 통해 처음으로 기능 별 클래스를 생성해 보았다.
- 기존에 기능을 함수로만 나누어 구현해 보았지만, 클래스 단위로 나누어 구현해 보니 훨씬 더 정리된 느낌이고, 객체 지향스러운 느낌이 들었다.
- 본 문제에서 필요한 기능은 word의 알파벳 변환이었으므로, 객체 내에서 private 하게 동작하거나 객체 생성이 필요한 방식이 아닌, Math.max()나 String.join() 처럼 객체 생성 없이 클래스만으로 메소드에 접근할 수 있도록 static으로 구현하였다.
  - word 전체를 변환하는 기능 말고 알파벳 하나를 변환하는 기능도 필요로 하는 사람이 있을 수 있다.
- 이렇게 '제공되는 형태'의 기능을 구현할 때는 static 메소드로 구현하는 것도 나쁘지 않은 방법인 듯 하다.
- 남은 문제들 중에서 private 하게 동작하는 방식 위주로도 한번 구현해 보면 좋을 것 같다.


### 4. 사용자 정의 예외 클래스

- 문제를 다 해결하고 예외처리 과정에서 문득 예외 클래스를 직접 생성해서 관리할 수 있는 방법에 대해 떠올랐다.
- problem4 패키지 내에 exception 패키지를 생성한 후, 예외 클래스를 직접 생성해 보았다.
- java에서 예외는 **일반 예외(Exception)**와 **실행 예외(RuntimeException)**가 있다.
  - 일반 예외 : 코드를 컴파일하는 과정에서 예외 처리에 대한 검사 수행
    - 컴파일 과정에서 예외가 발생할 수 있는 경우들에 대해 try-catch로 처리를 해주면 된다.
  - 실행 예외 : 컴파일하는 과정에서 예외 처리에 대한 검사 미수행
    - 컴파일 과정에서는 통과되고, 런타임 시 예외가 발생하게 되므로 주의해야 한다. 보통 개발자의 부주의 혹은 경험 부족으로 인해 발생하기 때문에 로직으로 예외처리를 할 필요는 없다.
    - 다만, 오류 메세지를 통해 어떤 오류인지 파악할 수 있어야 하며, 애초에 실행 예외가 발생하지 않도록 주의해야 한다.
    - NullPointerException, ArrayIndexOutOfBoundsException, NumberFormatException, ClassCastException 등

##### < 사용자 정의 예외 클래스 >

- 선언

  - 일반 예외로 선언 : Exception 상속
  - 실행 예외로 선언 : RuntimeException 상속
  - 클래스 이름은 ~~Exception으로 끝내기
  - 필드, 생성자, 메소드 등을 선언할 수도 있지만, 대부분 생성자만 선언한다.

  ```java
  public class CharacterCategoryMistmatchException extends Exception {
    
  }
  ```



- 생성자

  - 생성자는 2개를 선언하는 것이 일반적. (**매개 변수 없는 기본 생성자**, **예외 메세지를 매개 변수로 받는 생성자**)

  ```java
  public class CharacterCategoryMistmatchException extends Exception {
    // 매개 변수 없는 기본 생성자
    public CharacterCategoryMistmatchException() {  }
    
    // 예외 메세지를 매개 변수로 받는 생성자
    public CharacterCategoryMistmatchException(String errorMessage) {
      super(errorMessage);
    }
  }
  ```

  - Exception 클래스를 상속받기 때문에 getMessage(), printStackTrace()와 같은 Exception 클래스의 메소드들을 활용할 수 있다.
    - printStackTrace() : 예외 발생 코드를 추적해서 모두 콘솔에 출력한다. 어떤 예외가 어디서 발생했는지 상세하게 출력되어 디버깅에 활용될 수 있다.

- 예외 발생

  - Exception에서 발생시킨 것과 동일한 방식으로 throw new ~~Exception("메세지"); 하면 된다.

    ```java
    try {
      if (lowercaseCharacter < ASCII_OF_LOWERCASE_A || ASCII_OF_LOWERCASE_Z < lowercaseCharacter) {
        throw new CharacterCategoryMismatchException("The character is NOT LOWERCASE. Or not alphabet");
        
        ...
          
      } catch (CharacterCategoryMismatchException e) {
        System.out.println(e.getMessage());
    		return 0;
      }
    }
    ```
  