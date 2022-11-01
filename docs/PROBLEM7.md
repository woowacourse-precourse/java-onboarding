# [Problem 7](https://www.notion.so/7-c1c8e2f1ca9841859be4e38093bc1ac4) 기능별 명세

## 1. public static List<String\> findAllFriends(String user, List<List<String\>> friends) {}

### input
- **String user**
  친구 목록을 반환받을 사용자의 아이디.
- **List<List<String\>> friends**]
  SNS의 친구 관계 정보.
### output
- **(List<String\>)** user와 친구 관계에 있는 사람들의 아이디가 저장된 리스트.
-
### 기능 상세
파라미터로 받은 user와 친구인 사람들을 찾는 기능을 합니다.</br>
friends에서 user가 포함되어 있는 리스트를 찾은 경우, 그 리스트에서 user를 제외한 다른 원소 값이 user와 친구인 사람의 아이디입니다.</br>
friends에서 user와 친구인 사람을 모두 찾아 리스트에 그 아이디를 저장한 후 반환합니다.

## 2. public static Map<String, Integer> calculateScoreByFriendsList(List<String\> usersFriends, List<String\> objectsFriends, String object) {}

### input
- **List<String\> usersFriends**
  user의 친구 목록.
- **List<String\> objectsFriends**
  점수를 계산하고자 하는 사용자의 친구 목록.
- **String object**
  점수를 계산하고자 하는 사용자의 아이디.

### output
- **(Map<String, Integer>)** key 값은 object, value 값은 object는 user와 함께 아는 친구 수를 바탕으로 얻은 점수.

### 기능 상세
점수를 구하려고 하는 object에 대해 user와 함께 아는 친구의 수를 얻은 후, 친구 1명당 10점을 부여한 결과를 반환하는 기능을 합니다.</br>
usersFriends에 있는 user의 친구 아이디 정보들을 하나씩 꺼내어 해당 아이디가 objectsFriends에도 존재하는지 확인합니다. 존재한다면 count를 1씩 증가시킵니다.</br>
usersFreinds의 모든 아이디에 대해 존재 여부 확인이 끝나면, count * 10의 값을 value로 하여 Map을 반환합니다.