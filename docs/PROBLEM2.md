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
  - while문을 통해 빈 문자열("")이 반환될 때까지 **deleteRepeatedString()** 함수를 호출한다.
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
          - modifiedCryptogram = ""
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