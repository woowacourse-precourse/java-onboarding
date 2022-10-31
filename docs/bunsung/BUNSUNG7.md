# Solution: bunsung92

- 레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다. 
- 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구 추천 알고리즘을 구현하고자 아래와 같은 규칙을 세웠다.
- 사용자와 함께 아는 친구의 수 = 10점
- 사용자의 타임 라인에 방문한 횟수 = 1점
*** 
- 사용자 아이디 user 와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors 가 매개변수로 주어질 때, 
- 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라. 
- 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.

### 제한사항

- user 는 길이가 1 이상 30 이하인 문자열이다.
- friends 는 길이가 1 이상 10,000 이하인 리스트/배열이다.
- friends 의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
    - A와 B는 친구라는 의미이다.
    - 아이디는 길이가 1 이상 30 이하인 문자열이다.
- visitors 는 길이가 0 이상 10,000 이하인 리스트/배열이다.
- 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
- 동일한 친구 관계가 중복해서 주어지지 않는다.
- 추천할 친구가 없는 경우는 주어지지 않는다.

### 실행 결과 예시

| user | friends | visitors | result |
| --- | --- | --- | --- |
| "mrko" | [ ["donut", "andole"], ["donut", "jun"], ["donut", "mrko"], ["shakevan", "andole"], ["shakevan", "jun"], ["shakevan", "mrko"] ] | ["bedi", "bedi", "donut", "bedi", "shakevan"] | ["andole", "jun", "bedi"] |

## `findFrends()` 메서드 사용
- 파라미터로 String user, List<List<String>> friends, Map<String, RecommendFriend> recommendFriendsMap, List<String> userFriends 사용한다.
  - what does means Map<String, RecommendFriend> recommendFriendsMap ???
  - 가장 먼저 value 에 위치한 `RecommendFriend` 클래스를 선언해야한다.
  - `RecommendFriend` 란
```java
class RecommendFriend implements Comparable<RecommendFriend> {

    private final String name;
    private int score;

    public RecommendFriend(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void friendPlusScore() {
        this.score += FRIEND_SCORE;
    }

    public void visitPlusScore() {
        this.score += VISITOR_SCORE;
    }

    @Override
    public int compareTo(RecommendFriend o) {
        if (o.getScore() == this.getScore()) {
            return this.name.compareTo(o.name);
        }

        return o.getScore() - this.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecommendFriend that = (RecommendFriend) o;
        return score == that.score && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
```
- 해당 클래스의 메서드를 이용하여 비교를 실행한다.
- 해당 클래스는 필드 값 `이름`과 `점수`를 가진다.
- 이때 RecommendFriends 는 Comparable<RecommendFriend> 구현한다.
- compareTo(Recommend o) 메서드를 Override 하여 파라미터로 들어온 객체의 점수와 현재 객체의 점수가 같은지 비교한다.

## `findVisitors()` 메서드 사용
- 파라미터로 List<String> visitors, Map<String, RecommendFriend> recommendFriendsMap,
  List<String> userFriends 가진다.
  - 해당 메서드는 방문자이면서 친구일 경우를 먼저 검증한다. 
  - 만약 친구가 아니고 방문자일 경우, 방문자 점수를 가진 생성자를 만든다.
  - 위에서 생성자가 만들어 진 뒤, 다시 확인하여 방문자일 경우는 방문자 점수를 추가하는 메서드가 동작한다.

### Commit
- [x] feat: add find friend method and recommend friend class
- [x] feat: add find visitors method