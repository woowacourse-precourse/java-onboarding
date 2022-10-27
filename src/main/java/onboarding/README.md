# 기능 목록

### Problem1
 
|     | 번호  | 기능 코드                       | Depth1   | Depth2 | method                                                              | 설명                         |
|-----|-----|-----------------------------|----------|--------|---------------------------------------------------------------------|----------------------------|
 | O   | 1   | onBoarding-back-Problem1-01 | solution | 유효성    | private static boolean nonValidPage(List<Integer> pages)            | 입력값의 유효성 확인                |
| O   | 2   | onBoarding-back-Problem1-02 | solution | 합      | private static int getSumNumber(Integer page)                       | 각 자리 숫자의 합을 구한다            |
| O   | 3   | onBoarding-back-Problem1-03 | solution | 곱      | private static int getMultiplyNumber(Integer page)                  | 각 자리 숫자의 곱을 구한다            |
| O   | 4   | onBoarding-back-Problem1-04 | solution |        | public static int solution(List<Integer> pobi, List<Integer> crong) | 페이지 번호 게임의 승자를 구한다         |
  | O   | 5   | onBoarding-back-Problem1-05 | solution | 최대값    | private static int getBiggerNumber(List<Integer> pages)             | 두 페이지중 각자리 합 혹은 곱중 최대값 구하기 |

### Problem2

|     | 번호  | 기능 코드                       | Depth1   | Depth2 | method                                           | 설명             |
|-----|-----|-----------------------------|----------|--------|--------------------------------------------------|----------------|
| O   | 1   | onBoarding-back-Problem2-01 | solution |        | public static String solution(String cryptogram) | 중복된 문자들 삭제한 결과 |


### Problem3

|     | 번호  | 기능 코드                       | Depth1   | Depth2 | method                                      | 설명            |
|-----|-----|-----------------------------|----------|--------|---------------------------------------------|---------------|
| O   | 1   | onBoarding-back-Problem3-01 | solution |        | private static int getClapCount(int number) | 총 박수친 횟수      |
| O   | 2   | onBoarding-back-Problem3-02 | solution | 개별 박수  | private static int getClapCount(int number) | 현재 숫자에 박수친 횟수 |


### Problem4

|     | 번호  | 기능 코드                       | Depth1   | Depth2 | Depth3 | method                                      | 설명           |
|-----|-----|-----------------------------|----------|--------|--------|---------------------------------------------|--------------|
| X   | 1   | onBoarding-back-Problem4-01 | solution |        |        | public static String solution(String word)  | 청개구리 변환한 문자열 |
| O   | 2   | onBoarding-back-Problem4-02 | solution | 알파벳 변환 | 소문자    | private static char getChangeLower(char c)  | 소문자를 청개구리 변환 |
| O   | 3   | onBoarding-back-Problem4-03 | solution | 알파벳 변환 | 대문자    | private static char getChangeUpper(char c)  | 대문자를 청개구리 변환 |
