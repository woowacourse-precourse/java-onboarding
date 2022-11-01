## 기능 목록

### Problem1
- [x] 각 페이지별 유효성 체크
- [x] 포비의 최댓값과 크롱의 최댓값 산출
- [x] 포비와 크롱 중 점수가 높은사람 산출

### Problem2
- [x] 스택 유효성 체크
- [x] 현재 스택의 마지막값고 들어올 값이 같을 시 체크변수에 체크 후 continue
- [x] 마지막에 한번 더 체크

### Problem3
- [x] 1부터 number까지 문자열로 바꿔 문자열 배열에 저장
- [x] 문자열 배열을 처음부터 확인하며 해다 문자에 3,6,9있는지 확인
- [x] 3,6,9 갯수만큼 결과값 증가

### Problem4
- [x] 각 문자별 대응되는 문자를 저장
- [x] 주어진 문자열을 하나씩 비교하며 대응되는 문자로 변경

### Problem5
- [x] 나눠야 하는 돈의 액수를 정수배열에 저장
- [x] 현재 가진돈을 나눠야하는 돈으로 차례로 나눔
- [x] 몫을 결과배열에 저장 후 나머지를 가진돈으로 변경

### Problem6
- [x] 한 닉네임와 다른 모든 아이디 비교
- [x] 한 닉네임에서 문자열의 간격 설정
- [x] 문자열 간격과 더불어 시작 위치 설정
- [x] 설정한 문자열을 포함한 모든 아이디의 이메일들을 결과set에 저장
- [x] Set을 List형태로 변경 후 오름차순으로 리턴

### Problem7
- [x] visitors에 담긴 사람들 1점씩 추가
- [x] friends 배열에서 user와 친구이 경우는 친구 추천 제외이므로 user와 친구일때는 따로 저장
- [x] 친구의 친구는 10점 추가
- [x] 점수 내림차순/이름 오름차순으로 정렬
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
