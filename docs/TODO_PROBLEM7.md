## 🚀 문제 7 기능 구현내용

### 필요기능


| 필요기능                           | 변수명(함수명)                                    | 구현 여부(O, X) |
|--------------------------------|---------------------------------------------|-------------|
| 사용자와 친구인 유저의 이름 배열에 담기         | for (List<String> friend : friends) | O           |
| 사용자와 함께 아는 친구의 이름 10점 주기       |  for (List<String> friend : friends)   | O           |
| 방문한 유저를 1점 주기 이미 값이 있다면 1점 추가  |  for (String visit : visitors) | O           |
| 해쉬맵을 value값으로 내림차순 정렬 후 return | public int compare(Map.Entry<String, Integer> arr1, Map.Entry<String, Integer> arr2)| O           |

### 예외처리

| 예외처리                | validation or 함수 | 구현 여부(O, X) |
|---------------------|-----------------|-------------|
|  최대 5명을 return  |    if(answer.size() > 5)  | O           |
|  추천 점수가 0점일 경우 삭제  |    boolean removed = friendWithUserDict.entrySet().removeIf  | O           |
|  추천 점수가 같은 경우는 이름순으로 정렬  |    if (arr1.getValue() == arr2.getValue())  | O           |