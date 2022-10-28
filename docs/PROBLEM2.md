# [Problem 2](https://www.notion.so/2-2ca70805a4bb4db28d9bd48a7666f387) 기능별 명세

## 1. public static List<String\> stringToArrayList(String cryptogram) {}
### input
- **String cryptogram** : 해독할 암호 데이터.

### output
- **(List<String\>)** String 타입의 cryptogram을 ArrayList 타입으로 변환한 결과 값.

### 기능 상세
파라미터로 넘겨 받은 String 타입의 cryptogram을 ArrayList<String>으로 변환하는 기능을 하는 메소드입니다.<br/>
암호 해독을 위해서는 문자열 내 각 문자들에 접근해야 하는데, String 타입에서는 그것이 불가능하므로 ArrayList로 변환해 인덱스로 접근하기 위함입니다.<br/>
cryptogram.toCharArray()를 통해 String 타입 데이터를 char형 배열 데이터로 바꾼 후, 이 배열의 각 원소 값을 다시 String으로 타입 캐스팅하여 리스트에 하나씩 추가하는 방식입니다.