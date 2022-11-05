기능 목록
---
1. 각 크루원의 닉네임 중 연속된 두 글자의 모든 조합을 구하는 기능 (getSimilarNicknameCrewEmail)

2. 각 글자의 조합이 포함된 닉네임을 갖는 크루원의 목록을 Map에 저장하는 기능 (getSimilarNicknameMap)

3. 비슷한 닉네임을 갖는 크루원의 이메일 목록을 구하는 기능 (getEmailSet)

4. 이메일 목록에서 중복을 제거하고 오름차순으로 정렬해 반환하는 기능 (solution)

검증 & 예외처리 목록
---
* 크루 인원 검증(1 ~ 10000) (validateCrewNumber)
  * ex) forms 길이 10000보다 큰 경우 -> 예외처리
  
  
* 이메일 형식 검증 (validateEmailFormat)
  * ex) 이메일 형식이 xxx@email.com과 다른 경우 -> 예외처리


* 이메일 길이 검증(11 ~ 20) (validateEmailLength)
 * ex) 이메일 길이 20보다 긴 경우 -> 예외처리
  

* 닉네임 형식 검증 (validateNicknameFormat)
  * ex) 닉네임에 한글이 아닌 문자 포함된 경우 -> 예외처리
  

* 닉네임 길이 검증(1 ~ 20) (validateNicknameLength)
  * ex) 닉네임 길이 20보다 긴 경우 -> 예외처리
