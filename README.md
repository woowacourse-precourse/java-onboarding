# 미션 - 온보딩

---

## 🚀 기능 목록

1. [문제 1](./docs/PROBLEM1.md)
  - [X] isValidInput
  - 인자값이 유효한지 검사한다.
    - [X] hasTwoElements
      - 페이지 배열의 길이가 2인지 검사한다.
    - [X] hasValidNumbers
      - 페이지 배열의 숫자가 자연수에 연속된 홀수 짝수인지 검사한다.
  - [X] convertIntoSplitPageNumbers
    - 두 페이지 배열들의 요소를 자연수에서 자릿수별로 나눈 배열로 바꿔준다.
    - [X] splitByDigit
      - 자연수를 각 자릿수로 나눠준다.
  - [X] findWinner
    - 페이지 게임의 승자를 알려준다. 0은 무승부, 1은 포비, 2는 크롱.
    - [X] getSum
      - 배열 안의 모든 자연수를 더해준다.
    - [X] getProduct
      - 배열 안의 모든 자연수를 곱해준다.
    - [X] getBiggerNumber
      - 두 숫자 중 큰 숫자를 알려준다.

2. [문제 2](./docs/PROBLEM2.md)
  - [X] decrypt
  - 중복 문자가 없을 때까지 단계를 거쳐 문자열을 해독한다.
    - [X] removeRepeatingLetters
      - 스택 자료구조를 사용해 중복 문자열이 나오면 딱 한번 제거한다.
      - 이전 문자를 저장해 현재 문자와 같으면 추가하지 않는다.
      - [X] stringify
        - 스택 자료구조로 저장된 문자들을 합친다.


3. [문제 3](./docs/PROBLEM3.md)
  - [X] count369InRange
  - 인자값 까지의 모든 숫자의 3, 6, 9 개수를 센다.
    - [X] count369InNumber
    - 인자값 숫자의 3, 6, 9 개수를 센다.
      - [X] is369
      - 숫자가 3, 6, 9인지 알려준다.

4. [문제 4](./docs/PROBLEM4.md)
  - [X] encryptString
  - 문자열을 반대로 바꿔준다.
    - [X] encryptCharacter
    - 하나의 문자를 반대로 바꿔준다.
      - [X] isAlphabet
      - 문자가 영문자인지 알려준다.
      - [X] getOppositeAlphabet
      - 영문자를 반대 영문자로 바꿔준다.

5. [문제 5](./docs/PROBLEM5.md)
  - [X] exchangeMoney
  - 최소한의 화폐 개수로 나눠줄 수 있는 경우를 찾는다.

6. [문제 6](./docs/PROBLEM6.md)
- [X] getDuplicateNicknameUsers
- 중복 닉네임을 가진 유저들의 이메일을 알려준다.
- 원소 검색이 O(1)으로 이루어지는 해시맵을 사용해 검사한다.
  - [X] addEmailsByNickname
  - 각 유저의 닉네임을 두 글자씩 떼어서, 해당 조합을 사용하는 유저들의 수를 검사한다.
  - 닉네임 두 글자를 키로, 이메일은 그 안의 해시셋에 저장한다.
  - [X] getEmailsByNickname
  - 특정 닉네임 조합을 둘 이상이 사용하면, 해당 유저들의 이메일을 저장합니다.
  - [X] setToSortedList
  - 문자열들을 알파벳 순으로 정렬시켜 줍니다.

7. [문제 7](./docs/PROBLEM7.md)
 - [X] recommendFriends
 - 추천할 친구들을 알려준다.
   - [X] getFriendGraph
   - 친구 관계를 토대로 친구 관계 그래프를 만든다.
   - [X] add10points
   - 친구의 친구에게 10점을 부여한다.
   - [ ] add1point
   - 방문자에게 1점을 부여한다.
   - [ ] sortByPointAndId
   - 친구 점수 및 ID에 따라 정렬한다.

---

## ✏ 과제 진행 중 배운 점

- ### **좋은 코드란 무엇인가?** [[참조](https://velog.io/@couchcoding/%EA%B0%9C%EB%B0%9C-%EC%B4%88%EB%B3%B4%EB%8F%84-%EB%B0%94%EB%A1%9C-%EC%A0%81%EC%9A%A9%ED%95%B4-%EB%B3%BC-%EC%88%98-%EC%9E%88%EB%8A%94-%EC%A2%8B%EC%9D%80-%EC%BD%94%EB%93%9C-%EC%9E%91%EC%84%B1%EB%B2%95)]
   - 일반적으로 좋은 코드란 **가독성이 좋아 이해하기 쉽고, 변경하기 쉬우며, 재사용하기 쉽고, 효율적인 코드**를 이야기 한다고 한다.
   - 그런 코드를 작성하기 위해 지켜야 할 사항은 아래와 같다.
     1. 코딩 컨벤션을 지키자.
     2. 이름을 잘 짓자.
     3. 파악하기 쉬운 프로젝트 구조를 만들자.
     4. 추상레벨을 일정 수준으로 유지하자.
     5. 반복하지 말자(Don't Repeat Yourself).
   - 앞으로 코드를 작성할 때 위의 사항들을 유념하며 작성하도록 해야겠다.


- ### **코딩 컨벤션이란?** [[참조](https://developer-doreen.tistory.com/38)]
  - 코딩 컨벤션은 읽고, 관리하기 쉬운 코드를 작성하기 위한 일종의 코딩 스타일 규약(하나의 작성 표준)이다. 
    - 개발자 간 통일된 규약이 없다면 코드의 의도를 파악하거나 오류를 찾기 어려우며 유지보수 비용이 늘어난다.
  - JAVA의 코딩 컨벤션의 종류 [[참조](https://velog.io/@ozragwort/JAVA-%EC%BD%94%EB%94%A9-%EC%BB%A8%EB%B2%A4%EC%85%98%EC%97%90-%EB%8C%80%ED%95%B4%EC%84%9C)]
    - NAVER: [캠퍼스 핵데이 Java 코딩 컨벤션](https://naver.github.io/hackday-conventions-java/)
    - GOOGLE: [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
    - ORACLE: [Code Conventions for the Java](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)


- ### **이름은 어떻게 잘 지을까?**
  - 네이밍시 중요한 고려사항
    - 왜 존재해야 하는가
    - 무슨 작업을 하는가
    - 어떻게 사용하는가
  - 메서드 명명 규칙 [[참조](https://tecoble.techcourse.co.kr/post/2020-04-26-Method-Naming/)]
    - 메서드 이름은 lowerCamelCase로 작성한다.
    - 메서드 이름은 동사/전치사로 시작한다.
  - 변수명 명명 규칙 [[참조](https://tecoble.techcourse.co.kr/post/2020-04-24-variable_naming/)]
    - 변수명 역시 lowerCamelCase로 작성한다.
    - 따로 주석이 필요 없을 정도로 명확한 변수명을 쓴다.
    - 맥락을 고려해 생략 가능한 부분은 생략해 가독성을 높인다.
    - 불린형 변수는 not을 붙이지 않는다.

- ### **깃 커밋 메시지 컨벤션** [[참조](https://seolahchloe.tistory.com/entry/GitHub-%EA%B9%83-%EC%BB%A4%EB%B0%8B-%EB%A9%94%EC%84%B8%EC%A7%80-%EC%BB%A8%EB%B2%A4%EC%85%98-Git-Commit-Message-Convention)]
  - 커밋 메시지 구조
    ```
    타입: 제목 (이하 선택사항, 작성시 두 줄을 띈다.)
    
    본문
    
    각주
    ```
    - 타입
      - 해당 커밋이 무엇을 한 커밋인지 대분류로 나눈다.
      - 종류:
        - Feat - 새로운 기능 추가
        - Fix - 버그 수정
        - Docs - 문서 수정
        - Style - 코드 포맷팅, 세미콜론 누락 등, 기능 변경은 없는 경우
        - Refactor - 코드 리팩토링
        - Test - 테스트 코드, 리팩토링 테스트 코드 추가
        - Chore - 빌드 업무 수정, 패키지 매니저 수정
    - 제목
      - 50자를 넘기지 않고 첫 글자는 대문자로, 마침표는 찍지 않는다
      - 현재 시제의 명령문으로 작성한다
    - 본문
      - 선택사항이기 때문에 작성할 필요는 없다.
      - 어떻게 보다는 '무엇을' 과 '왜'에 대한 내용을 설명한다.
      - 72자 이내로 작성한다.
    - 각주
      - 역시 선택사항이다.
      - Issue Tracker ID를 작성할 때 사용한다.
      - 예) Resolves: #??? 혹은 See Also: #???

- ### **변수 선언은 반복문 안에서 하는게 좋은가?** [[참조](https://velog.io/@sc_shin/%EB%B0%98%EB%B3%B5%EB%AC%B8%EC%97%90%EC%84%9C-%EB%B3%80%EC%88%98-%EC%84%A0%EC%96%B8-%EC%9C%84%EC%B9%98)]
  - 변수의 유효범위를 생각하자
    - 변수를 반복문 안에서 선언했다면, 변수는 반복문이 종료되면 사라진다.
    - 만약 반복문 밖에서도 사용할 변수가 아니라면, 안에서 선언하는 게 좋다.
  - 최대한 좁은 범위 내에서 사용하자.
- ### **문자열을 for문으로 돌리는 방법** [[참조](https://dlee0129.tistory.com/94)]
  - 인덱스 번호로 돌리기
  ```java
  for (int i = 0; i < s.length(); i++) {
    char c = s.charAt(i);
    ...
  }
  ```
  - toCharArray 로 배열로 바꿔 돌리기
  ```java
  for (char c : s.toCharArray()) {
  ...
  }
  ```
  - chars로 IntStream으로 바꿔 돌리기
  ```java
  s.chars().forEach(c -> ... );
  ```