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

## 📄 기능 정리

### 1. 전체 동작 과정

(1) **calculateScore() 동작** : 최종 점수를 반환하는 함수. 내부에서 다음 두 가지 함수가 수행된다.

  - **makePageMaxNumber()** : leftPageMaxNumber, rightPageMaxNumber를 구하는 기능
  - **selectBiggestNumber()** :  leftPageMaxNumber와 rightPageMaxNumber 중 큰 수를 리턴하는 기능

(2) **decideWinner() 동작** : 최종 점수를 토대로 승자를 결정하는 함수

### 2. 함수 별 입/출력 및 동작 과정

- **calculateScore()**
  - 입력 : 펼친 페이지 숫자 리스트 (= **List<Integer> pageNumbers**)
  - makePageMaxNumber() 2회 호출
    - 왼쪽 페이지 번호(pageNumbers[0]), 오른쪽 페이지 번호(pageNumbers[1])에 대해 각각 호출
    - 왼쪽 페이지 번호 최대값(leftPageMaxNumber), 오른쪽 페이지 번호 최대값(rightPageMaxNumber) 반환
  - selectBiggestNumber() 호출
    - 최종 최대값(= 최종 점수) 반환
  - 출력 : 최종 점수 (= **int score**)
<br><br>
- **makePageMaxNumber()**
  - 입력 : 왼쪽 혹은 오른쪽 페이지 번호 (= **int pageNumber**)
  - 자리 별 숫자 분리
    - 100의 자리 수 : 100으로 나눈 몫
      - 구한 후 100의 자리 수 제거
    - 10의 자리 수 : 10으로 나눈 몫
      - 구한 후 10의 자리 수 제거
    - 1의 자리 수 : 남은 수
  - 덧셈 vs 곱셈 결과 중 큰 수 선택 (= **int pageMaxNumber**)
  - 출력 : **int pageMaxNumber**
<br><br>
- **selectBiggestNumber()**
  - 입력 : 왼쪽 페이지 번호의 최대 숫자 (= **int leftPageMaxNumber**), 오른쪽 페이지 번호의 최대 숫자 (= **int rightPageMaxNumber**)
  - 두 숫자 중 큰 수 선택 (= **int biggestNumber**)
  - 출력 : **int biggestNumber**
<br><br>
- **decideWinner()**
  - 입력 : 포비의 점수 (= **int pobiScore**), 크롱의 점수 (= **int crongScore**)
  - 포비의 점수가 클 경우 : answer = 1
  - 크롱의 점수가 클 경우 : answer = 2
  - 두 점수가 같을 경우 : answer = 0
  - 출력 : **int answer**

## ✋ 예외사항

- **1 <= 페이지 번호 <= 400**
- 왼쪽 페이지는 **홀수**
- 오른쪽 페이지는 **짝수**
- 오른쪽 페이지 - 왼쪽 페이지 = 1
- List 인덱스 관련 예외
