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

### 💻💬 구현 기능 목록
1. 문제 1
   1. 예외사항 처리하는 기능
   2. pobi, crong 각각의 결과 구하는 기능
      1. 각 자리 수 마다의 합, 곱 구하기
   3. 두 결과 비교하여 최종 결과 구해서 반환하기
2. 문제 2
   1. 반복되는 문자열 제거하는 기능
      1. 모든 문자열 stack에 넣고 중복되는 문자열 pop으로 제거하기
3. 문제 3
   1. 1부터 input 범위까지 확인하는 기능
      1. 숫자 비교하기 쉽도록 String type으로 바꾼다.
   2. 해당 숫자가 3, 6, 9인지 확인하는 기능
4. 문제 4
   1. 해당 문자열 하나씩 convert 하는 기능
      1. 대문자 ➡️ 소문자 convert 하는 기능
      2. 소문자 ➡️ 대문자 convert 하는 기능 
5. 문제 5
   1. input 까지 지페, 동전으로 변환하는 기능
      1. 큰 단위의 돈 단위부터 사용해서 변환하기 
6. 문제 6
   1. input 닉네임 2자씩 끊어서 Map에 담는 기능
      1. `Map<String, Set<String>>` 사용한다.
   2. 1번 과정 완료 후 Map의 value를 조회하며 Set size가 2인 것 추출하는 기능
   3. 오름차순으로 정렬하는 기능
7. 문제 7
   1. 이미 친구인 사용자들 추출하는 기능
   2. 사용자와 함께 아는 친구 찾아 점수주는 기능
   3. 타임라인에 방문하는 친구들 중 친구아닌 사람 찾아 점수주는 기능
   4. 최종 추천친구 추출하여 정렬하여 반환하는 기능

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
