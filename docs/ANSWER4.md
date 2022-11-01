## ANSWER4

### solution
입력된 문자열을 차례로 순회하여 주어진 규칙에 맞게 변환하는 메소드
- reverseCase
- convertChar

### reverseCase
입력된 문자의 대,소문자를 변환하는 메소드
- checkLowerCase : 입력된 문자가 소문자인지 확인하는 메소드

### convertChar
입력된 문자를 주어진 규칙에 맞게 변환하는 메소드
- verifyChar : 주어진 문자가 알파벳이 맞는지 확인하는 메소드
- findCharIndex : 주어진 문자에 해당하는 base 문자로 부터 입력된 문자가 몇번째 위치하는지 반환하는 메소드  
- getBase : 주어진 문자가 소문자 이면 'a'의 ASCII_CODE 값, 대문자이면 'A'의 ASCII_CODE 값을 반환하는 메소드 