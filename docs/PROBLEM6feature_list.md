


## 문제 분석


### 실행 결과 예시


| forms | result |
| --- | --- |
| [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"], ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"], ["nowm@email.com", "이제엠"] ] | ["jason@email.com", "jm@email.com", "mj@email.com"] |



- result는 닉네임 들 중같은 글자가 연속적으로 포함 되는 닉네임 들을 반환한다.
- 예시의 result ["jason@email.com", "jm@email.com", "mj@email.com"]이메일의 닉네임은 모두 '제이'를 포함한다.
- 제한 사항에 '두 글자 이상의 문자가 문자 그대로 다른 닉네임에도 나타날 경우'라고 했으므로 '엠'과 '이제'는 조건에 포함되지 않는다.
- 이메일 주소와 닉네임은 같지 않을 수 있다.

 </br>

## 구현 기능 목록


+ [ ] 주어진 닉네임 각각에서 연속되는 2글자 이상의 단어 조합 찾기
  - ex) "제이엠" => "제이", "이엠", "제이엠"

+ [ ] 위에서 찾은 각각의 단어들을 다른 닉네임에서도 찾아보고 있으면 result 배열에 이메일을 추가 하기
+ [ ] result배열 중복 제거하기
+ [ ] result배열 오름차순으로 정렬하기