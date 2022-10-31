## 🚀 기능 목록
1. cryptogram을 char형 배열로 담아준다.
2. 스택 st를 선언해준다.
3. 비교식을 통해 스택 st가 공백이거나 , st의 가장 최근의 값이 char c 와 같지 않으면 push를 해준다 ,  else st.pop()
4. vlalueof를 사용하여 Character형을 String으로 변환하여 , replaceAll을 사용하여 알파벳 소문자가 아니라면 공백값을 제거해준다.

### 제한사항

- cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
- cryptogram은 알파벳 소문자로만 이루어져 있다.

### 실행 결과 예시

| cryptogram | result |
| --- | --- |
| "browoanoommnaon" | "brown" |
| "zyelleyz" | "" |
