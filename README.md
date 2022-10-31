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
   
   📌 필요한 기능 목록
   - 유효하지 않은 페이지가 입력으로 주어진 경우 예외처리 기능
     - 페이지가 [1, 400] 범위에 속하지 않는 경우
     - 연속된 페이지가 아닌 경우
     - [왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수]를 만족하지 않는 경우
     - 시작 면이나 마지막 면이 나오도록 책을 펼친 경우
       - 모든 페이지에는 번호가 있다고 했으므로 시작 면: [1,2], 마지막 면: [399, 400] 으로 가정함
   - 두 페이지의 각 자리 수를 각각 더해서 둘 중 더 큰 수를 구하는 기능
   - 두 페이지의 각 자리 수를 각각 곱해서 둘 중 더 큰 수를 구하는 기능
   - 위의 두 기능으로 구한 값 중 더 큰 값을 점수로 하는 기능
   - 포비와 크롱의 점수를 비교해 승자를 결정하는 기능


2. [문제 2](./docs/PROBLEM2.md)

   📌 필요한 기능 목록
   - 문자열을 순회하는 기능
   - 연속하는 중복 문자들을 포함하지 않는 새 문자열을 생성하는 기능
     - 앞 글자와 중복된 문자인 경우 새 문자열에 추가하지 않는다
     - 앞 글자와 다른 문자인 경우 
       - 이전에 중복 문자열이 있었다면 새 문자열의 마지막 글자를 제거한다
       - 이전에 중복 문자열이 없었다면 문자를 새 문자열에 추가한다
   

3. [문제 3](./docs/PROBLEM3.md)

   📌 필요한 기능 목록
   - 1부터 number까지 순회하는 기능
   - 숫자를 문자열로 변환하여 문자열에 포함된 3, 6, 9 개수를 세는 기능
   

4. [문제 4](./docs/PROBLEM4.md)

   📌 필요한 기능 목록
   - 문자열을 순회하는 기능
   - 문자를 규칙에 맞게 변환하는 기능
   - 변환한 문자를 새 문자열에 더하는 기능
   

5. [문제 5](./docs/PROBLEM5.md)

   📌 필요한 기능 목록
   - 화폐단위에 따라 변환 가능한 개수를 구하는 기능
   - 금액별로 개수를 구해서 answer 리스트에 추가하는 기능


6. [문제 6](./docs/PROBLEM6.md)

   📌 필요한 기능 목록
   - 닉네임의 중복을 판단하는 기능
     - 닉네임을 두 글자마다 잘라서 동일한 닉네임이 이미 존재하는지 확인한다
       - 동일한 닉네임이 이미 나왔다면 두 지원자의 이메일을 목록에 저장해야 한다
       - 동일한 닉네임이 없다면 닉네임을 새롭게 등록한다
   - form 객체에서 닉네임 별 인덱스를 찾는 기능
   - 인덱스를 통해 이메일을 찾는 기능
   - 이메일을 중복 없이 오름차순 정렬하는 기능


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
