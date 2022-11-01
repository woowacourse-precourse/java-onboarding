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

## 기능 구현

- countClapCase()
    -  각 자리수 별로 나눠서 총 박수를 치는 횟수를 계산
- generalTensDigit()
    - 0~9까지 박수를 치는 횟수
- specificTensDiigt()
    - 30 ~ 39까지 박수를 치는 횟수
- generalHundreds()
    - 0~99까지 박수를 치는 횟수
- specificHundreds()
    - 300~399까지 박수를 치는 횟수
- generalThousands()
    - 0~999까지 박수를 치는 횟수
- specificThousands()
    - 3000 ~ 3999까지 박수를 치는 횟수
- tenThousand()
    - 0 ~ 10000까지(최대 경우) 박수를 치는 횟수
- calculateOnesClapCase()
    - 일의자리 값으로 박수치는 횟수를 계산(ex) 7 -> 2번)
- calculateTensClapCase()
    - 십의 자리 밑으로 버림을 한 수 까지 박수를 치는 횟수를 계산(ex) 64 -> 60)
- calculateHundredsClapCase()
    - 백의 자리 밑으로 버림을 한 수까지 박수를 치는 횟수를 계산 (ex) 140 -> 100)
- calculateThousandsClapCase()
    - 천의 자리 밑으로 버림을 한 수 까지 박수를 치는 횟수를 계산 (ex) 1340 -> 1000)
- numberOutOfRangeException()
    - 숫자 크기 예외 처리