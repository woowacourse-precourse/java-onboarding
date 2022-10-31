## 🚀 문제 6 기능 구현내용

### 필요기능


| 필요기능         | 변수명(함수명)                                    | 구현 여부(O, X) |
|--------------|---------------------------------------------|-------------|
| 2단어씩 나누기     | for (int j = 0; j < name.length() - 1; j++) | O           |
| 키를 가지고 있으면   | if (email_nick.containsKey(key)) | O           |
| nickname에 추가 |  nickname.add(email);| O           |
| 정렬           |  .sorted()| O           |

### 예외처리

| 예외처리                    | validation or 함수                          | 구현 여부(O, X) |
|-------------------------|-------------------------------------------|-------------|
| 닉네임 길이가 2보다 짧으면         | if (name.length() < 2)                    | O           |
| 1명 미만 10,000명 초과        | if (forms.size() < 1  forms.size() > 10000 ) | O           |
| 이메일 전체 길이 11자 미만 20자 이상 |  if (check_email.length() < 11  check_email.length() > 20 | O           |
| email.com 도메인이 아닐 경우    |     if (!check_email.contains("email.com"))          | O           |
| 닉네임은 한글만 가능             |       boolean check_nickname= Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name); | O           |
| 닉네임 전체 길이는 1자 이상 20자 미만   |   if (name.length() < 1  name.length() > 19)          | O           |