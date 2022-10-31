
# 👩🏻‍💻 기능 목록


## 📖 주 기능 함수

### 1️⃣ user에게 추천할 수 있는 (user의 친구가 아닌) 사람들을 점수와 함께 반환하는 함수 (점수는 0으로 초기화)

  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | recommendationFriendsMap | String user, List<List<String>> friends | Map<String,Integer> | user의 친구들을 제외한 사람들을 0점으로 초기화하여 반환|

  
#### 1-1. user의 친구들을 반환하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | userFriends | String user, List<List<String>> friends | List<String> | user의 친구 리스트 반환 |

#### 1-2. user의 친구들을 찾아주는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | isUserFriend | String user, List<String> friend,List<String> userFriendList | List<String> | 유저의 친구가 맞다면 리스트에 추가하여 반환 |
  
#### 1-3. 주어진 friends의 사람들을 Map에 점수와 저장하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | listToMap | List<List<String>> friends | Map<String,Integer> | list를 map으로 반환 |

  
#### 1-4. user의 친구와 user를 friendsMap에서 제거하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | removeKnown | Map<String,Integer> friendsMap, List<String> userFriendList, String user | Map<String,Integer> | map에서 user와 user친구들을 제거하여 반환 |

  
### 2️⃣ 친구 추천 후보들의 점수 추가가 완료된 목록 반환
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | endAddPoint | String user, List<List<String>> friends, List<String> visitors | Map<String,Integer> | 점수 추가가 완료된 map 반환 |

#### 2-1. user와 함께 아는 친구 수 * 10 점을 부여하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | addTenPoint | Map<String,Integer> friendsMap,List<String> userFriendList,List<List<String>> friends | Map<String,Integer> | 함께 아는 친구 수*10 점을 부여하여 반환 |
  

#### 2-2. user와 함께 아는 친구 수를 구하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | countFriend | String target,List<String> userFriendList,List<List<String>> friends | int | user와 함께 아는 친구 수를 반환 |
  
    

#### 2-3. user의 친구와 친구인지 확인하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | isFriend | String target, String userFriend,List<List<String>> friends | boolean | user의 친구와 친구인지 여부 반환 |
  

#### 2-4. visitors에게 1점 주는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | addOnePoint | Map<String,Integer> friendsMap,List<String> userFriendList,List<String> visitors | Map<String,Integer> | 방문자에게 1점씩 부여하여 반환 |
  
  
### 3️⃣ 점수가 높은 최대 5명까지만 반환하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | topFive | Map<String, Integer> friendsMap | List<String> | 점수가 높은 5명 이하만 반환 |

#### 3-1. 점수가 높은 순으로 정렬하는 함수

  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | orderByScore | Map<String, Integer> friendsMap | List<String> | 점수를 내림차순으로 정렬하여  |
