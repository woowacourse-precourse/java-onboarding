## 문제 6 기능 구현 내용

### 객체

| 객체  | class    | 구현여부 |
|-----|-------------|------|
| 크루  | Crew     | O    |

### 필요한 기능

| 기능                     | function    | 구현여부 |
|------------------------|-------------|------|
| 두글자씩 나눠서 해시맵에 넣는 기능 구현 | makeNicknameMap     | O    |
| 중복되면 list에 넣는 기능 구현    | getOverlapCrew     | O    |
| 정렬                     |     | O    |
| 중복제거                   |      | O    |

### 예외처리

| 기능                          | function             | 처리            | 구현여부 |
|-----------------------------|----------------------|---------------|------|
| 1명 미만 10000명 초과인 경우         | isNotInRangeCrew     | 빈 list 반환     | O    |
| 닉네임이 1자 미만 20자 이상인 경우       | isNotInRangeNickname | 빈 list 반환 | X    |
| 이메일이 11자 미만 20자 이상인 경우      | isNotInRangeEmail    | 빈 list 반환 | X    |
| 닉네임이 한글이 아닌 경우              | isNotInRange         | 빈 list 반환 | X    |
| 이메일 도메인이 'email.com'이 아닌 경우 | isWrongDomain        | 빈 list 반환 | X    |

