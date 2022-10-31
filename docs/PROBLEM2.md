## 암호문 문제

## 기능 목록
- [x] 스택 구현 사용하기 CheckDuplicates# -> Stack 임포트
    - 이유는, 시간복잡도가 O(n)이기에 스택을 사용하였습니다.
- [x] 암호문을 스택에 넣기 전에 중복값을 제거하고 넣는다. StackGenerator#createStack
- [x] 중복 문자를 만날때 마다 삭제 시켜준다.
- [x] 삭제 시킨 다음 그전 인덱스의 문자랑 중복이 된다면 한번더 삭제 시켜준다.
- [x] 중복을 모두 없앤 결과와 "brown" 비교하여 맞으면 리턴 determine#compare()
  <br/>  - 그렇지 않다면 빈 문자열 리턴  

## 기능 요구 사항

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 
예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.
    
1. "browoanoommnaon"
2. "browoannaon" -> oomm
3. "browoaaon"   -> nn
4. "browoon"     -> aa
5. "brown"       -> oo

임의의 문자열 cryptogram이 매개변수로 주어질 때, 
연속하는 중복 문자들을 삭제한, 결과를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |
