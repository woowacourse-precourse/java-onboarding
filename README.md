

## 진행 방식
---------------------------------------

### 문제1

1. ***SeparateDigit*** 클래스의 **isWrongPage**로 예외 상황 확인 후 예외가 발생하면 -1을 반환한다.
2. 인자로 받은 두 List\<Integer>를 이용하여 ***SeparateDigit*** 클래스를 각각 생성한다.
3. 첫 클래스의 **compareScore**를 이용하여 반환된 결과를 *answer*에 저장하고 *answer*를 반환한다.

#### ***SeparateDigit*** 클래스
* 필드
    *  int[] *separatedNumber*
    *  int *size*
    * 상수
        * int MAXPAGE = 400
        * int MINPAGE = 1
* 메소드   

| 메소드                         | 기능                                                                                                         |
|-----------------------------|------------------------------------------------------------------------------------------------------------|
| **digitSeparating**         | List\<Integer>의 자릿수를 분리                                                                                    |
| **isWrongPage**             | List\<Integer>가 잘못된 형식이라면 true, 아니면 false 반환<br/>첫 수가 1~399인지 확인<br/>첫 수가 홀수인지 확인<br/>(첫 수 - 뒷 수)가 -1인지 확인 |
| **Score**                   | 조건에 부합하는 두 수 중 큰 값을 반환                                                                                     |
| **SumSeparatedNumber**      | 자릿수가 분리된 숫자를 더한 값을 반환                                                                                      |
| **multiplySeparatedNumber** | 자릿수가 분리된 숫자를 곱한 값을 반환                                                                                      |
| **compareScore**            | 다른 SeparateDigit클래스의 Score와 비교하여 다른 클래스보다 크면 1,같으면 0, 작으면 2를 반환                                            |
-------------------------------
### 문제2
1. 루프문으로 **removeDuplicateLetters** 메소드로 중복 제거 반복
2. **removeDuplicateLetters**의 결과(*removedAnswer*)와 *answer*가 같을 경우 *answer* 리턴
#### Problem2 클래스
* 필드
    * String *answer*
    * String *removedAnswer*
* 메소드 

| 메소드                        | 기능             |
|----------------------------|----------------|
| **removeDuplicateLetters** | 연속한 중복된 글자를 제거 |

---------------------------------------
### 문제3
1. 1부터 입력받은 수까지 **countingClaps**를 반복하기
2. **countingClaps**의 리턴값은 answer에 더한다.
#### Problem3 클래스
* 필드
    * int *answer*
* 메소드
  
| 메소드               | 기능              |
|-------------------|-----------------|
| **countingClaps** | 해당 수의 박수 횟수를 반환 |
   

-----------------------------------------------------------
### 문제4
1. 받은 문자열을 *answer*에 담는다.
2. *answer*를 **changeSmallLetters**로 소문자를 조건에 맞게 변경한다.
3. *answer*를 **changeCapitalLetters**로 대문자도 조건에 맞게 변경한다.
4. *answer*를 반환한다.
#### Problem4 클래스
* 필드
    * String *answer*
* 메소드

| 메소드                      | 기능                  |
|--------------------------|---------------------|
| **changeSmallLetters**   | 문자열의 소문자를 조건에 맞게 변경 |
| **changeCapitalLetters** | 문자열의 대문자를 조건에 맞게 변경 |


-----------------------------------------------------------------
### 문제5
1. *balance*에 *money*를 담는다.
2. *answer*에 **unitCounting**결과를 add한다.
3. 전환된 값을 *balance*에서 차감한다.
4. 위를 9회 반복하면 *answer*를 반환한다.
#### Problem5 클래스
* 필드
    * List\<Integer> *answer*
    * int *balance*
    * 상수
        * *BANKNOTE_UNIT[9]*
* 메소드
  
| 메소드              | 기능           |
|------------------|--------------|
| **unitCounting** | 단위로 나눈 몫을 반환 | 
    

---------------------------------------
### 문제6
1. *form*s의 List<String>를 **checkNickName**에 차례대로 넣기.
2. **checkNickName**에서 2글자식 나눠서 *myNickNamePart*에 담기
3. **checkNickNamePart**로 넣어서 *myNickNamePart*이 *usedNickNamePart*에 키 값으로 존재하는지 확인하고 있으면 해당 키의 value(email)와 myEmail 둘 다 emailToBeSent에 add해주기
4. *myUsedNickNamePart*에 모든 *key:myNickNamePart = value:myEmail*저장하기
5. *usedNickNamePart*에 *myNickNamePart* 모두 넣어주기
6. 반복이 끝나면 *emailToBeSent*를 ArrayList로 변환해 *answer*에 넣어주고 *answer* 반환

#### Problem6 클래스
* 필드
  * static HashMap<String, String> *usedNickNamePart*
  * static TreeSet<String> *emailToBeSent*
* 메소드

| 메소드              | 기능           |
|------------------|--------------|
| **checkNickName**| 받은 *emailAndName*에서 *Name*을 2글자 단위로 쪼개서 **checkNickNamePart**에 보내고 난 뒤 *usedNickNamePart*에 *myEmail*을 value로 모두 추가|
|**checkNIckNamePart**|받은 2글자가 usedNickNamePart에 있는지 확인하고 있으면 해당 key를 가진 value(Email)와 myEmail을 *emailToBeSent*에 추가해 줌 |

---------------------------------------

### 문제7
1. 친구 관계를 
2. 친구의 친구 찾기
3. 친구의 친구를 key로 HashMap(이름=점수)에 value를 10으로 추가하는데 이미 있으면 value+10해준다.
4. visitor를 key로 value를 1로 추가 이미 있으면 value+1하기
5. HashMap(이름=점수)을 List로 변환해서 value(점수)기준(같을 경우 key(이름)기준)으로 내림차순 정렬한다.
6. 본인이름을 제외한 5개 뽑고 이름만 answer에 담아 return한다.
