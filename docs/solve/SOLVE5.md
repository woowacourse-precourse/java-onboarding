### 🚀 기능 목록

####  problem5 - solution()
[요구] 돈의 액수 money가 매개변수로 주어질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return
- List\<Integer> moneyUnitList: 화폐 단위 금액이 저장된 배열
- reverMoneyToUnit(): 돈을 큰 금액 순으로 화폐로 변환 후 화폐 개수 배열을 리턴하는 메서드
   - List\<Integer> answer: 화폐 단위 개수를 저장하는 배열
   - int index
   - for (int unit : moneyUnitList):
      - if (money >= unit): money를 화폐로 바꿀 수 있으면
         - answer의 index 위치에 화폐 개수를 넣는다.
            - 화폐 개수: (int) money / unit
         - money에서 (화폐개수 * 화폐단위)를 뺀다.
      - index를 1씩 증가
   - answer를 리턴