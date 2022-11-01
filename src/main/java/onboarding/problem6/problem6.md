### problem6 기능 명세서

### Validation Class
교육생의 이메일과 닉네임을 검증할 수 있는 정규 표현식을 작성하여 Validation 클래스를 생성하였습니다.

| 이름 | 기능 | 
| --- | --- | 
| getRegexMatcherResult | 정규표현식 검사 기능 |
| isValidEmail | 이메일 형식 검증 기능 |
| isValidNickName | 닉네임 형식 검증 기능 |


### Problem6.java
- 1. 교육생의 이메일과 닉네임의 형식을 검증합니다.(validateEmailAndNickname)
- 2. 중복된 닉네임의 교육생을 찾는 함수를 호출합니다.(findCrewsHavingDuplicateNickName)
- 3. 닉네임 글자가 연속적으로 포함이 되면, notices map 에 중복의 교육생을 추가합니다. (중복 제거)
- 4. 중복된 닉네임의 교육생을 모두 찾아내면, 교육생의 이메일을 기준으로 오름차순 정렬을 수행합니다.
- 5. 그리고 중복이 제거된 오름차순의 이메일 목록 리스트를 반환합니다.
    
| 이름 | 기능 | 
| --- | --- |
| containConsecutiveLetters | 닉네임 글자가 연속적으로 포함되는지 검증 기능 |
| putDuplicateCrewInNoticesMap | notices map에 닉네임 중복의 교육생 추가 |
| sortByKey | HashMap 키 기반의 오름차순 정렬 기능 |
| findCrewsHavingDuplicateNickName | 중복된 닉네임의 교육생을 찾는 함수 |
| validateEmailAndNickname | forms의 이메일 및 닉네임 검증 함수 |
