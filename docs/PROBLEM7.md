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

### 풀이 전략

1. 이름, 친구목록, 점수를 필드로 가지고 있는 `Member` 클래스를 만들어 관리한다.
   - `getMemberNameSet()` : `user`, 친구, 방문자를 모두 포함한 멤버 이름을 저장한 `Set`을 반환한다.
   - `getMemberList()` : `getMemberNameSet()`으로 받아온 `Set`의 각 멤버 이름으로 `Member` 타입의 객체를 만들어 리스트로 반환한다.
   - `getCommonFriendNum()` : `user`와 `member`의 함께아는 친구 수를 반환한다.
   - `setCommonFriendScore()` : `getCommonFriendNum()` 매서드로 구한 함께아는 친구 수를 이용해 각 멤버객체마다 함께아는 친구의 점수를 저장한다.
   - `findUserByName()` : 이름을 통해 멤버 객체를 찾아 반환한다.
   - `setVisitFriendScore()` : 방문자 멤버 객체들의 점수를 저장한다.
   - `sortByScore()` : 멤버리스트를 점수에 따라 내림차순, 점수가 같다면 이름에 따라 오름차순으로 정렬해 반환한다.
   - `getSortedMemberList()` : 멤버리스트의 각 멤버마다 점수를 세팅 후 정렬해 반환한다.
   - `isScoreIsZero()` : 멤버 객체의 점수가 0점인지의 여부를 확인한다.
   - `isUsersFriend()` : 멤버 객체가 이미 `user`의 친구인지 여부를 확인한다.
   - `getResultList()` : `isScoreIsZero()`와 `isUsersFriend()` 메서드로 각 객체의 유효성검사를 한 후 정렬된 순서대로 5개를 가져와 반환한다. 

