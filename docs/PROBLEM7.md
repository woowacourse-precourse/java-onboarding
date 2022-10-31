## 🚀 기능 요구 사항

레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다. 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구 추천 알고리즘을 구현하고자 아래와 같은 규칙을 세웠다.

- 사용자와 함께 아는 친구의 수 = 10점 
- 사용자의 타임 라인에 방문한 횟수 = 1점

사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때, 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라. 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.

### 제한사항

- user는 길이가 1 이상 30 이하인 문자열이다.
- friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
- friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
  - A와 B는 친구라는 의미이다.
  - 아이디는 길이가 1 이상 30 이하인 문자열이다.
- visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
- 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
- 동일한 친구 관계가 중복해서 주어지지 않는다.
- 추천할 친구가 없는 경우는 주어지지 않는다.

### 실행 결과 예시

| user | friends | visitors | result |
| --- | --- | --- | --- |
| "mrko" | [ ["donut", "andole"], ["donut", "jun"], ["donut", "mrko"], ["shakevan", "andole"], ["shakevan", "jun"], ["shakevan", "mrko"] ] | ["bedi", "bedi", "donut", "bedi", "shakevan"] | ["andole", "jun", "bedi"] |


---
## 📄 기능 정리

### 0. Class 설정

#### (1) FriendsRecommender class

##### <멤버 필드(변수, 상수)>

- String user : 유저
- HashMap< String, HashSet< String > > friendsInformation : 사용자 별 친구 목록
- HashMap< String, Integer > recommendScore : 사용자 별 추천 점수
- HashSet< String > userFriends : user의 친구 목록

##### <멤버 메소드>

- public FriendsRecommender(String user, List<List< String >> friends, List< String > visitors) : 생성자

- public List< String > makeRecommendedFriendsList() : 친구 추천 목록 생성 함수 (최상위 함수)

- private void scoreFriendsUserKnow() : 함께 아는 친구 점수 반영

- private void scoreOtherEachUsers(String otherUser) : 각 사용자 별 함께 아는 친구 점수 반영

- private int countFriendsUserKnow(String otherUser) : 각 사용자 별 함께 아는 친구 수 반환

- private List< String > makeSortedRecommendlist() : 문제의 조건대로 정렬 후 리스트로 변환 후 반환



### 1. 전체 동작 과정

(1) 생성자를 통해 다음과 같이 설정된다.

- 사용자 별 친구 목록 생성 (이미 user와 친구관계인 사용자 제외)
- 방문자 점수 반영

(2) makeRecommendedFriendsList() 호출. 내부에서 scoreFriendsUserKnow(), makeSortedRecommendlist() 호출.

- scoreFriendsUserKnow() 내부에서 friendsInformation 순회하며 scoreOtherEachUsers() 호출

    - scoreOtherEachUsers() countFriendsUserKnow() 호출
        - countFriendsUserKnow() 내부에서 user의 friendsInformation을 순회하며 함께 아는 친구 수 반환

    - 함께 아는 친구 수 만큼 recommendScore 에 반영

- makeSortedRecommendlist() : recommendScore 정렬 후 리스트로 변환하여 반환

(3) 정렬된 친구 목록 리스트 반환



### 2. 함수 별 동작 과정

- 생성자
    - 입력 : String user, List<List< String >> friends, List< String > visitors
    - this.user 초기화
    - friends를 토대로 this.friendsInformation 초기화
        - key : 사용자 이름
        - value : 친구 목록 HashSet
        - 초기화 이후 user와 친구 관계인 사용자 내용 삭제(remove)
            - 이미 친구 관계인 사용자는 고려 대상에서 제외
    - userFriends 초기화
    - recommendScore 초기화
        - key : friendsInformation의 key값
        - value : 0
    - visitors 순회하며 recommendScore에 반영
        - recommendScore의 Key에 없는 사용자의 경우 continue
            - 이미 user와 친구 관계이므로



- public List< String > makeRecommendedFriendsList()
    - scoreFriendsUserKnow() 호출
    - makeSortedRecommendlist() 호출 : 정렬된 리스트 반환
    - 반환 : 정렬된 리스트



- private void scoreFriendsUserKnow()
    - friendsInformation 순회하며 scoreOtherEachUsers() 호출



- private void scoreOtherEachUsers(String otherUser)
    - countFriendsUserKnow() 호출 : 함께 아는 친구 수 반환
    - 함께 아는 친구 수 만큼 recommendScore 에 반영



- private int countFriendsUserKnow(String otherUser)
    - user의 friendsInformation을 순회하며 otherUserFriends에 존재하는지 여부 확인(contains)
        - true : numberOfFriendsUserKnow += 1
    - 반환 : int numberOfFriendsUserKnow



- private List< String > makeSortedRecommendlist()
    - 문제의 조건대로 recommendScore 정렬 
      - 점수 기준 내림차순
      - 같은 점수일 경우 이름 기준 오름차순
    - Collection.sort, Comparator 활용
    - 정렬된 recommendScore의 Key 값을 모아 리스트로 생성
    - 반환 : 정렬된 리스트

---

## ✏️ 새로 배운 내용

### 1. Map

- Map은 key-value 쌍으로 데이터를 저장할 수 있는 인터페이스이다.
    - 리스트나 배열처럼 순차적으로 저장되어 인덱스로 값을 구하는 것이 아닌, key를 통해 value를 얻는다.
- key는 중복되지 않으며, value는 중복될 수 있다.
- 대표적인 구현체로 HashMap과 TreeMap이 있다.
- 기본적인 메소드는 다음과 같다.
    - put(key, value) : key - value 쌍을 저장한다.
    - get(key) : 파라미터 key에 해당하는 value 값을 반환한다.
    - replace(key, value) : 파라미터 key에 해당하는 value 값을 파라미터 value로 수정한다.
    - remove(key) : 파라미터 key에 해당하는 key - value 쌍을 삭제한다.
    - containsKey(key) : 파라미터 key가 해당 Map 안에 존재하는지 여부를 T/F 로 반환한다.
    - containsValue(value) : 파라미터 value를 갖는 key가 하나 이상인지 여부를 T/F로 반환한다.

##### < HashMap >

- 가장 많이 활용되는 Map 구현체이다.
- key와 value를 묶어 하나의 entry로 저장한다.
- Hash 알고리즘이 활용되며, 많은 양의 데이터를 검색하는데 속도가 매우 빠르다.
- value에 null을 저장할 수 있다.

##### < TreeMap >

- key - value 쌍을 이진 검색 트리(BST) 형태로 저장한다.

    - 기존의 이진 검색 트리의 성능을 향상시킨 레드-블랙 트리로 구현된다.

- 데이터를 추가하거나 제거하는 등의 기본 동작 시간이 매우 빠르다.

- 기본적으로 key 값에 의해 정렬된 상태를 유지한다.

    - 생성자에 compare 메소드를 오버라이딩한 Comparator 객체를 입력하면 정렬 기준을 수정할 수 있다.

  ```java
  TreeMap<String, Integer> treeMap = new TreeMap<String,Integer>(
  	new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return (o1.charAt(0) - o1.charAt(0)) * -1;
      }
    }
  );
  ```



### 2. Comparable, Comparator

- Comparable과 Comparator는 **객체를 비교**할 수 있도록 도와주는 인터페이스이다.
    - 기본 변수 타입인 primitive 타입의 경우, 부등호를 통해 쉽게 비교가 가능하다.
    - 하지만 객체의 경우, 두 객체를 비교하기 위해서는 개발자가 기준을 정해주어야 한다. 이 때 Comparable 혹은 Comparator가 활용된다.
- 주로 객체 정렬 과정에 쓰인다.



#### < 정렬 과정에서 비교 규칙 >

- Comparable, Comparator를 활용하여 정렬할 때, 다음과 같이 두 가지 로직으로 구현되어질 수 있다.

**<로직 1>**
- 오름차순
  - 앞 값 > 뒷 값 -> return 1;  (혹은 양수 값)
  - 앞 값 < 뒷 값 -> return -1 :  (혹은 음수 값)
  - 앞 값 == 뒷 값 -> return 0;
- 내림차순
  - 오름차순의 반대로 해주면 된다.

  (Comparable의 경우, 앞 값이 자기 자신이 된다.)

**<로직 2>**

- 오름차순
  - return 앞 값 - 뒷 값;
- 내림차순
  - return (앖 값 - 뒷 값) * -1;
  - return 뒷 값 - 앞 값;



**<유의할 점>**

- **로직 2의 경우, 자료형 범위를 이탈한 값이 들어올 경우에 원하는 결과가 나오지 않을 수 있다.**

    - 예를 들어 int의 경우, 자료형의 범위는 (-2^31) ~ (2^31 - 1) 이다.
    - 해당 범위를 넘어선 값이 들어올 경우, Underflow 혹은 Overflow가 발생한다.
        - Undeflow : 범위의 최소값보다 작은 수가 들어오면 최대값 쪽으로 넘어가버리는 현상
        - Overflow : 범위의 최대값보다 큰 수가 들어오면 최소값 쪽으로 넘어가버리는 현상

    - 따라서 Underflow나 Overflow가 발생할 여지가 있는지에 대한 확인이 필요하다.

- **로직 1처럼 부등호를 활용하여 대소 비교 후, (1, 0, -1) 중 하나를 반환하는 것이 안전하며, 권장되는 방식이다.**



#### < Comparable >

- java.lang 패키지에 있어 import 해 줄 필요가 없다.

- **자기 자신**과 **매개변수 객체**를 비교한다.

- **public int compareTo(T o)** 메소드를 구현해야 한다.

  ```java
  class ComparableExample implements Comparable<ComparableExample> {
    int field1;
    int field2;
    
    ...
    
    @Override
    public int compareTo(ComparableExample ce1) {
      if (this.field1 > ce1.field1) {
        return 1;
      } else if (this.field1 < ce1.field1) {
        return -1;
      } else {
        if (this.field2 > ce1.field2) {
          return 1;
        } else if (this.field2 < ce1.field2) {
          return -1;
        } else {
          return 0;
        }
      }
    }
    
    ...
    
  ```

    - 위 예시 코드의 경우, ComparableExample class의 객체를 비교하기 위해 compareTo() 메소드를 정의하였다.
        - field1 기준으로 먼저 비교 하고, field1이 같을 경우 field2를 기준으로 비교한다.
        - 이는 곧 정렬 과정에서 "field1 기준 오름차순, 동일한 field1 값을 갖는 객체들은 field2 기준 오름차순" 의 규칙이 될 수 있다.



#### < Comparator >

- java.util 패키지에 있어 import가 필요하다.

- **매개변수로 입력되는 두 개의 객체**를 비교한다.

- **public int compare(T o1, T o2)** 메소드를 구현해야 한다.

  ```java
  class ComparatorExample implements Comparator<ComparatorExample> {
    int field1;
    ...
    @Override
    public int compare(ComparatorExample ce1, ComparatorExample ce2) {
      if (ce1.field1 > ce2.field2) {
        return 1;
      } else if (ce1.field1 < ce2.field2) {
        return -1;
      } else {
        return 0;
      }
    ...
  ```

    - 기본적으로 compareTo와 유사하지만, 파라미터로 두 개의 객체가 전달된다.
    - compareTo에서 '자기자신' 에 해당하는 객체가 첫번째 파라미터 객체(= ce1)이다.

#### < Comparator 익명 객체 활용 >

##### <익명 객체>

- 이름이 정의되지 않은 객체

- 구현

  ```java
  부모클래스 이름 = new 부모클래스(매개변수) {
    구현부
  };
  
  Comparator<Type> comparator = new Comparator<Type>() {
    구현부
  }
  ```

- Comparator는 인터페이스이다. 따라서 객체를 생성할 수 없다. 하지만 위 코드의 경우, 'comparator' 라는 이름의 객체가 생성된다.

- 이는 익명 객체를 통해 구현된 것으로, Comparator 를 상속받는 클래스를 생성하고, 객체를 만들어 comparator에 넣어준 것이다.

- '구현부' 에서는 Overriding 혹은 추가 기능들을 클래스 만들듯이 넣어주면 된다.

##### <Comparator 활용>

- Comparator 익명 객체를 통해 비교 연산자 객체를 만들 수 있다.

    - 예시

  ```java
  Comparator<ComparatorExample> comparator = new Comparator() {
    @Override
    public int compare(ComparatorExample ce1, ComparatorExample ce2) {
      if (ce1.field1 > ce2.field2) {
        return 1;
      } else if (ce1.field < ce2.field) {
        return -1;
      } else {
        return 0;
      }
    }
  };
  
  if (comparator.compare(comparatorExample1, comparatorExample2) == 1) {
    System.out.println("First one is bigger than second one.");
  }
  ```

- 본 문제 Problem 7에서는 다음과 같이 활용되었다.

  ```java
  Collections.sort(sortedRecommendScore, new Comparator<Map.Entry<String, Integer>>() {
  			@Override
  			public int compare(Map.Entry<String, Integer> score1, Map.Entry<String, Integer> score2) {
  				int differenceOfTwoScores = (score1.getValue() - score2.getValue()) * -1;
  
  				if (differenceOfTwoScores == 0) {
  					return score1.getKey().compareTo(score2.getKey());
  				} else {
  					return differenceOfTwoScores;
  				}
  			}
  		});
  ```

    - Collections의 sort 메소드의 매개변수로 Comparator를 전달해주어야 하고, 이를 위해 익명 객체로 생성하여 전달한 것이다.



### 3. Stream

-  기존에 알아보고 싶었던 stream에 대해 알아보았고, 활용해 보았다.
- Stream은 다음과 같은 과정으로 수행된다.
    - 전체.Stream생성.가공1.가공2•••.결과생성

#### <Stream 생성>

1. 배열 스트림

   ```java
   Stream<String> stringStream = Arrays.stream(new String[]{"a", "b"});
   ```

2. 컬렉션 스트림

    - Collection, List, Set 등

   ```java
   List<String> list = new ArrayList<>(List.of("a", "b"));
   Stream<String> stream = list.stream();
   ```

3. Stream.builder()

    - 다음과 같이 스트림에 원하는 값을 직접 넣어줄 수도 있다.

   ```java
   Stream<String> builderStream = Stream.<String>builder()
                                        .add("a").add("b")
                                        .build();
   ```

4. Stream.generate()

    - **매개변수는 없고 리턴값만 있는 형태**로 값을 채울 수 있다.

   ```java
   Stream<String> generateStream = Stream.generate(() -> "a").limit(4);
   // "a" 가 4개 들어감
   ```

    - 다음과 같이 같은 값이 반복되는 리스트를 생성할 때 요긴하게 쓸 수도 있을 것 같다.

   ```java
   int numberOfFalse = 10;
   List<Boolean> booleanList = new ArrayList<>();
   booleanList = Stream.generate(() -> false).limit(numberOfFalse)
     					.collect(Collectors.toList());
   ```

5. Stream.iterate()

    - **"초기 값"과 "이 값의 변수"를 매개변수로 전달하여 리턴 값을 만들어 낼 수 있는 형태**로 값을 채울 수 있다.

   ```java
   Stream<Integer> iterateStream = Stream.iterate(1, n -> n + 1).limit(4);
   // 1, n : 1은 초기 값, 이후 n이 리턴 형태에 맞춰 반환된다.
   // 1, 2, 3, 4 
   ```

    - 다음과 같이 일정하게 증가하는 값을 갖도록 리스트를 생성할 때 쓰일 수 있을 것 같다.

   ```java
   int numberOfIds = 10;
   List<Integer> idList = new ArrayList<>();
   idList = Stream.iterate(1, n -> n + 1).limit(numberOfIds).collect(Collectors.toList());
   ```

6. 기본 타입형 스트림 (IntStream, LongStream, DoubleStream)

    - primitive 타입의 스트림을 생성할 수도 있다. 여기서 .range()가 유용하다.

   ```java
   IntStream intStream = IntStream.range(1, 5);
   LongStream longStream = LongStream.range(1, 5);
   //1, 2, 3, 4
   ```

    - 기본 타입형 스트림은 그냥 Stream과는 다른 타입이다.
    - 기본 타입형 스트림으로 값을 생성하고, Stream으로 만들어주려면 끝에 .boxed()를 붙여주면 된다.

   ```java
   IntStream intStream = IntStream.range(1, 5);
   
   Stream<Integer> integerStream = intStream.boxed();
   ```

    - 특정 범위의 값을 갖는 리스트를 만들 때, 유용하게 쓰일 수 있을 것 같다.

   ```java
   int numberOfIds = 10;
   List<Integer> idList = new ArrayList<>();
   idList = IntStream.range(1, numberOfIds+1).boxed().collect(Collector.toList());
   ```

7. 스트림 연결하기

    - Stream.concat()을 활용해 두 개의 스트림을 연결하여 새로운 스트림을 만들어 낼 수 있다.

   ```java
   Stream<Integer> stream1 = Stream.of(1, 2, 3);
   Stream<Integer> stream2 = Stream.of(4, 5, 6);
   Stream<Integer> concatStream = Stream.concat(stream1, stream2);
   //1, 2, 3, 4, 5, 6
   ```



#### <Stream 가공>

- Stream의 전체 요소들 중에서 원하는 값만 뽑아내는 등의 가공 단계를 수행할 수 있다.
- 가공 단계는 "중간 작업" 이라고도 하며, 해당 작업들은 Stream을 반환하기 때문에 여러 작업을 이어붙여서(chaining) 활용할 수 있다.

1. Filtering (.filter())

    - Stream의 요소들을 하나씩 판별해서 걸러내는 작업이다.
    - **매개변수에 값이 하나씩** 들어가 **판별 기준에 적용**되고, **true에 해당하는 값들만 반환**된다.

   ```java
   List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 11, 12, 13));
   Stream<Integer> integerStream = numbers.stream().filter(number -> number > 10);
   // 11, 12, 13
   ```

   ```java
   List<String> words = new ArrayList<>(List.of("aaa", "abc", "dfe"));
   Stream<String> filtered = words.stream().filter(word -> word.contains("a"));
   // "aaa", "abc"
   ```

2. Mapping (.map())

    - Stream의 요소들을 하나씩 특정 값으로 변환해 준다.
    - 매개변수로 요소들이 하나씩 넘어가며, 특정 작업을 걸어 변화된 값으로 리턴시킬 수 있다.
    - 이 때 값을 변환하기 위한 람다를 인자로 받는다. (혹은 그냥 코드도 가능하다)
        - 그냥 코드 : 클래스.메소드(), 객체.메소드()
            - String.toUpperCase()
        - 람다 : 클래스::메소드, 객체::메소드
            - String::toUpperCase
    - 다음은 대문자로 변환하는 예시이다.

   ```java
   List<String> strings = new ArrayList<>(List.of("a", "b", "c"));
   // 아래 두 방법 동일한 결과를 갖는다.
   Stream<String> upper = strings.stream().map(s -> s.toUpperCase());
   Stream<String> upper = strings.stream().map(String::toUpperCase);
   //A, B, C
   ```

    - 본 문제 Problem 7에서 Mapping을 사용하였다.

   ```java
   List<String> sortedRecommendList = sortedRecommendScore.stream()
     .map(Map.Entry::getKey).collect(Collectors.toList());
   ```

    - 이는 아래와 같이 쓰일 수도 있다.

   ```java
   List<String> sortedRecommendList = sortedRecommendScore.stream()
     .map(score -> score.getKey()).collect(Collectors.toList());
   ```

3. Sorting (.sorted())

    - 매개변수 없이 쓸 경우, 오름차순으로 정렬된다.

   ```java
   List<Integer> numbers = new ArrayList<>(List.of(3, 1, 2, 4));
   Stream<Integer> sorted = numbers.stream().sorted();
   //1, 2, 3, 4
   ```

    - 매개변수를 통해 Comparator를 넣어줄 수 있다.

   ```java
   List<Integer> numbers = new ArrayList<>(List.of(3, 1, 2, 4));
   Stream<Integer> sorted = numbers.stream().sorted(Comparator.reverseOrder());
   //4, 3, 2, 1
   ```

   ```java
   List<String> strings = new ArrayList<>(List.of("aa", "aaa", "a", "aaaa"));
   // 아래는 모두 같은 방법들이다.
   // 방법 1
   Stream<String> sorted = strings.stream().sorted(Comparator.comparingInt(String::length));
   // 방법 2
   Comparator<String> comparator = new Comparator<String>() {
     @Override
     public int compare(String o1, String o2) {
       if (o1.length() > o2.length()) {
         return 1;
       } else if (o1.length() < o2.length()) {
         return -1;
       } else {
         return 0;
       }
     }
   };
   Stream<String> sorted = strings.stream().sorted(comparator);
   // 방법 3
   Stream<String> sorted = strings.stream().sorted((s1, s2) -> s1.length() - s2.length());
   // "a", "aa", "aaa", "aaaa"
   ```

4. Iterating (.peek())

    - Stream 내 요소들 각각을 대상으로 특정 작업을 수행한다.
    - 작업은 수행되지만, 결과는 반환되지 않는다. (void)
    - 즉, 특정 작업만 수행할 뿐, 결과에 영향을 미치진 않는다.

   ```java
   List<String> strings1 = new ArrayList<>(List.of("aa", "aaa", "a", "aaaa"));
   // 아래 모두 같은 방법들
   // 방법 1
   List<String> sorted11 = strings.stream()
       .sorted(Comparator.comparingInt(String::length))
       .peek(System.out::println)
       .collect(Collectors.toList());
   //방법 2
   List<String> sorted11 = strings.stream()
       .sorted(Comparator.comparingInt(String::length))
       .peek(s -> System.out.println(s))
       .collect(Collectors.toList());
   ```



#### <결과 만들기>

- 가공한 스트림을 결과값으로 만들어 내는 단계이다.
- 스트림을 끝내는 '최종 작업' 단계이다.

##### < Calculating(min, max, count, sum, average >

- 최소, 최대, 개수, 합, 평균을 구할 수 있다.

```java
long count = IntStream.of(1, 2, 3).min();
long count = IntStream.of(1, 2, 3).max();
long count = IntStream.of(1, 2, 3).count();
long count = IntStream.of(1, 2, 3).sum();
long count = IntStream.of(1, 2, 3).average();
```

##### < Collecting(collect) >

- Collector 타입의 인자를 받아 처리한다. 주로 Collectors.~~ 로 처리할 수 있다.

1. Collectors.toList()

    - 스트림 가공 결과를 리스트에 담아서 반환해 준다.

   ```java
   List<Integer> intList = new ArrayList<>(List.of(1, 2, 11, 12));
   List<Integer> overTen = intList.stream().filter(n -> n > 10).collect(Collectors.toList());
   ```

    - 본 문제 Problem 7에서도 쓰였다.

   ```java
   List<String> sortedRecommendList = sortedRecommendScore.stream()
     .map(Map.Entry::getKey).collect(Collectors.toList());
   ```

2. Collectors.joining()

    - 스트림 가공 결과를 하나의 스트링으로 이어서 붙일 수 있다.

   ```java
   List<Integer> intList = new ArrayList<>(List.of(1, 2, 11, 12));
   String overTenString = intList.stream()
                                 .filter(n -> n > 10)
                                 .map(n -> n.toString()
                                 .collect(Collectors.joining());
   // 1112
   ```

    - 매개변수로 스트링 내용을 추가해 줄 수도 있다.
        - joining(delimeter, prefix, suffix)
            - delimeter : 각 요소 중간 중간에 들어가는 구분자
            - prefix : 맨 앞에 붙는 문자
            - suffix : 맨 뒤에 붙는 문자

   ```java
   List<Integer> intList = new ArrayList<>(List.of(1, 2, 11, 12));
   String overTenString = intList.stream()
                                 .filter(n -> n > 10)
                                 .map(n -> n.toString()
                                 .collect(Collectors.joining(", ", "[", "]"));
   // [11, 12]
   ```

##### < Matching(anyMatch, allMatch, noneMatch) >

- 조건을 설정하여 만족하는 요소가 있는지 여부를 boolean 타입으로 반환한다.

1. anyMatch

    - 조건에 부합하는게 하나라도 있으면 true

   ```java
   List<String> strings = new ArrayList<>(List.of("abcd", "abcd", "abc"));
   boolean anyMatch = strings.stream().anyMatch(s -> s.length() == 3);
   // true
   ```

2. allMatch

    - 조건에 모두 부합해야 true

   ```java
   List<String> strings = new ArrayList<>(List.of("abcd", "abcd", "abc"));
   boolean allMatch = strings.stream().allMatch(s -> s.contains("abc"));
   // true
   ```

3. noneMatch

    - 조건에 부합하는게 없어야 true

   ```java
   List<String> strings = new ArrayList<>(List.of("abcd", "abcd", "abc"));
   boolean noneMatch = strings.stream().noneMatch(s -> s.contains("e"));
   // true
   ```

##### < Iterating(forEach) >

1. forEach

    - peek의 최종 작업 단계.

    - peek는 중간에 삽입. forEach는 최종으로 삽입.

   ```java
   List<String> strings = new ArrayList<>(List.of("abcd", "abcd", "abc"));
   strings.stream().forEach(System.out::println);
   ```

   