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


### 기능목록
- User 객체
  - 해당 유저의 이름 
  - 친구 목록 (친구들을 기록하는 변수 및 함수)
  - 어떤 사람과 친구인지 확인하는 함수
- 이름별 점수를 저장하는 MAP (이름, 점수)
  - visit + 1점
  - 함께아는친구 +10점
- 함께아는 친구들을 확인하는 로직
- 최종적으로 추천목록을 반환하는 로직
  - 이미 친구인 사람들은 추천하지 않음
  - 점수 DESC, 이름 ASC 로 정렬
  - 5명까지만 추천함

### 참고자료
- Map 인자 대입 : https://blog.advenoh.pe.kr/java/%EC%9E%90%EB%B0%948-HashMap-%EB%B3%B4%EB%8B%A4-%EA%B0%84%EA%B2%B0%ED%95%98%EA%B3%A0-%ED%9A%A8%EA%B3%BC%EC%A0%81%EC%9C%BC%EB%A1%9C-%EC%9E%91%EC%84%B1%ED%95%98%EA%B8%B0/
- HashMap 값(value) 변경 : https://developer-talk.tistory.com/745
- https://m.blog.naver.com/occidere/220918234464
- https://elevate-myself.tistory.com/75
