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

<hr> <br>

## 기능 목록
- SolutionClass
  - 문제 해결을 위해 정의된 InnerClass
  - 문제 해결을 위한 변수와 메소드가 저장된다.
  - 생성자에 `String user, List<List<String>> friends, List<String> visitors` 값을 파라미터로 받아온다.

<br>

### In SolutionClass Class

- `public void saveFriend(List<List<String>> friends)`
  - friends 리스트를 참조하여 친구 관계를 저장해준다.
  - 친구 관계는 map 자료구조에 저장된다.
  - key(String) / Value(ArrayList<String>)
  - key의 친구들은 Value에 저장된다.
  - 친구 관계는 양쪽이므로, 반대로도 저장해준다.
 
<br>

- `public void isFriendOfUser(ArrayList<String> userFriends)`
  - 친구의 친구라면 10점을 추가해주는 메소드이다.
  - user의 친구목록인 userFriends 리스트를 받아와 친구의 친구이며 user와는 친구가 추가가 안되어있으면 10점을 추가해준다.
  
<br>
  
- `public void visitorScore(ArrayList<String> userFriends)`
  - 방문자에게 1점을 추가해주는 메소드이다.
  - Input으로 들어오는 user의 친구목록 userFriends를 참고해서 만약 user의 친구라면 1점을 추가해주지 않는다.
  
<br>
  
- `public List<Map.Entry<String, Integer>> desendingByScore()`
  - <이름, 점수> 의 구조로 저장되어 있는 result 를 점수기준 내림차순 해준다.

<br> 
  
- `public List<String> getTopFive(List<Map.Entry<String, Integer>> entryList)`
  - desendingByScore 에 의해 내림차순 된 리스트를 파라미터로 받아 top 5명의 이름을 받아온다.
  - 만약 5명이 넘지 않는다면 그 전에 끝낸다.

<br>
  
- `public List<String> inSolution()`
  - 위 선언된 함수들을  solution 이 원하는 값 (top5 이름) 을 return 해준다
  
<br>
  
  
### In Problem7 Class

- `public static List<String> solution(String user, List<List<String>> friends, List<String> visitors)`
  - SolutionClass 클래스를 생성하고 inSolution 메소드를 호출해서 정답을 return 한다. 
  
