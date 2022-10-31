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
([문제 보기](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM2.md))

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
([문제 보기](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM3.md))

### 기능 목록
- int `3, 6, 9`가 담긴 ArrayList를 생성한다.
- 👏손뼉 친 횟수를 나타내는 매개변수 `answer`를 선언한다.
- for문으로 int i를 1부터 매개변수 `number`까지 돌린다.
    - for문 안에서 i를 각각의 자릿수로 나눈 뒤 새로운 int 배열에 담는다,
    - 배열에 담긴 자릿수들이 `3, 6, 9`를 가리키는지 확인한다.
    - 가리킨다면 `answer`를 1 증가시킨다.

## 📌문제4
([문제 보기](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM4.md))
    
### 기능 목록
- string 매개변수를 쪼갠 뒤 ArrayList `wordsIntoLetters`에 담는다.
- 변환된 값을 담을 ArrayList `lettersEncrypted`를 생성한다.
- for문을 돌려 `wordsIntoLetters`를 검사한다.
    - 요소가 소문자 또는 대문자 알파벳인가?
    - 조건을 충족하면 청개구리 사전을 참고해 해당 요소를 반대로 변환한다.
    - 모든 요소는 `lettersEncrypted`에 담긴다.
- `lettersEncrypted`를 String으로 바꾼 뒤 값을 반환한다.

## 📌문제5
([문제 보기](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM5.md))

### 기능 목록
- 매개변수 money를 받아 클래스 `MoneySorter`를 생성한다.
    - 이 클래스에는 **금액**을 나타내는 `money`, <b>지폐와 동전 개수에 대한 초깃값(0)</b>을 나타내는 `initialNumberOfBIll`, **금액에 필요한 지폐와 동전 개수들을 담을 리스트** `currentBillsSorted`가 있다.
- `calculateNumberOfBill` 메소드를 이용해 각 화폐 단위 당 필요한 지폐와 동전 개수를 구하고 이를 `currentBillsSorted`에 반영한다.
    - 내부에선 for문이 돌아가며 `getNumberOfBillFromMoney` 메소드가 아래 사항을 체크한다.🔍
    - 금액이 주어진 화폐 단위보다 크거나 같아야 한다.
    - 조건을 만족하면 금액을 화폐 단위로 나눈 뒤 몫을 구한다. **이 몫이 필요한 지폐 또는 동전의 개수가 된다.**
    - 계산이 끝날 때마다 금액에서 <b>(화폐 단위 * 몫)</b>을 뺀다.
- for문이 끝나면 업데이트된 `currentBillsSorted에`를 반환한다.

## 📌문제6
([문제 보기](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM6.md))

### 기능 목록
- 클래스 `UserInfo`를 이용해 이중 list인 매개변수 `forms`를 이메일 리스트와 닉네임 리스트로 분리한다.
    - 클래스 `InputValidator`의 조건을 지킨 이메일과 닉네임만 통과된다.
- 클래스 `DuplicateLettersFinder`로 주어진 닉네임들 중 **겹치는 글자**와 해당 닉네임의 **이메일**들을 추출한다.
    - 겹치는 글자를 가진 닉네임과 이메일은 map 타입 필드인 `result`에 추가된다. `result`의 key에는 string 타입으로 **겹치는 글자**가, value에는 set 타입으로 **해당 이메일**들이 들어간다.
    - for문을 통해 현재 닉네임이 다음 닉네임을 차례대로 검사한다.
    - `chooseNicknames` 메소드로 검사할 두 닉네임을 고른 뒤 `compareLetters` 메소드로 **두 글자씩 비교**한다.
    - 겹치는 글자를 발견하면 `result`에 새로 등록한다. 이때 해당 글자가 이미 key값으로 존재한다면 이메일들만 해당 key의 value에 추가한다. (value는 set 타입이라 중복은 알아서 걸러짐)
    - 열심히 for문을 돌린다.
- 클래스 `ResultView`를 이용해 `result`에서 이메일들만 오름차순으로 뽑아낸다. `result`는 map 타입이기 때문에 **겹치는 글자와 해당 이메일에 대해 여러 케이스가 존재할 수 있지만 주어진 문제는 한 케이스 ('제이')에 대한 이메일 명단을 요구하기 때문에 한 번 더 필터링할 필요가 있다.**

## 📌문제7
([문제 보기](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM7.md))

### 기능 목록
- 사용자 아이디 <i>**user**</i>와 친구 관계 정보 <i>**friends**</i>, 사용자 타임 라인 방문 기록 <i>**visitors**</i>가 매개변수로 주어진다.
- 주어진 매개변수들을 클래스 `GroupGenerator`에 담는다.
    - `getRecommendationScores` 메소드를 실행하여 id와 추천 점수를 각각 key와 value로 갖고 있는 필드 변수 <i>**recommendationScores**</i> 해시맵을 불러온다.
        - 내부에서 `updateMyFriends` 메소드가 실행된다. 친구 관계 정보가 담겨 있는 필드 변수 <i>**friends**</i>에서 <i>**user**</i>와 친구인 id들만 뽑아내 필드 변수 <i>**MyFriends**</i> 리스트에 담는다.
        - 그 다음 `updateNotMyFriends` 메소드가 실행된다. 필드 변수 <i>**friends**</i>에서 <i>**user**</i>와 친구가 아닌 id들만 뽑아내 필드 변수 <i>**NotMyFriends**</i> 리스트에 담는다.
        - 업데이트된 `NotMyFriends`의 요소 (id)를 key로 하여, 추천 점수를 나타내는 value를 전부 0으로 지정하고 <i>**recommendationScores**</i>에 추가한다. <i>(id1 = 0, id2 = 0, id3 = 0, ...)</i>
    - `updateRecommendationScores` 메소드를 실행해 점수를 계산한다.
        - 필드 변수 <i>**friends**</i>를 참고해 `checkFriendship` 메소드로 <i>**NotMyFriends**</i>의 요소 (id)와 <i>**MyFriends**</i>의 요소 (id)가 친구 사이인지를 확인한다. (내 친구의 친구인지를 확인하는 것이며 맞으면 +10점)
        - 필드 변수 <i>**visitors**</i>를 참고해 `checkVisits` 메소드로 <i>**NotMyFriends**</i>의 요소 (id) 중 <i>**user**</i> 계정에 방문한 id를 확인한다. (방문 시 +1점) 
- 계산이 적용된 <i>**recommendationScores**</i>는 클래스 `ResultView`로 옮겨져 결과를 반환한다.
    - `filterZeroScore` 메소드 적용 시 <i>**recommendationScores**</i> key의 value (추천 점수)가 0이면 목록에서 제외된다.
    - `getResultIdsFromResults` 메소드로 <i>**recommendationScores**</i>에서 key (id)만 뽑아내 리스트로 반환한다.
        - 리스트에 담기기 전에 <i>**recommendationScores**</i> value를 내림차순 (높은 점수), value가 같을 시 key를 오름차순 (빠른 이름)으로 정렬한다.
        - id 리스트의 사이즈가 5를 넘을 경우 초과분은 제거한다.


---
## 이미지 출처
<p><a href="https://www.flaticon.com/free-icons/books" title="books icons">Books icons created by popo2021 - Flaticon</a></p>
<p><a href="https://www.flaticon.com/free-icons/password" title="password icons">Password icons created by Freepik - Flaticon</a></p>
<p><a href="https://www.flaticon.com/free-icons/clap" title="clap icons">Clap icons created by Smashicons - Flaticon</a></P>
<p><a href="https://www.flaticon.com/free-icons/caesar" title="caesar icons">Caesar icons created by istar_design_bureau - Flaticon</a></P>
<p><a href="https://www.flaticon.com/free-icons/money" title="money icons">Money icons created by vectorsmarket15 - Flaticon</a></P>
<p><a href="https://www.flaticon.com/free-icons/name" title="name icons">Name icons created by Good Ware - Flaticon</a></P>
<p><a href="https://www.flaticon.com/free-icons/teamwork" title="teamwork icons">Teamwork icons created by Becris - Flaticon</a></P>
