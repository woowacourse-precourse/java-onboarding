# [Problem 5](https://www.notion.so/5-bb6cf19d2c3f4b4bb5d64c8158f16351) 기능별 명세

## 1. public static List<Integer\> calculateNumberOfBills(int placeValue, List<Integer\> billNumbers) {}

### input
- **int placeValue** 
  - 화폐의 개수를 구하기 위해 필요한 자릿수 정보.
  - 만의 자리 미만의 경우 각 자릿수를 한 자릿수로 추출해 넘겨받지만, 만의 자리 이상은 한 번에 넘겨 받습니다.(만의 자리보다 큰 화폐 단위가 없기 때문.)
- **List<Integer\>**
  - 메소드를 통해 구해질 각 화폐 단위의 개수를 저장할 리스트.

### output
- **(List<Integer\>)** 조건에 맞는 각 화폐의 개수를 구해 저장한 결과.

### 기능 상세
자릿수(placeValue)에 관한 정보를 파라미터로 받은 후, 문제의 조건에 맞는 (placeValue * 1)원권의 개수와 (placeValue * 5)원권의 개수를 구해서 리스트에 저장하는 기능을 수행합니다.</br>
placeValue는 낮은 자릿수부터 높은 자릿수 순으로 주어집니다.</br>
그러므로 이 메소드는 작은 화폐 단위부터 큰 화폐 단위 순으로 리스트에 값을 저장합니다.</br>
이는 문제의 조건과 반대되는 순서이므로 리스트에 모든 값이 저장된 후에 리스트를 Collections.reverse()의 파라미터에 넘겨줌으로써 이 순서를 뒤집어야 합니다.</br>
한 번에 메소드 호출에 함께 구해지는 (placeValue * 1)원권의 개수와 (placeValue * 5)원권의 개수도 낮은 단위에서 높은 단위 순으로 저장함으로써 리스트 내 원소들이 reverse되었을 때 조건에 맞는 순서로 정렬될 수 있도록 합니다.

## 2. public static List<Integer\> getNumberOfBills(int money, List<Integer\> numberOfBills) {}

### input
- **int money**
  출금하고자 하는 전체 액수.
- **List<Integer\>**
  해당 메소드를 통해 구해질 각 화폐 단위의 개수를 저장할 리스트.

### output
- **(List<Integer\>)** 조건에 맞는 각 화폐의 개수를 구해 저장한 결과.

### 기능 상세
현재 구하고자 하는 화폐 단위의 개수에 맞게 파라미터에 값을 넘겨주며 calculateNumberOfBills()를 호출하는 기능을 합니다.</br>
일반적으로 화폐는 n원권과 5n원권이 함께 존재하기 때문에 calculateNumberOfBills()의 구현에서 input n에 대한 n원권의 개수와 5n원권의 개수를 함께 도출하도록 했습니다.</br>
하지만 유일하게 n=1인 경우에는 일 원 동전은 존재하지만 오 원 동전은 존재하지 않으므로 calculateNumberOfBills()를 호출해 구할 수 없습니다.</br>
따라서 일 원 동전의 경우 calculateNumberOfBills()를 호출하는 for 루프 시작 전 따로 계산해 리스트에 추가합니다.</br>
또한 money의 최대 자릿수가 십만, 백만자리더라도 화폐 단위는 만의 자릿수(만 원권, 오 만원권)가 최대이므로 10만원 이상의 금액도 모두 5만원 단위로 출금해야 합니다.</br>
따라서 한 자릿수 단위로 화폐의 개수를 구했던 만 원권 미만과 달리 만 원권과 오 만원권에 대해서는 만 이상의 모든 자릿수를 한 번에 파라미터로 넘겨 줍니다.</br>
단위가 작은 화폐부터 큰 화폐 순으로 개수를 저장한 이 리스트를 Collections.reverse()의 파라미터로 넘겨 줌으로써 조건에 맞게 큰 화폐부터 저장되도록 뒤집습니다.