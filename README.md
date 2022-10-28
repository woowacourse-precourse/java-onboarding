# 온보딩 미션 기능 목록 

## 문제1

- 페이지 번호를 받아서 각 자리 숫자를 모두 더하는 plusNumber 메서드
- 페이지 번호를 받아서 각 자리 숫자를 모두 곱하는 multiplyNumber 메서드
- List 객체를 받아 그 객체에 예외 사항이 발생하면 true를, 정상이면 false를 반환하는 handleException 메서드
  - 페이지 수가 1 이하나 400 이상인 것
  - 왼쪽페이지가 짝수이고 오른쪽페이지가 홀수인 것
  - 연속된 숫자가 아닌 것
- 페이지 번호 목록을 받아 최종 점수를 반환하는 getPoint 메서드
- 두 점수를 받아서 게임 결과를 반환하는 getResult 메서드
- pobi와 crong의 값을 받아서 요구사항을 처리 한 후 결과값을 반환하는 solution 메서드

## 문제2

- String을 받아 연속된 문자를 제거하여 반환하는 deleteRepeat 메서드
  - 받은 String의 길이가 1 이하인 경우 바로 그 값을 리턴한다
- cryptogram을 받아 요구사항을 처리하고 결과를 반환하는 solution 메서드

## 문제3

- 10단위의 숫자를 받아서 이때의 손뼉 수를 반환하는 clapTen 메서드
- 100단위의 숫자를 받아서 이때의 손뼉 수를 반환하는 clapHundred 메서드
- 1000단위의 숫자를 받아서 이때의 손뼉 수를 반환하는 clapThousand 메서드
- 숫자 number를 받아서 자리수에 따라 메서드를 적용하여 손뼉수를 반환하는 solution
  - number가 10000인 경우에는 9999로 변환하여 처리한다.

## 문제4

- 알파벳 소문자를 받아 ASCII code를 사용하여 청개구리 사전으로 변환하는 lowerChange 메서드
- 알파벳 대문자를 받아 ASCII code를 사용하여 청개구리 사전으로 변환하는 upperChange 메서드
- 엄마 말씀 word를 받아서 반복문을 통해 한글자씩 청개구리 사전으로 변환한 결과를 반환하는 solution

## 문제5

- 돈의 액수를 받아서 이를 최대한 가볍도록 하여 화폐 단위로 변환하는 withdraw 메서드
- 돈의 액수 money를 받아서 withdraw 메서드를 통해 변환하여 결과값을 반환하는 solution

## 문제6

- 두 닉네임을 받아서 중복이 있는지 아닌지 반환하는 isRepeat 메서드
- 닉네임 지원 목록 forms를 받아서 1:1로 비교하면서 중복 목록 result를 반환하는 solution

## 문제7

- friends 목록과 user를 받아서 해당 user의 친구만 List로 만들어 반환하는 createUserFriends 메서드
- friends 목록을 받아서 friends 목록의 사용자와 친구인 리스트를 만들어 반환하는 createUserFriendFriends 메서드
  - user가 userFriendFriends로 들어갈 때 제거
- 친구 목록과 방문자 목록을 받아서 각 사용자와 그 추천 점수를 반환하는 createPoints 메서드
  - user가 points에 들어갈 때 제거
- user와 friends, visitor를 받아서 메서드들을 사용하여 최종 result 리스트를 반환하는 solution

## 참고 문헌

- 좋은 코드를 위한 자바 변수명 네이밍(https://tecoble.techcourse.co.kr/post/2020-04-24-variable_naming/)
- 좋은 코드를 위한 자바 메서드 네이밍(https://tecoble.techcourse.co.kr/post/2020-04-26-Method-Naming/)
- 깃 커밋 메세지 컨벤션(https://seolahchloe.tistory.com/entry/GitHub-%EA%B9%83-%EC%BB%A4%EB%B0%8B-%EB%A9%94%EC%84%B8%EC%A7%80-%EC%BB%A8%EB%B2%A4%EC%85%98-Git-Commit-Message-Convention)
