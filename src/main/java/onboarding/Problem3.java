package onboarding;

public class Problem3 {
    /*
    주어진 숫자를 문자열로 바꾸어 각 자릿수를 순회하며 3, 6, 9가 포함됐는지, 됐다면 얼마나 됐는지 여부를 카운트하는 메서드를 활용해서 문제를 풀었습니다.
    */
    static int cnt369(int num) {
        char[] strNum = String.valueOf(num).toCharArray();
        int numLen = strNum.length;
        int count = 0;
        for (int i = 0; i < numLen; i++)
            if ((strNum[i] == '3') || (strNum[i] == '6') || (strNum[i] == '9'))
                count += 1;
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += cnt369(i);
        }
        return answer;
    }
}
