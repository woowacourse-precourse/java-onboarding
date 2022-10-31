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

1. main 메서드:
  - 사용자 아이디 user을 입력받는다.
  - 친구 관계 정보를 입력 받고 2차원 배열 arr에 저장한다.
  - convertToList 메서드를 호출한다.
  - 사용자 타임 라인 방문 기록 visitors를 입력 받아 리스트에 저장한다.
  - solution 메서드를 호출한다.
2. convertToList 메서드:
  - 2차원 배열을 2차원 List로 변환하여 return한다.
3. solution 메서드:
  - user와 친구인 아이디를 리스트에 저장한다.
  - set형식으로 user의 친구의 친구인 아이디를 저장하여 중복을 제거한 후 다시 리스트로 변환한다.
  - 아이디와 점수를 입력 받을 HashMap형식의idScore을 생성한다.
  - acquitancescore 메서드를 호출한다.
  - visitscore 메서드를 호츨한다.
  - hashmap idScore의 value를 기준으로 정렬하기 위해 comparator 인터페이스를 implements한 후에 compare 메서드를 오버라이딩 한다.
      - hashmap의 <Key, Value> 쌍을 유지한 상태로 정렬하기 위해 Map.Entry를 이용한다.
      - 순서 유지를 위해 LinkedHashMap을 이용하여 정렬한다.
  - 정렬된 해쉬맵에서 key값(아이디)만 뽑아서 리스트에 저장한다.
  - 유저와 친구인 아이디가 결과에 포함되지 않도록 제거한다.
  - 5명 이상일 경우 5명까지만 저장하여 answer을 반환한다.
4. acquitancescore 메서드: 함께 아는 친구의 점수를 계산한다.
  - 전체 친구 관계 목록에서 친구를 찾고, 그 옆에 있는 아이디가 친구의 친구인 아이디 목록에 있을 경우 10점을 추가한다.
5. visitscore 메서드: 방문 횟수 점수를 계산한다.
  - 방문 횟수에 따라 1점을 추가한다.