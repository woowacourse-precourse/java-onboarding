## Problem1 기능 목록
1. 책을 펼쳤을 때 연속된 페이지가 아닌 잘못된 페이지가 나왔을 경우 예외처리 메서드를 구현한다.
2. 각 페이지별 숫자를 자릿수별로 나누는 메서드를 구현한다.
3. IntegerList를 모두 더하는 메서드를 구현한다.
4. IntegerList를 모두 곱하는 메서드를 구현한다.
5. 각 페이지의 숫자들을 더하고 곱한 값들을 각각 포비와 크롱을 기준으로 나눠 두 개의 IntegerList에 담는다.
6. 각 List에서 가장 큰 값을 구해서 비교한다.
7. 예외 상황이라면 -1, 포비가 크다면 1, 크롱이 크다면 2, 같다면 0을 결과값으로 반환한다.

- <code>splitInteger</code>: Integer를 자릿수별로 나눠 IntegerList를 반환하는 메서드
- <code>sumIntegerList</code>: IntegerList를 모두 더하는 메서드
- <code>multipleIntegerList</code>: IntegerList를 모두 곱하는 메서드
- <code>checkBookPage</code>: 페이지가 잘못된 페이지인지 예외를 확인하는 메서드

---

## Problem2 기능 목록
1. 문자열을 ArrayList 타입으로 한글자씩 자르는 메서드를 구현한다.
2. ArrayList 타입으로 한글자씩 자른 문자에서 인접한 문자중 중첩된 문자를 제거하는 메서드를 구현한다.
3. 암호문을 복호화해 문자열을 반환한다.

- <code>splitStringToArrayList</code>: 문자열을 한글자씩 ArrayList 타입으로 변환하는 메서드
- <code>decryption</code>: 인접한 문자중 중첩된 문자를 제거해 복호화하는 메서드
---

## Problem3 기능 목록
1. 정수에 3, 6, 9가 몇개 들어있는지 찾는 메서드를 구현한다.
2. 해당 정수까지 몇번의 박수를 치는지 확인한다.

- <code>countNumber</code>: 해당 숫자가 3, 6, 9가 총 몇개인지 반환하는 메서드

---

## Problem4 기능 목록
1. 청개구리 사전에 맞게 문자를 번역하는 메서드를 구현한다.
2. 번역 메서드를 이용해 문자열을 번역해 반환한다.

- <code>translateCharacter</code>: 청개구리 사전으로 영어만 번역 되고 나머지는 번역하지 않는다.

---

## Problem5 기능 목록
1. 자연수를 모은 배열을 기준으로 순서대로 리스트에 담아 반환하는 메서드 구현
2. 원화를 기준으로 금액이 큰 순서대로 리스트에 담아 반환

- <code>calculateExchange</code>: 자연수를 모은 배열을 기준으로 순서대로 리스트에 담아 반환하는 메서드
---

## Problem6 기능 목록
1. 2차원 리스트에서 닉네임 부분의 길이가 2이상인 2차원 리스트만 반환하는 메서드 구현
2. 문자열의 순서를 바꾸지 않고 원하는 길이 만큼 자를 수 있는 모든 경우에 수를 리스트 형태로 반환하는 메서드 구현
3. 문자열 리스트중에 부분 문자열을 뽑아 리스트 내부에 다른 요소들중 해당 부분 문자열이 포함되어 있는 인덱스를 반환하는 메서드를 구현 
4. 2차원 리스트를 1차원 리스트로 평탄화 해주는 메서드 구현
5. 한국어가 존재하는 요소를 List에서 추출해 반환하는 메서드 구현
6. 위에서 구현한 메서드들을 이용해 한글 닉네임이 문자열의 순서를 변경시키지 않고 2자이상 부분적으로 일치하는 유저에 이메일을 오름차순으로 반환하는 메서드 구현

- <code>getUserListByNicknameLength</code>: 2차원 리스트에서 닉네임 부분의 길이가 2이상인 2차원 리스트만 반환하는 메서드
- <code>splitStringInAllCases</code>: 문자열의 순서를 바꾸지 않고 원하는 길이 만큼 자를 수 있는 모든 경우에 수를 리스트 형태로 반환하는 메서드 구현
- <code>getIndexListOfContainSubString</code>: 문자열 리스트중에 부분 문자열을 뽑아 리스트 내부에 다른 요소들중 해당 부분 문자열이 포함되어 있는 인덱스를 반환하는 메서드를 구현
- <code>getElementsByKorean</code>: 한글이 존재하는 요소를 List에서 추출해 반환하는 메서드 구현
- <code>getFlatList</code>: 2차원 리스트를 1차원 리스트로 평탄화 해주는 메서드 구현

---

## Problem7 기능 목록
1. Point 적립기준인 방문과 함께아는친구로 나눠 해당 point를 value로 가질 수 있게 enum을 선언
2. 추천을 띄워주고싶은 유저 아이디와 그 해당 유저와 함께 아는 친구가 있는 유저를 중복을 제거하지 않고 문자열 리스트로 반환하는 메서드 구현
3. 추천을 띄워주고싶은 유저와 직접적으로 친구인 문자열 리스트를 반환하는 메서드 구현
4. 포인트를 위 1번의 pointType에 따라 value를 더해줘 Map<String, Integer>를 반환하는 메서드 구현(2번에서 중복 제거하지 않은 이유)</br>
   **(key = userId, value = point)**
5. Map<String, Integer>를 merge 할 때 key값이 존재하면 value를 더해 주는 메서드 구현
6. Map을 value기준으로 내림차순으로 정렬하고 value가 같은 것들 끼리는 Key기준 오름차순으로 정렬하고, size에 따라 해당 크기까지만 반환하는 메서드 구현
7. Key 기준으로 Map에서 지우고 반환하는 메서드 구현(3번과 함께 사용)
8. 사용자와 함께 아는 친구의 숫자와 타임라인의 방문한 횟수로 친구 추천 리스트를 반환하는 메서드 구현

- <code>getFriendOfFriends</code>: user와 친구인 사람과 친구인 user를 문자열 리스트형으로 반환하는 메서드
- <code>getFriends</code>: 친구관계에서 user와 직접적으로 친구인 문자열 리스트 반환하는 메서드
- <code>calculatePoint</code>: users를 Key로 point를 value로 반환하는데, pointType의 value를 더해 Map<String, Integer>을 반환하는 메서드 구현
- <code>mergeMapSumValue</code>: Key가 같은 것들 끼리는 value를 더하며 합쳐 같은 타입의 하나의 Map으로 반환하는 메서드
- <code>getEntryDescByValue</code>: Map의 Value 기준 내림차순으로 정렬하고 Value 가 같은것 끼리는 Key 내림차순으로 정렬하는 메서드
- <code>removeByKey</code>: map에서 keyList를 지우고 반환하는 메서드

---

