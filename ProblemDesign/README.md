# 미션 - 온보딩

##목차
*[문제1](#문제1)

*[문제2](#문제2)

*[문제3](#문제3)

*[문제4](#문제4)


*[문제5](#문제5)

*[문제6](#문제6)

*[문제7](#문제7)

#문제1


##예상 필요 기능 정의
1. 들어온 리스트를 잘라서 더하는 기능(sum)
2. 들어온 리스트를 잘라서 곱하는 기능(mul)
3. 위에 구한 리스튿을을 합쳐서 max를 찾는 기능(max)
4. pobi 와 crong중 누가 큰 값을 가지고 있는지 비교하고 문제의 요구사항대로 출력해주는 기능(compare)
5. 그외 -1인 상황을 예외해주는 예외처리 기능(exception)
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
##5. Exception
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
public class RangeException extends Exception {
    public RangeException(String message) {
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
###5.2 exception method
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
##6. 최종 솔루션
~~~java
public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;
    try {
        exception(pobi,crong);
        int pobiMax = max(sum(pobi), mul(pobi));
        int crongMax = max(sum(crong), mul(crong));
        answer = compare(pobiMax, crongMax);
    }catch (InputException e1)
    {
        return -1;
    }catch (PageException e2)
    {
        return -1;
    }catch (PageSortException e3)
    {
        return -1;
    }
    return answer;
}
~~~
---
#문제2
##예상 필요 기능 정의
1. 문자열에서 연속된 값이 있는지 확인하는 메소드
2. 예외처리하기
##1. deleteConsecutiveChar
###1.1 deleteConsecutiveChar method
~~~java
/**
 * 문자열에서 연속된 값을 찾아 제거하는 메소드
 *
 * @param cryptogram 문자열
 * @return 제거된 문자열
 */
public static String deleteConsecutiveChar(String cryptogram)
{
    int i=1;
    while (true)
    {
        if(i==cryptogram.length()||cryptogram.length()==0)
        {
            break;
        }
        if(cryptogram.charAt(i)==cryptogram.charAt(i-1)) {
            cryptogram = cryptogram.substring(0, i - 1) + cryptogram.substring(i+1);
            i = 1;
            continue;
        }
        i++;
    }
    return cryptogram;
}
~~~
###1.2 deleteConsecutiveChar Test -> main test로 대체

##2. Exception
###2.1 정의한 Exception
~~~java
public class RangeException extends Exception {
    public RangeException(String message) {
        super(message);
    }
}

public class IsUpperCaseException extends Exception{
    public IsUpperCaseException(String message) {
        super(message);
    }
}
~~~
###2.2 exception method
~~~java
/**
 * 문제의 예외인 대문자입력, 문자열 길이 범위 1~40000초과시
 *
 * @param cryptogram 문자열
 * @throws IsUpperCaseException 대문자입력시 예외발생
 * @throws RangeException 문자열 길이 범위 1~40000이 아닌경우 예외발생
 */
public static void exception(String cryptogram) throws IsUpperCaseException, RangeException
{
    char charArray[] = cryptogram.toCharArray();
    for(char isUpperCaseTestChar : charArray)
    {
       if (Character.isUpperCase(isUpperCaseTestChar)) throw new IsUpperCaseException("입력값에 대문자가 있습니다");
    }
    if (cryptogram.length()<1||cryptogram.length()>40000) throw new RangeException("문자열 길이 범위 1~40000에 일치하지 않습니다");
}
~~~
###2.3 Exception Test
~~~java
@Nested
class Problem2Test {
    @Test
    void isUpperCaseException() {
        String cryptogram = "BBB";
        String result = "answer";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void rangeCaseException() {
        String cryptogram = "";
        String result = "answer";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
}
~~~
##3. 최종솔루션
~~~java
public static String solution(String cryptogram) {
    String answer = "answer";
    try {
        exception(cryptogram);
        answer = deleteConsecutiveChar(cryptogram);
    }catch (IsUpperCaseException e)
    {
        //문제에 예외를 어떻게 처리하라는 말이 없음
        //log.error OR log.warn
        //System.out.println(e.toString());
    }catch (RangeException e){
        //문제에 예외를 어떻게 처리하라는 말이 없음
        //log.error OR log.warn
        //System.out.println(e.toString());
    }
    return answer;
}
~~~
---
#3. 문제3
##예상 필요 기능 정의
1. 3,6,9를 처리하는 메소드
2. 예외처리하는 메소드
##1. count369
###1.1 count369 method
~~~java
/**
 * 369를 자른후 count해주는 method
 * 
 * @param number 정수 값
 * @return  3,6,9 를 카운트 한 값
 */
public static int count369(int number)
{
    int count = 0;

    for (int i=3;i<=number;i++)
    {
        String numberToString = Integer.toString(i);
        char stringToCharArray[] = numberToString.toCharArray();
        for (char c : stringToCharArray)
        {
            if(c=='3'||c=='6'||c=='9')
            {
                System.out.println(i);
                count++;
            }
        }
    }
    return count;
}
~~~
###1.2 count369 Test -> main test로 대체
##2. exception
###2.1 정의한 Exception
~~~java
public RangeException(String message) {
    super(message);
}
~~~
###2.2 exception method
~~~java
/**
 *
 * @param number 정수
 * @throws RangeException  입력범위 1~ 10000 범위를 벗어난 예외
 */
public static void exception(int number) throws RangeException
{
    if(number<1||number>10000) throw new RangeException("입력범위 1~10000초과");

}
~~~
###2.3 exception TEst
~~~java
@Nested
class Problem3Test {
    @Test
    void case1() {
        int number = 0;
        int result = 0;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }

    @Test
    void case2() {
        int number = 10001;
        int result = 0;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }
} 
~~~
##3. 최종솔루션
~~~java
public static int solution(int number) {
    int answer = 0;
    try {
        exception(number);
        answer = count369(number);
    }catch (RangeException e)
    {
        //문제에 예외를 어떻게 처리하라는 말이 없음
        //log.error OR log.warn
        //System.out.println(e.toString());
    }
    return answer;
}
~~~
---
#4. 문제4
##예상 필요 기능 정의
1. 소문자 테이블
2. 대문자 테이블
3. 치환 메소드
4. mixer 메소드
5. exception 처리

##1. 소문자 테이블
~~~java
private static String lowerCasesTable = "abcdefghijklnmopqrstuvwxyz";
~~~
##2. 대문자 테이블
~~~java
private static String upperCasesTable = "ABCDEFGHIJKLNMOPQRSTUVWXYZ";
~~~
##3. 치환 메소드
###3.1 substitution method
~~~java
/**
 * 치환해주는 메소드
 *
 * @param word 문장
 * @return 치환된 문장
 */
public static List<Character> substitution(String word){
    List<Character> answer = new ArrayList<>();
    for(char c : word.toCharArray()) {
            answer.add(mixer(c, Character.isUpperCase(c)));
    }
    return answer;
}
~~~
###3.2 substitution Test
~~~java
@Test
void case1() {
    char alphabet = '0';
    char result = '0';
    assertThat(Problem4.mixer(alphabet,false)).isEqualTo(result);
}
@Test
void case2() {
    char alphabet = 'A';
    char result = 'Z';
    assertThat(Problem4.mixer(alphabet,true)).isEqualTo(result);
}
@Test
void case3() {
    char alphabet = 'a';
    char result = 'z';
    assertThat(Problem4.mixer(alphabet,false)).isEqualTo(result);
~~~
##4. mixer 메소드
###4.1 mixer method
~~~java
/**
 * 테이블을 이용하여 본격적으로 섞어주는 메소드
 *
 * @param alphabet 알파벳 한글자
 * @param isUpper 대문자 구분
 * @return 치환된 알파벳
 */
public static char mixer(char alphabet,boolean isUpper)
{
    int index;
    char substitutionChar;
    if(alphabet==' ') return ' ';
    if(isUpper)
    {   index = upperCasesTable.length()-upperCasesTable.lastIndexOf(alphabet) - 1;
        substitutionChar= upperCasesTable.charAt(index);
    }else{
        index = lowerCasesTable.length()-lowerCasesTable.lastIndexOf(alphabet) - 1 ;
        try{
            substitutionChar= lowerCasesTable.charAt(index);
        }catch (StringIndexOutOfBoundsException e)
        {
            substitutionChar = alphabet;
        }
    }
    return substitutionChar;
}
~~~
###4.2 mixer Test -> main test(생략) + custom Test
~~~java
@Test
void case4() {
    String word = "Svool, Dliow! 123";
    String result = "Hello, World! 123";
    assertThat(Problem4.solution(word)).isEqualTo(result);
}
~~~
##5. Exception
~~~java
/**
 * 1~1000범위에 일치하지 않는 입력값 예외처리
 * 
 * @param word 문장
 * @throws RangeException 범위Exception
 */
public static void exception(String word) throws RangeException
{
    if(word.length()<0||word.length()>1000){
        new RangeException("1~1000의 범위와 일치하지 않습니다");
    }
}
~~~
##6. 최종 솔루션
~~~java
public static String solution(String word) {
    String answer = "";
    answer=substitution(word).stream().map(String::valueOf).collect(Collectors.joining());
    return answer;
}
~~~
---
#5. 문제5
##예상 필요 기능 정의
1. 머니를 입력값으로 받아 지폐종류에따라 몇장이필요한지 반환해주는 메소드
2. 리스트에 넣어주는 메소드
3. 예외처리
##1. 지폐카운트 메소드
###1.1 moneyCount
~~~java
/**
 * 지폐수를 세어주는 method
 *
 * @param money 입력 돈
 * @param moneyUnit 단위
 * @return 카운트 된 값
 */
public static int moneyCount(int money,int moneyUnit)
{
    int count =0;
    if(money>=moneyUnit)
    {
        count=money/moneyUnit;
    }
    return count;
}
~~~
###1.2 moneyCount Test
~~~java
@Test
void case1() {
    int money = 50_237;
    int result = 1;
    assertThat(Problem5.moneyCount(money,50000)).isEqualTo(result);
}
~~~
##2. 리스트에 머니카운트 담는 메소드
###2.1 ListInMoneyCount
~~~java
/**
 * if횟수를 줄여본 리스트에 담는 머니카운트
 *
 * else if 작업을 줄여보았습니다.
 * @param money 입력 돈
 * @return answer
 */
public static List<Integer> ListInMoneyCount (int money)
{
    int moneyUnits[] = {50000,10000,5000,1000,500,100,50,10,1};
    List<Integer> answer = new ArrayList<>();
    for (int moneyUnit : moneyUnits) {
        int count = moneyCount(money, moneyUnit);
        answer.add(count);
        money=money-(moneyUnit*count);
    }
    return answer;
}
~~~
###2.2 ListInMoneyCount Test -> main Test로 대체
##3. Exception
###3.1 exception
~~~java
/**
 * 입력값에 범위를 벗어날떄 예외처리
 *
 * @param money 입력 돈
 * @throws RangeException 입력 범위 초과 1~1000000
 */
public static void exception(int money) throws RangeException
{
    if(money<1||money>1000000)
    {
        new RangeException("1~1000000 범위를 벗어납니다");
    }
}
~~~
##4. 최종 솔루션
~~~java
public static List<Integer> solution(int money) {
    List<Integer> answer = Collections.emptyList();
    try {
        exception(money);
        answer = ListInMoneyCount(money);
    }catch (RangeException e)
    {
        //문제에 예외를 어떻게 처리하라는 말이 없음
        //log.error OR log.warn
        //System.out.println(e.toString());
    }
    return answer;
}
~~~
---
#6. 문제6
##예상 필요 기능 정의
1. 두글자씩 모두 List에 저장하는 메소드
2. 닉네임이 한글인지 구분하는 메소드
3. result 정렬하는 메소드
4. result에 중복된 값을 제거하는 메소드
5. @email.com이 맞는지 확인하는 메소드
6. 두글자씩자르는 메소드
7. Exception 입력범위
---
#7. 문제7
##예상 필요 기능 정의
1. 중복을 제거하는 기능
2. 친구의 친구를 찾는기능
3. 친구의 친구중 내친구를 제거하는기능
4. 나의 방문자를 확인하는기능
5. 나의 방문자중 친구를 제거하는 기능