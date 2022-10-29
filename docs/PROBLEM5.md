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

---

## 📄 기능 정리

### 0. Class 설정

#### (1) BillConverter class

- 입력된 금액(money)을 화폐 단위로 변환하는 클래스

##### <멤버 필드(변수, 상수)>

- private List< Integer > numberOfBills (Getter, Setter 생성X)

##### <멤버 메소드>

- public List< Integer > convertIntoBills(int money) : 화폐 단위로 변환하는 함수
- private int calculateNumberOfBills(UnitsOfBill unit, int money) : 몇개의 화폐가 필요한지 계산하는 함수

#### (2) UnitsOfBill enum

- 화폐 단위 상수를 저장하는 enum 클래스

##### <상수 열거>

- 50000~1원까지 화폐 단위 설정
- 각 화폐 단위 별로 해당 금액(= int amountOfMoney)을 상수로 갖는다.
- 상수 값을 얻을 수 있도록 Getter(= getAmountOfMoney()) 생성



### 1. 전체 동작 과정

(1) convertIntoBills() 내에서 for문을 반복하며 calculateNumberOfBills() 함수를 호출한다.

(2) 멤버 변수 numberOfBills를 반환한다.



### 2. 함수 별 동작 과정

- convertIntoBills()
    - 입력 : 주어진 금액 (= int money)
    - Enum.values()를 통해 UnitsOfBill 상수 리스트를 생성
    - UnitsOfBill 리스트 내 상수들을 차례대로 탐색하며 반복문 수행
    - 화폐 단위 금액보다 현재 money 값이 더 클 경우, calculateNumberOfBills() 함수 호출
        - 화폐 단위 금액 : UnitsOfBill.getAmountOfMoney() 를 통해 획득
        - calculateNumberOfBills() : 멤버 변수 numberOfBills에 반영, 남은 잔돈 반환
    - 출력 : 멤버 변수 List< Integer > numberOfBills
- calculateNumberOfBills()
    - 입력 : 화폐 단위 (= UnitsOfBill unitOfBill), 현재 금액 (= int money)
    - 화폐 단위 금액으로 현재 금액을 나눈 몫(= int numberOfBills)과 잔돈(= int change)을 저장한다.
    - numberOfBills를 멤버 변수 numberOfBills에 반영한다.
        - 인덱스 : Enum.ordinal() 활용
    - 출력 : 잔돈 int change



------

## ✋ 예외 사항

- 1 <= money <= 1,000,000