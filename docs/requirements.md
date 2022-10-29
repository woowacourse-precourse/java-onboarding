# 기능 목록
## 목차
1. 문제 1
2. 문제 2
3. 문제 3
4. 문제 4
5. 문제 5
6. 문제 6
7. 문제 7

## 문제 1
### 구현 메소드 및 설명
- isException
- addIntegers
- multiplyIntegers
- getMaxScore
- solution

### isException
- List<Integer>를 매개변수로 받는다. (0)은 왼쪽 페이지 번호, (1)은 오른쪽 페이지 번호
- 책을 펼쳤을 때, 왼쪽 페이지는 짝수, 오른쪽 페이지는 홀수라는 조건이 존재
  - 따라서 두 페이지의 짝수/홀수 여부를 확인, 만족하지 않을 경우 return true
- 책이므로, 두 수는 인접해야 함 (중간에 페이지가 찢어지지 않는 이상)
  - 따라서 (오른쪽 - 왼쪽 == 1)을 만족하지 않으면 true
- 시작 면 (1, 2)이나 마지막 면 (399, 400)을 펼치면 안됨
  - 따라서 왼쪽이 1보다 작거나 오른쪽이 400보다 크면 false, (1, 2) 또는 (399, 400)이면 true;
- 위 조건 중 true가 발생하지 않는다면 false를 리턴한다.

### addIntegers
- int를 매개변수로 받는다. 이 값은 페이지 번호이다.
- 이 메소드는 전달받은 정수의 각 자릿수를 모두 더한 값을 리턴한다.
- 아래 로직을 따른다.
  - 리턴할 int형 변수 answer = 0으로 초기화한다.
  - input을 10으로 나누었을 때의 나머지를 계속 answer에 더한다.
  - 이후 input을 10으로 나눈 값으로 갱신한다.
  - input이 10보다 작으면, input의 값을 answer에 더한다.
- answer를 return한다.

### multiplyIntegers
- int를 매개변수로 받는다. 이 값은 페이지 번호이다.
- 이 메소드는 전달받은 정수의 각 자릿수를 모두 곱한 값을 리턴한다.
- 아래 로직을 따른다.
    - 리턴할 int형 변수 answer = 1으로 초기화한다.
    - input을 10으로 나누었을 때의 나머지를 계속 answer에 곱한다.
    - 이후 input을 10으로 나눈 값으로 갱신한다.
    - input이 10보다 작으면, input의 값을 answer에 곱한다.
- answer를 return한다.

### getMaxScore
- List<Integer>를 매개변수로 받는다. (0)은 왼쪽 페이지 번호, (1)은 오른쪽 페이지 번호
- 이 메소드는 한 사람이 가지게 되는 점수를 구하여 리턴한다.
- 한 사람이 가질 수 있는 점수의 경우의 수는 왼쪽, 오른쪽 각각 더했을 때, 곱했을 때이다.
- 따라서 위의 네 가지 경우를 addIntegers와 multiplyIntegers를 통해 각각 구하고, 그 중 최댓값을 리턴한다.

### solution
- List<Integer> pobi, List<Integer> crong을 각각 매개변수로 받는다.
- 이 메소드는 pobi와 crong 중 이기는 사람이 누구인지 구한다.
- 먼저 pobi와 crong의 페이지 번호가 합당한지 isException을 통해 점검한다.
  - 둘 중 하나라도 만족하지 않는 경우, -1을 리턴한다.
- pobi와 crong의 점수를 각각 getMaxScore를 통해 구한다.
- 두 점수를 비교하여 아래와 같이 값을 리턴한다.
  - 두 점수가 같은 경우 0을 리턴한다.
  - pobi가 이긴 경우 1을 리턴한다.
  - crong이 이긴 경우 2를 리턴한다.

## 문제 2
### 구현 및 메소드 설명
 - decryptString 
 - solution

### decryptString
- String을 매개변수로 받는다. 이 값은 cryptogram이다.
- String을 뒤에서부터 순회하며, 다음 과정을 수행한다.
  - stack이 비었다면, 현재 값을 stack에 담는다.
  - 현재 값이 stack.top()과 같다면, stack.pop()을 한다.
  - 그렇지 않다면, stack.push() 한다.
- 완성된 stack이 빌 때까지, pop() 하여 String으로 만든다.
- 만들어진 String을 return 한다.

### solution
- String을 매개변수로 받는다. 이 값은 cryptogram이다.
- 입력받은 cryptogram을 decryptString에 전달한다.
- 받은 결과값을 return한다.

## 문제 3
### 구현 및 메소드 설명
- shouldClap
- getTotalClaps
- solution

### shouldClap
- int를 매개변수로 받는다. 이 값은 박수를 쳐야 하는지의 여부이다.
- 받은 숫자가 10 이상일 때, 아래 과정을 반복한다.
  - 숫자의 1의 자리가 3인지 확인한다. 맞다면 박수를 쳐야 한다.
  - 그렇지 않다면, 숫자를 10으로 나눈다.
- 최종적으로 박수를 쳐야 하는지 여부를 리턴한다.

### getTotalClaps
- int를 매개변수로 받는다. 이 값은 박수를 몇 번 쳐야 하는지 구하고자 하는 number이다.
- 1부터 number까지 shouldClap을 호출한다. true의 횟수를 기록한다.
- 기록한 총 횟수를 리턴한다.

### solution
- int를 매개변수로 받는다. 이 값은 박수를 몇 번 쳐야 하는지 구하고자 하는 number이다.
- shouldClap을 호출하고, 결과값을 답으로써 리턴한다.

## 문제 4
### 구현 메소드 및 설명
- reverseAlphabet
- buildReverseWord
- solution

### reverseAlphabet
- char를 매개변수로 받는다. 이 값은 word의 한 인자이다.
- 이 메소드는 넘겨받은 알파벳 대문자 혹은 소문자를 반대로 변환한다.
- 아래 로직을 따른다.
  - 소문자, 대문자인 경우 각각 진행
    - 공백일 경우 공백을 그대로 return한다.
  - 'z' 또는 'Z'에서 입력받은 char를 뺀다.
  - 'a' 또는 'A'를 더한다.
  - char로 형변환을 하여 return한다.

### buildReverseWord
- String을 매개변수로 받는다. 이 값은 word이다.
- 이 메소드는 넘겨받은 문자열을 reverse하여 리턴한다.
- 아래 로직을 따란다.
  - String의 각 원소를 reverseAlphabet을 통해 reverse한다.
  - reverse한 알파벳을 StringBuilder에 append 한다.
  - String의 모든 원소를 거친 후, StringBuilder를 통해 String을 생성하여 return한다.

### solution
- String을 매개변수로 받는다. 이 값은 word이다.
- reverseAlphabet을 호출하여 입력 받은 word를 reverse한 후 return한다.