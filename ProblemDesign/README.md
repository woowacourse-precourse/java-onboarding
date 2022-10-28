S# 미션 - 온보딩

# 🔍 문제1


##예상 필요 기능 정의
1. 들어온 리스트를 잘라서 더하는 기능(sum)
2. 들어온 리스트를 잘라서 곱하는 기능(mul)
3. 위에 구한 리스튿을을 합쳐서 max를 찾는 기능(max)
4. pobi 와 crong중 누가 큰 값을 가지고 있는지 비교하고 문제의 요구사항대로 출력해주는 기능(compare)
5. 그외 -1인 상황을 예외해주는 예외처리 기능(exception)
---
##1. sum
###1.1 sum method
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
###1.2 sum Test

~~~java
@Test
void sum()
{
    List<Integer> human = List.of(123,124);
    List<Integer> results = Arrays.asList(6,7);
    assertThat(Problem1.sum(human)).isEqualTo(results);
}
~~~
---
##2. mul
###2.1 mul method
~~~java
/***
 * 2. 들어온 리스트들을 잘라서 곱하는 mul method
 *
 * @param human 페이지 리스트
 * @return mul을 한 리스트가 출력한다.
 */
public static List<Integer> mul(List<Integer> human)
{
    List<Integer> sumList = new ArrayList<>();
    //입력의 경우가 두개뿐 따라서 반복문을 사용하지 않음
    sumList.add(Stream.of(String.valueOf(human.get(0)).split("")).mapToInt(Integer::parseInt).reduce(1,(a,b)-> a*b));
    sumList.add(Stream.of(String.valueOf(human.get(1)).split("")).mapToInt(Integer::parseInt).reduce(1,(a,b)-> a*b));
    return sumList;
}
~~~
###2.2 mul Test
~~~java
@Test
void mul()
{
    List<Integer> human = List.of(123,124);
    List<Integer> results = Arrays.asList(6,8);
    assertThat(Problem1.mul(human)).isEqualTo(results);
}
~~~
---
##3. max
###3.1 max method
~~~java
/***
 * 3. sum과 mul에서 받은 리스트중에 가장 큰 값을 찾는 max method
 *
 * @param sumList sum을 한 리스트
 * @param mulList mul을 한 리스트
 * @return  각 인물의 가장 큰 값을 return 해준다
 */
public static int max(List<Integer> sumList,List<Integer> mulList)
{
    List<Integer> maxList = Stream.of(sumList,mulList).flatMap(x->x.stream()).collect(Collectors.toList());
    int maxAnswer = maxList.stream().max((x, y) -> x - y).orElse(Integer.MIN_VALUE);
    return maxAnswer;
}
~~~
###3.2 max Test
~~~java
@Test
void max()
{
    List<Integer> human = List.of(123,124);
    int result = 8;
    assertThat(Problem1.max(Problem1.sum(human),Problem1.mul(human))).isEqualTo(result);
}
~~~
---
##4. compare
###4.1 compare method
~~~java
/***
     * 4. pobi와 crong을 비교해주는 method
     *
     * @param pobi  max에서 받은 pobi에서 가장 큰 값
     * @param crong max에서 받은 crong에서 가장 큰 값
     * @return 출력 요구사항대로 return 해준다
     */
    public static int compare(int pobi, int crong)
    {
        int answer = (pobi == crong) ? 0 : (pobi>crong)? 1 : 2;
        return answer;
    }
~~~
###4.2 compare Test
~~~java
@Test
void compare1()
{
    int pobi = 1;
    int crong = 2;
    int result = 2;
    assertThat(Problem1.compare(pobi,crong)).isEqualTo(result);
}
@Test
void compare2()
{
    int pobi = 2;
    int crong = 1;
    int result = 1;
    assertThat(Problem1.compare(pobi,crong)).isEqualTo(result);
}
@Test
void compare3()
{
    int pobi = 1;
    int crong = 1;
    int result = 0;
    assertThat(Problem1.compare(pobi,crong)).isEqualTo(result);
}
~~~
---
##5. Exception
~~~java
/**
 * 5. 제한사항 처리하기
 * 1) pobi와 crong의 길이는 2이다.
 * 2) pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.
 * 3) 입력 범위는 1~400
 *
 * @param pobi pobi에 제한 사항을 처리해준다
 * @param crong crong에 제한 사항을 처리해준다

 */
public static void exception(List<Integer> pobi, List<Integer> crong) throws Exception {
     /*
        ex1) 23, 24 => 23 - 24 = -1 * -1 = 정상
        ex2) 24, 23 => 24 - 23 = 1 * -1 = 비정상
        ex3) 23, 25 => 23 - 25 = -2 *- 1  = 비정상
        그 외 사항도 처리.
     */
    if(pobi.size()>=3 || crong.size()>=3) throw new InputException("지정하지 않은 범위에 값이 입력되었습니다");
    else if((pobi.get(0)-pobi.get(1))*-1!=1||(crong.get(0)-crong.get(1))*-1!=1) throw new PageSortException("연속되지 않은 페이지입니다");
    else if(pobi.get(0)<=0||pobi.get(0)>=401||pobi.get(1)<=0||pobi.get(1)>=401||
            crong.get(0)<=0||crong.get(0)>=401||crong.get(1)<=0||crong.get(1)>=401) throw new PageException("페이지의 범위가 아닙니다");

}
~~~
###5.1 정의한 Exception
~~~java
/**
 * 입력값의 길이가 2이상인 예외
 */
public class InputException extends Exception {
    public InputException(String message) {
        super(message);
    }
}

/**
 * 페이지가 1~400이 아닌경우
 */
public class PageException extends Exception {
    public PageException(String message) {
        super(message);
    }
}

/**
 * 페이지가 연속적인 범위가 아닌경우
 */
public class PageSortException extends Exception{
    public PageSortException(String message) {
        super(message);
    }
}
~~~