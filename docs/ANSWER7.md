## ANSWER6

### solution
주어진 입력값들에 대해 유효성을 검사하고 주어진 조건(방문,함께아는 친구)에 따라 점수를 적용하여 결과값을 반환하는 메소드
- verifyUser
- verifyFriends
- verifyVisitors
- increasePoint
- increasePointFriends
- deleteUserAndFriend

### verifyUser
회원에 대한 유효성 검사
- verifyIdLength : 회원 아이디 길이 - `1` 이상 `30` 이하
- verifyIdType : `영어 소문자` 만 허용

### verifyFriends
친구 리스트 및 개별값에 대한 유효성 검사
- verifyFriendsLength : 친구 리스트 길이 - `1` 이상 `10000`이하
- verifyFriendsId : 아이디 길이 - `1` 이상 `30` 이하

### verifyVisitors
방문자 리스트에 대한 유효성 검사 : 방문자 리스트 길이 - `1` 이상 `10000`이하

### increasePoint
입력된 방문기록을 통해 방문자들은 +1점

### increasePointFriends
함께 아는 친구가 있을 경우 +10점
- findFriendsWithUser : 조회할 유저의 id와 친구목록을 입력받아 해당 유저의 친구 목록을 반환하는 메소드

### deleteUserAndFriend
결과값에서 본인과 이미 친구인 사람들은 제외
