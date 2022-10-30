## Problem7의 기능목록

---

주의
* 추천점수가 0점이면 추천하지 않는다
* 점수가 같다면 이름순으로 정렬한다


### 함께 아는 친구를 기반으로 점수 매기는 기능
* `parameter` : list<list>, string(user)
* `return` : treemap
* `myFriendScore()으로 구현`

### 각 유저별로 친구를 저장하는 기능
* `parameter` : list<list>
* `return` : list<list>
* `getFriendList()으로 구현`

### sns 사용자의 이름을 저장하는 기능
* `parameter` : list<list>
* `return` : list
* `getUserList()으로 구현`

### 방문자를 기반으로 점수 매기는 기능
* `parameter` : list(visitors), string(user)
* `return` : treemap
* `getVisitScore()으로 구현`

### 이미 친구인 사람을 제외시키는 기능
* `parameter` : list<list>, treemap
* `return` : treemap
* `removeMyfried()으로 구현`










