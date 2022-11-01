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

## 구현 과정

`HashMap<String, ArrayList<String>> friendsMap`

`HashMap<String, Integer> userScoreMap` 사용

---

1. 친구 관계에 대한 정보를 `friendsMap`에 저장

  - `A`가 `B, C, D`와 친구라고 하면 `A`가 `Key`, `{B, C, D}`가 `Value`
  - `B`, `C`, `D`도 `A`와 친구이므로 마찬가지로 저장


2. 타임라인에 방문한 친구들에 대해 추천 점수 1점씩 추가

  - `A, B, C`가 사용자의 타임라인에 방문했다면, `A, B, C` 각각 1점 추가


3. 사용자의 친구의 친구들에 대해 추천 점수 10점씩 추가

  - 사용자 `A`가 `B, C, D`와 친구이고 이 중 `B`가 `E, F`와 친구라면
    <br>`E, F` 각각 추천 점수 10점 추가


4. 친구 이름에 대한 추천 점수가 `userScoreMap`에 저장된다.
  - `B` 친구 추천 점수가 10점이라면 `(B, 10)`의 `(Key, value)`로 저장


5. `userScoreMap`을 `value(친구 추천 점수)`를 기준으로 내림차순 정렬


6. 정렬된 `userScoreMap`에서 최대 5명을 반환 (추천 점수가 0인 인원은 제외)
