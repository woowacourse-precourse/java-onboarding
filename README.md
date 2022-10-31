# 미션 - 온보딩

## 🗒 미션별 문제 풀이 및 기능 목록 정리

### Problem1

#### 목표 요약

>  포비와 크롱 중 주어진 조건에 맞는 값을 구했을 때 누가 더 큰 값을 가졌는지 비교하는 기능 만들기

#### 기능 목록
- [x] 주어진 페이지를 조건에 맞게 계산하여 가장 큰 수를 구하는 기능 - findBiggerScore()
    - [x] 글자별로 값을 더하는 기능 - sumEachDigit()
    - [x] 글자별로 값을 곱하는 기능 - multiplyEachDigit()
- [x] 유효한 페이지인지 확인하는 기능 - validatePage()

#### 문제 풀이 순서
1. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.<br> -> Math.max(왼쪽 페이지 각 자리수 더하기, 왼쪽 페이지 각 자리수 곱하기)
2. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
   <br> -> Math.max(오른쪽 페이지 각 자리수 더하기, 오른쪽페이지 각 자리수 곱하기)
3. Math.max(1번 값, 2번 값)이 나의 점수
4. 포비와 크롱 중 3번의 값이 더 큰 사람이 승자

### Problem2

#### 목표 요약

>  중복되는 문자열을 제거하여 암호를 해독하는 기능 만들기

#### 기능 목록
- [x] word를 확인하여 중복되는 부분이 있는지 확인하는 기능 - findDuplicationLetters()
- [x] word에서 중복이 확인된 글자들을 제거해주는 기능 - removeDuplicationLetters()

#### 문제 풀이 순서
1. 먼저 중복된 단어의 인덱스를 찾아서 set에 넣어준다.
2. set에 포함된 인덱스를 반대로 정렬하고 해당 인덱스를 통해서 cryptogram의 중복 문자열을 지워준다.
3. 중복 문자열이 나오면 재귀적으로 메서드를 반복하여 다시 중복이 있는지 확인한다.
4. 중복 문자열이 없다면 해당 cryptogram을 리턴해준다.

### Problem3

#### 목표 요약

>  369게임을 할 때 1~number까지 몇 번의 손뼉을 치는지 확인하는 기능 만들기

#### 기능 목록
- [x] 1~number까지의 박수 횟수 구하는 기능 - sumClapCount()
    - [x] 임의의 숫자의 박수 횟수 구하는 기능 - countClap()

#### 문제 풀이 순서
1. 먼저 list에 박수를 쳐야 할 떄인 3, 6, 9를 초기화 해준다.
2. 박수는 3부터 치기 때문에 3~number까지 for문을 돌려준다.
3. for문을 돌면서 현재 num을 String으로 변환해주고 3, 6, 9가 몇 개 포함되어 있는지 확인한다.
4. for문을 돌면서 박수친 횟수를 모두 더해주면 결과가 나온다.

### Problem4

#### 목표 요약

>  word가 주어질 때 청개구리 사전을 참고하여 변환한 값을 구하는 기능

#### 기능 목록
- [x] 청개구리 사전을 map 자료구조에 매핑하는 기능 - createTreeFrogs(), mappingAlphabetToMap
- [x] 청개구리 사전을 통해 주어진 word를 확인하여 값을 변환하는 기능 - changeWordWithTreeFrogs()

#### 문제 풀이 순서
1. map에 청개구리 사전을 a~z까지 등록한다.
2. 주어진 word의 글자를 하나씩 확인하면서 청개구리 사전 map을 통해 문자열을 반환한다.

### Problem5

#### 목표 요약

> 돈의 액수가 money가 주어지고 큰 금액의 화폐를 우선순위로 받는다고 했을 때, <br>
> 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전<br>
> 각 몇 개로 변환 가능한지를 구하는 기능

#### 기능 목록
- [x] 각 단위별 화페의 개수를 구하는 기능 - findMonetaryUnitCounts(), countMonetaryUnit()
  - [x] 각 단위별 화폐의 개수를 구하고 남은 돈을 반환해주는 기능 - giveChange()

#### 문제 풀이 순서
1. 각 단위별 화폐의 갯수를 구한다.
2. 1번을 오 만원 권부터 일원 동전까지 반복해서 결과값을 도출한다.

### Problem6

#### 목표 요약

>  우테코 크루들의 닉네임 중 같은 글자가 연속적으로 포함되는 경우 해당 멤버들의 이메일을 List에 담아서 리턴하는 기능 

#### 기능 목록
- [x] 이메일 형식에 맞는지 확인하는 기능 - validateEmail()
- [x] 닉네임 형식에 맞는지 확인하는 기능 - validateNickname()
- [x] 같은 글자가 연속적으로 포함되는 닉네임이 있는지 찾는 기능 - findDuplicationNicknames(), findDuplicationNickname()
- [x] 중복된 닉네임을 가진 크루들의 이메일을 조건에 맞게 파싱하는 기능 - parseEmails()

#### 문제 풀이 순서
1. 임의의 크루가 정한 이메일 형식과 닉네임 형식에 제한 사항에 맞는지 확인하고 맞지 않으면 리스트에서 제거
2. 크루들이 정한 닉네임을 앞에서부터 2글자씩(i, i + 1) 초기화해둔 map에 포함되어 있나 확인한다.
3. 확인했을 때 들어있다면 초기화해둔 set에 해당 인덱스와 map에 들어있던 인덱스를 추가해준다.
4. 확인했을 때 없다면 map에 닉네임의 2글자를 매핑해준다.
5. set을 정렬하고 list로 변환해서 리턴

#### 예외 처리

> 조건에 맞지 않는 이메일이나 닉네임이 들어오면 IllegalArgumentException 에러를 발생 시켰습니다. 

### Problem7

#### 목표 요약

> 주어진 조건에 맞게 함께 하는 친구의 점수를 계산하여 점수가 높은 순으로 정렬하여 최대 5명을 리턴하는 기능 만들기 

#### 기능 목록
- [x] 함께 아는 친구를 찾아서 +10 해주는 기능 - findAcquaintances(), calculateAcquaintanceScore(), addScoreWithAcquaintances(), findUnExcludedAcquaintances()
- [x] 사용자 타임 라인에 방문한 함께 아는 친구를 +1 해주는 기능 - calculateAcquaintanceScore(), addScoreWithVisitor() 
- [x] 함께 아는 친구 리스트를 조건에 맞게 정렬해주는 기능 - sortAcquaintanceScore()

#### 문제 풀이 순서
1. user와 frineds 정보를 통해서 함께 아는 친구 찾기
2. 함께 아는 친구를 찾으면 그 친구에 +10점을 해주기(map을 통해서 관리), 그냥 친구는 포함되지 않음.(이것도 map을 통해 관리)
3. visitors를 순회하면서 방문한 기록이 있다면 +1 해주기
4. 조건에 맞게 정렬하고 리턴

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
