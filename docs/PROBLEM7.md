## 👀 생각할 점

1. 두 가지의 Map을 생성한다.
  + Map<String,List<String>> 친구관계 맵 => key값으로 id, value 값으로 친구 리스트 
    + key 값은 friends.get(0) value 값은 List<String>.add(friends.get(1))
    + 이떄 user와 user의 친구들은 key 값으로 추가하지 않는다.
  + Map<String,Integer> 스코어 맵 => key 값으로 id, value 값으로 score
    + key 값은 친구 추천 대상이 될수 있는 인물의 id 값, value 값은 로직에 따라 얻는 점수값

2. user의 친구 리스트를 생성한다.
   + freinds를 참조하여 user의 친구 리스트를 생성한다. 

3. 점수를 얻는 방법
  + 친구관계 맵을 통해서 user 의 친구리스트를 순회하면서 해당 친구의 친구리스트에 있는 인물들을 알아낸뒤 스코어 맵에 +10점을 준다.
  + visitors 리스트를 순회하면서 등장한 인물들을 알아낸뒤 스코어 맵에 +1 점을 준다.

4. 모든 과정을 마친 후 value를 기준으로 내림 차순정렬하고 상위 5명을 반환한다.
  + 이때 value 값이 같다면 name을 기준으로 오름차순 정렬한다.
  + 이때 value 값이 0 인 사람은 반환하지 않는다.


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
