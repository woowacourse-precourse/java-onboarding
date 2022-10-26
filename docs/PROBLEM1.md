## 🚀 기능 요구 사항

포비와 크롱이 페이지 번호가 1부터 시작되는 400 페이지의 책을 주웠다. 책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이고 모든 페이지에는 번호가 적혀있었다. 책이 마음에 든 포비와 크롱은 페이지 번호 게임을 통해 게임에서 이긴 사람이 책을 갖기로 한다. 페이지 번호 게임의 규칙은 아래와 같다.

1. 책을 임의로 펼친다.
2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.

포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때, 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.

### 제한사항

- pobi와 crong의 길이는 2이다.
- pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.

### 실행 결과 예시


| pobi       | crong      | result |
| ------------ | ------------ | -------- |
| [97, 98]   | [197, 198] | 0      |
| [131, 132] | [211, 212] | 1      |
| [99, 102]  | [211, 212] | -1     |

<br>

---
## 📄 기능 정리

### 1. 전체 동작 과정

(1) **calculateScore() 동작** : 최종 점수를 반환하는 함수. 내부에서 다음 두 가지 함수가 수행된다.
  - **makePageMaxNumber()** : leftPageMaxNumber, rightPageMaxNumber를 구하는 기능. 내부에서 **splitNumber()** 함수가 수행된다.
    - **splitNumbers()** : 왼쪽 페이지 숫자(leftPageNumber)와 오른쪽 페이지 숫자(rightPageNumber)의 각 자리수를 반환

(2) **decideWinner() 동작** : 최종 점수를 토대로 승자를 결정하는 함수

### 2. 함수 별 입/출력 및 동작 과정

- **calculateScore()**
  - 입력 : 펼친 페이지 숫자 리스트 (= **List<Integer> pageNumbers**)
  - makePageMaxNumber() 2회 호출
    - 왼쪽 페이지 번호(pageNumbers[0]), 오른쪽 페이지 번호(pageNumbers[1])에 대해 각각 호출
    - 왼쪽 페이지 번호 최대값(leftPageMaxNumber), 오른쪽 페이지 번호 최대값(rightPageMaxNumber) 반환
  - 출력 : 최종 점수 (= **int score**)
<br><br>
- **makePageMaxNumber()**
  - 입력 : 왼쪽 혹은 오른쪽 페이지 번호 (= **int pageNumber**)
  - **splitNumber()** 함수 호출 : 자리 별 숫자 분리
    - 100의 자리 수 : 100으로 나눈 몫
      - 구한 후 100의 자리 수 제거
    - 10의 자리 수 : 10으로 나눈 몫
    - 1의 자리 수 : 10으로 나눈 나머지
  - 덧셈 vs 곱셈 결과 중 큰 수 선택 (= **int pageMaxNumber**)
  - 출력 : **int pageMaxNumber**
<br><br>
- **decideWinner()**
  - 입력 : 포비의 점수 (= **int pobiScore**), 크롱의 점수 (= **int crongScore**)
  - 포비의 점수가 클 경우 : answer = 1
  - 크롱의 점수가 클 경우 : answer = 2
  - 두 점수가 같을 경우 : answer = 0
  - 출력 : **int answer**

---

## ✋ 예외사항

- **1 <= 페이지 번호 <= 400**
- 왼쪽 페이지는 **홀수**
- 오른쪽 페이지는 **짝수**
- 오른쪽 페이지 - 왼쪽 페이지 = 1
- List 인덱스 관련 예외

---

## ✏️ 새롭게 시도해 본 내용

#### 1. 기능 별 함수로 나누기

- 각 기능에서 맡는 역할을 최대한 작게 만들어 로직을 정리.
- 각 함수는 자신의 역할만을 수행.
- 함수 입출력 내용이 문제의 조건에 의존하지 않도록 구현.
  - 만약 문제의 큰 틀은 유지돼되, 조건이 달라져도 각 함수들이 최대한 그대로 활용될 수 있도록 설계.
  - splitNumbers : 3자리 정수를 입력하면 각 자리의 숫자를 담은 리스트를 반환.
  - makePageMaxNumber : 3자리 정수를 입력하면 각 자리수의 곱과 합 중 큰 값을 반환.
  - decideWinner : 두 점수가 주어질 때, 그에 맞는 결과를 반환.
    - 만약 승자에 따라 반환되어야 하는 값(1, 2, 0)까지 파라미터로 설정할 수 있도록 설계할 경우, 재활용성이 더 커질 것 같음.
    - 하지만 java에서는 디폴트 매개변수를 지원하지 않으므로, 함수 오버로딩을 통해 구현해야 하는데, 필요성이 모호하다.



#### 2. 테스트 코드 연습

- 테스트 코드 작성이 미숙하여 기능 별로 모든 테스트 코드를 작성해 보았다.
- 각 기능 별로 상황을 좀 더 세세하게 설정해야 하지만, Problem1에서는 문법에 익숙해지는 것에 의미를 두었다.



#### 3. 예외처리 연습

- 예외처리 과정도 미숙하여 if/else 구문으로 가능한 예외처리도 try-catch 로 구현해 보았다.

- 내부에서 동작하는 함수의 경우, 함수 명 옆에 'throws Exception' 구문을 붙여 구현할 수 있음을 알게 되었다.

  - 가장 외부에 있는 함수 'solution' 에서 try - catch 구문이 사용된다.

  ```java
        try {
            if ((pobi.size() != 2) || (crong.size() != 2)) {
                throw new Exception();
            }

            int pobiScore = problem1.calculateScore(pobi);
            int crongScore = problem1.calculateScore(crong);

            int answer = problem1.decideWinner(pobiScore, crongScore);

            return answer;
        } catch (Exception e) {
            return -1;
        }
  ```

  - 내부에서 호출되는 'calculateScore' 함수에서 예외가 발생할 경우, 아래와 같이 'throws Exception' 구문을 활용할 수 있다.

  ```java
      public int calculateScore(List<Integer> pageNumbers) throws Exception {
          if ((pageNumbers.get(0) % 2 == 0) || (pageNumbers.get(1) % 2 == 1)) {
              throw new Exception();
          } else if ((pageNumbers.get(1) - pageNumbers.get(0)) != 1) {
              throw new Exception();
          }
  
          int leftPageMaxNumber = makePageMaxNumber(pageNumbers.get(0));
          int rightPageMaxNumber = makePageMaxNumber(pageNumbers.get(1));
  
          int score = Math.max(leftPageMaxNumber, rightPageMaxNumber);
  
          return score;
      }
  ```

  - 내부 함수에서 예외가 발생할 경우, throws Exception 을 통해 외부 함수로 예외를 던질 수 있다.