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

***
## 기능 목록

### 메소드 목록
* isAlreadyFriend
  * 이미 user와 친구인지 판단하는 메소드.
  * 해당 이름이 nameAndScore에 있고, 해당 이름 key의 value가 -1이라면 이미 친구이므로 true return.
* isUser
  * 이름이 user와 같은지 판단하는 메소드.
  * name이 user의 이름과 같다면 true를 return.
* calculateFriendScore
  * '사용자와 함께 아는 친구의 수 = 10점'을 부여하는 메소드.
  * nameAndScore에 이미 있다면 기존 점수에 +10, 없다면 10점으로 추가한다.
* calculateVisitorScore
  * '타임라인 방문 횟수 = 1점'을 부여하는 메소드.
  * nameAndScore에 이미 key가 있고, user와 친구가 아니라면 +1점을 부여한다.
  * nameAndScore에 없다면 1점으로 추가한다.
* getAnswer
  * 정렬된 LinkedList<Map.Entry<String, Integer>> entries를 순회하며 List answer에 이름을 추가한다.
  * 점수가 0점보다 크면 answer에 추가하고, answer의 크기가 5이면 탈출한다. 

### 작동 과정
* 각 친구관계의 첫번째는 user의 친구로 가정하고 기능을 구현하였다.
* Map nameAndScore에서 user의 친구는 score를 -1로 관리한다.
* 친구관계 List friends를 순회하며 친구 관계의 두번째 이름이 isUser, isAlreadyFriend의 경우는 continue로 통과한다.
* nameAndScore의 key 중 친구 관계의 첫번째 이름인 것이 없다면 -1점으로 nameAndScore에 추가한다.
* 친구 관계 두번째 이름의 점수를 calculateFriendScore로 계산하여 nameAndScore에 추가한다.
* 타임라인 방문자 List visitors를 순회하며 calculateVisitorScore를 통해 점수를 추가한다.
* Map nameAndScore를 entrySet으로 변환 후 이를 LinkedList에 담은 entries를 생성한다.
* entries를 문제 요구 사항에 맞게 정렬한다.(점수순 우선, 동률 시 이름순)
* getAnswer를 통해 List answer에 정답을 담고 return.