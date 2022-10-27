# 미션 - 온보딩온보딩 🔍📮🚨🚀🎯✏

## 🚀 기능 목록
### 🔍 [문제 1](./docs/PROBLEM1.md)
#### 페이지 번호 게임
- [x] 1.입력받은 숫자의 각 자릿수를 더하는 메서드
- [x] 2.입력받은 숫자의 각 자릿수를 곱하는 메서드
- [x] 3.입력받은 두 수의 크기를 비교하여 더 큰 수를 반환하는 메서드
- [x] 4.기능 요구 사항에 맞춰 작성된 값을 반환하는 메서드

##### 더 생각해볼 것
1. if-return 기반으로 코드를 작성하기는 했으나, 조금 더 깔끔하게 작성할 수 없을까?

---
### 🔍 [문제 2](./docs/PROBLEM2.md)
#### 암호문 해독하기
- [x] 1.연속하는 중복 문자를 삭제한 결과를 반환하는 메서드

##### 실행해본 접근 방식과 더 생각해볼 것
1. 정규 표현식의 사용
   - 모든 문자를 삭제하거나, 맨 마지막 문자열만 남겨진 값이 출력된다. ex) [a-z]{2}
2. 반복문의 사용
   - 1차적으로 문자를 처음부터 끝까지 훑으며 중복 글자가 제거되는 것을 확인했다.   
   메서드를 반복시키면 문제가 요구하던 기능이 구현됨을 확인 후 재귀적으로 중복을 제거해보고자 했으나, 무한 루프에 빠졌고 스택 오버플로우 에러를 만났다.
   - for문과 if문을 사용하여 해결했다. 1번 문제와 마찬가지로 좀 더 깔끔하게 코드 작성하는 법을 생각해봐야겠다.

---
### 🔍 [문제 3](./docs/PROBLEM3.md)
#### 369게임
- [ ] 1.입력받은 숫자 안에서 3의 배수를 찾아 그 갯수를 반환하는 메서드

---
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
