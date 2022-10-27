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

## 📄 기능 정리

### 1. 전체 동작 과정

(1) 반복문을 통해 cryptogram 내에 연속으로 중복되는 문자를 제거한다. : solveCryptogram()
  - 연속으로 중복되는 문자열 제거하는 함수 선언 : deleteRepeatedString()
  - 연속으로 중복되는 문자 제거하는 함수 선언 : deleteRepeatedCharacter()

(2) 최종 결과 문자열을 반환한다. : String answer


### 2. 함수 별 입/출력 및 동작 과정
##### <=== 참고 ===>
- 함수의 입/출력은 다음과 같다.
- 입력 : 함수가 호출될 때 전달되는 파라미터.
- 출력 : 함수 기능 후, 최종적으로 **반환되는 값**. **print가 아님.**
##### <==========>

- **solveCryptogram()**
  - 입력 : 주어진 cryptogram (= **String cryptogram**)
  - while문을 통해 수정되지 않음 문자열("NOT MODIFIED")이 반환될 때까지 **deleteRepeatedString()** 함수를 호출한다.
  - 최종 결과 문자열을 반환한다.
  - 출력 : 최종 결과 문자열 (= **String answer**)


- **deleteRepeatedString()**
  - 입력 : solveCryptogram()으로부터 주어지는 cryptogram (= **String cryptogram**)
  - 문자열 수정 여부를 저장하는 boolean 변수를 선언한다. : **boolean isModified** (Default : false)
  - 문자열을 탐색하며 다음 과정을 수행한다. : String.charAt()
      - 현재 인덱스 == 다음 인덱스 : **deleteRepeatedCharacter()** 함수를 호출하고, isModified를 true로 설정.
      - 현재 인덱스 != 다음 인덱스 : 인덱스 + 1
  - isModified의 값에 따라 출력할 **modifiedCryptogram**을 다음과 같이 설정한다.
      - isModified == true
          - modifiedCryptogram = 수정된 cryptogram
      - isModified == false
          - modifiedCryptogram = "NOT MODIFIED"
          - cryptogram은 소문자로만 이루어져 있는 제한 사항을 활용.
  - 출력 : **String modifiedCryptogram**


- **deleteRepeatedCharacter()**
    - 입력 : deleteRepeatedString()으로부터 주어지는 cryptogram (= **String cryptogram**), 중복 시작 인덱스(= **int repeatStartIndex**)
    - 입력받은 cryptogram을 List로 변환 : Arrays.asList(split())
    - repeatStartIndex의 원소와 다음 인덱스의 원소가 다를 때까지 원소 제거
    - cryptogram 리스트를 String으로 변환 : list.toString()
    - 출력 : 수정된 cryptogram (= **String modifiedCryptogram**)



---



## ✋ 예외 사항

- 1 <= cryptogram의 길이 <= 1000
- cryptogram은 모두 소문자로 이루어져 있다.


---

## ✏️ 새로 배운 내용

### 1. String <-> List 변환

- String -> List 변환

  - 과정 : String -> Array -> List
  - String -> Array : **String.split()** 함수를 통해 String[] 배열로 변환
    - split() 함수의 매개변수로 인덱스 나누는 **기준 문자**를 전달 (빈 문자열 전달 시 한 문자씩 쪼갬)
  - Array -> List : **Arrays.asList()** 함수를 통해 String[] 배열을 List로 변환

    ```java
    List<String> cryptogramList = new ArrayList<>(Arrays.asList(cryptogram.split("")));
    ```

- List -> String 변환

  - String.join() 함수 활용

  - 파라미터

    - 문자열 delimiter : List를 하나의 String으로 합칠 때, 각 원소들 사이에 삽입되는 문자열
    - 리스트 : 하나의 String으로 합칠 List

  - 예시

    ```java
    List<String> strings = List.of("Java", "is", "cool");
    String message = String.join(" ", strings);
    //message : "Java is cool"
    
    Set<String> strings = new LinkedHashSet<>(List.of("Java", "is", "cool"));
    String message = String.join("-", strings);
    //message : "Java-is-cool"
    ```



### 2. Primitive type, Reference type

- Java에서 타입은 크게 primitive type과 reference type이 있다.

#### < primitive type >

- boolean, int, long, float, double, char 등 정수, 실수, 문자 등의 실제 데이터 값을 저장하는 타입
- 반드시 사용하기 전에 선언되어야 함.
- null을 가질 수 없음.
- Stack 메모리에 저장

#### < reference type >

- primitive type을 제외한 모든 타입들 (array, enumeration, class, interface)
- java.lang.Object 를 상속받으면 reference type이 된다고 한다.
- null 가능.
- 참조 타입의 **변수 자체**는 실제 값을 갖고 있는게 아닌, **실제 값이 저장되어 있는 주소값**을 갖게 된다. 이는 Stack에 저장된다.
- **실제 값은 Heap**에 저장된다.



### 3. 값 비교 (==, equals())

- 요약

  - primitive type은 == 으로 비교
  - reference type은 equals()로 비교

- ==

  - primitive type에 대해서는 값을 비교한다.
  - reference type에 대해서는 주소값을 비교한다.

- equals()

  - equals()는 최상위 클래스인 java.lang.Object에 정의되어 있으며, 모든 하위 클래스에서 재정의해서 사용할 수 있으므로, 필요하면 재정의하면 된다.
  - String의 경우, equals()에서 주소를 비교하는게 아닌, 내용을 비교하도록 구현되어 있다.
  - 따라서 다음과 같이 equals를 활용해 비교할 수 있다.

  ```java
  if (a.equals(b) == true) {
    System.out.println("a == b");
  }
  ```

  
