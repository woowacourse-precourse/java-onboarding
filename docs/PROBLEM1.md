# 문제 1.

### **Problem 1.**

**문제 기능 요구 사항**

- 두 명의 유저에게 주어지는 오른쪽, 왼쪽 페이지 쪽수를 받는다.
- 각 숫자들이 문제의 요구사항에 부합하는지 확인한다. (유효성 검사)
  1. pobi, crong의 길이가 2인가? (1쪽만 주어진다던가, 2쪽 이상이 주어지는 경우)
  2. 입력으로 주어진 책이 1 초과 400 미만인가?
  3. 입력으로 주어진 배열에서 왼쪽 페이지가 홀수, 오른쪽 페이지에는 짝수가 들어오는가?
  4.  입력으로 주어진 배열의 값 중 오른쪽 페이지가 왼쪽 페이지보다 1만큼 큰가?
  5. 각 숫자들이 문제의 요구사항에 부합하는지 확인한다.
- 두 명의 유저에게서 각자 최댓값을 골라내 승자를 가린다.

**기능 구현 중 고민 사항**

- 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
  - 책의 표지가 아닌,  리스트가 1,2 쪽,  399,400 쪽이 나오는 경우를 시작면과 마지막면으로  해 예외처리를 하였다.


**구현 내용**

1. User 클래스를 생성해 pobi, crong 객체를 생성하고자 하였다.
2. User 객체를 생성하기 전 예외처리 메서드들을 만들어 위의 유효성 검사를 만족하지 않는 경우 -1을 리턴하도록 하였다.

```java
public static int pageException(List<Integer> usr1, List<Integer> usr2) {
  if (usr1.size() != 2 || usr2.size() != 2) {
    return -1;
  }
  if (pageInRange(usr1, usr2) == -1) {
    return -1;
  }
  if (evenOddCheck(usr1, usr2) == -1) {
    return -1;
  }
  if (pagesInPair(usr1, usr2) == -1) {
    return -1;
  }
  return 1;
}
```

1. Pobi, Crong 객체를 생성 후, 각각의 객체에서 왼쪽 페이지, 오른쪽 페이지 자릿수의 합과 곱을 계산 해 최대값을 지정해주었다.
  1. getSum() 메서드에서는 각 자릿수에 대한 합을 구한다.
  2. getMulti() 메서드에서는 각 자릿수에 대한 곱을 구한다.
  3. getDigit() 메서드에서는 숫자의 자릿수들을 분리해 배열에 저장한다.
2. pobi의 최대값과 crong의 최댓값을 비교하여 올바른 value를 return 한다.

**예외케이스 구현**

1. 입력 문자열의 길이가 2가 아닌 경우. ( 빈 리스트, 원소 1개, 3개 등)
2. 왼쪽 페이지와 오른쪽 페이지 차이가 1이 아닌 경우.
3. 1쪽, 400 쪽이 입력으로 들어오는 경우.
4. 쪽수 범위를 만족하지 않는 경우.

``` JAVA
void myCaseForPro1() {
    int result = -1;
    List<Integer> pobi = List.of(99, 102, 10);
    List<Integer> crong = List.of(211, 212, 100);

    List<Integer> pobi1 = List.of(99, 103);
    List<Integer> crong1 = List.of(211, 213);

    List<Integer> pobi2 = List.of(92, 103);
    List<Integer> crong2 = List.of(212, 213);

    List<Integer> pobi3 = List.of(92, 102);
    List<Integer> crong3 = List.of(212, 212);

    List<Integer> pobi4 = List.of(1, 2);
    List<Integer> crong4 = List.of(399, 400);

    List<Integer> pobi5 = List.of(0, 1);
    List<Integer> crong5 = List.of(401, 402);

    List<Integer> pobi6 = List.of(-389, -390);
    List<Integer> crong6 = List.of(-389, -390);

    List<Integer> pobi7 = List.of(389);
    List<Integer> crong7 = List.of(399);

    List<Integer> pobi8 = new ArrayList<>();
    List<Integer> crong8 = List.of(399);

assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
assertThat(Problem1.solution(pobi1, crong1)).isEqualTo(result);
assertThat(Problem1.solution(pobi2, crong2)).isEqualTo(result);
assertThat(Problem1.solution(pobi3, crong3)).isEqualTo(result);
assertThat(Problem1.solution(pobi4, crong4)).isEqualTo(result);
assertThat(Problem1.solution(pobi5, crong5)).isEqualTo(result);
assertThat(Problem1.solution(pobi6, crong6)).isEqualTo(result);
assertThat(Problem1.solution(pobi7, crong7)).isEqualTo(result);
assertThat(Problem1.solution(pobi8, crong8)).isEqualTo(result);
}
```