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

### 변수 목록
1. 친구 관계를 저장하는 HashMap : fList
2. 해당 user의 점수를 저장하는 HashMap : sList
3. 리스트를 반환하기 위한 score 별로 user를 저장하는 HashMap : scoreUser

### 기능 목록
1. 처음 friends에서 점수를 계산해야할 user 목록을 만드는 기능 : makeSList 
   - user와 user 친구들을 제외한 나머지 회원들을 0점으로 초기화 해준다.
2. 회원별 친구관계가 있는 회원들을 모두 list로 넣어주는 기능 : addFriend
3. sList에 존재하는 회원들 중, user와 함께 아는 친구가 있을 때마다 10점을 추가해주는 기능 : calScore
4. 방문한 회원의 경우 1점을 추가해주는 기능 : calScoreVisitors
5. 점수 순으로 나열하기 위해, {key : person -> value : score} 구조인 sList에서 
   {key : score -> value : person's list} 구조를 가진 scoreUser로 데이터를 넣어주는 기능 : changeKeyValue
6. 점수 순으로 나열하되, 같은 점수의 회원으 경우 알파벳순으로 나열하는 기능 : getAnswer