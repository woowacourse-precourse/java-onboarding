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