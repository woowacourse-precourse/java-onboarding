package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number+1; i++) {
            String strNumber = Integer.toString(i);

            if (strNumber.contains("3") || strNumber.contains("6") || strNumber.contains("9")) {
                String[] strNum = strNumber.split("");
            }
        }
        return answer;
    }
}

// 13	4
// 33	14

// 입력 값까지 for문 진행
// 수를 Strgin형태로 변환 후 3,6,9를 포함하였다면 문자열 배열로 변환
// 배열의 길이만큼 반복문을 진행하며 3,6,9를 포함하였는지 판별
// -> 포함하였다면 answer += 1
// answer 값 출력