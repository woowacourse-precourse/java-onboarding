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

<br>

---

## 기능 구현 목록

- isValidRangeNumberException(int number)
  - number가 유효한 범위에 있으면 true 리턴
- isClapTiming(char numTypeOfChar)
  - numTypeOfChar 변수가 3, 6, 9에 해당되면 true 리턴
- makeStringNumber(int number)
  - 매개변수로 들어온 int형 number를 String 타입으로 바꾼 후 리턴
- getClapCountByNumber(String numberStr)
  - 매개변수로 들어온 값으로 박수를 몇 번 쳐야하는지 리턴해준다.
- getAnswer(int number)
  - 1 ~ number까지 총 박수를 몇 번 쳐야하는지 알려준다.