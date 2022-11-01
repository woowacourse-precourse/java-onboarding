# Problem 7

---

## 구현 기능 목록
- [X] friends 리스트를 (key, value) = (user, friendsList)인 HashMap으로 변환한다
- [X] 친구 HashMap과 방문자 List를 기반으로 친구 추천 점수 HashMap을 구성한다
  - [X] 지정된 사용자의 친구의 친구들에 10점을 친구 추천 점수 HashMap에 추가한다.
  - [X] 방문자들에게 1점을 친구 추천 점수 HashMap에 추가한다.
- [X] 높은 점수 다섯 명의 리스트를 반환한다.
  - [X] 친구 추천 점수 HashMap의 Key를 점수와 이름 기반으로 정렬한다.
  - [X] 최대 5명까지 뽑아 result 리스트를 완성한다.
