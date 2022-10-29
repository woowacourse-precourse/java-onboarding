# 미션 - 온보딩

## 문제 별 부연 설명

<br>

## Problem 1
- 사용된 클래스 리스트
  - bigNumber
  - numCalculation
  - solution

**핵심기능** 
> 입력된 수에 대해 구할 수 있는 큰 수 반환

### numCalculation

숫자계산

bigNumber 클래스를 통해 구할 수 있는 가장 큰 수를 반환합니다.

### bigNumber

입력된 숫자들에 대해 각 숫자들을 더하거나 곱한 수 중 가장 큰 수를 반환합니다.

### solution

pobi 와 crong 의 승부 여부를 가립니다.
pobi가 이기게 되면 1 반환, crong이 이기게 되면 2 무승부는 0을 예외사항은 -1을 반환합니다.

연속되지 않는 숫자들에 대해 if문을 통해 예외처리를 합니다.

<br>

## Problem 2

- 사용된 클래스 리스트
  - solutoin
  - overlap

**핵심기능** 
> stack 구현

### solution
입력된 스트링 값을 overlap 클래스를 통해 스트링 값 반환합니다.


### overlap
입력된 스트링에 대해 charAt 함수를 통해 각 캐릭터에 접근하여 리스트에 추가합니다.

리스트 원소들을 스택에 push를 통해 추가하며 이전 값과 동일 시 pop을 통해 제거합니다.

<br>

## Problem 3

- 사용된 클래스 리스트
  - solution
  - clap
  - judgment

**핵심기능**
> 숫자 입력시 캐릭터 변환 후 charAt를 통해 3, 6, 9 숫자에 대해 카운트 

### solution

clap 클래스를 통해 총 카운트 된 int 숫자를 반환합니다.

### clap

judgment 클래스를 통해 입력된 숫자의 3, 6, 9 개수를 모두 더하여 numResult변수로 반환합니다.


### judgment

입력된 숫자에 대해서 3, 6, 9 숫자의 개수를 카운트 하여 count변수로 반환합니다.

<br>

## Problem 4

- 사용된 클래스 리스트
  - solution
  - cToitran
  - iToCtran
  - join
  - characterArr

**핵심기능**

> 스트링 -> 아스키코드 -> 스트링 변환시 변환 방정식을 구현하여 사용

### solution

입력된 스트링에 대해 join 클래스를 통해 변환된 스트링을 반환합니다.


### cToitran

스트링을 입력받아 아스키코드로 변환합니다.

for문을 통해 각 캐릭터들에 접근하여 아스키코드로 변환하여 다시 배열에 넣어줍니다.

변환한 배열을 반환합니다.

### iToCtran

cToitran에서 반환된 배열을 통해 아스키코드를 캐릭터로 변환하여 배열에 넣어줍니다.

### join

캐릭터배열을 스트링으로 변환하여 반환합니다.

### characterArr

입력된 스트링을 캐릭터배열로 반환합니다.


<br>

## Problem 5

- 사용된 클래스 리스트
  - solution
  - calculation

**핵심기능**
> 각 지폐단위로 나눈 후 나머지 값에 대해서 특정 클래스 사용 없이 계산되도록 구현

### solution

answer List 를 ArrayList 로 변경하였습니다.
answer List 를 반환합니다.

### calculation

int[] 리스트 타입으로 지폐단위 리스트를 선언하였습니다.

각 지폐 단위로 나눈 몫과 나머지를 배열에 저장, 다음 지폐단위 계산을 위해 나머지 값을 다음 배열원소로 나누어 몫 배열저장 합니다.

위 과정을 지폐단위 개수만큼 반복합니다.

<br>


## Problem 6

- 사용된 클래스 리스트

<br>


## Problem 7

- 사용된 클래스 리스트








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
