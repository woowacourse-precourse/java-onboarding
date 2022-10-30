# 미션 - 온보딩온보딩 🔍📮🚨🚀🎯✏

## 🚀 기능 목록
### 🔍 [문제 1](./docs/PROBLEM1.md)
#### 페이지 번호 게임
- [x] 1.입력받은 숫자의 각 자릿수를 더하는 메서드 sumNum
- [x] 2.입력받은 숫자의 각 자릿수를 곱하는 메서드 multiplyNum
- [x] 3.입력받은 두 수의 크기를 비교하여 더 큰 수를 반환하는 메서드 maxNum
- [x] 4.기능 요구 사항에 맞춰 작성된 값을 반환하는 메서드 solution

##### ✏ 더 생각해볼 것
1. if-return 기반으로 코드를 작성하기는 했으나, 조금 더 깔끔하게 작성할 수 없을까?

---
### 🔍 [문제 2](./docs/PROBLEM2.md)
#### 암호문 해독하기
- [x] 1.연속하는 중복 문자를 삭제한 결과를 반환하는 메서드 solution

##### 접근 방식
1. 정규 표현식의 사용
   - 모든 문자를 삭제하거나, 맨 마지막 문자열만 남겨진 값이 출력된다. ex) [a-z]{2}
2. 반복문의 사용
   - 1차적으로 문자를 처음부터 끝까지 훑으며 중복 글자가 제거되는 것을 확인했다.   
   메서드를 반복시키면 문제가 요구하던 기능이 구현됨을 확인 후 재귀적으로 중복을 제거해보고자 했으나, 무한 루프에 빠졌고 스택 오버플로우 에러를 만났다.
   
##### ✏ 더 생각해볼 것
1. 접근 방식 2번으로 문제를 풀었다.   
발생한 문제는 또다른 for문과 if문을 안에서 재귀 함수를 쓰는 것으로 해결했지만, 1번 문제와 마찬가지로 좀 더 깔끔하게 코드 작성하는 법을 생각해봐야겠다.

---
### 🔍 [문제 3](./docs/PROBLEM3.md)
#### 369게임
- [x] 1.숫자 하나에서 3,6,9가 몇 번 포함되어 있는지 확인하는 메서드 checkNum
- [x] 2.기능 요구 사항에 맞춰 주어진 숫자 안에서 총 몇 번의 손뼉을 쳐야하는지 카운트하는 메서드 solution

#### ✏ 더 생각해볼 것
1. 차근차근 문제를 푸는 동안, 너무 반복문에만 의지하는 것이 아닌가하는 의문이 들었다.   
문제를 다 풀고난 후에는, 다른 방식으로도 푸는 법을 고민해봐야겠다.
---
### 🔍 [문제 4](./docs/PROBLEM4.md)
#### 청개구리 사전
- [x] 1.정방향 배열을 통해 역방향 배열의 같은 인덱스에 있는 알파벳을 반환시키는 메서드 matchAlphabet
- [x] 2.기능 요구 사항에 맞춰 띄어쓰기 자리에는 공백을, 아닌 자리에는 위 메서드로 찾은 알파벳을 추가하는 메서드 solution

##### 접근 방식
1. 정방햘 정렬 배열과, 역방향 정렬 배열을 선언하고 입력받은 word의 알파벳을 정방향 정렬과 매칭시켜본다.   
이후, 역방향 배열에서 같은 인덱스 자리에 있는 요소를 최종적으로 리턴시킬 값에 넣어준다.
   - 하나의 메서드 안에서 다 진행하려 했더니 중첩의 중첩의...가 되어 한번 분리를 하게 되었다.

#### ✏ 더 생각해볼 것
1. 모든 알파벳을 나열한 배열 두 개를 직접 손으로 다 입력했는데, 그것 외의 방법은 없을까?

---
### 🔍 [문제 5](./docs/PROBLEM5.md)
#### 출금한 돈 단위별로 쪼개기
- [X] 기능 요구 사항에 맞춰 단위별 지폐나 동전이 몇개씩인지 리스트/배열로 담는 메서드

#### 접근 방식
1. while문을 이용하여 각 금액별로 나눈 값을 리스트/배열에 넣어준다.

---
### 🔍 [문제 6](./docs/PROBLEM6.md)
#### 같은 글자가 연속적으로 포함되는 닉네임 제한하기
- [X] 입력받은 이메일과 닉네임에서 닉네임만 분리한 리스트/배열 만들기
- [X] 추출된 닉네임 리스트에서 같은 글자가 연속적으로 포함되는 닉네임 추출하기
- [X] 기존에 입력받은 매개변수와 추출한 닉네임을 비교하여 반환시킬 이메일 찾기
- [X] 이메일의 형태가 email.com인 것만 오름차순으로 반환하기

#### ✏ 더 생각해볼 것
1. 더 간략하게 코드가 나올 수 있도록 해보기

---
### 🔍 [문제 7](./docs/PROBLEM7.md)
#### 친구 추천 알고리즘
- [X] user와 친구 상태인 사용자를 제외하고, 추천 점수를 계산해야할 유저의 리스트 추출

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
