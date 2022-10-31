
# 기능 목록
### 기능을 구현하기 위한 기능 목록은 다음과 같습니다.

### 입력받은 액수의 돈을 최대한 큰 단위의 지폐를 많이 가지게 변환
#### moneyToList(int money, List<Integer> answer)
- 화폐 단위가 담긴 unit 배열을 생성합니다.
- unit의 크기만큼 for문을 수행합니다.
- 입력받은 money와 화폐 단위인 unit[i]를 나누어 몫을 구한뒤 divide에 저장합니다.
- 해당 divide가 화폐의 개수이므로 answer[i]에 저장합니다.
- 입력받은 money에서 변환한 화폐의 개수와 화폐의 단위를 곱해 빼줍니다.
- 위 과정을 반복합니다.


# 전체 동작 과정
1. unit 변수를 생성 후 기능 요구사항에서 제시한 화폐 단위들로 초기화 합니다.
2. moneyToList()에 입력받은 money와 answer를 넣습니다.
3. 반환된 answer 리스트를 제출합니다.