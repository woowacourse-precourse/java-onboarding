## 문제 1. 포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때, 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.

### 1번 기능 리스트업
1. 배열에서 왼쪽 수를 추출하는 기능
2. 배열에서 오른쪽 수를 추출하는 기능
3. 숫자가 파라미터로 주어졌을 때, 숫자의 각 요소를 추출하는 기능
4. 추출한 요소를 모두 더한 결과를 반환하는 기능
5. 추출한 요소를 모두 곱한 결과를 반환하는 기능
6. 한 페이지의 게임 결과를 반환하는 기능
7. 한 사람의 점수를 반환하는 기능
8. 두 사람의 게임 결과를 반환하는 기능
9. 숫자가 유효하지 않은 경우 예외처리
   1. 첫 번째 혹은 마지막 페이지를 펼친 경우
   2. 왼쪽 페이지가 홀수가 아니거나 오른쪽 페이지가 짝수가 아닌 경우
   3. 연속된 페이지가 아닌 경우
   
---

## 문제 2. 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.

### 2번 기능 리스트업
1. LinkedList 가 비어있는지 확인하는 기능
2. LinkedList에 char 문자를 add 하는 기능
3. 중복 문자를 확인하는 기능
4. 중복 문자를 제거하는 기능
5. LinkedList<Charactor> 의 요소를 String 으로 변환하는 기능

---

## 문제 3. 숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.

### 3번 기능 리스트업
1. number 가 주어졌을 때, number 이하의 모든 수를 포함하는 List를 반환하는 기능
2. 어떤 숫자가 들어왔을 때 charArray 로 반환하는 기능
3. char 가 '3' 혹은 '6' 혹은 '9' 와 같은지 확인하는 기능

---

## 문제 4. 엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.

### 4번 기능 리스트업
1. 어떤 문자가 알파벳인지 아닌지 구분할 수 있는 기능
2. 종합 매퍼를 반환하는 기능
3. 매퍼를 담은 일급 클래스 및 클래스 내부에서 어떤 문자가 들어왔을 때 변환하여 반환할 수 있는 기능
4. 알파벳을 StringBuilder 에 추가할 수 있는 기능

---

## 문제 5. 돈의 액수 money가 매개변수로 주어질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.

### 5번 기능 리스트업
1. 현재 금액에서 특정 단위의 지폐/동전이 몇개로 변환될 수 있는지 반환하는 기능
2. 반환된 값을 List 에 저장하는 기능
3. 반환된 만큼 현재 금액에서 제거하는 기능

---

## 문제 6. 신청받은 닉네임 중 **같은 글자가 연속적으로 포함** 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 메서드를 완성하라.

### 6번 기능 리스트업
1. 닉네임을 두글자 단위로 쪼개는 기능
2. 신청한 닉네임이 같은 글자가 연속적으로 포함되는 지를 확인하는 기능

---

## 문제 7. 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때, 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라. 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.

### 7번 기능 리스트업
1. 사용자와 친구인 유저의 닉네임 리스트를 반환
2. 사용자와 친구가 아니면서 함께 아는 친구가 있는 경우, 인당 +10점을 부여하는 기능
3. 친구가 아닌 방문자들에게 +2 점을 부여하는 기능
4. 사용자와 친구가 아니면서 0점이 아닌 유저들 중 추천 순서에 맞춰 추천 친구 리스트를 반환해주는 기능