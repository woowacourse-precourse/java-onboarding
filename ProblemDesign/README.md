S# 미션 - 온보딩

# 🔍 문제1


##예상 필요 기능 정의
1. 들어온 리스트를 잘라서 더하는 기능(sum)
2. 들어온 리스트를 잘라서 곱하는 기능(mul)
3. 위에 구한 리스튿을을 합쳐서 max를 찾는 기능(max)
4. pobi 와 crong중 누가 큰 값을 가지고 있는지 비교하고 문제의 요구사항대로 출력해주는 기능(compare)
5. 그외 -1인 상황을 예외해주는 예외처리 기능(exception)
---
##구현코드
###1. sum method
~~~java
 /***
 *  1. 들어온 리스트들을 잘라서 더하는 sum method
 *
 * @param human 페이지 리스트
 * @return sum을 한 리스트가 출력된다.
 */
public static List<Integer> sum(List<Integer> human)
{
    List<Integer> sumList = new ArrayList<>();
    //입력의 경우가 두개뿐 따라서 반복문을 사용하지 않음
    sumList.add(Stream.of(String.valueOf(human.get(0)).split("")).mapToInt(Integer::parseInt).sum());
    sumList.add(Stream.of(String.valueOf(human.get(1)).split("")).mapToInt(Integer::parseInt).sum());
    return sumList;
}
~~~


###생성 TEST CASE
####1. sum Test
~~~java
@Test
void sum()
{
    List<Integer> human = List.of(123,124);
    List<Integer> results = Arrays.asList(6,7);
    assertThat(Problem1.sum(human)).isEqualTo(results);
}
~~~


