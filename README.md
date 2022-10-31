# 미션 - 온보딩

## ✅ 기능목록

<details>
<summary style="font-size: large">문제 1</summary>
<div markdown="1">

- 인자값에 대한 유효성검사 기능
- 숫자의 각 자릿수의 합과 곱을 비교하는 기능
- 두개의 숫자의 크기를 비교하는 기능

</div>
</details>

<details>
<summary style="font-size: large">문제 2</summary>
<div markdown="1">

1. 반복문을 통해 현재글자와 이전글자, 다음 글자를 비교하여 겹치지 않은 글자를 찾는 기능
   2-1. 현재 글자와 앞글자를 비교하는 기능
   2-2. 현재 글자와 다음글자를 비교하는 기능
2. 1의 결과들을 String으로 변환하는 기능
3. 2 결과값이 입력값과 차이가 있는지 확인하고 변화가 있으면 1번부터 다시반복


</div>
</details>
<details>

<summary style="font-size: large">문제 3</summary>
<div markdown="1">

1. 입력값이 Multiple number(3) 보다 작으면 0을 리턴
2. 반복문을 통해 multiple number 부터 입력값까지 총 박수횟구 구하는 기능
    2-1. 각각의 숫자의 박수횟수를 구하는 기능
    2-2. 숫자의 일의 자리부터 마지막 자리까지 multiple number의 배수인지 확인하는 기능

</div>
</details>
<details>

<summary style="font-size: large">문제 4</summary>
<div markdown="1">

- 해당 글자가 대문자인지, 소문자인지 구분하는 기능
- 대문자 혹은 소문자인 경우 매칭되는 글자로 변환하는 기능
- 아스키 코드를 통해 글자를 변환하는 기능

</div>
</details>
<details>

<summary style="font-size: large">문제 5</summary>
<div markdown="1">

number를 가장큰 화폐단위부터 순서대로 나누고 나눈 몫을 answerList에 추가,
나머지를 Number로 재할당

</div>
</details>
<details>

<summary style="font-size: large">문제 6</summary>
<div markdown="1">

- String을 length2 단위로 나눠서 List에 저장하는 기능
- 위의 결과(List)가 다른 String에 포함되는지 확인하는 기능

</div>
</details>
<details>

<summary style="font-size: large">문제 7</summary>
<div markdown="1">

1. user의 친구 리스트 만드는 기능
2. friends에서 user의 친구의 친구를 List로 저장
3. visitor에서 user의 친구를 제외하는 기능
4. 2와 3의 결과에따라 각각의 사용자에 점수를 할당하는기능
5. 4의 결과에 따라 점수순(내림차순)으로 정렬하고, 동점일 경우 이름(오름차순)으로 정렬하는 기능
6. 5의 결과의 length가 5를 초과하는 경우 length5 로 slice하는 기능
    

</div>
</details>

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
