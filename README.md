# 미션 - 온보딩

## 📑기능 목록

> 문제 1
+ **기능 1.** 입력받은 페이지 번호를 검증하기
    - 예외 상황은 -1 return
    - [예외 처리] 시작 면이나 마지막 면이 나오도록 책을 펼친 경우
    - [예외 처리] 왼쪽 페이지 번호가 홀수가 아닌 경우
    - [예외 처리] 왼쪽과 오른쪽 페이지 번호가 이어지지 않는 경우 (왼쪽 페이지 번호 + 1 = 오른쪽 페이지 번호)
  

+ **기능 2.** 이긴 사람 구하기
    - 포비, 크롱의 점수 계산하기
    - 두 사람의 점수 비교하여 0, 1, 또는 2  return  

<br>

> 문제 2
+ **기능 1.** 문자열 안에서 연속하는 중복 문자들을 삭제하기
    - 연속하는 중복 문자가 없어진 문자열을 return

<br>

> 문제 3
+ **기능 1.** 하나의 숫자에 포함된 3, 6, 9의 개수 구하기  
  

+ **기능 2.** 1부터 number까지의 숫자들에 포함된 3, 6, 9의 개수 구하기
    - 반복문과 기능 1을 이용하여 손뼉 횟수 구하기
    - 손뼉 횟수 return

<br>


> 문제 4
+ **기능 1.** 청개구리 사전을 참고해 알파벳 1개를 반대로 변환하기
    - [예외 처리] 알파벳 외의 문자는 변환하지 않음
    - 알파벳 대문자는 대문자로, 소문자는 소문자로 변환

    
+ **기능 2.** word의 모든 알파벳을 반대로 변환하기
  - 반복문과 기능 1을 이용하여 word를 변환
  - 변환된 word를 return


<br>


> 문제 5
+ **기능 1.** 화폐 액수가 큰 순서대로 리스트에 담기
    - 1원 동전까지 반복이 끝나면, 리스트 return


<br>


> 문제 6
+ **기능 1.** 같은 글자가 연속적으로 포함되는 닉네임을 작성한 크루들의 이메일 목록을 만들기
    - 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복 닉네임으로 간주
    - 이메일 목록에 같은 이메일이 여러 번 등록되는 일 방지


+ **기능 2.** 이메일 목록을 오름차순 정렬 후 return


<br>


> 문제 7
+ **기능 1.** user와 친구인 사람들의 목록 만들기


+ **기능 2.** user와 친구가 아닌 사람들의 목록 만들기


+ **기능 3.** user와 친구가 아닌 사람들의 '사용자와 함께 아는 친구의 수' 점수 구하기


+ **기능 4.** user와 친구가 아닌 사람들의 '사용자의 타임 라인에 방문한 횟수' 점수 구하기


+ **기능 5.** user와 친구가 아닌 사람들을 점수가 높은 순으로 정렬하여 최대 5명 return하기
  - 점수가 0점인 경우 추천하지 않음
  - 점수가 같은 경우 이름순으로 정렬  


<br>

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
