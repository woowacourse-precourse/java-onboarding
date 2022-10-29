# [Problem 4](https://www.notion.so/4-2b52442d0b8045b9856edcbaa1700e62) 기능별 명세

~~## 1. public static List<String> stringToList(String word) {}~~

~~### input~~
~~- **String word** : 반대로 변환하고자 하는 문자열.~~

~~### output~~
~~- **(List<String>)** word를 ArrayList로 변환한 결과~~

~~### 기능 상세
파라미터로 주어지는 word 데이터의 각 문자에 인덱스로 접근하기 위하여 해당 데이터를 ArrayList로 변환하는 기능을 합니다.</br>
word.toCharArray()를 통해 String 타입 데이터를    r char형 배열 데이터로 바꾼 후, 이 배열의 각 원소 값을 다시 String으로 타입 캐스팅하여 리스트에 하나씩 추가하는 방식입니다.~~

<span style="color:hotpink">
String word를 ArrayList가 아닌 Char Array 타입으로 변환해 문제를 해결하는 방향으로 구현 방식을 바꾸었습니다.</br>
Char Array는 String.toCharArray()를 통해 변환할 수 있기 때문에 위 메소드는 삭제하였습니다.
</span>

## 2. public static Character findOppositeLetter(int before) {}

### input
- **int before** : 반대로 변환하고자 하는 문자의 아스키 코드 값.

### output
- **(char)** before을 반대로 변환한 문자.

### 기능 상세
하나의 문자에 반대되는 문자가 무엇인지 찾는 기능을 합니다.</br>
파라미터로 before에 변환하고자 하는 문자의 아스키 코드 값을 받습니다.</br></br>
알파벳은 중간 값인 M(77), N(78) / m(109), n(110)을 기준으로 반대로 바뀝니다.</br>
따라서 (before와 M(m) 혹은 N(n) 사이의 거리의 2배) + 1만큼 이동하면 after 값을 도출할 수 있습니다. 이를 바탕으로 before의 값을 다음과 같은 경우의 수로 나눌 수 있습니다.
- 알파벳 대문자 (65 <= before <= 90)
  - after = before + (77 - before) * 2 + 1 = 155 - before
- 알파벳 소문자(97 <= before <= 122)
  - after = before + (109 - before) * 2 + 1 = 219 - before
- 알파벳 외의 문자 (else)
  - 변환하지 않으므로 after = before
  - 
## 3. public static String getConvertedString(char [] word) {}

### input
- **char [] word** : 변환해야 할 word 데이터를 char array로 변환한 값.

### output
- **(String)** 변환이 완료된 문자열.

### 기능 상세
각 알파벳마다 findOppositeLetter()를 호출해서 반대되는 알파벳을 찾고, 변환 완료된 값을 String으로 반환하는 기능을 합니다.
