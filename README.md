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
    * 기능 목록
      1. **각 페이지 유효성 검사 기능**  
         a-1. 각 페이지가 1씩 순차적인지 검사 기능  
         a-2. 각 페이지가 첫 페이지 또는 마지막 페이지인지 검사 기능  
      2. **페이지의 각 자리수를 더한 값과 곱한 값중 가장 큰 값을 계산하는 기능**  
         b-1. Integer 숫자 각 자리수를 int[]로 변환하는 기능  
         b-2. int[] 배열의 합을 구하는 기능  
         b-3. int[] 배열의 곱을 구하는 기능  
2. [문제 2](./docs/PROBLEM2.md)
    * 기능 목록
      1. **배열 요소 반복하면서 반환 리스트에 중복되지 않은 요소 추가 기능 - decipherCryptogram()**
      2. **해당 요소가 중복된 요소인지 확인하고 중복이면 삭제하고 아니면 리스트에 추가하는 기능 - add()**
      3. **해당 요소가 중복된 문자인지 확인하는 메서드 기능 - isDuplication()**
3. [문제 3](./docs/PROBLEM3.md)
   * 기능 목록
     1. **1 ~ number 범위의 int[] 배열 생성 기능** 
     2. **1 ~ number 범위의 각 각의 숫자에서 박수 횟수 계산하는 기능**
4. [문제 4](./docs/PROBLEM4.md)
   * 기능 목록
       1. **a ~ z 알파벳을 담은 배열 생성 기능**  
       2. **알파벳 배열 반복하면서 리스트에 반전된 알파벳 추가하는 기능**  
       3. **알파벳 반전시키는 기능**  
          3-1. 알파벳 문자가 아니면 그냥 리턴  
          3-2. 알파벳이 대문자인지 소문자인지 기억하는 flag 저장  
          3-3. 4번 기능 활용하여 배열의 해당 인덱스 참조  
          3-4. 대소문자 flag로 소문자인지 대문지인지 판단해서 알맞게 리스트에 저장  
       4. **알파벳 별로 맞는 인덱스를 계산해서 반환하는 기능 (a == 25, z == 0가 됨)**  
          4-1. 모든 알파벳 upperCase()로 변경  
          4-2. normal index = ((int)현재 알파벳 - 65)  
          4-1. reverse index = (26(알파벳 개수) - 1) - normal index  
5. [문제 5](./docs/PROBLEM5.md)
   * 기능 목록
       1. **돈 단위(오만원, 만원, 오천원 등) 리스트를 순회하며 단위 별 반환 개수를 저장하는 기능**
6. [문제 6](./docs/PROBLEM6.md)
   * 기능 목록
       1. **n 단위로 문자열 slicing 해주는 기능**
       2. **두 개의 문자열에서 서로 2글자 연속으로 중복되는게 있는지 boolean 값으로 알려주는 기능**
       3. **매개변수로 건네온 컬렉션을 clone해서 해당 컬럭센에서 요소를 삭제해주는 기능**
       4. **매개변수 forms에서 같은 글자가 연속적으로 포함된 닉네임을 가진 이메일 리스트를 반환하는 기능**
       5. **이메일이 담긴 리스트를 오름차순으로 정렬하는 기능**
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
