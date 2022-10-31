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


### 필요메서드

| 함수명                    | 함수설명                                                                                                                                                                                                                                        | InPut                                                                                                                   | OutPut                                      |  
|------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|---------------------------------------------|
| isCorrectInputs        | 문제의 제한사항에 위반되는지를 판단한다.<br/>-위반되지 않는경우:true<br/>- 위반되는경우:false<br/><br/>예외처리 목록<br/>- user의 길이는 1이상 30이하의 문자열<br/>- friends의 list길이는 1이상 10,000이하<br/>- freinds list에 들어있는 각 아이디의 길이는 1이상 30이하의 문자열<br/>- visitor list 길이는 0이상 10,000이하<br/> | String user, <br/>List<List<-String->> friends, <br/>List<-String-> visitors                                            | boolean                                     |
| makeFriends            | HashMap을 사용하여 (key,value)값으로 친구관계를 매핑한다.<br/>Key={유저}, Value={유저의 친구 List(List<-String->)}                                                                                                                                                  | List<List<-String->> friends                                                                                            | HashMap<-String,List<-String->-> friendsMap |
| setPointsForFriendsMap | '사용자와 함께 아는 친구의 수=10'점에 대한 로직을 구현한다.<br/>return값은 HashMap으로 Key={유저},Value={point}                                                                                                                                                          | String user, <br/>HashMap<-String,List<-String->-> friendsMap , <br/>HashMap<String, Integer> recommendFriendToPointMap | void                                        |
| setPointsForVisitorMaps       | '사용자 타임라인에 밤운한 횟수=1점'에 대한 로직을 구현한다. <br/>return값은 HashMap으로 Key={유저},Value={point}                                                                                                                                                          | List<-String-> visitors , <br/>HashMap<String,Intger> recommendFriendToPointMap                                         | void                                        |
| removeMapUsersFriends    | 친구 추천으로 등록된 후보중 이미 user와 친구인 유저는 제외하는 로직을 구현한다.<br/>return값은 return값은 HashMap으로 Key={유저},Value={point}                                                                                                                                      | List<-String-> usersFriends <br/>   HashMap<String, Integer> recommendFriendToPointMap                                  | void                                        |                                                  |
| sortByRestrictions     | 주어진 제한사항에 맞게 친구 추천후보를 정렬한다.<br/>hashmap->list <br/>요구사항<br/>  - 최대 5명까지 나타냄<br/> - 점수가 높은순으로 정렬<br/> - 점수가 같은 경우 이름순으로 정렬                                                                                                                   | HashMap<String, Integer> recommendFriendToPointMap                                                                                           | List<-String-> recommendedSortedList        |                 |