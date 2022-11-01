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
- 포비의 페이지가 담긴 List 변수 <i>**pobi**</i>와 크롱의 페이지가 담긴 List 변수 <i>**crong**</i>이 매개변수로 주어진다.
- <i>**pobi**</i>와 <i>**crong**</i>을 각각 클래스 `Pages`로 전달한다. 해당 클래스에서 플레이어가 고른 페이지들을 왼쪽 페이지와 오른쪽 페이지로 나눈 뒤 각각 필드 변수 <i>**leftPage**</i>와 <i>**rightPage**</i>에 할당한다.
- 클래스 `PageValidator`로 포비와 크롱이 고른 페이지들이 유효한지 검사한다.
    - 검사를 통과하지 못하면 **예외를 의미하는 숫자 -1**을 반환한다.
- 검사를 통과했다면 클래스 `MaximumCalculator`로 플레이어의 최댓값을 구한다. 과정은 아래와 같다.
    - `getMaximum` 메소드로 플레이어의 <i>**leftPage**</i>와 <i>**rightPage**</i>를 받는다.
        - `getDigts` 메소드로 페이지를 자릿수로 분리한다. <i>(97 => 9와 7)</i>
        - `compareCalculations` 메소드로 페이지의 곱과 합을 구한 뒤 더 큰 수를 반환한다. <i>(곱: 9X7 = 63, 합: 9+7=16이므로 해당 페이지는 곱이 최댓값)</i>
    - 왼쪽 페이지의 최댓값과 오른쪽 페이지의 최댓값을 비교해 최종 최댓값을 구한다.
- 포비와 크롱이의 최댓값을 구했다면 클래스 `CompareMaximums`로 둘을 비교한다.
    - **포비의 최댓값이 더 클 경우 숫자 1**을 반환
    - **크롱이의 최댓값이 더 클 경우 숫자 2**를 반환
    - **같을 경우 숫자 0**을 반환

## 📌문제2
([문제 보기](https://github.com/areyouhun/java-onboarding/blob/areyouhun/docs/PROBLEM2.md))

### 기능 목록
- 암호가 담긴 문자열 매개변수 <i>**cryptogram**</i>을 클래스 `CryptogramSolver`에 전달한다.
    - <i>**cryptogram**</i>의 길이가 2 미만이면 그대로 반환한다.
    - 길이가 2 이상인 경우, <i>**cryptogram**</i>을 글자들로 잘게 잘게 잘게 쪼갠 뒤 char 배열 변수 <i>**previousCharsOfCryptogram**</i>에 담는다. 또한 분석된 암호를 담을 List 변수 <i>**laterCharsOfCryptogram**</i>을 생성한다.
    - `compareChars` 메소드로 <i>**previousCharsOfCryptogram**</i>의 요소 (글자)들을 각각 비교한다.
        - for문 안 에서 이전 요소가 다음 요소와 다르면 이전 요소를 <i>**laterCharsOfCryptogram**</i>에 담는다.
        - 두 요소가 서로 같다면 while문을 돌려서 같지 않은 요소가 등장할 때까지 인덱스를 증가시킨다.
    - 요소 비교가 끝나면 <i>**previousCharsOfCryptogram**</i>의 마지막 요소 (글자)를 이전 요소와 비교한다. (원래라면 마지막 요소는 마지막 다음 요소와 비교해야 하지만 마지막 다음 요소라는 건 존재하지 않는다.)
    - `charsToString` 메소드로 <i>**laterCharsOfCryptogram**</i>을 문자열로 만든 뒤 변수 <i>**newCryptogram**</i>에 할당한다.
    - 처음에 주어졌던 문자열 변수 <i>**cryptogram**</i>과 <i>**newCryptogram**</i>의 값이 같은지 비교한다. 같으면 <i>**newCryptogram**</i>을 반환하고 다르면 <i>**newCryptogram**</i>을 매개변수로 위의 전 과정을 반복한다.
- 반환된 값을 문자열 변수 <i>**answer**</i>에 담으면 완성!

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
- 이메일과 닉네임이 담긴 이중 List 변수 <i>**forms**</i>를 매개변수로 클래스 `UserInfo`에 전달한다.
    - 매개변수 <i>**forms**</i>는 필드 변수 <i>**forms**</i>에 담긴다. 또한 <i>**forms**</i>에서 닉네임만 뽑아내 필드 변수 <i>**nicknames**</i>에 담는다.
- 클래스 `UserInfo`를 매개변수로 클래스 `DuplicateFinder`에 전달한다.
    - 겹치는 문자를 가진 닉네임들을 담을 Set 변수 <i>**nicknamesWithDuplicateLetters**</i>가 있다.
    - `getNicknamesWithDuplicateLetters` 메소드로 클래스 `UserInfo`의 <i>**nicknames**</i>를 검사한다.
        - for문을 돌려 현재 닉네임을 나타내는 문자열 변수 <i>**currentNickname**</i>와 다음 닉네임인 <i>**nextNickname**</i>을 비교한다.
        - <i>**currentNickname**</i>을 두 글자씩 나눠서 해당 두 글자가 <i>**nextNickname**</i>에 들어있는지 확인한다. <i>(제이엠슨 => 제이, 이엠, 엠슨)</i>
        - 들어있다면 <i>**nicknamesWithDuplicateLetters**</i>에 추가한다.
- 모든 검사가 끝나면 클래스 `UserInfo`와 클래스 `DuplicateFinder`를 매개변수로 클래스 `ResultView`에 전달한다. 여기서 클래스 `DuplicateFinder`의 <i>**nicknamesWithDuplicateLetters**</i>을 참고해 클래스 `UserInfo`의 <i>**forms**</i>에서 겹치는 닉네임을 가진 이메일만 추출한다.   
    - `updateResults`메소드로 해당 이메일들을 오름차순으로 정렬한다. (**문제에서 아이디와 도메인을 구분짓지 않았기에 이메일 전체를 정렬 기준으로 잡음**) 
    - 정렬된 이메일을 `getResults` 메소드로 반환한다.

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
