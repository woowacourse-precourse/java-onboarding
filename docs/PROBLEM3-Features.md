## 문제 3번 기능목록

## GameOperator
1. Iterator369에 의존한다
2. 게임시작
   1. Iterator369를 동작시킨다

## 369Iterator
1. ClapCounter에 의존한다
2. 목표 숫자를 입력받는다
3. 목표 숫자까지 1씩 증가시킨다
   1. 현재 숫자에서 3,6,9 개수를 반환한다
   2. 반환받은 개수 만큼 ClapCounter에서 박수를 친다

## ClapCounter
1. 박수를 한 번 치게되면 현재 카운터에서 1증가 시킨다
2. 몇 번 박수쳤는지 상태를 반환할 수 있다