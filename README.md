# 미션 - 온보딩

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 📮 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
    - GitHub을 활용한 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고해
      제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원](https://apply.techcourse.co.kr) 사이트에 접속하여 프리코스 과제를 제출한다.
    - 자세한 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 참고
    - **Pull Request만 보내고 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## 🚨 과제 제출 전 체크 리스트 - 0점 방지

- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.

### 테스트 실행 가이드

- 터미널에서 `java -version`을 실행하여 Java 버전이 11인지 확인한다. 또는 Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 11로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,   
  Windows 사용자의 경우  `gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구 사항
아래의 7가지 기능 요구 사항을 모두 해결해야 한다.

1. [문제 1](./docs/PROBLEM1.md)
2. [문제 2](./docs/PROBLEM2.md)
3. [문제 3](./docs/PROBLEM3.md)
4. [문제 4](./docs/PROBLEM4.md)
5. [문제 5](./docs/PROBLEM5.md)
6. [문제 6](./docs/PROBLEM6.md)
7. [문제 7](./docs/PROBLEM7.md)

---

## 🎯 프로그래밍 요구 사항

- JDK 11 버전에서 실행 가능해야 한다. **JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- `build.gradle`을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-onboarding](https://github.com/woowacourse-precourse/java-onboarding) 저장소를 Fork & Clone해 시작한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.



---

# 문제별 기능 목록과 메서드 

### Problem 1
* 첫 페이지, 마지막 페이지 상수로 저장.
* ` validPage` : 유효한 페이지 확인하기
  * (리스트 체크) List<Integer> 이 null값인지
  * (리스트 체크) List<Integer>의 개수가 2개인지
  * (페이지 체크) Integer 요소가 null값인지
  * (페이지 체크) 첫 페이지 혹은 마지막 페이지와 같은지
  * (페이지 체크) 제한된 페이지 수를 넘어가는지
  * (페이지 연결 체크) 왼쪽은 홀수, 오른쪽은 짝수 페이지인지 
  * (페이지 연결 체크) 두 페이지가 연결되는지
* ` calculate` : 곱과 합 중에 큰 수 반환하기
* `biggerPage` : `calculate(leftPage)` , `calculate(rightPage)` 중 큰 수 반환
* `compare` : pobi와 crong의 수 비교하기


### Problem 2
* solution 함수에 구현
* Stack<Character> 이용하여 중복 제거하기
    : peek()과 add()하려는 값이 같으면, pop()
* `StringBuffer` 이용해 스택 요소 문자열로 변환하기


### Problem 3
* `count` : 숫자에 3,6,9 몇 개 있는지 세기
* `solution` : 매개변수 값 number까지 순회하며, 총 3,6,9 개수 세기


### Problem 4
* solution 함수에 구현
* 입력받은 문자열을 char[]로 변환
* 대문자인 경우 : ` (char) ('Z'-(ch-'A'))`
* 소문자인 경우 :  `(char) ('z'-(ch-'a'))`


### Problem 5
* solution 함수에 구현
* `int[] moneyList` 만들기
* 입력받은 money를 moneyList의 돈으로 나누어, 사용한 화폐 개수 세기


### Problem 6
* `isValidForm` :` isValidEmail` 와 `isValidNickname` 사용해서 유효한 form인지 체크하기
* ` isValidEmail` : 정규식을 통해 이메일 형식 체크
* `isValidNickname` : 정규식을 통해 닉네임 형식 체크
* `checkDuplicated` : 
     1) 닉네임에서 연속된 두 글자 추출,  `twoCharMap`에 {두 글자 : 이메일} 형식으로 저장
     2) 동시에, 두글자가 이미   `twoCharMap`에 KEY로 있다면, 삽입하려는 이메일(VALUE)과, 이미 저장되어있는 이메일(VALUE)를 `answer`에 저장
* `solution` : 
     1) `Set<String> answer` 생성 : 중복 닉네임의 이메일 저장하기 위한 공간
     2) `twoCharMap` 생성 : {두 글자 : 이메일} 저장 공간
     3) 스트림 생성해서, 유효한 form인지 거르고 ->   `checkDuplicated` 실행
     4) Set 형식인 answer을 List형식으로 변환, 문자열 오름차순으로 정렬


### Problem 7
* 포인트점수(친구의 친구관계/ 방문자) 상수로 저장
* `createFriendMap` : 매개변수 friends 순회하며 {user : user's friendList} 형식의 맵 만들기
* `addUserToFriendMap` : user(KEY)마다 친구리스트(VALUE) 생성하여, 친구 저장하기.
* `recommendAcquaintance` : 
     1) 매개변수 user 친구들의 친구 리스트(아는사이) 가져오기
     2) 아는사이 유저들을 `recommendFriendPoint` 맵에 {아는사이 : 점수} 형식으로 저장
* `calculateAcquaintance`: 친구 목록 중, 친구 아닌 유저들을 `recommendFriendPoint` 맵에 {유저 : 점수}로 저장 및 포인트 10점 주기
*  `recommendVisitors` : visitor 중, 친구 아닌 유저들을 `recommendFriendPoint` 맵에 {유저 : 점수}로 저장 및 포인트 1점 주기
* ` createRecommendList` : 
     1) `recommendFriendPoint` 맵에 저장된 유저들을 점수, 문자열 오름차순으로 정렬
     2) 최대 5명의 추천 유저들을 리스트로 만들기 





