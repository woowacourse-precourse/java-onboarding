## 🚀 기능 목록
1. friedns를 list에 담아서 친구 관계의 양방향 그래프를 딕셔너리를 작성해준다.
2. Id에 있는 함께 아는 친구들은 total+10 해준다.
3. visit들은 total+1 해준다.
4. totalScore Map을 keyset을 사용해 key전체의 값을 list str에 담아 변환 해준다.
5. list str로 변환 해준 값을 람다식을 통해 오름차순으로 정렬해준다.
6. 최대 5명을 return 해주기 위해 조건문을 이용해 return 해준다.
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
