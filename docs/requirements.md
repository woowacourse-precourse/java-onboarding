# 기능 목록
## 목차
1. 문제 1
2. 문제 2
3. 문제 3
4. 문제 4
5. 문제 5
6. 문제 6
7. 문제 7

## 문제 1
### 구현 메소드 및 설명
- isException
- addIntegers
- multiplyIntegers
- getMaxScore
- solution

### isException
- List<Integer>를 매개변수로 받는다. (0)은 왼쪽 페이지 번호, (1)은 오른쪽 페이지 번호
- 책을 펼쳤을 때, 왼쪽 페이지는 짝수, 오른쪽 페이지는 홀수라는 조건이 존재
  - 따라서 두 페이지의 짝수/홀수 여부를 확인, 만족하지 않을 경우 return true
- 책이므로, 두 수는 인접해야 함 (중간에 페이지가 찢어지지 않는 이상)
  - 따라서 (오른쪽 - 왼쪽 == 1)을 만족하지 않으면 true
- 시작 면 (1, 2)이나 마지막 면 (399, 400)을 펼치면 안됨
  - 따라서 왼쪽이 1보다 작거나 오른쪽이 400보다 크면 false, (1, 2) 또는 (399, 400)이면 true;
- 위 조건 중 true가 발생하지 않는다면 false를 리턴한다.

### addIntegers
- int를 매개변수로 받는다. 이 값은 페이지 번호이다.
- 이 메소드는 전달받은 정수의 각 자릿수를 모두 더한 값을 리턴한다.
- 아래 로직을 따른다.
  - 리턴할 int형 변수 answer = 0으로 초기화한다.
  - input을 10으로 나누었을 때의 나머지를 계속 answer에 더한다.
  - 이후 input을 10으로 나눈 값으로 갱신한다.
  - input이 10보다 작으면, input의 값을 answer에 더한다.
- answer를 return한다.

### multiplyIntegers
- int를 매개변수로 받는다. 이 값은 페이지 번호이다.
- 이 메소드는 전달받은 정수의 각 자릿수를 모두 곱한 값을 리턴한다.
- 아래 로직을 따른다.
    - 리턴할 int형 변수 answer = 1으로 초기화한다.
    - input을 10으로 나누었을 때의 나머지를 계속 answer에 곱한다.
    - 이후 input을 10으로 나눈 값으로 갱신한다.
    - input이 10보다 작으면, input의 값을 answer에 곱한다.
- answer를 return한다.

### getMaxScore
- List<Integer>를 매개변수로 받는다. (0)은 왼쪽 페이지 번호, (1)은 오른쪽 페이지 번호
- 이 메소드는 한 사람이 가지게 되는 점수를 구하여 리턴한다.
- 한 사람이 가질 수 있는 점수의 경우의 수는 왼쪽, 오른쪽 각각 더했을 때, 곱했을 때이다.
- 따라서 위의 네 가지 경우를 addIntegers와 multiplyIntegers를 통해 각각 구하고, 그 중 최댓값을 리턴한다.

### solution
- List<Integer> pobi, List<Integer> crong을 각각 매개변수로 받는다.
- 이 메소드는 pobi와 crong 중 이기는 사람이 누구인지 구한다.
- 먼저 pobi와 crong의 페이지 번호가 합당한지 isException을 통해 점검한다.
  - 둘 중 하나라도 만족하지 않는 경우, -1을 리턴한다.
- pobi와 crong의 점수를 각각 getMaxScore를 통해 구한다.
- 두 점수를 비교하여 아래와 같이 값을 리턴한다.
  - 두 점수가 같은 경우 0을 리턴한다.
  - pobi가 이긴 경우 1을 리턴한다.
  - crong이 이긴 경우 2를 리턴한다.

## 문제 2
### 구현 및 메소드 설명
 - decryptString 
 - solution

### decryptString
- String을 매개변수로 받는다. 이 값은 cryptogram이다.
- String을 뒤에서부터 순회하며, 다음 과정을 수행한다.
  - stack이 비었다면, 현재 값을 stack에 담는다.
  - 현재 값이 stack.top()과 같다면, stack.pop()을 한다.
  - 그렇지 않다면, stack.push() 한다.
- 완성된 stack이 빌 때까지, pop() 하여 String으로 만든다.
- 만들어진 String을 return 한다.

### solution
- String을 매개변수로 받는다. 이 값은 cryptogram이다.
- 입력받은 cryptogram을 decryptString에 전달한다.
- 받은 결과값을 return한다.

## 문제 3
### 구현 및 메소드 설명
- shouldClap
- getTotalClaps
- solution

### shouldClap
- int를 매개변수로 받는다. 이 값은 박수를 쳐야 하는지의 여부이다.
- 받은 숫자가 10 이상일 때, 아래 과정을 반복한다.
  - 숫자의 1의 자리가 3인지 확인한다. 맞다면 박수를 쳐야 한다.
  - 그렇지 않다면, 숫자를 10으로 나눈다.
- 최종적으로 박수를 쳐야 하는 횟수를 리턴한다.

### getTotalClaps
- int를 매개변수로 받는다. 이 값은 박수를 몇 번 쳐야 하는지 구하고자 하는 number이다.
- 1부터 number까지 shouldClap을 호출한다. true의 횟수를 기록한다.
- 기록한 총 횟수를 리턴한다.

### solution
- int를 매개변수로 받는다. 이 값은 박수를 몇 번 쳐야 하는지 구하고자 하는 number이다.
- shouldClap을 호출하고, 결과값을 답으로써 리턴한다.

## 문제 4
### 구현 메소드 및 설명
- reverseAlphabet
- buildReverseWord
- solution

### reverseAlphabet
- char를 매개변수로 받는다. 이 값은 word의 한 인자이다.
- 이 메소드는 넘겨받은 알파벳 대문자 혹은 소문자를 반대로 변환한다.
- 아래 로직을 따른다.
  - 소문자, 대문자인 경우 각각 진행
    - 공백일 경우 공백을 그대로 return한다.
  - 'z' 또는 'Z'에서 입력받은 char를 뺀다.
  - 'a' 또는 'A'를 더한다.
  - char로 형변환을 하여 return한다.

### buildReverseWord
- String을 매개변수로 받는다. 이 값은 word이다.
- 이 메소드는 넘겨받은 문자열을 reverse하여 리턴한다.
- 아래 로직을 따란다.
  - String의 각 원소를 reverseAlphabet을 통해 reverse한다.
  - reverse한 알파벳을 StringBuilder에 append 한다.
  - String의 모든 원소를 거친 후, StringBuilder를 통해 String을 생성하여 return한다.

### solution
- String을 매개변수로 받는다. 이 값은 word이다.
- reverseAlphabet을 호출하여 입력 받은 word를 reverse한 후 return한다.

## 문제 5
### 구현 메소드 및 설명
- exposeCashUnit
- getEachUnit
- solution

### exposeCashUnit
- int을 매개변수로 받는다. 이 값은 remainingPrice이다.
- 이 메소드는 현재 금액에서 꺼낼 수 있는 가장 큰 단위의 화폐와 그 종류를 List에 담아 리턴한다.
- 아래 로직을 따른다.
  - 받을 수 있는 돈 중에서 꺼낼 수 있는 가장 큰 단위를 greedy한 방법으로 구한다.
  - 남은 금액과 사용된 액수를 List에 담아 리턴한다.

### getEachUnit
- int을 매개변수로 받는다. 이 값은 money이다.
- 이 메소드는 더 이상 돈을 꺼낼 수 없을 때까지 exposeCashUnit을 호출한 후, 그 결과를 기록한다.
- 사용한 금액 단위를 각각 List에 담는다. 완성되면 이를 리턴한다.

### solution
- int을 매개변수로 받는다. 이 값은 money이다.
- 이 메소드는 getEachUnit을 호출한다.
- 사용한 금액 단위가 담긴 List를 받아 리턴한다.

## 문제 6
### 구현 메소드 및 설명
- inspectEmailCondition
- inspectNicknameCondition
- getEmailUsername
- collectValidInputs
- twoStringsAreAlike
- checkAlikeNicknames
- getAlikeNicknamesList

### inspectEmailCondition
- String을 매개변수로 받는다. 이 값은 email이다.
- 주어진 이메일이 요구 조건에 맞는지 확인한다.
  - 이메일 형식에 부합하여야 한다.
  - 도메인은 `email.com`이다.
  - 이메일의 길이는 11 이상 20 이하이다.
- 위 조건을 모두 만족하면 true를, 그렇지 않다면 false를 리턴한다.

### inspectNicknameCondition
- String을 매개변수로 받는다. 이 값은 nickname이다.
- 주어진 닉네임이 요구 조건에 맞는지 확인한다.
  - 닉네임은 한글이다.
  - 닉네임의 길이는 1 이상 20 이하이다.
- 위 조건을 모두 만족하면 true를, 그렇지 않다면 false를 리턴한다.

### getEmailUsername
- String을 매개변수로 받는다. 이 값은 email이다.
- 주어진 닉네임에서 아래 과정을 통해 앞부분의 username을 얻는다.
  - 문자열 내에서 `@`의 위치를 찾는다.
  - 해당 문자 이전까지의 문자열을 username으로 간주한다.
- 얻은 username을 리턴한다.

### collectValidInputs
- List<List<String>>을 매개변수로 받는다. 이 값은 문제에서 주어지는 [이메일, 닉네임] 쌍의 목록이다.
- 각 쌍에 대해 아래 과정을 거친다.
  - inspectEmailCondition, inspectNicknameCondition을 통해 이메일과 닉네임을 각각 검사한다.
  - 둘 다 만족하는 경우, [이메일의 앞 부분 (@ 이전), 닉네임] 쌍을 새 List<List<String>>에 기록한다.
- 기록한 List<List<String>> 을 리턴한다.

### twoStringsAreAlike
- String a, String b를 매개변수로 받는다. 이 값들은 서로 비교할 두 닉네임이다.
- String a에 포함된 길이 2의 문자열이 String b에 포함되어 있는지 확인한다.
- 포함되어 있다면 true, 포함되어 있지 않다면 false를 리턴한다.

### checkAlikeNicknames
- List<List<String>>을 매개변수로 받는다. 이 값은 주어진 조건을 만족하는 [이메일, 닉네임] 목록이다.
- 주어진 목록을 아래와 같이 확인한다.
  - 서로 다른 [이메일, 닉네임] 쌍 중 닉네임이 유사한 경우를 확인한다. 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 유사하다고 판단한다.
  - 유사한 경우, 두 대상의 이메일을 TreeSet<String>에 추가한다.
- 완성된 TreeSet<String>을 순회하며, 뒤에 `@email.com`을 붙여 List<String>에 담는다.
- 완성된 List를 리턴한다.

### getAlikeNicknamesList
- List<List<String>>을 매개변수로 받는다. 이 값은 문제에서 주어지는 [이메일, 닉네임] 쌍의 목록이다.
- 주어지는 목록을 `collectValidInputs`을 통해, 조건을 만족하지 않는 입력을 걸러 낸다.
- 걸러 낸 목록을 `checkAlikeNicknames`을 통해, 유사한 닉네임인 경우의 이메일 목록을 수집한다.
- 결과로 받은 List<String>을 리턴한다.

### solution
- List<List<String>>을 매개변수로 받는다. 이 값은 문제에서 주어지는 [이메일, 닉네임] 쌍의 목록이다.
- getAlikeNicknamesList에 해당 List를 넘겨 주고, 결과값을 정답으로 리턴한다.

## 문제 7
### 구현 메소드 및 설명
- getUsersList
- getEachFriendsList
- getFriendsScore
- getVisitorsScore
- getTotalRecommendation
- solution

### getUsersList
- List<List<<String>>을 매개변수로 받는다. 이 값은 서로 친구인 사람들의 목록이다.
- 각 사용자를 전부 Set<String>에 집어넣어, 중복 없이 모든 사용자 이름의 목록을 얻는다.
- 얻은 목록을 리턴한다.

### getEachFriendsList
- List<List<<String>>을 매개변수로 받는다. 이 값은 서로 친구인 사람들의 목록이다.
- HashMap<String, HashSet<String>>을 만든다. 각 사용자명을 key로 하여, 해당 사용자와 친구인 사람들이 각 HashSet에 저장된다.
- 만들어진 HashMap을 리턴한다.

### getFriendsScore
- HashMap<String, HashSet<String>>을 매개변수로 받는다. 이 값은 각 사용자가 가지는 친구의 목록이다.
- 모든 사용자 중 user와 친구가 아닌 사람들을 대상으로, 아래 과정을 통해 점수를 구한다.
  - user와 해당 사용자가 공통으로 가지는 친구의 수를 구한다.
  - 구한 수 * 10을 한 후, HashMap<String, Integer>에 이를 담는다. 값은 [친구가 아닌 사람, 점수]이다.
- 구한 HashMap<String, Integer>을 리턴한다.

### getVisitorsScore
- List<String>, HashMap<String, HashSet<String>>을 매개변수로 받는다. 이 값은 사용자 프로필 방문자 목록, 각 사용자별 추천 점수이다.
- List 중 사용자가 아닌 사람에 대해, 아래 과정을 거친다.
  - 해당 사용자의 점수에 1을 더한다.
- 구한 HashMap<String, Integer>을 리턴한다.

### getTotalRecommendation
- HashMap<String, String>을 매개변수로 받는다. 이 값은 현재 사용자에 대해 추천된 사용자와 그 점수의 목록이다.
- 해당 값을 아래 기준으로 정렬한다.
  - 점수, 내림차순
  - 점수가 같은 경우, 이름, 오름차순
- 구한 목록의 이름을 List에 담아 리턴한다.

### solution
- String, List<List<String>>, List<String>을 매개변수로 받는다. 이 값은 각각 사용자명, 친구 목록, 사용자 프로필 조회자 목록이다.
- getUsersList를 호출하여 독립된 사용자명 목록을 구한다.
- HashMap<String, Integer>에 본인을 제외한 각 사용자에 대해, [사용자명, 0]을 담는다.
- getFriendsScore 및 getVisitorsScore를 호출하여, 친구가 아닌 사용자에 대해 추천 점수를 구한다.
- getTotalRecommendation을 통해 최종적으로 추천받는 목록을 받는다.
- 추천받은 목록을 정답으로 리턴한다.