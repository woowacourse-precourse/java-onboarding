## 기능 목록
### 구현에 사용한 규칙
* 단위 화폐가 9가지이므로 9번의 계산이 필요하다.
* money가 단위 화폐 이상일 때 단위 화폐만큼 빼면 필요한 개수를 알 수 있다.
### 구현 방법
1. 각 화폐 단위가 필요한 개수 만큼 구하는 moneyCalculation 메서드 생성.
2. solution 메서드에서 moneyCalculation 메서드를 사용해 필요한 화폐 개수 구해 반환.
### 구현 메서드 상세
0. (추가) 클래스변수
* 정답 (화폐의 갯수)을 저장할 List<Intiger> answer
1. moneyCalculation 메서드
   1. <매개변수>\
      계산 필요한 돈 액수 money (입력 값)\
      계산한 횟수를 확인할 int형 변수 num\
      (삭제) ~~계산한 돈의 개수를 저장할 List<Integer> wallet~~
   2. <변수>\
      각 단위 화폐를 담은 int형 리스트 money_list (size = 9)\
      계산한 돈의 개수를 저장할 int형 변수 number
   3. <구현>\
      num을 money_list의 인덱스로 활용한다.\
      money_list[num] 보다 money가 큰 경우 뺄셈 진행.
      * 뺄 수 있는 갯수를 number에 저장.
      * number를 answer ~~wallet~~에 저장.
      * money 업데이트.
      * num 1 증가.
   
      money_list[num] 보다 money가 작은 경우.
      * answer ~~wallet~~에 0 저장.
      * num 1 증가.
      
      money, num, ~~wallet~~을 매개변수로 moneyCalculatuon 메서드 재귀\
      num이 9가 되면 메서드 종료.
2. solution 메서드
   1. <매개변수>\
      계산 필요한 돈의 액수 money (입력 값)
   2. <변수>\
      (삭제) ~~정답을 담을 List<Integer> answer (size = 9)~~ **해당 변수 클래스 변수로 변경.\
      (추가) 클래스 변수 answer를 size=9로 초기화
   3. <구현>\
      moneyCalculation 메서드에 매개변수로 (money, 0) 넣어 호출, answer 업데이트\
      answer 반환.

## 🚀 기능 요구 사항

계좌에 들어있는 돈 일부를 은행에서 출금하고자 한다. 돈 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 받는다.

돈의 액수 money가 매개변수로 주어질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.

### 제한사항

- money는 1 이상 1,000,000 이하인 자연수이다.

### 실행 결과 예시

| money | result |
| --- | --- |
| 50237	| [1, 0, 0, 0, 0, 2, 0, 3, 7] |
| 15000	| [0, 1, 1, 0, 0, 0, 0, 0, 0] |