## Problem1
***
- [x] **왼쪽 페이지** 번호의 각 자리 숫자를 `더한 값`과 `곱한 값`을 각각 구하기 
- [x] 위에서 구한 값 중에서 `더 큰 수`를 고르기
- [x] **오른쪽 페이지**도 위 과정을 진행
- [x] **왼쪽 페이지**에서 나온 값과 **오른쪽 페이지**에서 나온 값을 비교해서 **더 큰 수**를 구하기
- [x] 위 과정을 `포비`와 `크롱`이 진행해서 각 값을 비교해서 더 큰 값을 구함

***주의*** 
* `시작 면`이나 `마지막 면`이 나오도록 책을 펼치지 않을 것

***제한사항***
* `pobi`와 `crong`의 길이는 **2**이다.
* `pobi`와 `crong`에는 [`왼쪽 페이지 번호`, `오른쪽 페이지 번호`]가 **순서대로 들어있다.**

***

## Problem2
***

- [x] 문자열에서 **연속된 중복된 문자** 찾고 `제거`하기
- [x] 연속된 중복된 문자가 없을 때까지 위 과정을 반복하기

***제한사항***
* 문자열은 길이가 **1 이상 1000 이하**인 문자열이다.
* 문자열은 알파벳 **소문자**로만 이루어져 있다.

***

## Problem3
***
- [x] 숫자의 각 자리 분리
- [x] 각 자릿수가 3, 6, 9가 포함된 숫자인지 확인
- [x] 3, 6, 9가 포함된 수 만큼 cnt를 증가시키고 cnt 반환
- [x] 위 과정을 1부터 사용자가 입력한 수까지 반복

***제한사항***
* number는 1 이상 10,000 이하인 자연수이다.

***주의***
* 3이 여러번 나오는 숫자는 손뼉을 여러번 쳐야함

***

## Problem4
***
- [x] 알파벳 반대순서로 바꾸기
- [x] 알파벳 관련 상수들 상수 클래스로 분리하기
- [x] 문자를 붙여서 문자열로 반환하는 메서드를 따로 정의하기
- [x] 알파벳 소문자, 대문자 구분해서 메서드 구현하기

***제한사항***
* `word`는 길이가 1 이상 1,000 이하인 문자열이다.
* `알파벳 외의 문자`는 **변환하지 않는다.**
* 알파벳 `대문자`는 알파벳 `대문자`로, 알파벳 `소문자`는 알파벳 `소문자`로 변환한다.

***

## Problem5
***
- [x] 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 리스트 초기화 하기
- [x] 입력 받은 수를 `오만 원권(높은 화폐 단위)`부터 차례대로 검증함

***제한사항***
* money는 1 이상 1,000,000 이하인 자연수이다.

***
## Problem6
***

- [x] 닉네임 검증 하기 전에 `List 초기화`하기
- [x] 모든 닉네임을 `users List에 저장`하기
- [x] List 안에 글자가 연속적으로 포함되는 닉네임이 있는지 확인하기
- [x] **이미 존재하는 닉네임**이라면 users 안에 있는 이메일도 `result` 에 저장하기
- [x] 이메일 기준 `오름차순 정렬`하기

