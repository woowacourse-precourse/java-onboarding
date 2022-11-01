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

### 기능 목록
1. 유형 별 친구 추천 점수 SCORE_OF_COMMON_FRIEND, SCORE_OF_TIMELINE_VISIT와 최대 추천 친구수 제한 MAX_LIST_SIZE 
2. <사용자 아이디, 사용자의 친구 목록> 구조의 friend_map, <사용자 아이디, 추천 점수> 구조의 score_map
3. 친구 관계를 friend_map에 적용하는 함수 add_relationship
4. friend_map을 생성하는 함수 get_friend_map
5. 친구의 친구를 살피며 추천 점수를 주는 함수 consider_friend_of_friend
6. 방문한 타임라인을 살피며 추천 점수를 주는 함수 consider_visitor
7. score_map을 생성하는 함수 get_score_map
8. score_map을 바탕으로 최대 5명의 정렬된 추천 친구 아이디 리스트를 반환하는 함수 get_recommended_friend_list
9. 추천 친구 아이디 리스트를 리턴하는 함수 solution