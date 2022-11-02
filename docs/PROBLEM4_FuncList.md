## 기능 목록
1. ASCII 코드로 단어가 대문자인지 소문자인지 비교한다.
   - boolean isUpperChar(char word) , boolean isLowerChar(char word)
2. 1번의 결과에 따른 단어를 reverse 시킨다.
   - char convertUpperChar(char word), char convertLowerChar(char word)
3. 2번을 활용하여 변경된 단어를 리턴시킨다. 둘중 어느곳에도 포함되지 않을 시 단어를 그대로 리턴한다.
   - char convertWord(char word)