

## 진행 방식

### 문제1

1. ***SeparateDigit*** 클래스의 **isWrongPage**로 예외 상황 확인 후 예외가 발생하면 -1을 반환한다.
2. 인자로 받은 두 List\<Integer>를 이용하여 ***SeparateDigit*** 클래스를 각각 생성한다.
3. 첫 클래스의 compareScore를 이용하여 반환된 결과를 answer에 저장하고 answer를 반환한다.

 * ***SeparateDigit*** 클래스
   * 필드
       *  *int[] separatedNumber*
       *  *int size*
     * 상수
       * MAXPAGE = 400
       * MINPAGE = 1
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
2. **removeDuplicateLetters**의 return (removedAnswer)과 answer가 같을 경우 answer 리턴
* 필드
    * String answer
    * String removedAnswer
* 메소드 
  * 연속한 중복된 글자를 제거 **removeDuplicateLetters**