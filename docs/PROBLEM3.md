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

# 개발 기록

## 기능 목록

개요
1. 어떤 숫자에서 3, 6, 9의 개수를 세는 기능
2. 1부터 number까지 369게임을 진행하는 기능

### 1. public int countTargetCharacterInNumber(char targetCharacter, int number)
- number 안에 찾는 숫자(targetCharacter)의 개수를 세서 반환하는 메소드
- 기능 : 
  - number 안에 찾는 숫자(targetCharacter)가 있는지 확인한다.
  - 찾는 숫자가 있으면 그 수를 세서 반환한다. 없으면 0을 반환한다.

### 2. public int play369Game(int endNumber)
- 게임의 끝을 입력받고, 1부터 끝까지 369 게임을 진행하는 메소드
- 기능 :
  - 게임의 끝 숫자(endNumber)를 입력받는다.
  - 1부터 끝(endNumber)까지 369게임을 진행한다.
  - 게임을 진행하면서, 박수의 횟수를 센다.
  - 박수의 횟수를 반환한다.

## Test Code
### 1. countTargetCharacterInNumberTest()
- 숫자와 찾는 숫자를 입력 시 숫자의 찾는 수의 개수를 반환하는지 확인
  - 테스트 : (3, 3), (6, 636), (6, 993)
  - 정답 : (1), (1), (0)

### 2. play369GameTest()
- 369 게임의 결과를 맞게 반환하는지 확인
  - 테스트 : 33
  - 정답 : 14

