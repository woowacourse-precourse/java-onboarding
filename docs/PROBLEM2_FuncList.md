## 기능 목록
1. 중복된 문자가 있는지 확인
    - isDuplication(String[] array)
2. 같은 문자를 특정 문자로 변경
   - void convertSpecificValue(String[] array)
3. 특정 문자가 제거된 새로운 문자 생성
    - String convertString(String[] array)
4. 중복문자가 없을 때 까지 반복
    - while(){...}
-------------------------------------------------
## 리펙터링
### 이유
1. 중복되는 코드 등장
   - isDuplications 내 for 문과 convertSpecificValue for 문이 일치하는 문제
2. while 문 + for 문으로 인한 시간복잡도 증가
3. SPECIFIC_VALUE 라는 상수가 굳이 필요한가? 에 대한 의문

### 변경방법
stack 을 활용하여 스택 안의 문자와 다음에 들어오는 문자를 비교하여 같으면 pop() 다를 시 push() 하는 방식으로 변경
