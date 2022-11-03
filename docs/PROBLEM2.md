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

## 2.public static List<String\> decodeCryptogram(List<String\> cryptogram) {}
### input
- **List<String\> cryptogram** : 해독해야 할 암호 데이터를 List<String\> 타입으로 변환한 결과. stringToArrayList()의 반환 값입니다.

### output
- **(List<String\>)** 해독이 완료된 String 리스트.

### 기능 상세
파라미터로 넘겨 받은 List<String> 타입의 암호 데이터를 대상으로 암호 해독을 수행하는 기능을 하는 메소드입니다.</br>
인덱스 i를 1씩 증가시키며 cryptogram.get(i)와 cryptogram.get(i+1)을 비교하고, 두 값이 일치할 경우 삭제하는 과정을 반복합니다.</br>
더 이상 삭제할 원소가 존재하지 않아 삭제 전후로 리스트의 크기 변화가 없다면 해독이 완료된 cryptogram을 반환하고 메소드를 종료합니다.

## 3. public static String arrayListToSting(List<String\> cryptogram) {}

### input
- **List<String> cryptogram** : 해독이 완료된 암호 데이터. decodeCryptogram()의 반환 값입니다.

### output
- **(String)** 파라미터로 주어진 List<String\> 타입의 cryptogram을 String 타입으로 변환한 결과 값.

### 기능 상세
암호 해독을 위해 ArrayList로 변환했던 cryptogram을 다시 String 데이터로 변환하는 기능을 하는 메소드입니다.</br>
StringBuilder를 사용해서 리스트 내부의 각 원소들을 String에 하나씩 추가하는 방식입니다.