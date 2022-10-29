# refactor 해볼 것들

## validation

- 공통적으로 userInput이 Integer이던지, String이던지 크기나 길이 비교하는 코드가 유사하고 해야하는 행동이 비슷하다는 생각이 들어서 이를 하나의 interface로 다형성을 지원하기로 결정
- 