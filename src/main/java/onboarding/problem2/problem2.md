### problem2 기능 명세서

### Cryptogram Class
| 이름 | 기능 | 
| --- | --- | 
| removeDuplicateCharacters | 연속하는 중복 문자 제거하는 함수 |  

### Problem2.java
- 1. cryptogram 문자열에서 연속하는 중복 문자가 있을 시 이를 제거합니다.
- 2. 더 이상 제거할 중복 문자가 없으면(decodeResult.equals(cryptogram)) 해당 문자열이 최종 결과로 반환됩니다.