## Problem7의 기능목록

---

주의
* 추천점수가 0점이면 추천하지 않는다
* 점수가 같다면 이름순으로 정렬한다



### 서로의 친구란 점을 감안한 새로운 친구 리스트 만드는 기능
* `parameter` : list<list> , string(user)
* `return` : list
* `getFriedList()으로 구현`

### 함께 아는 친구를 기반으로 점수 매기는 기능
* `parameter` : list<list>, string(user)
* `return` : treemap
* `myFriendScore()으로 구현`

### 방문자를 기반으로 점수 매기는 기능
* `parameter` : list(visitors), string(user)
* `return` : treemap
* `getVisitScore()으로 구현`

### 방문자 점수와 함께 친구인 점수 합치는 기능
* `parameter` : map, map, int
* `return` : treemap
* `getTotalScore()으로 구현`

### 이름, 점수로 되어 있던 map을 점수, 이름 내림차순으로 만드는 기능
* `parameter` : map
* `return` : set
* `getReverseMap()으로 구현`

### sns 사용자 명수 구하는 기능
* `parameter` : list
* `return` : int
* `getUserList()으로 구현`










