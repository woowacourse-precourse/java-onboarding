# 문제 2.

### **Problem 2.**

**문제 기능 요구 사항**

- cryptogram을 입력 인자로 받는다.
- cryptogram 이 문제의 요구사항에 부합하는지 확인한다. (유효성 검사)
  1. cryptogram의 길이가 1이상 1000 이하 인가?
  2. cryptogram이 알파벳 소문자로만 이루어져 있는가?
    1. 알파벳이 아닌 다른 문자가 들어있는지 여부 확인.
    2. 모두 알파벳으로 이루어져 있다면 대문자가 있지는 않은지 확인.
- cryptogram에서 중복되는 문자들을 삭제한 결과를 리턴한다.

**기능 구현 중 고민 사항**

- 유효성 검사를 효과적으로 하는 방법에 대한 고민
  - ValidityChecker 클래스를 생성하였다.
- 알파벳으로만 이루어져 있는지, 알파벳 소문자로만 이루어져 있는지 판단하는 방법
  - 정규식을 이용한다.
  - 참고 : [https://androidkim.tistory.com/4](https://androidkim.tistory.com/4)
- stack을 이용해 중복을 제거하는 방법



**구현 내용**

1. Crypto 클래스를 생성하여, 입력받은 문자열을 생성자의 인자로 하여 객체 생성.
2. Crypto 클래스 생성자 내부에서 validityChecker 클래스를 생성해 입력된 문자가 유효한지 확인 후 문제 발생 시 런타임 에러를 생성함
3. stack을 이용한 중복문자 제거 방법
  - stack의 top과 현재 넣고자 하는 인덱스가 같을 경우 pop 시켜 주었다.
    - 이 경우 같은 문자가 3번 이상 연속할 때 제거가 잘 되지 않는다.
  - prevPopValue 변수를 만들어 이전에 pop한 값을 저장해, push 할 때마다 비교한다.
    - 이 경우 prevPopValue의 값을 제대로 초기화해주지 않으면 연속하지 않은 문자도 prevPopValue와 같을 경우 삭제가 된다.
  - prevPopValue 변수를 만들어 저장하고, 새로 push 가 일어날 때마다 초기화해 주었다.

    ```java
    private Stack<Character> stackMaker(Stack<Character> stack) {
      char prevPopValue = 0;
      for (int i = 0; i < cryptogram.length(); i++) {
        if (stack.empty()) {
          if (prevPopValue == cryptogram.charAt(i)) {
            continue;
          }
          stack.push(cryptogram.charAt(i));
          prevPopValue = 0;
          continue;
        }
        if (stack.peek() == cryptogram.charAt(i)) {
          prevPopValue = stack.pop();
          stack.trimToSize();
        } else if (stack.peek() != cryptogram.charAt(i)) {
          if (prevPopValue == cryptogram.charAt(i)) {
            continue;
          }
          stack.push(cryptogram.charAt(i));
          prevPopValue = 0;
        }
      }
      return stack;
    }
    
    ```

4. Stringbuilder 를 사용하여 stack에 저장된 char 들을 한 String으로 묶음.

**예외케이스 구현**

2번의 경우 예외케이스를 만족하지 않을 시 프로그램을 종료하는 것이 맞다 판단해 run time error를 생성하였다.

1. 입력문의 길이가 조건을 만족하지 않는 경우 (빈문자열, 1000자 이상)
2. 입력문에 영어 소문자가 아닌 다른 문자가 있는 경우 (띄어쓰기, 대문자 등)
3. 스택 활용에 있어서 문제가 발생할 경우 ( 빈 스택에서 pop을 하려는 경우가 있는가?)
4. 스택 사용 방식이 틀려 중복문자열 제거가 제대로 되지 않은 경우 (같은 문자가 홀수번 입력될 경우, 처음부터 중복문자들이 들어오는 경우, prevPopValue 변수가 제대로 초기화가 되지 않은 경우)

```JAVA
@Test
void case1() {
    String cryptogram = "browoanoommnaon";
    String result = "brown";
assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
}

@Test
void case2() {
    String cryptogram = "zyelleyz";
    String result = "";
assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
}

@Test
void case3() {
    String cryptogram = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    String result = "";
assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
}

@Test
void myCaseForPro2Uppercase1() {
    String result = "";
    String cryptogram = "ZyelleyZ";

assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
}
@Test
void myCaseForPro2Uppercase2() {
    String result = "";
    String cryptogram = "abccbaD";

assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
}

@Test
void myCaseForPro2Space() {
    String result = "";
    String cryptogram = "";

assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
}

@Test
void checkTmpError() {
    String result = "brnown";
    String cryptogram = "brooonown";

assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
}

@Test
void case4() {
    String result = "rnown";
    String cryptogram = "bbrooonown";

assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
}
```
