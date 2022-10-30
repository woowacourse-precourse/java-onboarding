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

### 문제1 기능 목록

#### 예외처리

- 입력이 올바르지 않은 경우 예외처리를 하여 `-1` 을 return 한다.
    - 각각의 숫자가 1 미만이거나 400 초과인 수가 있을 경우
    - 배열의 길이가 2가 아닌 경우
    - [홀수 페이지, 짝수 페이지(==홀수 페이지+1)] 의 순서가 아닌 경우
    - 시작면을 펼친 경우
    - 마지막면을 펼친 경우

#### 기능

- 책의 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱한 수 중 가장 큰 수를 구한다.
- 두 수를 비교하여 결과를 낸다
    - 두 수가 같으면 `0` 결과값을 낸다
    - 포비의 수가 더 크다면 `1` 결과값을 낸다
    - 크롱이 이긴다면 `2` 결과값을 낸다

2. [문제 2](./docs/PROBLEM2.md)

### 문제2 기능 목록

#### 예외처리

- 입력이 올바르지 않은 경우 예외처리
    - 길이가 `1` 미만 `1000` 초과일 때
    - 알파벳 소문자로 이루어지지 않았을 때

#### 기능

- 새로운 암호의 시작은 기존 암호의 첫번째 문자
- 새로운 암호의 마지막 문자와 기존 암호에서 같은 문자가 몇개인지 count
    - 0 이상이면 `index+count` 후 기존 암호의 `index+count`부터 탐색
    - 0 이면 `index+1`해서 다음 문자부터 탐색
- 기존 암호를 탐색하면서 새로운 암호의 마지막 문자와 같을 때와 같지 않을 때 구분 (연속된 문자가 있을 때와 없을 때)
- `탐색중인 기존 암호의 문자 == 새로운 암호의 마지막 문자` 일 때
    - 새로운 암호의 마지막 문자는 지움
- `탐색중인 기존 암호의 문자 != 새로운 암호의 마지막 문자` 일 때
    - 탐색중인 기존 암호의 문자를 새로운 암호의 마지막 문자에 추가
- 만약 위 과정 시행중 새로운 암호문이 `""` 이 될 경우 탐색할 기존 암호문의 문자를 추가 오 `index+1`

3. [문제 3](./docs/PROBLEM3.md)

### 문제3 기능 목록

#### 예외처리

- 입력이 올바르지 않은 경우 예외처리
    - 입력이 `1` 이상 `10000` 이하인 자연수가 아닐 경우

#### 기능

- 하나의 숫자에서 `3`, `6`, `9` 가 포함되어 있는지 확인
- 숫자에 `3`, `6`, `9` 가 포함되어 있는 만큼 count

4. [문제 4](./docs/PROBLEM4.md)

### 문제4 기능 목록

#### 예외처리

- 입력이 올바르지 않은 경우 예외처리
    - 길이가 `1`미만 `1000`초과인 문자열이 주어질 때

#### 기능

- 알파벳(`A-Z`, `a-z`)인지 확인
- 알파벳은 청개구리 사전대로 변환 (아스키코드 사용)
- 알파벳인 경우와 알파벳이 아닌 경우 구분해서 변환
- 문자열에서 문자 하나당 변인

5. [문제 5](./docs/PROBLEM5.md)

### 문제5 기능 목록

#### 예외처리

- 입력이 올바르지 않은 경우 예외처리
    - 숫자가 `1`미만 `1000000`초과일 때

#### 기능

- 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 순서대로 가장 큰 금액부터 많이 변환할 수 있도록 한다
- 남은 금액에서 단위 금액을 나눠준다.

6. [문제 6](./docs/PROBLEM6.md)

### 문제6 기능 목록

#### 예외처리

- 입력의 길이가 `1` 미만이거나 `10000` 초과인 경우
- 각각 `form`의 길이가 `2`가 아닐 때 (이메일, 닉네임만 주어진 것이 아닐 때)
- 이메일이 입력 형식에 맞지 않을 때
    - 길이가 `11` 미만이거나 `20` 초과일 때
    - 도메인이 `email.com` 이 아닐 때
    - 이메일 형식이 아닐 때
- 닉네임이 입력 형식에 맞지 않을 때
    - 길이가 `1` 미만이거나 `20` 초과일 때
    - 한글이 아닐 때

#### 기능

- 모든 닉네임에서 2번 이상 나오는 단어의 집합을 만든다
    - 모든 닉네임에 대해 최소 두 글자만 같으면 되므로 두 글자만 비교한다. (예시 : `안녕하세요` -> `안녕, 녕하, 하세, 세요`)
    - 위의 예시에서 모든 경우를 다 비교하면 비효율적이므로, 한번 더 나오는 수에 대해서만 단어의 set을 만든다.
- 구한 집합의 단어과 닉네임을 비교한다.
    - 단어가 닉네임에 포함되어 있다면 중복된 단어를 쓰는 사용자이므로 닉네임을 저장한다
- 닉네임을 사용해 이메일 리스트를 구하고, 이름순으로 정렬한다.

#### 추가로 생각해야 할 반례조건

- 한 사람의 닉네임이 `안녕안녕` 과 같이 두 글자 이상이 반복될 때
- 닉네임이 완전히 같은 사람이 여러명 일 때

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
