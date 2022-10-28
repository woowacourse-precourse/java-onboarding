# 문제2번
> 문제2번의 핵심은 같은 문자의 길이가 2이상 나열된다면 중복되는 문자로 간주, 제거해주는 Solution이 필요하다.<br>
> Two Pointer Algorithm을 활용하여 해결하자.

# 기능 명세
* 중복되는 문자가 존재할 때, 제거하여 새롭게 문자열을 생성 후, 더 이상 중복되는 문자열이 없다면 해당 문자열을 return하는 메서드 생성
  decrypt(String str);
# 학습 한 내용
> Java에서 문자열을 다루는 대표적인 클래스로는 String, StringBuffer, StringBuilder가 존재한다.
> 연산 횟수, 멀티쓰레드, Race Condition 등의 상황이 발생 한다면 각 클래스의 특징을 정확히 이해 및 알고 사용해주는 것이 좋다.
> String은 먼저 immutable한 속성을 가지고 있다는 점이 특징이다.
```java
String str = "Hello";
str = str + " World!";
보통 str이 가리키는 메모리 공간에 World!를 더해 변경한 것으로 착각할 수 있지만 str이라는 참조변수가 
        새로운 메모리 영역을 가리키게 되고 기존의 공간은 Garbage Collection에 의해 사라지게 된다.
```
> 반대로 가변성(Mutable)을 가지는 StringBuffer / StringBuilder 클래스가 존재한다. append나 delete를 활용할 수 있습니다. 하지만 StringBuffer와 StringBuilder의 차이는 무엇일까?
> <br> StringBuilder는 동기화를 지원하지 않기 때문에 멀티쓰레드 환경에서 사용하는 것은 적합하지 않지만 동기화를 고려하지 않는 만큼 단인 쓰레드에서의 성능은 StringBuffer보다 뛰어나다.