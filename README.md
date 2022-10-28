# 미션 - 온보딩

## 문제 1 기능 목록
- [x] **입력이 올바른지 검사하는 기능**
  - [x] 페이지 번호는 1이상 400이하
  - [x] 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수
  - [x] 왼쪽 페이지 + 1은 오른쪽 페이지
  - [x] 시작면이나 마지막 면이 나오면 안된다. (1,2) (399, 400)
  - [x] 예외상황에는 -1을 반환한다.
- [x] **점수를 계산하는 기능**
  - [x] 왼쪽 오른쪽 각각 페이지의 각 자릿수의 합과 곱중 큰 값을 구한다.
  - [x] 왼쪽 페이지와 오른쪽 페이지 중 큰 값을 구한다.
- [x] **포비와 크롱의 점수를 비교하여 승자 결정**

## 문제 2 기능 목록
- [x] 문자열에서 중복된 문자 찾기
  - [x] 중복된 문자가 시작되는 지점 찾기
  - [x] 중복된 문자가 끝나는 지점 찾기
- [x] 중복된 문자 삭제
- [x] 중복된 문자가 없을때까지 위의 과정 반복

## 문제 3 기능 목록
- [x] 각 자릿수 뽑아내기
- [x] 각 자릿수가 3, 6, 9인지 확인 후 개수 세기

## 문제 4 기능 목록
- [x] 문자열의 각 문자가 알파벳인지 확인
- [x] 알파벳의 경우 대소문자 구분
- [x] 사전을 참고하여 반대로 변환

## 문제 5 기능 목록
- [x] 주어진 금액에 맞게 화폐의 단위가 큰 것부터 최대한 바꾼뒤 갯수를 담은 리스트 반환

## 문제 6 기능 목록
- [ ] 겹칠 가능성이 있는 두 글자 단어와 닉네임을 가져와 Map 생성
- [ ] Map에서 value에 닉네임이 2개이상 들어있으면 Set에 추가
- [ ] Set에 저장된 닉네임에 해당하는 email을 TreeSet에 저장
- [ ] TreeSet을 List로 변환

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
