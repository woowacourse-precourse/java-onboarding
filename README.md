[이미지 넣기]
# 프리코스 1주차 미션 - 온보딩
![Generic badge](https://img.shields.io/badge/language-java-green.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.0-green.svg)
> 우아한테크코스 5기 프리코스 1주차 미션을 구현한 저장소입니다. 총 7문제가 들어있습니다.

## 📌목차
- [문제1](#문제1)
- [문제2](#문제2)
- [문제3](#문제3)
- [문제4](#문제4)
- [문제5](#문제5)
- [문제6](#문제6)
- [문제7](#문제7)

## 📌문제1
포비와 크롱이 페이지 번호가 **1부터 시작되는 400 페이지의 책**을 주웠다. 책을 살펴보니 **왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호**이고 모든 페이지에는 번호가 적혀있었다. 책이 마음에 든 포비와 크롱은 페이지 번호 게임을 통해 게임에서 이긴 사람이 책을 갖기로 한다. 페이지 번호 게임의 규칙 및 요구사항은 다음의 링크를 참고한다.
([문제 요구사항](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM1.md))

### 기능 목록
- 포비와 크롱이가 선택한 페이지를 각각 List<Integer>에 담는다.
- List의 요소 (페이지)를 검사한다.
    - 연속된 두 수인가?
    - 첫 번째 요소가 1 또는 399인가?
    - 검사를 통과하지 못하면 예외를 발생시킨다.
- 검사를 통과했을 경우 요소를 자릿수로 분리한 뒤 각각의 곱과 합을 구한다. 그리고 구한 값들 중 가장 큰 값을 반환한다.
- 위의 과정으로 구한 포비의 최댓값과 크롱이의 최댓값을 두고 대소관계를 확인한다.

## 📌문제2
암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 **중복 문자**를 이용한 새로운 암호를 만들게 되는데...
([문제 요구사항](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM2.md))

### 기능 목록
- 문자열 `cryptogram`의 길이가 2 미만이면 해당 문자열을 바로 반환한다.
- 2 이상인 경우, `cryptogram`을 잘게 잘게 잘게 쪼개서 char 타입 배열 `previousString`에 넣는다.
- List<character> `laterString`을 새로 선언한다. 이곳엔 연속하는 중복 문자가 **아닌!!** 문자들만 들어갈 예정이다.
- for문을 돌려 `previousString`의 요소들을 검사한다. (**두 번째 요소부터 검사**)
    - 현재 요소가 이전 요소와 일치하지 않으면 `laterString`에 이전 요소를 추가한다.
    - 일치한다면 while문을 돌려서 일치하지 않는 요소가 등장할 때까지 인덱스를 건너 뛴다.
- for문이 끝나면 `previousString`의 마지막 요소를 검사한다. (**마지막 요소를 검사하지 못하고 for문이 끝남**)
- `laterString`을 매개값으로 새로운 문자열 `newCryptogram`을 생성한다.
- `cryptogram`과 `newCryptogram`이 같은지 확인한다.
    - 같지 않으면 `newCryptogram`을 함수 <code><b>solution</b></code>에 넣고 재호출한다.
    - 같으면 `newCryptogram`을 반환한다.

## 📌문제3
배달이가 좋아하는 369게임을 하고자 한다. 놀이법은 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 한다.
([문제 요구사항](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM3.md))

### 기능 목록
- 매개변수 number를 각각의 자릿수로 나눈 뒤 배열에 담는다,
- 배열에 담긴 자릿수들이 3, 6, 9를 가리키는지 확인한다.
    - 가리킨다면 👏손뼉 친 횟수를 증가시킨다.
