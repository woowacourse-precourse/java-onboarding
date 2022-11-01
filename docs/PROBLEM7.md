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

### 문제 분석
1. 해쉬맵을 사용해서 사용자 정보, 점수 정보 저장
   - 사용자 정보: {key: 본인 이름, value: 해쉬셋으로 친구들 저장}
   - 점수 정보: {key: 사용자 이름, value: 점수(0으로 초기화)}
2. user 로 입력 받은 사람의 친구들 해쉬셋 리스트를 가져옴
3. 사용자 정보가 저장된 해쉬맵을 전체 다 순환하면서 user 의 친구들 해쉬셋에 포함되어 있는지 확인하고 있으면 점수에 +10
4.  visitor 를 순환하면서 점수 정보에 +1

### 기능 목록
1. createUserInfo
   - parameter: friends 리스트
   - return: 해쉬맵
2. createPointInfo
   - parameter: 사람들 리스트
   - return: 해쉬맵
   - 1번 함수로 만들어진 해쉬맵의 key 값들 리스트를 받아와 실행
3. givePointUsingFriendRelationship
   - parameter: String user, Hashmap userInfo, HashMap pointInfo
   - return: HashMap pointInfo
   - 유저정보에서 key 를 순회 하면서 사용자와 같이 아는 친구를 찾아 pointInfo 의 점수에 점수를 증가시킴, 이때 이미 user 와 친구이면 점수 증가 하지 않음.
4. givePointUsingVisitorList
    - parameter: Visitor list, HashMap pointInfo
    - return: HashMap pointInfo
    - 방문자 목록을 받아와 점수 증가, 이때 이미 user 와 친구이면 점수 증가 하지 않음.
5. deleteZero
   - parameter: HashMap pointInfo
   - return: HashMap pointInfo
   - 점수가 0점인 경우 삭제
6. findFriendsList
   - parameter: HashMap pointInfo
   - return: List<String> friends
   - 점수가 높은 순으로 정렬
   - 점수가 동일 하다면 이름 순으로 정렬