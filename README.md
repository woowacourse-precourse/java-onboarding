# 미션 - 온보딩
## 📋 기능 구현 목록
### Problem 1
1. 각 자리 숫자를 모두 **더하는** 기능 
2. 각 자리 숫자를 모두 **곱하는** 기능 
3. 오른쪽, 왼쪽 페이지의 각 자리 숫자를 **더한 값 중 큰 수를 구하는** 기능
4. 오른쪽, 왼쪽 페이지의 각 자리 숫자를 **곱한 값 중 큰 수 를 구하는** 기능 
5. 3~4 과정을 모두 포함하여 가장 큰 수를 구하는(점수를 정하는) 기능
6. 각 점수를 비교하여 결과를 return 하는 기능
7. 예외 처리 기능
   - 연속된 페이지인 경우
   - 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수가 아닌 경우
   - 시작 면이나 마지막 면을 포함하여 페이지를 벗어난 곳을 펼친 경우
### Problem 2
1. 암호문을 한글자씩 순서대로 arrayList에 담아주는 기능
2. 암호 앞, 뒤 글자가 일치하는지 비교하는 기능
   - 일치하는 경우 실행
     - 뒤 글자를 list에서 삭제
     - 'stateRecord'에 "remove"한 상태 업데이트
   - 일치하지 않는 경우 실행
     - 직전에 "remove"된 경우
       - 앞 글자를 list에서 삭제
       - "save"한 상태 업데이트
     - 직전에 "save"되었거나 스택이 빈 상태인 경우
       - "save"한 상태 업데이트 
3. 마지막 글자 체크하는 기능
   - 글자수가 1이상이며 직전에 "remove"된 상태라면 마지막 글자 삭제
4. 삭제된 횟수 카운트 하여 해독이 완료될 때까지 반복하는 기능
5. 해독한 결과를 문자열에 담는 기능
### Problem 3
1. 각 자리 숫자를 List에 넣는 기능
2. 해당 숫자가 3,6,9인지 확인하는 기능
3. 손뼉 치는 횟수를 카운트하는 기능
4. 1~3 과정을 1부터 number까지 반복해주는 기능
### Problem 4
1. 알파벳인지 판단하는 기능
2. 대문자, 소문자를 각각 변환하는 기능
   - 알파벳이 아닌 문자(공백, 숫자, 기호 등)는 변환하지 않음 
3. 변환 혹은 변환하지 않은 문자를 연결하는 기능
### Problem 5
1. 금액 단위별 선언 및 금액 단위별 리스트를 큐에 입력하는 기능
2. 변환되는 개수 카운트하는 기능
3. 잔액 계산하는 기능
4. 2~3 과정을 통해 변환되는 개수를 순서대로 배열에 담는 기능
### Problem 6
1. forms에서 [이메일,닉네임] 가져오는 기능
2. 닉네임 중 두 글자가 연속적으로 포함될 때 체크
3. 이메일 도메인 추가해서 리스트에 담는 기능
4. 이메일 오름차순 정렬
5. 이메일 중복 제거(set 활용)

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
