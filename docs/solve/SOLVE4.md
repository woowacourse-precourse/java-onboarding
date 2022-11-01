### 🚀 기능 목록

####  problem4 - solution()
[요구] 문자열 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return
- reverseString(): 청개구리 사전을 참고해 문자열을 반대로 변환하는 메서드
   - String reversedWord: 변환한 문자열을 저장
   - for (char character : word.toCharArray())
      - if ('A' <= character && character <= 'Z'): character가 대문자일 때
         - reverseUpperCase(): 청개구리 사전을 참고해 대문자를 반대로 변환하는 메서드
      - if ('a' <= character && character <= 'z'): character가 소문자일 때
         - reverseLowerCase(): 청개구리 사전을 참고해 소문자를 반대로 변환하는 메서드
      - 알파벳 외의 문자는 변환하지 않는다.
   - reversedWord를 리턴

#### 청개구리 사전 (아스키코드)
- 대문자
  - A: 65 <-> Z: 90
  - B: 66 <-> Y: 89
    - A+Z 나 B+Y의 값은 155로 같다.
- 소문자
  - a: 97 <-> z: 122
  - b: 98 <-> y: 121
    - a+z 나 b+y의 값은 219로 같다.
  
따라서 아스키코드 값의 차이를 이용해 문자 변환을 할 수 있다.