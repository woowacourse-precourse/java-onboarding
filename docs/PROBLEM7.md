## 🚀 기능 요구 사항

레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다. 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구 추천 알고리즘을 구현하고자 아래와
같은 규칙을 세웠다.

- 사용자와 함께 아는 친구의 수 = 10점
- 사용자의 타임 라인에 방문한 횟수 = 1점

사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때, 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을
return 하도록 solution 메서드를 완성하라. 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.

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

---

## 문제 해결 전략

- user와 함께 아는 친구가 있으면 그 친구의 점수를 +10점 합니다.
- user의 visitors에 대해 +1점을 해줍니다.
- user와 직접 친구인 친구는 추천하지 않습니다.
- 결과를 담아 문제의 조건에 맞게 정렬하여 return합니다.

## 기능 목록

- [ ] user와 친구인 친구를 찾습니다.
- [ ] user와 친구인 친구의 친구를 찾으면 그 친구에 대해 점수를 +10점 해줍니다.
- [ ] user에게 방문한 친구의 점수를 +1점 해줍니다.
- [ ] 최대 5명까지 점수가 높은 순으로, 점수가 같으면 이름순으로 정렬합니다.

## 세부 구현 사항

- [x] List<String> userFriends 배열을 선언해줍니다.
- [x] findUserFriend(List<List<String>> friends, List<String> userFriends, String user) 메서드를 구현합니다.
    - [x] friends배열을 탐색하며 user의 친구를 userFrineds배열에 저장해줍니다.
- [ ] 점수를 계산할 calcFriendsScore(Map<String, Integer> friendScore, List<List<String>> friends, List<String> userFriends)
  메서드를 구현합니다.
    - [x] isFriendsFriend() 메서드를 통해 user와 직접 친구가 아니면서 user의 친구의 친구인지 확인합니다.
    - [ ] friends배열을 탐색하며 user와 직접 친구가 아니면서 userFriedns배열에 있는 친구와 친구인 친구의 점수를 갱신해줍니다.
    - [ ] user에게 방문한 친구의 점수를 갱신해줍니다.
- [ ] friendScore() 메서드를 통해점수가 높은 순서대로, 점수가 같다면 이름 순서대로 정렬해줍니다.
- [ ] recommendFriend()메서드를 통해추천할 친구가 있다면 최대 5명까지 배열에 넣어 return합니다.
    - [ ] 점수가 0점이상이고 직접 친구가 아닌 추천친구를 추가합니다.
    - [ ] 최대 5명만 추가하도록 합니다.
