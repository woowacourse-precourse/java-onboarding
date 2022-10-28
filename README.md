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
## 🚀 구현 기능 목록

<details>
<summary>문제 1</summary>
<div markdown="1">

- 조건을 만족하는 지 점검
- 각 입력값을 더하거나 곱한 값을 배열로 생성한 후 정렬
- 가장 큰 값을 비교하여 result 출력


</div>
</details>

<details>
<summary>문제 2</summary>
<div markdown="1">

- 입력 문자열을 분리하여 배열로 저장한 후 리스트로 변환
- while문을 진행하여 리스트에서 연속적으로 중복되는 문자열은 삭제
  - 모두 중복되어 문자열이 없거나 더이상 중복되는 문자열이 없을 경우 반복문 빠져나옴
- 리스트의 문자열을 합쳐서 출력 

</div>
</details>

<details>
<summary>문제 3</summary>
<div markdown="1">

- 입력 값까지 for문 진행
  - number를 Strgin형태로 변환 후 3,6,9를 포함하였다면 문자열 배열로 변환
  - 배열의 길이만큼 반복문을 진행하며 3,6,9를 포함하였는지 판별
    - 포함하였다면 answer += 1
- answer 값 출력

</div>
</details>

<details>
<summary>문제 4</summary>
<div markdown="1">

- map에 반대되는 알파벳들을 쌍 형태로 저장
  - for문을 진행하며 아스키코드를 변환하여 저장
- 입력 문자열의 반대 문자열 저장하기 
  - 문자열이 알파벳으로만 이루어졌는지 확인
  - 입력 문자열을 배열 형태로 분할하여 저장, 변환하여 string을 담을 배열 선언
  - 배열의 문자를 key 값으로 갖는 value를 answerArr에 담는 메소드 선언
    - for문을 진행하며 key 값에 맞는 value를 배열에 저장
    - 대문자일 경우 대문자, 소문자일 경우 소문자로 배열에 저장
- answerArr의 문자열을 합쳐서 출력

</div>
</details>

<details>
<summary>문제 5</summary>
<div markdown="1">

- 화폐 단위를 순서대로 배열로 저장
- for문을 진행하며 화폐 개수를 리스트에 추가
  - money를 화폐 단위의 배열값으로 나눠서 얻은 몫을 리스트에 추가
  - 나눈 나머지 값을 money로 for문 진행
- 리스트 출력


</div>
</details>

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
