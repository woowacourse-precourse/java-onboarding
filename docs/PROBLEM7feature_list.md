

## 문제 분석

- 점수가 0인 경우는 추천하지 않는다.
- 점수가 가장 높은 순으로 정렬하고, 점수가 같으면 이름순으로 정렬한다.
- 최대 5명만 추천한다.
- 이미 친구인 이들은 친구 추천에서 제외 해야 한다.


| user | friends | visitors | result |
| --- | --- | --- | --- |
| "mrko" | [ ["donut", "andole"], ["donut", "jun"], ["donut", "mrko"], ["shakevan", "andole"], ["shakevan", "jun"], ["shakevan", "mrko"] ] | ["bedi", "bedi", "donut", "bedi", "shakevan"] | ["andole", "jun", "bedi"] |


mrko와 친구관계 : donut,shakevan
mrko의 친구와 친구 관계(10점) : andole(2),jun(2)
mrko 타임라인 방문 횟수(1점) : bedi(3), donut(1), shakevan(1)

즉 result = andole(20) == jun(20) > bedi(3) / donut과 shakevan는 이미 친구이다.



## 기능 구현 목록

+ [ ] 친구 관계를 담은 graph 작성
+ [ ] 각 유저에 대해 점수를 담는 리스트 작성
+ [ ] graph를 순회하여 mrko에서 거리 2에 있는 유저의 점수를 +10한다.
+ [ ] visitor 배열을 돌리며 점수 리스트에가 각 유저마다 +1을 해준다.
+ [ ] 점수 리스트를 내림차순으로 정렬한다 
+ [ ] 같은 점수일 경우 알파벳 오름차순으로 정렬한다.
+ [ ] 상위 5명 까지만 result배열에 담는다.
