

## 진행 방식

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
       * List\<Integer>의 자릿수를 분리 **digitSeparating**
       * List\<Integer>가 잘못된 형식이라면 true, 아니면 false 반환 **isWrongPage**
         * 첫 수가 1~399인지 확인
         * 첫 수가 홀수인지 확인
         * (첫 수 - 뒷 수)가 -1인지 확인
       * 조건에 부합하는 두 수 중 큰 값을 반환 **Score**
         * 자릿수가 분리된 숫자를 곱한 값을 반환 **SumSeparatedNumber**
         * 자릿수가 분리된 숫자를 더한 값을 반환 **multiplySeparatedNumber**
         * 두 수 비교 후 큰 값을 반환 **biggerInt**
       * 다른 클래스의 Score와 비교하여 다른 클래스보다 크면 1,같으면 0, 작으면 2를 반환 **compareScore**

### 문제2
1. 루프문으로 **removeDuplicateLetters** 메소드로 중복 제거 반복
2. **removeDuplicateLetters**의 결과(*removedAnswer*)와 *answer*가 같을 경우 *answer* 리턴
#### Problem 2 클래스
* 필드
    * String *answer*
    * String *removedAnswer*
* 메소드 
  * 연속한 중복된 글자를 제거 **removeDuplicateLetters**
### 문제3
1. 입력받은 수까지 **countingClaps**을 반복하기
2. **countingClaps**의 리턴값을 answer에 더하면서 반복하기
### Problem 3 클래스
* 필드
  * int *answer*
* 메소드
  * 해당 수의 박수 횟수를 반환 **countingClaps**
### 문제4
1. 받은 문자열을 *answer*에 담는다.
2. *answer*를 **changeSmallLetters**로 소문자를 조건에 맞게 변경한다.
3. *answer*를 **changeCapitalLetters**로 대문자도 조건에 맞게 변경한다.
4. *answer*를 반환한다.
* 필드
  * String *answer*
* 메소드
  * 문자열의 소문자를 조건에 맞게 변경 **changeSmallLetters**
  * 문자열의 대문자를 조건에 맞게 변경 **changeCapitalLetters**
### 문제5
1. balance에 money를 담기
2. unitCounting 결과를 answer에 add하기
3. 전환된 돈만큼 balance를 차감한다.
4. 위를 9회 반복하면 *answer*를 반환한다.
* 필드
  * 상수
    * *BANKNOTE_UNIT[9]*
  * List\<Integer> *answer*
  * int *balance*
  * 메소드
    * 단위로 나눈 몫을 반환 **unitCounting**