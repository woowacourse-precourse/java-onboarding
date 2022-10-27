# 기능 목록
### 기능을 구현하기 위한 기능 목록은 다음과 같습니다.  

1. 자료구조  
   연속 중복 문자를 제거할 때는 stack 기능을 사용하고 문자열로 변환할 때는 queue 사용하기 위해 dequeue를 선택했습니다.



2. decoding()
- cryptogram이 주어지면 dequeue에 한 문자씩 뒤에서부터 저장합니다.
- dequeue의 마지막 문자와 저장할 문자가 다르다면 dequeue에 문자를 저장합니다.
- dequeue의 마지막 문자와 저장할 문자가 같다면 두 문자가 서로 다를 때까지 dequeue의 마지막 문자를 pop 시키고 해당 문자는 저장하지 않습니다.



3. dequeueToString()
- dequeue의 저장된 문자들을 앞에서부터 꺼내어 answer에 넣어줍니다.


# 전  동작 과정
1. 입력받은 cryptogram을 decoding()에 넣어 연속된 중복 값을 제거합니다.
2. 연속 중복 값이 제거된 dequeue를 dequeueToString()을 통해 문자열로 변환한 뒤 answer에 넣어줍니다.