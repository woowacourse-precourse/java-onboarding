# 기능 목록
### 기능을 구현하기 위한 함수 목록은 다음과 같습니다.

### 1. user의 친구목록 생성  
#### makeUserFriendList(List<List<String>> friends, String user) --> List<String> userFriendList
- 제공된 friends에서 user와 같은 리스트에 포함된 친구들을 userFriendList에 넣은 뒤 반환합니다.

### 2. friends중 user와 친구가 아닌 사람들을 모아 추천목록 생성
#### makeRecommendList(List<List<String>> friends, String user) --> Map<String, Integer> recommendList
- 제공된 friends에서 user를와 함께 리스트에 포함된 친구들을 제외한 나머지 친구들을 Map에 저장합니다.
- 친구들의 이름이 key값이며 친구들에 대한 추천 점수가 value값입니다.

### 3. 제공된 firends에서 user의 친구와 친구이면 추천 점수 증가

### 4. 제공된 visitors에 이름이 있으면 해당 친구 추천 점수 증가

### 5. 추천목록을 추천점수가 높은순으로 정렬, 이름이 같으면 이름순으로 정렬

### 6. 추천목록의 크기가 5를 초과하면 추천점수가 높은 5명만을 반환


# 전체 동작 과정
1. 입력받은 friends에서 
