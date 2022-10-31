# Proble1 기능 목록
### 기능을 구현하기 위한 함수 목록은 다음과 같습니다.

### 1. pobi와 crong의 페이지가 예외사항에 포함된것이 있는지 검사합니다.
#### validatePobi(List<Integer> pobi)  -->  boolean
-  입력 중 조건에 맞지 않는 입력이 있을 수 있기에 firstPage, secondPage가 조건에 맞는지 검사합니다. 조건에 맞으면 true를 맞지 않으면 false를 반환합니다.
   예외 사항은 아래와 같습니다.
- firstPage은 홀수, secondPage는 짝수여야 합니다.
- firstPage, secondPage 간의 차는 1이어야 합니다.
- firstPage가 1페이지거나 secondPage가 400페이지면 안됩니다.

#### validateCrong(List<Integer> crong)  -->  boolean
-  입력 중 조건에 맞지 않는 입력이 있을 수 있기에 firstPage, secondPage가 조건에 맞는지 검사합니다. 조건에 맞으면 true를 맞지 않으면 false를 반환합니다.
   예외 사항은 아래와 같습니다.
- firstPage은 홀수, secondPage는 짝수여야 합니다.
- firstPage, secondPage 간의 차는 1이어야 합니다.
- firstPage가 1페이지거나 secondPage가 400페이지면 안됩니다.


### 2. 두 페이지를 입력받아 각 페이지의 자릿수의 합과 곱중 큰값을 구한 다음 두 페이지의 값중 더 큰값을 반환
#### findMaxValue(List<Integer> player) --> int maxValue
- firstPage와 secondPage를 calculate() 메소드에 넣은 뒤 반환 된 값을 비교해 큰 값을 반환합니다.
- 반환된 값이 최종 점수입니다.


### 3. 2번의 기능중 페이지를 입력받아 자릿수의 합과 곱중 큰값을 반환합니다.
#### calculate(int page) --> int max
- 입력받은 page의 각 자릿수의 합과 자릿수의 곱중 더 큰 값을 반환합니다.

### 4. pobi와 crong 중 승자를 찾아 반환합니다.
#### findWinner(List<Integer> pobi, List<Integer> crong) --> int
- pobi와 crong의 리스트를 validatePobi(), validateCrong()을 통해 예외사항이 있는지 검사하고 예외사항이 존재하면 -1을 반환하고 없으면 밑의 과정을 진행합니다.
- findMaxValue()를 통해 pobi의 페이지 최댓값과 crong 페이지 최댓값을 구합니다.
- pobi의 최댓값이 더 크면 1, crong의 최댓값이 더 크면 2, 같으면 0을 반환합니다.


# 전체 동작 과정
1. findWinner() 메소드를 호출합니다.
2. findWinner() 메소드 안의 validatePobi(), validateCrong()을 실행해 예외사항이 존재하면 -1을 반환합니다.
3. 예외사항이 없을시 findMaxValue()를 호출합니다.
4. findMaxValue()를 통해 pobi와 crong의 최대점수를 구합니다.
5. 두 점수를 비교하여 pobi가 이겼으면 1, crong이 이겼으면 2, 비겼으면 0을 answer에 저장합니다.
6. answer를 반환합니다.



# Problem2 기능 목록
### 기능을 구현하기 위한 기능 목록은 다음과 같습니다.

### 1. 자료구조로 deque을 사용
- 중복을 제거하는 방식으로 stack 구조에 입력받은 문자열을 하나씩 저장하며 stack의 peak와 저장 할 문자가 동일할 때 두 문자를 삭제하는 방식을 사용합니다.
- 이후 중복 제거가 끝난 문자열을 string으로 반환하기 위해서 stack에 저장된 문자들을 queue 구조처럼 앞에서 꺼내 answer 변수에 저장해야합니다.
- 따라서 stack, queue 구조가 둘 다 필요하기에 deque을 사용했습니다


### 2. 입력받은 문자열을 deque에 저장하며 중복을 제거
#### decoding(String cryptogram) --> Deque<Character> deque
- 입력받은 cryptogram의 첫 문자를 deque에 저장합니다.
- 이후 저장되는 문자는 deque의 맨 위 요소와 같은지 비교하여 같다면 맨 위 요소를 지우고 해당 저장하려했던 문자도 생략합니다. deque의 맨 위 요소와 저장 할 요소가 같지 않을때까지 반복합니다.
- deque의 맨 위 요소와 저장 할 요소가 같지않다면 deque의 맨 위에 저장합니다.
-

### 3. 중복이 제거된 deque을 문자열로 변환
#### dequeueToString(Deque<Character> deque) --> String convert;
- deque의 문자들을 앞에서부터 꺼내 convert에 넣어준 뒤 반환합니다.


# 전체 동작 과정
1. 입력받은 cryptogram을 decoding()에 넣어 연속된 중복 값을 제거합니다.
2. 연속 중복 값이 제거된 dequeue를 dequeueToString()을 통해 문자열로 변환한 뒤 answer에 넣어줍니다.
3. answer을 반환합니다.




# Problem3 기능 목록
### 기능을 구현하기 위한 기능 목록은 다음과 같습니다.

### 1. 369 게임을 진행하며 입력받은 수에 도달할 떄 까지 친 박수의 횟수 반환
#### clapCount(int number) --> int count
- 1부터 입력받은 수까지 for 문을 수행합니다.
- for문의 i 값을 currentNumber에 넣은 뒤 currentNumber % 10을 하여 currentNumber의 1의 자릿수를 구한 뒤 3, 6, 9중 하나이면 count를 1씩 증가시킵니다.
- currentNumber / 10을 하여 currentNumber의 자릿수를 하나 낮춘 뒤 위 과정을 반복합니다.
- currentNumber의 자리수가 한자리가 될때까지 위 과정을 반복하여 박수의 횟수를 구합니다.

# 전체 동작 과정
1. number를 입력 받은 뒤 clapCount()에 입력합니다.
2. clapCount()에서 반환된 값을 answer에 넣습니다.
3. answer를 반환합니다.



# Problem4 기능 목록
### 기능을 구현하기 위한 기능 목록은 다음과 같습니다.

### 입력받은 문자열을 청개구리 사전의 규칙에 맞게 변환합니다.
#### convert(String word) --> string result
- 입력 받은 word의 길이만큼 for문을 실행합니다.
- java 내장함수 Character를 이용해 해당 문자가 소문자인지 대문자인지 판단합니다.
- 기능 요구사항의 청개구리 사전을 구현하기 위해 아스키 코드를 이용해 대문자이면 155 - 해당문자, 소문자이면 219 - 해당문자를 수행하여 청개구리 문자를 구한 뒤 result에 넣어줍니다.
- for문이 끝나면 result 문자열을 반환합니다.

# 전체 동작 과정
1. 문자열 word를 입력 받습니다.
2. word를 convert()에 넣은 뒤 반환된 결과를 answer에 넣습니다.
3. answer를 반환합니다.



# Problem5 기능 목록
### 기능을 구현하기 위한 기능 목록은 다음과 같습니다.

### 입력받은 액수의 돈을 최대한 큰 단위의 지폐를 많이 가지게 변환
#### moneyToList(int money, List<Integer> answer)
- 화폐 단위가 담긴 unit 배열을 생성합니다.
- unit의 크기만큼 for문을 수행합니다.
- 입력받은 money와 화폐 단위인 unit[i]를 나누어 몫을 구한뒤 divide에 저장합니다.
- 해당 divide가 화폐의 개수이므로 answer[i]에 저장합니다.
- 입력받은 money에서 변환한 화폐의 개수와 화폐의 단위를 곱해 빼줍니다.
- 위 과정을 반복합니다.


# 전체 동작 과정
1. unit 변수를 생성 후 기능 요구사항에서 제시한 화폐 단위들로 초기화 합니다.
2. moneyToList()에 입력받은 money와 answer를 넣습니다.
3. 반환된 answer 리스트를 제출합니다.



# Problem6 기능 목록
### 기능을 구현하기 위한 기능 목록은 다음과 같습니다.

#### 1. 예외사항 목록
1. 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
2. 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
3. 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.

### 2. 입력받은 forms의 이메일에 대하여 예외사항을 검사
#### validateEmails(List<List<String>> forms)
- 정규식 reg를 @기준으로 앞 부분은 영문자, 숫자 범위로 제한했고 @뒷부분은 email.com으로 제한했습니다.
- 입력받은 forms의 이메일을 matchs() 메서드를 이용해 정규식의 범위를 벗어나면 예외를 반환합니다.
- 입력받은 forms의 이메일의 길이가 11자 미만 20자 이상이면 예외를 반환합니다.


### 3. 입력받은 forms의 닉네임에 대하여 예외사항을 검사
#### validateNickNames(List<List<String>> forms)
- 정규식 reg를 한글로 제한했습니다.
- 입력받은 forms의 닉네임을 matchs() 메서드를 이용해 정규식의 범위를 벗어나면 예외를 반환합니다.
- 입력받은 forms의 닉네임의 길이가 1자 미만 20자 이상이면 예외를 반환합니다.

### 4. forms을 닉네임 글자 수 기준으로 오름차순 정렬
#### sortFormByNickName(List<List<String>> forms)
- 닉네임의 중복을 비교하기 전 실행하는 기능입니다.
- ArrayList의 get기능을 사용하기 위해 forms을 ArrayList 타입으로 변환합니다
- Collections의 comparator 기능을 사용하여 forms의 닉네임의 글자 수를 기준으로 오름차순 정렬합니다.

### 5. 닉네임 중복 검사를 위해 forms의 닉네임들을 두개씩 짝지어 닉네임 중복 검사 로직에 넣어주기
#### findDuplicateNickName(List<List<String>> forms)
- forms을 입력받습니다. 입력받은 forms은 현재 닉네임의 글자수를 기준으로 오름차순 정렬된 상태입니다.
- 이중 for문을 통해 forms의 모든 닉네임 쌍들을 compareNickName() 메서드에 넣습니다.
- compareNickName()의 반환값이 true이면 answer 리스트에 해당 닉네임 쌍에 대응하는 이메일 쌍들이 있는지 확인합니다.
- 이메일이 answer 리스트에 존재하지 않는다면 이메일을 넣고 존재한다면 넣지 않습니다.

### 6. 입력받은 두 닉네임이 두글자 이상 중복이 있는지 확인
#### compareNickName(String first_nickName, String second_nickName)
- sortFormByNickName()을 실행 한 뒤여서 입력받는 first_nickName은 항상 second_nickName보다 글자수가 작습니다.
- for문을 수행 할 때마다 first_nickName의 연속된 두 글자 조합을 만들어 second_nickName이 해당 두 글자 조합을 가지고 있는지 확인합니다.
- second_nickName이 두 글자 조합을 가지고 있으면 즉시 true를 반환하고 for문이 끝날 때 까지 없다면 false를 반환합니다.

### 7. 중복 된 닉네임에 대한 이메일들은 answer 리스트에 저장되고 이 리스트를 이메일순으로 정렬
#### sort()
- Collection의 sort를 사용해 전역변수로 설정된 answer 리스트를 정렬합니다.

### 8. answer 리스트에 저장된 이메일들중 중복이 있으면 제거합니다.
#### removeDuplication()
- stream()과 distinct()를 사용해 answer 리스트의 중복을 제거 합니다.

### 9. try cathc문을 사용하기 위해 예외사항을 검사하는 validateEmails(), validateNickNames()을 하나의 로직으로 묶어줍니다.
#### doValidation(List<List<String>> forms)
- forms에 대한 예외사항 검사 기능들을 한번에 실행하고 예외가 있을시 반환합니다.

### 10. 모든 기능들을 순서에 맞추어 실행합니다.
#### logic(List<List<String>> forms)
- 실행 순서에 맞에 요구 사항 기능들을 실행합니다.



# 전체 동작 과정
1. 닉네임 중복을 비교하는 방법은 입력받은 두개의 닉네임을 입력받아 짧은 닉네임을 기준으로 모든 가능한 두글자 조합을 만들어 긴 닉네임에 대해 중복을 검사하는 방식입니다.
   따라서 짧은 닉네임이 앞에 위치해야하기에 먼저 sortFormByNickName()을 실행해 forms을 닉네임 길이가 짧은순으로 정렬합니다.
2. findDuplicateNickName()을 실행하여 중복닉네임이 있으면 해당 닉네임에 대응하는 이메일을 answer 리스트에 넣어줍니다.
3. sort()를 실행해 answer 리스트를 이메일에 대해 오름차순으로 정렬합니다.
4. remove()를 실행해 answer 리스트의 중복을 제거합니다.


# Problem7 기능 목록
### 기능을 구현하기 위한 함수 목록은 다음과 같습니다.

### 1. user의 친구목록 생성
#### makeUserFriendList(List<List<String>> friends) --> List<String> userFriendList
- 제공된 friends에서 user와 같은 리스트에 포함된 친구들을 userFriendList에 넣습니다.


### 2. friends중 user와 user 친구를 제외한 사람들을 모아 추천목록 생성
#### makeRecommendList(List<List<String>> friends) --> Map<String, Integer> recommendList
- 제공된 friends에서 user를와 함께 리스트에 포함된 친구들을 제외한 나머지 친구들을 Map에 저장합니다.
- 친구들의 이름이 key값이며 친구들에 대한 추천 점수가 value값입니다.

### 3.visitors중 user의 친구를 제외한 사람들 추천목록에 추가
#### addCisitorInRecommendList(List<String> visitors) --> Map<String, Integer> recommendList
- 제공된 visitor 목록에서 user의 친구들을 제외한 이름들을 makeRecommendList()에서 만든 recommendList에 추가합니다.

### 4. 제공된 firends에서 user의 친구와 친구이면 추천 점수 증가
#### addScoreByFriends(List<List<String>> friends) --> Map<String, Integer> recommendList
- for문을 수행하며 제공된 friends의 각 친구관계를 firstFriend와 secondFriend에 넣습니다.
- 입력받은 userFriend 목록에 firstFried의 이름이 있고 seconFriend의 이름이 user가 아니라면 해당 second 사람의 추천점수를 10 증가합니다.
- for문이 끝난 후 점수가 갱신된 recommendList를 반환합니다.

### 5. 제공된 visitors에 이름이 있고 user의 친구가 아니면 해당 visitor의 친구 추천 점수 증가
#### addScoreByVisitor(List<String> visitors) --> Map<String, Integer> recommendList
- for문을 수행하며 제공된 visitor 요소 중 userFriendList에 없는 사람이면 recommendList에서 조회 한 뒤 추천점수를 1 증가합니다.

### 6. 추천목록을 추천점수가 높은순으로 정렬
#### sortByScore() --> LinkedList<Map.Entry<String, Integer>> recommendEntryList
- 입력받은 recommendList를 comparator 기능을 사용하여 recommendList의 value가 높은순으로 정렬한뒤 recommendEntryList를 반환합니다.

### 7. 추천목록의 추천점수가 같으면 이름순으로 정렬
#### sortByName() --> LinkedList<Map.Entry<String, Integer>> recommendEntryList
- 입력받은 recommendEntryList를 comparator 기능을 사용하여 추천점수가 같다면 이름순으로 정렬한 뒤 recommendEntryList를 반환합니다.

### 8. 추천목록이 5명을 넘을수 추천점수가 높은순서대로 점수가 높은 5명의 이름을 반환한다. 단 점수가 같을시에는 이름순으로 리스트에 넣는다.
#### filterRecommendList() --> List<String> result
- 입력받은 recommendEntryList의 길이만큼 result 리스트에 recommendList의 이름을 넣습니다. 이때 입력받은 length가 5를 초과하면 5명만 reuslt 리스트에 넣습니다.

### 9. 8번에서 recommendList의 이름을 result 리스트에 넣어줍니다. 이때 추천점수인 score가 0이면 넣지 않습니다.
#### addList(List<String> result, int length)
- 입력받은 recommendList의 이름을 result에 넣어줍니다.
- 단 score가 0점 초과여야지 reuslt에 넣어줍니다.


# 전체 동작 과정
1. makeUserFriendList()를 실행해 friends에서 유저와 함께 친구인 친구목록을 생성합니다.
2. makeRecommendList()를 실행해 friends에서 유저와 친구가 아닌 사람들을 모아 recommendList를 만듭니다.
3. addVisitorsInRecommendList()를 실행해 friends에서는 없고 visitor에만 있는 사람들을 recommendList에 추가합니다.
4. addScoreByFriends()를 실행해 recommendList에서 사용자의 친구와 친구인 사람들의 추천점수를 10씩 증가시킵니다.
5. addScoreByVisitors()를 실행해 recommendList에서 사용자의 타임라인에 방문한 사람들의 추천점수를 1씩 증가시킵니다.
6. sortByScore()를 실행해 recommendList를 recommendEntryList로 변경한 뒤 추천점수가 높은 순서대로 recommendListEntry를 정렬합니다.
7. sortByName()를 실행해 recommendEntryList에서 추천점수가 같다면 이름순으로 정렬합니다.
8. filterRecommendEntry()를 실행해 점수가 높은 순서대로 5명을 반환합니다, 단 점수가 0이면 반환하지 않고 점수가 같으면 이름 순서대로 반환합니다.



