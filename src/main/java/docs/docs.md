## 기능 요구 사항 1

### 문제

- 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호
- 모든 페이지에는 번호가 적힘
- 게임 규칙
    1. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 곱해 가장 큰 수를 구한다. → **자리수를 쪼개고 더하고 곱한다.**
    2. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 곱해 가장 큰 수를 구한다. → 같은 방법
    3. 위 두 과정을 비교해서 가장 큰 수를 본인의 점수로 하고, 가장 높은 사람이 승자가 된다.
    4. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다 → **1, 2쪽과 399, 400쪽은 나오지 않는다.**
- 포비가 이기면 1, 크롱이 이기면 2, 무승부 0, 예외사항 -1
- 제한 사항
    - pobi와 crong의 길이는 2 → **0, 1**
    - 각각 왼쪽 페이지 번호, 오른쪽 페이지 번호가 순서대로 들어있다.

### 놓쳤던 부분

- 책의 페이지는 항상 1씩 차이나야한다
- [99, 102]의 경우 **붙어있는 페이지가 아니기 때문에 예외사항으로 둔다.**

### 필요한 개념

- 자바 List

### Code

```java
package onboarding;

import java.util.List;

class Problem1 {
    public static int maxResult (List<Integer> pages) {
        //각 페이지 번호의 각 자리 숫자를 모두 더하거나 곱해서 가장 큰 수를 구함
        int sum = 0;
        int multiple = 1;
        int max = Integer.MIN_VALUE;

        if(pages.get(1) - pages.get(0) != 1) return -1;

        for (int i=0; i<pages.size(); i++) {
            int temp = pages.get(i);

            if (temp <= 2 || temp >= 399) return -1;

            while (temp != 0) {
                sum += temp % 10;
                multiple *= temp % 10;

                temp /= 10;
            }

            if (sum > multiple) {
                if (max < sum) max = sum;
            } else if (max < multiple) max = multiple;

            sum = 0;
            multiple = 1;
        }

        return max;
    }

    public static int solution (List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = maxResult (pobi);
        int crongScore = maxResult (crong);

        if (pobiScore > crongScore) answer = 1;
        else if (pobiScore == -1 || crongScore == -1) answer = -1;
        else if(pobiScore == crongScore) answer = 0;
        else answer = 2;

        return answer;
    }
}
```

## 기능 요구사항 2

### 문제

- 중복 문자를 이용해 새로운 암호를 만듦
- 임의의 문자열 cryptogram 가 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 완성
- 예시 [browoanoommnaon]
    1. "browoan**oomm**naon"
    2. "browoa**nn**aon"
    3. "browo**aa**on"
    4. "brow**oo**n"
    5. "brown"
    6. oomm의 경우
        1. o[0]의 경우 앞에거와 다르기 때문에 저장하지 않음 → oom이 될 가능성이 있음
        2. 따라서 앞 뒤 모두 검사를 해야한다.
- 예시2 [zyelleyz]
    1. “zye**ll**eyz”
    2. “zy**ee**yz”
    3. “z**yy**z”
    4. “**zz**”
    5. “”
- 예시 테스트 [heemmmjin]
    1. “h**ee**mmmjin”
    2. “h**mmm**jin”
    3. “hjin”

### 알고리즘

- 연속된 문자열을 확인한다
- 더이상 삭제할 문자열이 없음을 판단해야한다
- 앞 뒤를 모두 검사해야 같음을 판단할 수 있음

### 필요한 개념

- Java의 문자열에서 특정 문자 제거
- 문자열에서 문자 하나씩 비교하기

### Code

```java
package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String subString = "";
        String tmpAnswer = answer;
        boolean isComplete = false;

        while (!isComplete) {
            tmpAnswer = answer;
            for (int i = 1; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1) || cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                    subString += cryptogram.charAt(i);
                }
            }

            answer = cryptogram.replaceAll(subString, "");
            cryptogram = answer;

            if (tmpAnswer.equals(answer)) {
                isComplete = true;
            }
            subString = "";
        }

        return answer;
    }
}
```

- case 2 통과가 안됐는데, **문자열이 2개일 경우 반복문 실행이 안돼서** 그런 것 같다.

```java
package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String subString = "";
        String tmpAnswer = answer;
        boolean isComplete = false;

        while (!isComplete) {
            tmpAnswer = answer;
            if (cryptogram.length() == 2 && cryptogram.charAt(0) == cryptogram.charAt(1)) {
                answer = "";
                break;
								// 문자열이 2개면 그냥 둘이 비교해서 같으면 없애버려
            }
            else {
                for (int i = 1; i < cryptogram.length() - 1; i++) {
                    if (cryptogram.charAt(i) == cryptogram.charAt(i + 1) || cryptogram.charAt(i) == cryptogram.charAt(i - 1))
                        subString += cryptogram.charAt(i);
                }
            }

            answer = cryptogram.replaceAll(subString, "");
            cryptogram = answer;

            if (tmpAnswer.equals(answer)) {    // 이전 값과 같으면 바뀐 것이 없으므로
                isComplete = true;
            }
            subString = "";
        }

        return answer;
    }
}
```

## 기능 요구 사항 3

### 문제

- 3, 6, 9
- 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야함
- 숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return
    - 13 → 3, 6, 9, 13 4번
    - 33 → 3, 6, 9, 13, 16, 19, 23, 26, 29, 30, 31, 32, 33  14번 **(33의 경우 3이 2개 들어갔으니 두번 쳐야함)**

### 알고리즘

- 자리수를 쪼갠 다음 3, 6, 9 갯수만큼 카운트 증가
- 3의 배수 → 0부터 9까지의 수 중에는 3, 6, 9 말고는 없으므로 3의 배수인지 확인한다.

### Code

```java
package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int tempNumber = number;

        for (int i=1; i<=number; i++) {
            while (tempNumber != 0) {
                if ((tempNumber % 10) % 3 == 0) {
                    answer++;
                }

                tempNumber /= 10;
            }
        }

        return answer;
    }
}
```

- 해결이 안 된 이유 : **i를 검사**해야 되는데 tempNumber를 하나 만들어버리고 그걸 검사했다.

```java
package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++) {
            int checkNumber = i;
            while (checkNumber != 0) {
                if ((checkNumber % 10) % 3 == 0) {
                    answer++;
                }

                checkNumber /= 10;
            }
        }

        return answer;
    }
}
```

- 왠지 모르겠지만 카운트가 이상하게 나왔다.
- 10의 경우 **0을 나누면 나머지가 0이기 때문에** 조건문이 통과됐던 것!

```java
package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++) {
            int checkNumber = i;
            while (checkNumber != 0) {
                int divideNumber = checkNumber % 10;
                if (divideNumber != 0 && divideNumber % 3 == 0) {
                    answer++;
                }

                checkNumber /= 10;
            }
        }

        return answer;
    }
}
```

- 최종 해결 완료!

## 기능 요구 사항 4

### 문제

- 단어가 매개변수로 주어지면 반대로 변환한다
- 알파벳 순서가 거꾸로임
- 제한 사항
    - 알파벳 외의 문자는 변환하지 않음
    - 알파벳 대문자는 대문자로, 소문자는 소문자로 변환한다.

### 알고리즘

- 아스키 코드를 이용하면 편할 것 같다

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b72148b6-29f3-4ffc-9bf3-0533d1924079/Untitled.png)

    - A - Z (대문자)
        - 65 - 90
        - 90 - 65 = 25
        - 89 - 66 = 23
        - 88 - 67 = 21
        - 2씩 점차 차이가 줄어듦
    - a - z (소문자)
        - 97 - 122
        - 122 - 97 = 25
        - 121 - 98 = 23
    - 표를 잘 보면 M, N 부분에서 서로 바뀌는 것을 알 수 있다
        - M = 77, N = 78
        - M 까지는 5, 3, 1 … 이런 식으로 더하고, N부터 차례대로 1, 3, 5 … 이런 식으로 아스키 코드값을 빼주면 된다
        - 25 ~ 1, -1 ~ -25

      → **a = 25, d = -2 인 등차수열로 풀어보자!**

    - **~~[구글링] z, Z보다 1 큰 숫자에서 자기 자신의 유니코드를 뺀다?~~**
- (두번째 방법) 알파벳 배열을 만들어서 푸는 방법
    - 뭔가 편법같아서 안 쓰려고 했는데 너무 안 풀리면 써야할 것 같다.
    - String alphabet = “ABCD~Z” → String reverse = “ZYX~A”

### Code

```java
package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0; i<word.length(); i++) {
            char divideWord = word.charAt(i);
            int a = 25;    // a가 25, d가 -2인 등차수열로 풀어보자
            if (divideWord >= 65 && divideWord <= 90) {
                // 해당 문자가 대문자라면
                for(char c='A'; c<='Z'; c++) {
                    if (divideWord == c) break;
                    a -= 2;
                }
            } else if (divideWord >= 97 && divideWord <= 122){
                // 해당 문자가 소문자라면
                for(char c='a'; c<='z'; c++) {
                    if (divideWord == c) break;
                    a -= 2;
                }
            } else {
                answer += divideWord;
                continue;
            }

            divideWord += a;
            answer += divideWord;
        }

        return answer;
    }
}
```

- 좀 드럽게(?) 짠 것 같아서 더 잘 짤 수 있는 방법을 연구해봐야겠다
- **반복문을 하나로 만들 수는 없을까?**

## 기능 요구 사항 5

### 알고리즘

- 배열 순서
    - 오만원권, 만원권, 오천원권, 천원권, 오백원, 백원, 오십원, 십원, 일원
    - 배열 크기 → 9
- 주어진 돈보다 더 큰 금액의 지폐가 나오면 skip
- **계산 결과로 나온 지폐의 갯수 * 계산했던 지폐 값**을 **빼줘야** 다음 값 계산이 가능하다

    ```java
    answer.add(money / moneys[i]);
    **money -= (money / moneys[i]) * moneys[i];**
    ```


### 발생한 오류

- Collections.emptyList()로 반환된 객체의 add 메소드를 호출하는 경우에는 UnsupportedOperationException이 발생
- 추가적인 데이터 수정을 하지 않는 경우에만 사용해야함
- [https://lucaskim.tistory.com/41](https://lucaskim.tistory.com/41)

### 필요한 개념

- Collections.emptyList()
    - static으로 이미 만들어진 객체 → CPU와 메모리에 추가 비용이 발생하지 않는다
    - final 불변 객체를 리턴한다 → 객체를 받아 값을 변경해야하는 등의 추가 작업이 있는 경우 new ArrayList()를 쓰는 것이 적합하다

### Code

```java
package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // List<Integer> answer = Collections.emptyList();
        List<Integer> answer = new ArrayList<>();
        int[] moneys = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

        for (int i=0; i<moneys.length; i++) {
            if (money < moneys[i]) {
                answer.add(0);
                continue;
            }

            answer.add(money / moneys[i]);
            money -= (money / moneys[i]) * moneys[i];
        }

        return answer;
    }
}
```

## 기능 요구 사항 6

### 문제

- 같은 글자가 연속적으로 포함될 경우 해당 닉네임 사용을 제한하려고 한다
- 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템
- 신청 닉네임 중 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 목록을 return

### 제한 사항

- **두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우** 중복으로 간주 → **두 글자 이상만 같으면 그 이상은 안 봐도 괜찮다**
- 이메일 도메인은 email.com으로만 제한한다. → **해당 문자열이 포함되어 있는지 검사해야한다.**
- 이메일 형식에 부합한다 → **도메인 검사 필요, 위에 제한 사항과 같이 검사**
- 전체 이메일의 길이는 **11자 이상 20자 미만**
- result는 이메일에 해당하는 부분의 **문자열을 오름차순으로 정렬**하고 **중복 제거**

### 필요한 개념

- List.of 역시 add가 불가능하다.
- List 문자열 오름차순 정렬  → Collections.sort()
- 문자열 중복 제거 → `!answer.contains(forms.get(k).get(0))`
- 문자열 포함 여부 확인 → contains 사용

### Code

```java
package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();
        String subString = "";

        for (int i=0; i<forms.size(); i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);

            if (!email.contains("@email.com")) continue;   // 이메일 형식에 부합하고 해당 도메인을 가지지 않으면 넘어간다.

            for (int j=0; j<name.length() - 1; j++) {
                subString = "" + name.charAt(j) + name.charAt(j+1);

                for (int k=0; k<forms.size(); k++) {
                    if (forms.get(k).get(1).equals(name)) continue;
                    if (forms.get(k).get(1).contains(subString) && !answer.contains(forms.get(k).get(0))) {
                        answer.add(forms.get(k).get(0));
                    }
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
```

## 기능 요구 사항 7

### 문제

- 사용자 아이디 user, 친구 관계 정보 friends, 사용자 타임라인 방문 기록 visitor
- 사용자와 함께 아는 친구의 수 10점
    - 사용자의 친구가 아닌 **친구의 친구**
    - 즉 이미 친구인 사람은 제외해야한다
- 사용자의 타임라인에 방문한 횟수 1점
- 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명 return
- 추천 점수가 0점인 경우 추천하지 않고, 추천 점수가 같은 경우는 이름순으로 정렬
    - 추천 점수가 0점이거나 null은 안됨
    - 동점인 경우 이름순 정렬은 오름차순으로 정리하면 해결될 것 같다.

→ 각 조건에 맞는 점수를 더해서 가장 높은 점수의 사람 이름을 출력!

### 제한 사항

- friends의 각 원소는 길이가 2인 리스트/배열로, [아이디A, 아이디B]
    - A와 B는 친구이다 → 해당 친구 리스트를 만들어 친구 목록 저장

### 알고리즘

- 친구 리스트 저장 → user와 함께 아는 경우 10점 추가
- 방문자를 저장하고, 카운트 증가 → 카운트만큼 점수 더하기

### 필요한 개념

- Map<key,value> → 해당 친구의 친구 리스트 저장
- HashMap 내림차순 정렬방법
    - [https://velog.io/@cgw0519/Java-HashMap-Value-기준으로-정렬하기](https://velog.io/@cgw0519/Java-HashMap-Value-%EA%B8%B0%EC%A4%80%EC%9C%BC%EB%A1%9C-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0)

### Code

```java
package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> saveUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        // 사용자의 친구 리스트 저장하기
        for (int i=0; i<friends.size(); i++) {
            if (friends.get(i).get(0).equals(user) && !userFriends.contains(friends.get(i).get(1))) {
                userFriends.add(friends.get(i).get(1));
            }

            if (friends.get(i).get(1).equals(user) && !userFriends.contains(friends.get(i).get(0))) {
                userFriends.add(friends.get(i).get(0));
            }
        }

        return userFriends;
    }

    public static HashMap<String, Integer> saveScoreByfriends(List<String> userFriends, List<List<String>> friends, String user) {
        HashMap<String, Integer> scores = new HashMap<>();

        // 친구 목록에서 사용자의 친구의 친구 찾기
        for (int i=0; i<userFriends.size(); i++) {
            String userFriendName = userFriends.get(i);
            for (int j=0; j<friends.size(); j++) {
                if (friends.get(j).contains(user)) continue;
                if (friends.get(j).get(0).equals(userFriendName) && !userFriends.contains(friends.get(j).get(1))) {
                    // 내 친구를 발견했고, 친구의 친구가 내 친구가 아니라면 저장한다.
                    Integer friendScore = scores.get(friends.get(j).get(1));
                    if (friendScore != null) {
                        friendScore += 10;
                        scores.put(friends.get(j).get(1), friendScore);
                    } else {
                        scores.put(friends.get(j).get(1), 10);
                    }
                }

                if (friends.get(j).get(1).equals(userFriendName) && !userFriends.contains(friends.get(j).get(0))) {
                    // 내 친구를 발견했고, 친구의 친구가 내 친구가 아니라면 저장한다.
                    Integer friendScore = scores.get(friends.get(j).get(0));
                    if (friendScore != null) {
                        friendScore += 10;
                        scores.put(friends.get(j).get(0), friendScore);
                    } else {
                        scores.put(friends.get(j).get(0), 10);
                    }
                }
            }
        }

        return scores;
    }

    public static HashMap<String, Integer> saveScoreByVisitor(List<String> visitors, List<String> userFriends, HashMap<String, Integer> scores) {
        // 사용자의 타임 라인에 방문한 횟수 저장
        for (int i=0; i<visitors.size(); i++) {
            if (userFriends.contains(visitors.get(i))) continue;
            Integer friendScore = scores.get(visitors.get(i));
            if (friendScore != null) {
                friendScore++;
                scores.put(visitors.get(i), friendScore);
            } else {
                scores.put(visitors.get(i), 1);
            }
        }
        return scores;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<>();
        List<String> userFriends;
        HashMap<String, Integer> scores;

        userFriends = saveUserFriends(user, friends);
        scores = saveScoreByfriends(userFriends, friends, user);
        scores = saveScoreByVisitor(visitors, userFriends, scores);

        // 내림차순으로 정렬하여 가장 큰 값부터 출력
        // 참고 사이트 https://velog.io/@cgw0519/Java-HashMap-Value-%EA%B8%B0%EC%A4%80%EC%9C%BC%EB%A1%9C-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(scores.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry : entryList){
            // System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
            answer.add(entry.getKey());
        }

       return answer;
    }
}
```