# 미션 - 온보딩

## 구현 기능 목록

### Problem1
- [x] 점수 계산
  - [x] 각 자리수의 합 구하기
  - [x] 각 자리수의 곱 구하기
  - [x] 큰 값 구하기
- [x] 점수 비교하여 결과 생성하기
- [x] 페이지 입력받기
- [x] 결과 반환하기


- [x] Validation
  - [x] 좌 홀수, 우 짝수 확인
  - [x] 연속된 페이지인지 확인
  - [x] 페이지 범위에 해당되는지 확인
    - 문제 요구사항 6번에 시작면이나 마지막 면이 나오도록 하지 않는다 : (1,2) (399,400) 을 혀용하지 않는다로 해석
    - 0이하, 400이상의 존제하지 않는 페이지인가 확인


### Problem2

- [x] 해독 함수 구현
  - [x] 연속된 문자 검출, 제거
    - [x] ~~연속된 문자 위치 확인~~
      - [x] 연속된 문자의 모든 위치 확인(1개 이상)
    - [x] 연속된 문자 수 확인
    - [x] ~~범위 내 문자 제거~~
      - [x] 1개 이상의 범위 내 문자 제거
  - [x] 해독 가능 상태 완료 여부 확인


- [x] solution method 구현

### Problem3

- [x] 단일 숫자에서 박수 횟수 계산
- [x] 총 박수 횟수 계산


- [x] solution method 구현

### Problem4

- [x] 문자(char) 변환
- [x] 문자 종류 검사
- [x] 문자열 변환


- [x] solution method 구현

### Problem5

- [x] 돈 enum
  - [x] 단위 amount 반환
  - [x] n개의 돈 총금액 반환


- [x] 단위별 돈 수량 계산


- [x] solution method 구현


### Problem6

- [x] Crew
  - 이름, 이메일 정보를 포함하는 class 생성


- [x] NicknameChecker
  - [x] 크루 입력받기
    - [x] 입력 가능 이메일 format 확인 `email.com`
  - [x] 닉네임 유사도 검증
    - [x] 연속되는 문자 있는지 체크
    - [x] 크루들 닉네임 유사도 검사
  - [x] 유사한 닉네임 크루 이메일 리스트 변환 & 반환
  - [x] 이메일 오름차순 정렬시 도메인부분 제거 후 이메일부분만 비교하도록 comparator 
    - `이메일에 해당하는 부분`을 도메인(@email.com)을 제외한 아이디 부분으로 해석


- [x] solution method 구현


### Problem7

- [x] User
  - 사용자 이름, 친구, 방문자 정보를 포함하는 class


- [x] SNS Controller
  - [x] 사용자 등록
  - [x] 친구관계 등록
  - [x] 방문자 등록
  - [x] 친구추천 상위 5명 구하기
    - [x] 이름, 점수를 포함하는 ~~내부 private class 생성~~ 외부클래스로 refactor
      - [x] comparable -> compareTo 구현 : 추천점수로, 동일 점수시 이름순으로
    - [x] 친구의 친구 점수 더하기
    - [x] 방문자 점수 점수 더하기
    - [x] 이미 친구인 사용자 점수 제거하기


- [x] solution method 구현

___

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
