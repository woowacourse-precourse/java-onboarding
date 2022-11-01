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


---
## 📄 기능 목록

### 전체 동작 과정
0. **class Person** : 추천 점수 저장
   1. **compareTo()** : 정렬 기준
1. **makeRecommendList()** : 추천 목록 만들기
   1. **userFriendList()** : 유저 친구 목록
   2. **recommendScoreList()** : 추천 점수 목록
   3. **removeUserAndUserFriends()** : 추천 점수 목록에서 user와 userFreinds 삭제
   4. **hashMapToPersonArray()** : 추천 점수 목록을 Person Array로 변환
2. **sortRecommendList** : 추천 목록 정렬하기

### 함수별 입출력 및 동작 과정
0. **class Person**
   - String name, int score
   1. **compareTo()**
      1. score는 내림차순
      2. score가 같을 때, name은 오름차순
1. **makeRecommendList()** : 추천 목록 만들기
   - 입력값 : user, friends, visitors
   - 동작과정 :
     - userFriendList()
     - recommendScoreList()
     - removeUserAndUserFriends()
     - hashMapToPersonArray()
   - 출력값 : 추천 점수 목록 (Person[] recommendPersonArray)
   
2. **userFriendList()** : 유저 친구 목록
  - 입력값 : user, friends
  - 동작과정 
    - user와 친구인 이름을 HashMap에 저장
    - HashMap을 String Array로 변환
  - 출력값 : 유저 친구 목록 (String[] userFriendArray)
3. **recommendScoreList()** : 추천 점수 목록
  - 입력값 : user, friends, visitors
  - 동작과정 : 
    - 친구일 경우 10을 score에 합함
    - 방문자일 경우 1을 score에 더해줌
  - 출력값 : 추천 점수 목록 (Map<String,Integer> recommendHMap)
4. **removeUserAndUserFriends()** : 추천 점수 목록에서 user와 userFreinds 삭제
  - 입력값 : user, userFriend, recommendHMap
  - 동작과정 : recommendMap 에 있는 user와 userFriend 정보 삭제
  - 출력값 : 추천 점수 목록 (Map<String,Integer> recommendHMap)
5. **hashMapToPersonArray()** : HashMap을 Person Array로 변환
6. **sortRecommendList** : 추천 목록 정렬하기
   - 입력 : 추천 점수 목록 (persons)
   - 동작과정 :
     - TreeSet에 persons 넣음
     - ArrayList로 변환
   - 출력 : 추천리스트 (List<String> recommendList)


---
## 💡 기타 내용 정리

### Set
1. HashSet
2. TreeSet
3. LinkedHashSet

### List
1. ArrayList
2. LinkedList

## Map
1. HashMap
2. TreeMap