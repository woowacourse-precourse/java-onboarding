## 기능 목록
### 오류 발생
기존 작성한 방식은 number가 박수를 한번 이상 치는 숫자인 경우 그 부분을 계산 못하는 오류가 있다.\
이에 따라 기능 목록을 다시 작성한다.
### 구현에 사용한 규칙

### 구현 방법
1. 매개변수로 주어진 char변수가 '3', '6', '9' 이면 true를 반환하는 메서드 checkToClap 생성 
2. number 를 String으로 변환 후 하나씩 꺼내 checkToClap이 true인 갯수를 반환하는 메서드 calculateClapNumber 생성
3. solution 메서드에서 number를 1씩 감소시키며 calculateCalpNumber반복, number 2되면 종료.
### 구현 메서드 상세
#### boolean checkToClap
1. <매개변수>\
   (char) 비교할 문자형 singlenumber
2. <변수>\
없음
3. <구현>\
singlenum이 '3', '6', '9' 와 같으면 true 반환.\
다 다르면 false반환.
#### int calculateClapNumber
1. <매개변수>\
   (int) 박수 갯수 계산할 number
2. <변수>\
   (int) 박수 갯수(checkToClap의 true 개수)를 저장할 clapnumber
3. <구현>\
number를 String형으로 바꾼 후\
문자형으로 하나씩 꺼내 checkToClap실행\
true인 경우 clapnumber 1증가, 종료 후 clapnumber 반환
#### int solution
1. <매개변수>\
   (int) number (입력값)
2. <변수>\
   (int) 최종 박수 갯수를 저장할 answer
3. <구현>\
for문을 돌며 calculateClapNumber 실행, number 1씩 감소.\
answer 에 calculateClapNumber의 리턴값 더함.\ 
종료 후 answer 반환

# 오류 발생한 구현 방식 (사용 X)
### 구현에 사용한 규칙
* 369 게임의 규칙성과 number의 제한사항을 활용한다.
  * 1~9 에선 3번의 손뼉이\
  1~99 에선 60번의 손뼉이\
  1~999 에선 900번의 손뼉이 쳐진다.
  * 이에 따라 number에서 1000을 뺄 때 900번, 100을 뺄 때 60번, 10을 뺄 때 3번의 손뼉을 추가한다.
  * 1000 단위를 먼저 진행 후 100단위, 10단위 로 진행한다.
  * 3000, 6000, 9000 은 각각 1000번씩 추가, 마찬가지로 300, 600, 900 은 100번, 30, 60, 90은 10번 추가한다.
  * 마지막 한 자리에서 개수를 판단해 최종 리턴값을 반환한다.
  * number는 10000이하로, 1000단위 까지만 계산하면 문제 해결 가능하다.
### 구현 방법
1. number에서 1000씩 빼며 손뼉 친 횟수 더하는 thousandMinus 메서드 생성.
2. number에서 100씩 빼며 손뼉 친 횟수 더하는 hundredMinus 메서드 생성.
3. number에서 10씩 빼며 손뼉 친 횟수 더하는 tenMinus 메서드 생성.
4. 한 자리수의 범위에 따라 손뼉 친 횟수 추가하는 singleDigitCalculate 메서드 생성.
5. solution에서 메서드를 활용해 최종 손뼉 친 횟수 반환한다.
### 구현 메서드 상세
#### 클래스변수
   (int) 최종 손뼉 친 횟수 저장할 변수 answer
#### void thousandMinus 메서드
1. <매개변수>\
   (int) 369 게임 수행하는 숫자 number (입력값)
2. <변수>\
   (int 상수) 1000씩 뺄 때 더할 손뼉 수 900을 담을 상수 THOUSANDCLAP\
   (int 상수) 3000, 6000, 9000 마다 추가될 1000을 담을 상수 THOUSANDPLUS\
   (int) number의 천의 자리 수를 담을 변수 number_thousand
   
3. <구현>\
number_thousand에 number/1000 결과 담기.\
number_thousand의 범위에 따라 answer에 손뼉 친 횟수 추가.\
number에 천의 자리 수 제거 후 hundredMinus 에 매개변수로 넣으며 호출.
#### void hundredMinus 메서드
1. <매개변수>\
       (int) 369 게임 수행하는 숫자 number (입력값)
2. <변수>\
   (int 상수) 100씩 뺄 때 더할 손뼉 수 60을 담을 상수 HUNDREDCLAP\
   (int 상수) 300, 600, 900 마다 추가될 100을 담을 상수 HUNDREDPLUS\
   (int) number의 천의 자리 수를 담을 변수 number_hundred

3. <구현>\
   number_hundred에 number/100 결과 담기.\
   number_hundred의 범위에 따라 answer에 손뼉 친 횟수 추가.\
   number에 백의 자리 수 제거 후 tenMinus 에 매개변수로 넣으며 호출.
#### void tenMinus 메서드
1. <매개변수>\
       (int) 369 게임 수행하는 숫자 number (입력값)
2. <변수>\
       (int 상수) 10씩 뺄 때 더할 손뼉 수 3을 담을 상수 TEMCLAP\
       (int 상수) 30, 60, 90 마다 추가될 10을 담을 상수 TEMPLUS\
       (int) number의 십의 자리 수를 담을 변수 number_ten

3. <구현>\
       number_ten에 number/10 결과 담기.\
       number_ten의 범위에 따라 answer에 손뼉 친 횟수 추가.\
       number에 십의 자리 수 제거 후 singleDigitCalculate 에 매개변수로 넣으며 호출.
#### void singleDigitCalculate  메서드
   1. <매개변수>\
      (int) 369 게임 수행하는 숫자 number (입력값)
   2. <변수>\
      없음

   3. <구현>\
      number의 범위에 따라 answer에 손뼉 친 횟수 추가.\
#### Integer solution
   1. <매개변수>\
      (int) 369 게임 수행하는 숫자 number (입력값)
   2. <변수>\
   클래스변수 answer 0으로 초기화.
   3. <구현>\
   answer 초기화
   thousandMinus 메서드 호출해 모든 손뼉 친 횟수 answer에 저장.\
   answer 반환.
   

## 🚀 기능 요구 사항

배달이가 좋아하는 369게임을 하고자 한다. 놀이법은 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 한다.

숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- number는 1 이상 10,000 이하인 자연수이다.

### 실행 결과 예시

| number | result |
| --- | --- |
| 13 | 4 |
| 33 | 14 |
