# Problem-7

## Explanation
- 연결 관계가 주어졌을 때 점수가 가장 높은 5명을 구한다.

## Function
### Interface

### Class
1. `RecommendCalculator implements Calculator`
   - 연결 관계를 바탕으로 점수가 가장 높은 5명을 구한다.

### Enum
1. `EACH`
   - 서로 연관되어 있는 인물의 위치 정보를 저장한다.
2. `Point`
   - 점수에 관한 정보가 저장된다.
   

### Method
1. `calculation()`
   - 이메일을 반환한다.
2. `void makeConnection()`
   - 연결 관계를 Map에 저장한다.
3. `void initDistance()`
   - 거리를 초기화 한다.
4. `void searchFriends()`
   - 둘 사이의 공통 친구를 찾아 점수를 부여한다.
5. `void addCommonFriend(String, String)`
   - 각 이름에서 부분 문자열을 구한다.
6. `void makeCount(Map<String, Integer>)`
   - 공통 친구인 경우 점수를 더한다.
7. `void visitorPoint()`
   - user와 친구가 아닌 방문객의 점수를 더한다.
8. `void addVisitorPoint(String)`
   - 방문객의 점수를 더한다.
9. `List<Map.Entry<String, Integer>> sortDescDistance()`
   - 내림차순으로 거리를 정렬한다.
10. `List<String> makeAnswer()`
   - 정렬된 거리 순으로 정답에 추가한다.

### Parameter
