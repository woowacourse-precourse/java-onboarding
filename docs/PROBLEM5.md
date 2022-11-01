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


---

## ✏️ 새로 배운 내용



### 1. Enum 활용

- Problem4에서는 단순 상수 열거용으로만 활용해 보았지만, 본 문제에서는 내부 기능을 조금 더 활용해 보았다.

##### <열거 상수 생성>

- enum타입은 열거 상수를 모아둘 수 있다.
- 열거 상수 각각은 Java 내부적으로 **Enum 클래스를 상속받는 public static final 객체**로 설정된다.
    - 즉, 각각의 상수는 클래스가 로드되는 시점부터(static) final **객체**로 생성된다.

```java
public enum UnitsOfBill {
	FIFTY_THOUSAND(50000),
	TEN_THOUSAND(10000),
	FIVE_THOUSAND(5000),
	ONE_THOUSAND(1000),
	FIVE_HUNDRED(500),
	ONE_HUNDRED(100),
	FIFTY(50),
	TEN(10),
	ONE(1);
  
  private final int amountOfMoney;

	UnitsOfBill(int money){
		this.amountOfMoney = money;
	}

	public int getAmountOfMoney(){
		return this.amountOfMoney;
	}
}
```

- 위 코드와 같이 소괄호를 통해 상수값을 설정할 수 있으며, 이를 설정하기 위해서는 멤버 변수를 생성해야 한다.

    - 열거 상수 각각 해당 멤버 변수를 갖도록 설정하는 것이다.

- 각각의 열거 상수는 **'객체'**이고, 설정한 멤버 변수는 수정할 수 없는 **'상수'** 이다.

    - 즉, 생성자를 통해서만 초기화 할 수 있으므로 생성자를 만들어 주어야 한다.

      ```java
      UnitsOfBill(int money){...}
      ```

        - 해당 생성자는 기본적으로 private 이기 때문에 외부에서 new 연산으로 생성할 수 없다.

    - 또한, 멤버 변수는 private으로 설정되어 있으므로, 이를 외부에서 가져다 쓸 수 있도록 Getter를 만들어 주어야 한다.

      ```java
      public int getAmountOfMoney() {...}
      ```

- 열거 상수들(열거 객체들)은 모두 java.lang.Enum 클래스를 상속받기 때문에 name(), ordinal(), valueOf(String name), values() 메소드를 사용할 수 있다.

##### <Enum 클래스 메소드>

- name() : 해당 열거 상수의 이름을 반환한다.
- ordinal() : 해당 열거 상수의 인덱스를 반환한다. 열거 상수들이 나열된 순서대로 0번 인덱스부터 매겨진다.
    - 본 문제에서 이를 활용하여 화폐 개수를 저장하는 리스트의 인덱스와 맞추어 활용될 수 있었다.
- valueOf(String name) : 전달된 문자열과 일치하는 열거 상수(열거 객체)를 반환한다.
- values() : 열거 상수들을 저장한 배열을 생성하여 반환한다.
    - 본 문제에서와 같이 상수들을 탐색하며 작업이 수행되어야 할 때 활용될 수 있다.



### 2. private 메소드 테스트

- 본 문제에서 calculateNumberOfBills() 메소드를 private으로 설정하여 테스트 과정에서 고민이 있었다.
- 구글링을 해보니, **private 메소드에 대해서는 테스트를 진행하지 않는 것이 권장되었다.**
- 하지만 private 메소드에 대해 테스트를 해 볼 수 있는 방법에 대해서는 알고 있어야 할 것 같아 테스트 코드를 작성해 보았다.

##### <private 메소드 테스트 방법>

- REFLECTION을 활용해 private 메소드 혹은 필드에 접근하여 접근 가능 여부(Accessible)를 설정할 수 있다.

```java
Method calcNumberOfBillsMethod = BillConverter.class
  .getDeclaredMethod("calculateNumberOfBills", UnitsOfBill.class, int.class);
calcNumberOfBillsMethod.setAccessible(true);
```

```java
Field numberOfBillsField = BillConverter.class.getDeclaredField("numberOfBills");
numberOfBillsField.setAccessible(true);
```

- 위와 같이 BillConverter 클래스 내부에 특정 메소드 혹은 필드에 접근하여 Method, Field 객체를 생성할 수 있다.
- 이렇게 생성된 Method, Field 객체를 통해 접근 가능 여부를 수정할 수 있다.
- Accessible을 true로 설정한 후, 다음과 같이 메소드를 호출해 보거나, 필드 값을 받아올 수 있다.

```java
BillConverter billConverter = new BillConverter();
int money = 32_345;
Object change = calcNumberOfBillsMethod
  .invoke(billConverter, UnitsOfBill.valueOf("TEN_THOUSAND", money));
```

- invoke(메소드 수행할 객체 이름, 해당 메소드의 파라미터)
- billConverter 객체 내에서 함수가 수행된다.

```java
Object numberOfBills = numberOfBillsField.get(billConverter);
```

- get(필드 값 가져올 객체 이름)
- billConverter의 멤버 변수 numberOfBills를 가져온다.



- 즉, 다음과 같이 수행된다.
    - Method, Field 객체를 통해 Accessible을 true로 수정한다.
    - 테스트 해 볼 객체 billConverter를 생성하고, Accessible을 수정한 Method와 Field를 이에 적용한다.
    - Method : billConverter 객체의 멤버 메소드에 대해 수행한다.
        - calculateNumberOfBills() 메소드는 멤버 변수 numberOfBills를 수정한다.
        - 본 과정을 통해 billConverter 객체의 numberOfBills가 수정된다.
    - Field : billConverter 객체의 numberOfBills를 가져온다.
        - set() 함수를 통해 수정도 가능하다.

##### <private 메소드에 대한 테스트가 권장되지 않는 이유>

- 애초에 private는 클래스 내부에서만 동작하며, public으로 설정된 다른 멤버 메소드에 의해 호출된다.
- 즉, 굳이 private 메소드에 대해 테스트를 진행하지 않아도, public으로 설정된 메소드만으로도 충분히 테스트가 가능하다.
- 또한 private 메소드는 외부에서 접근할 수 없도록 설정되어 클라이언트와의 결합도를 낮추는 역할도 수행될 수 있다.
- 하지만 클라이언트에 해당하는 테스트가 내부 메소드에 대해 알 수 있게 되는 것은 결합도를 높일 수 있다.
    - 이는 유지 보수 과정에서 테스트에 대한 비용을 증가시키는 요인이 될 수 있다고 한다.

