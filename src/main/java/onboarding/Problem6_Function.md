
# 기능 목록
### 기능을 구현하기 위한 기능 목록은 다음과 같습니다.


### 예외사항 검사 기능  
#### 예외사항 목록
1. 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
2. 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
3. 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.

#### 예외사항 기능 목록

1. validateEmails(List<List<String>> forms) 
- 정규식 reg를 @기준으로 앞 부분은 영문자, 숫자 범위로 제한했고 @뒷부분은 email.com으로 제한했습니다.
- 입력받은 forms의 이메일을 matchs() 메서드를 이용해 정규식의 범위를 벗어나면 예외를 반환합니다.
- 입력받은 forms의 이메일의 길이가 11자 미만 20자 이상이면 예외를 반환합니다.

2. validateNickNames(List<List<String>> forms)
- 정규식 reg를 한글로 제한했습니다.
- 입력받은 forms의 닉네임을 matchs() 메서드를 이용해 정규식의 범위를 벗어나면 예외를 반환합니다.
- 입력받은 forms의 닉네임의 길이가 1자 미만 20자 이상이면 예외를 반환합니다.

### 요구 사항을 수행하기 위한 기능 
1. sortFormByNickName(List<List<String>> forms)
- 닉네임의 중복을 비교하기 전 실행하는 기능입니다.
- ArrayList의 get기능을 사용하기 위해 forms을 ArrayList 타입으로 변환합니다
- Collections의 comparator 기능을 사용하여 forms의 닉네임의 글자 수를 기준으로 오름차순 정렬합니다. 

2. findDuplicateNickName(List<List<String>> forms)
- forms을 입력받습니다. 입력받은 forms은 현재 닉네임의 글자수를 기준으로 오름차순 정렬된 상태입니다.
- 이중 for문을 통해 forms의 닉네임 쌍들을 compareNickName() 메서드에 넣습니다.
- compareNickName()의 반환값이 true이면 answer 리스트에 해당 닉네임 쌍에 대응하는 이메일 쌍들이 있는지 확인합니다.
- 이메일이 answer 리스트에 존재하지 않는다면 이메일을 넣고 존재한다면 넣지 않습니다.
