## 🚀 문제 4 기능 구현내용

### 필요기능


| 필요기능            | 변수명(함수명) | 구현 여부(O, X) |
|-----------------|----------|-------------|
| 해시맵에 청개구리 언어 저장 | convert.put(String.valueOf((char) ('A' + i)), change_word[i]); | O           |
| 대문자, 소문자 판별     |   boolean isUpper = Character.isUpperCase(c.charAt(0));       | O           |


### 예외처리

| 예외처리                | validation | 구현 여부(O, X) |
|---------------------|------------|-------------|
| 길이가 1미만, 1000초과일 경우 |  | O           |
| 알파벳 외의 문자 변환 X      | if (now_value == null) | O           |