# 기능 목록
### 기능을 구현하기 위한 기능 목록은 다음과 같습니다.

### 1. 369 게임을 진행하며 입력받은 수에 도달할 떄 까지 친 박수의 횟수 반환
#### clapCount(int number) --> int count
- 1부터 입력받은 수까지 for 문을 수행합니다.
- for문의 i 값을 currentNumber에 넣은 뒤 currentNumber % 10을 하여 currentNumber의 1의 자릿수를 구한 뒤 3, 6, 9중 하나이면 count를 1씩 증가시킵니다.  
- currentNumber / 10을 하여 currentNumber의 자릿수를 하나 낮춘 뒤 위 과정을 반복합니다.
- currentNumber의 자리수가 한자리가 될때까지 위 과정을 반복하여 박수의 횟수를 구합니다.

# 전체 동작 과정
1. number를 입력 받은 뒤 clapCount()에 입력합니다.
2. clapCount()에서 반환된 값을 answer에 넣습니다.
3. answer를 반환합니다.