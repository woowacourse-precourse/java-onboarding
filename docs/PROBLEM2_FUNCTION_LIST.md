기능 목록
---
1. 암호문을 탐색해 연속하는 중복 문자를 삭제하는 기능 (deDuplicateCryptogram)

2. 중복 문자를 삭제한 암호문을 처음부터 재탐색하는 기능 (deDuplicateCryptogram)

3. 중복 문자를 모두 삭제한 최종 결과를 반환하는 기능 (solution)

검증 & 예외처리 목록
---
* cryptogram 길이 검증(1 ~ 1000) (validateCryptogramLength)
  * ex) cryptogram 길이 1 보다 작거나 1000보다 큰 경우  -> 예외처리


* cryptogram 알파벳 소문자로만 구성되었는지 검증 (validateCryptogramLowerAlpha)
  * ex) cryptogram = "Brown" -> 예외처리
