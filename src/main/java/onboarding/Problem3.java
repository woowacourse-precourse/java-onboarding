package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = countNumber(number);
        return answer;
    }
    public static int countNumber(int number) {
        int count = 0; // clap's total count

        for(int n = 1; n < number+1; n++) {
            String stringNum = Integer.toString(n);
            String[] numArr = stringNum.split("");

            for(int i = 0; i < numArr.length; i++) {
                if(numArr[i].contains("3") || numArr[i].contains("6") || numArr[i].contains("9")) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
