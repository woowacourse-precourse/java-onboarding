# refactor 해볼 것들

## validation

- 공통적으로 userInput이 Integer이던지, String이던지 크기나 길이 비교하는 코드가 유사하고 해야하는 행동이 비슷하다는 생각이 들어서 이를 하나의 interface로 다형성을 지원하기로 결정 - e1439eb
- 그렇게 작성한 validation의 경우 여러 곳에서 validation을 쓸 경우 무분별한 객체를 생성하는 문제를 야기 -> 싱글톤패턴을 이용하여 매번 새롭게 만드는 것이 아닌 한번 생성하고 난 뒤에는 그 객체를 불러서 사용하는 방식을 채택 - 0c0d268

## 공통 refactor 요소

- java convention, else 예약어 쓰지 않기