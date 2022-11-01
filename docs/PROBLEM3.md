## 🚀 기능 요구 사항

배달이가 좋아하는 369게임을 하고자 한다. 놀이법은 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 한다.

숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- number는 1 이상 10,000 이하인 자연수이다.

### 실행 결과 예시

| number | result |
| --- | --- |
| 13 | 4 |
| 33 | 14 |
---
## 도메인 목록

### Game369
- 369게임에 필요한 기능을 제공하는 클래스

    
    int getTotalClapTimeOfNumbersInRange(int start, int end)
- 주어진 [start, end] 범위 내의 숫자의 총 박수 횟수를 반환하는 메서드


    int getClapTimeOfNumber(int number)
- 주어진 숫자의 필요한 박수 횟수를 반환하는 메서드

    
    boolean checkNumberIs369(int number)
- 주어진 숫자가 박수를 쳐야 하는 숫자인지(3/6/9)인지 여부 반환