
# 기능 목록
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