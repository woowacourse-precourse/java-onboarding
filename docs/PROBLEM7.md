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

### 기능 조건
1. 유저별 친구 목록이 필요 ( '사용자와 함께 아는 친구의 수' 를 위해 )
2. O(1)을 위해 HashMap<String, ArrayList<String>> 사용
3. friends 입력 값 기반으로 HashMap 초기화
4. visitors 입력 값 - keySet에 없을 시 추가
5. 사용자와 함께 아는 친구의 수 연산
6. 사용자의 타임 라인에 방문한 횟수 연산

### 기능 구현
1. HashMap<String, ArrayList<String>> 초기화 - initHashMap()
2. 기존 keySet에 없을 시 추가하는 메소드
3. 사용자와 함께 아는 친구 수 count & calculate
4. 방문한 횟수 count & calculate
5. compare & sort 위에 inner class implements Comparable

### 학습 사항
1. static이란
   1. Static이란 키워드를 사용하여 정적 필드와 정적 메소드를 선언 (클래스 멤버)
   2. 정적 필드와 메소드는 객체(인스턴스)에 소속된 멤버가 아니라 클래스에 고정된 멤버
   3. 클래스 로더가 클래스를 로딩해서 메소드 메모리 영역에 적재할 때 클래스별로 관리된다.
   4. 클래스의 로딩이 끝나는 즉시 사용 가능.

2. static field 주의 사항
   1. static 필드를 사용하게 되면 모든 메소드에서 접근할 수 있다는 장점이 있지만,
      static은 프로그램의 종료시에 비워지는(garbage collector의 관할 밖) 구조이기에 리소스 낭비로 이어질 수 있다.