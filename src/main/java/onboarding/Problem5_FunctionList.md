
# 기능 목록
### 기능을 구현하기 위한 기능 목록은 다음과 같습니다.

1. moneyToList(int money, List<Integer> answer)
   1-1) 화폐 단위가 담긴 unit의 크기만큼 for문을 수행합니다.
   1-2) 입력받은 money와 화폐 단위인 unit[i]를 나누어 몫을 구한뒤 divide에 저장합니다.
   1-3) 해당 divide가 화폐의 개수이므로 answer[i]에 저장합니다.
   1-4) 입력받은 money에서 변환한 화폐의 개수와 화폐의 단위를 곱해 빼줍니다.


# 전체 동작 과정
1. unit 변수를 생성 후 기능 요구사항에서 제시한 화폐 단위들로 초기화 합니다.
2. moneyToList()에 입력받은 money와 answer를 넣고 반환 된 answer를 제출합니다.