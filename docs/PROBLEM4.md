# [Problem 4](https://www.notion.so/4-2b52442d0b8045b9856edcbaa1700e62) 기능별 명세

## 1. public static List<String> stringToList(String word) {}

### input
- **String word** : 반대로 변환하고자 하는 문자열.

### output
- **(List<String>)** word를 ArrayList로 변환한 결과

### 기능 상세
파라미터로 주어지는 word 데이터의 각 문자에 인덱스로 접근하기 위하여 해당 데이터를 ArrayList로 변환하는 기능을 합니다.</br>
word.toCharArray()를 통해 String 타입 데이터를 char형 배열 데이터로 바꾼 후, 이 배열의 각 원소 값을 다시 String으로 타입 캐스팅하여 리스트에 하나씩 추가하는 방식입니다.
