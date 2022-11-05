기능 목록
---
1. friends 리스트 검사해 친구관계 map에 저장하는 기능 (getFriendRelationshipMap)

2. user 제외한 사용자의 점수 0으로 초기화하는 기능 (initializeScoreMap)

3. user와 함께 아는 친구의 수 1명 당 사용자의 점수 10점씩 증가시키는 기능 (increaseAcquaintanceScore)

4. visitors 리스트 검사해 방문 횟수 당 사용자의 점수 1점씩 증가시키는 기능 (increaseVisitorScore)

5. 점수가 0점인 사용자를(이미 친구인 사용자) 제외한 나머지를 리스트에 저장하는 기능 (getRecommendedFriends)

6. 점수 내림차순으로 정렬(같은 경우 이름순 정렬)하는 기능 (sortRecommendedFriends)

7. 추천 친구 최대 5명만 반환하는 기능 (solution)

검증 & 예외처리 목록
---
* user 길이 검증(1 ~ 30) (validateUserLength)
  * ex) user 길이 1보다 작거나 30보다 큰 경우 -> 예외처리
  
  
* friends 길이 검증(1 ~ 10000) (validateFriendsLength)
  * ex) friends 길이 1보다 작거나 10000보다 큰 경우 -> 예외처리


* friends 각 원소 길이 검증(2) (validateFriendsElementLength)
  * ex) friends = [["userA", "userB", "userC"]] -> 예외처리
  
  
* 아이디 길이 검증(1 ~ 30) (validateIdLength)
  * ex) friends = [["userA", "abcdefghijklmnopqrstuvwxyzabcde"] -> 예외처리


* 아이디 형식 검증 (validateIdFormat)
  * ex) 아이디에 알파벳 외의 문자 있을 경우 -> 예외처리


* visitors 길이 검증(0 ~ 10000) (validateVisitorsLength)
  * ex) visitors 길이 10000보다 큰 경우 -> 예외처리
