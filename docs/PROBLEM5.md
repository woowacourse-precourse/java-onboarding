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