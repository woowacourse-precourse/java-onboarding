# 미션 - 온보딩

## 기능 구현 목록
### Problem 1

#### 1. 예외처리 확인을 하는 내부 클래스
    1-1 클래스에서 쓸 2명의 4 페이지 번호를 int 타입 변수로 명시적 초기화
    1-2 시작 면 혹은 마지막 면이 있을 경우를 확인하는 boolean 타입 반환 메서드
    1-3 주어진 페이지 들이 1보다 크거나 같고 400보다 작거나 같은지 확인
        1-3-1 주어진 페이지 하나가 1보다 크거나 같고 400보다 작거나 같은지 확인하는 boolean 타입 반환 메서드
        1-3-2 1-3-1의 메서드를 이용하여 4개의 페이지를 확인하는 boolean 타입 반환 메서드
    1-4 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수인지 확인하는 boolean 타입 반환 메서드
    1-5 오른쪽 페이지가 왼쪽 페이지 보다 1 큰지 확인하는 boolean 타입 반환 메서드
    1-6 위의 하위 boolean 타입 예외처리 메서드들의 논리곱을 반환하는 최종 예외확인 boolean 타입 반환 메서드

#### 2. 승부 기능 내부 클래스
    2-1 클래스에서 쓸 2명의 4 페이지 번호를 int 타입 변수로 명시적 초기화
    2-2 문자열 안의 숫자들을 모두 더하는 int 타입 반환 메서드
    2-3 문자열 안의 숫자들을 모두 곱하는 int 타입 반환 메서드
    2-4 왼쪽과 오른쪽 페이지를 각각 문자열로 제공하여 2와 3의 결과중 최대값을 구해 int 타입으로 반환하는 메서드
    2-5 각각 pobi와 crong을 매개변수로 가지는 두개의 2-3 메서드를 통해 승자를 int 형으로 반환하는 메서드

#### 3. 예외여부 확인 후 승부 결과를 반환하도록 solution 메서드 완성


### Problem 2

#### 1. 문자열에서 매개변수로 주어진 알파벳의 3개이상 연속된 문자열을 2개로 치환하는 문자열 반환 메서드
#### 2. 모든 알파벳 소문자를 1에 매개변수로 제공하는 메서드
#### 3. 스택을 이용하여 2개 연속된 문자를 제거하는 문자열 반환 메서드
#### 4. 3의 결과물을 대괄호와 쉼표, 공백을 제거하여 반환 할 수 있도록 solution 메서드 완성

### Problem 3
#### 1. 특정 정수가 주어졌을 때 문자열로 바꾼 후 3,6,9 개수의 합을 리턴하는 메서드
#### 2. solution 메서드에서 1부터 주어진 매개변수 number 까지 1의 매개변수로 준 결과를 합해 반환, 완성



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
