## 🚀 기능 요구 사항

레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다. 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구 추천 알고리즘을 구현하고자 아래와 같은 규칙을 세웠다.

- 사용자와 함께 아는 친구의 수 = 10점 
- 사용자의 타임 라인에 방문한 횟수 = 1점

사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때, 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라. 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.

### 제한사항

- user는 길이가 1 이상 30 이하인 문자열이다.
- friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
- friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
  - A와 B는 친구라는 의미이다.
  - 아이디는 길이가 1 이상 30 이하인 문자열이다.
- visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
- 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
- 동일한 친구 관계가 중복해서 주어지지 않는다.
- 추천할 친구가 없는 경우는 주어지지 않는다.

### 실행 결과 예시

| user | friends | visitors | result |
| --- | --- | --- | --- |
| "mrko" | [ ["donut", "andole"], ["donut", "jun"], ["donut", "mrko"], ["shakevan", "andole"], ["shakevan", "jun"], ["shakevan", "mrko"] ] | ["bedi", "bedi", "donut", "bedi", "shakevan"] | ["andole", "jun", "bedi"] |

## 📗 기능 목록

* 추천 친구 목록 정렬 기능
* 모든 유저들의 친구 관계 저장 기능
* 타임 라인을 방문한 유저의 추천 포인트 증가 기능
* 함께 아는 친구가 있는 유저의 추천 포인트 증가 기능
* 최대 5명의 추천 친구 리스트 반환 기능



## 📑 클래스별 상세 기능 목록

### 📌 class `RecommendedFriendComparator`

추천 친구 목록을 정렬하기 위한 클래스

* **`int compare (String leftUser, String rightUser)`**

  * 추천 친구 목록 정렬 수행


### 📌 class `UserManager`

모든 유저들의 친구 관계를 관리하는 클래스

* **`void addFriend(String sourceUser, String destUser)`**

  * `friendsMap`에 유저의 친구 관계를 저장. `sourceUser`의 친구 리스트에 `destUser`를 추가.

* **`Map<String, List<String>> getFriendsMap(List<List<String>> friends)`**

  * 모든 유저들의 친구 관계를 저장하는 `friendMap` 반환


### 📌 class `User`

사용자의 이름, 타임 라인 방문자 리스트, 친구 리스트, 추천 친구 리스트를 클래스

* **`void setRecommendPoint(List<String> candidates, int extraPoint)`**
  * 추천 친구 후보인 candidate가 user 본인이 아니고, 이미 등록된 친구가 아닐경우에만 `extraPoint`만큼 추천 점수를 올림
* **`void addVisitPoint`**
  * 타임라인을 방문한 유저의 추천 포인트 추가
* **`void addFriendPoint`**
  * 함께 아는 친구가 있는 유저의 추천 포인트 추가
* **`List<String> getSortedKeySet()`**
  * 정렬된 추천 친구 리스트의 key 리스트 반환
* **`List<String> getTopFiveRecommendedFriend`**
  * 최대 5명의 추천 친구 리스트 반환
