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


## 📝 기능 요구사항 정리
### 문제 1번
1. 입력 조건에 맞지 않는 경우 예외처리 기능
- 시작 면이나 마지막 면이 나오지 않도록 예외처리
- 1부터 400까지의 페이지가 아닌 경우 예외처리
- 연속된 페이지이면서 홀수 페이지(왼쪽 페이지)로 시작하지 않는 경우 예외처리
- 리스트의 길이가 2가 아닌 경우 예외처리
2. 왼쪽, 오른쪽 페이지 번호로 더하거나 곱해서 각각의 최대값을 구하는 기능
3. 최대값을 이용해 게임의 승자를 결정하는 기능
4. ~~게임의 승자를 출력하는 기능~~

### 문제 2번
1. 입력 조건에 맞지 않는 경우 예외처리 기능
- 길이가 1 이상 1000 이하인지 체크
- 알파벳 소문자로만 이루어져 있는지 체크
2. 문자열을 압축하는 기능
3. 더 이상 압축할 문자열이 있는지 체크하는 기능


### 문제 3번
1. 입력 조건에 맞지 않는 경우 예외처리 기능
- 1 이상 10000 이하의 자연수인지 체크
2. 주어진 숫자가 3, 6, 9 키워드를 몇개 포함하고 있는지 체크하는 기능
3. 총 3, 6, 9 키워드가 몇개인지 계산하는 기능

### 문제 4번
1. 입력 조건에 맞지 않는 경우 예외처리 기능
2. 알파벳을 변환하는 기능
- (예외) 알파벳 외의 문자는 변환하지 않음
3. word를 변환하는 기능


### 문제 5번
1. 입력 조건에 맞지 않는 경우 예외처리 기능 
- money가 1 이상 1,000,000 이하의 자연수인지 체크
2. money가 총 몇 개의 화폐로 구성될 수 있는지 계산하는 기능
3. money가 해당 화폐로 나누어지는지 확인하는 기능
4. money를 해당 화폐로 나누고 나눈 몫을 반환하는 기능
5. 화폐로 나누어짐에 따라 money를 갱신하는 기능

### 문제 6번
1. 입력 조건에 맞지 않는 경우 예외처리 기능
- 크루는 1명 이상 10000명 이하
- 이메일 형식 체크, 길이는 11자 이상, 20자 미만
- 이메일 도메인은 email.com만 가능
- 닉네임은 한글만 가능, 길이는 1자 이상, 20자 미만
2. 이름을 2글자씩 분류해서 저장하는 기능
3. 2글자 이름이 저장소에서 두 번 이상 등장하는지 체크하는 기능
4. 데이터를 정렬 후 리스트로 반환하는 기능

### 문제 7번
1. 입력 조건에 맞지 않는 경우 예외처리 기능
- user 길이 제한
- friends 길이 및 원소 크기 제한
- 아이디 길이, 알파벳 소문자 제한
- visitor 길이 제한
- 동일한 친구 관계 존재하지 않음
- 추천할 친구가 없는 경우는 없음
2. 유저마다 고유한 ID를 부여하는 기능 
3. friends 배열에서 A 유저의 친구를 찾는 기능
4. 추천 가중치를 부여하는 기능 
5. friends 가중치를 부여하는 기능
6. visitor 가중치를 부여하는 기능
7. 가중치가 큰 원소부터 최대 5개 원소의 리스트로 반환하는 기능