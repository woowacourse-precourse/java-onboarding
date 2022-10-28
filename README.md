<p align="center">
    <img src="./mainbanner.png" alt="메인배너" width="100%">
</p>

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
- int `3, 6, 9`가 담긴 ArrayList를 생성한다.
- 👏손뼉 친 횟수를 나타내는 매개변수 `answer`를 선언한다.
- for문으로 int i를 1부터 매개변수 `number`까지 돌린다.
    - for문 안에서 i를 각각의 자릿수로 나눈 뒤 새로운 int 배열에 담는다,
    - 배열에 담긴 자릿수들이 `3, 6, 9`를 가리키는지 확인한다.
    - 가리킨다면 `answer`를 1 증가시킨다.

## 📌문제4
어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었다. 청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였다. 엄마 말씀이 주어질 때, **청개구리 사전**을 참고해 반대로 변환하여 값을 return 하자.
([문제 요구사항](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM4.md))
    
### 기능 목록
- String 매개변수를 쪼갠 뒤 ArrayList `wordsIntoLetters`에 담는다.
- 변환된 값을 담을 ArrayList `lettersEncrypted`를 생성한다.
- for문을 돌려 `wordsIntoLetters`를 검사한다.
    - 요소가 소문자 또는 대문자 알파벳인가?
    - 조건을 충족하면 청개구리 사전을 참고해 해당 요소를 반대로 변환한다.
    - 모든 요소는 `lettersEncrypted`에 담긴다.
- `lettersEncrypted`를 String으로 바꾼 뒤 값을 반환한다.

## 📌문제5
계좌에 들어있는 돈 일부를 은행에서 출금하고자 한다. 돈 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 받는다.

돈의 액수 money가 매개변수로 주어질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.
([문제 요구사항](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM5.md))

### 기능 목록
- 매개변수 money를 받아 클래스 `MoneySorter`를 생성한다.
    - 이 클래스에는 **금액**을 나타내는 `money`, <b>지폐와 동전 개수에 대한 초깃값(0)</b>을 나타내는 `initialNumberOfBIll`, **금액에 필요한 지폐와 동전 개수들을 담을 리스트** `currentBillsSorted`가 있다.
- `calculateNumberOfBill` 메소드를 이용해 각 화폐 단위 당 필요한 지폐와 동전 개수를 구하고 이를 `currentBillsSorted`에 반영한다.
    - 내부에선 for문이 돌아가며 `getNumberOfBillFromMoney` 메소드가 아래 사항을 체크한다.🔍
    - 금액이 주어진 화폐 단위보다 크거나 같아야 한다.
    - 조건을 만족하면 금액을 화폐 단위로 나눈 뒤 몫을 구한다. **이 몫이 필요한 지폐 또는 동전의 개수가 된다.**
    - 계산이 끝날 때마다 금액에서 <b>(화폐 단위 * 몫)</b>을 뺀다.
- for문이 끝나면 업데이트된 `currentBillsSorted에`를 반환한다.
