package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (number >= 1 && number <= 10000)
            answer = checkNum(number);
        return answer;
    }

    public static int checkDuplicaion(String strNum)
    {
        int duplicaionCnt = 0;

        for (int i = 0; i < strNum.length(); i++)
        {
            if (strNum.charAt(i) == '3' || strNum.charAt(i) == '6' || strNum.charAt(i) == '9')
            {
                duplicaionCnt++;
            }
        }
        return duplicaionCnt - 1;
    }
    public static int checkNum(int number)
    {
        String strNum = null;
        int cnt = 0;

        for (int i = 1; i <= number; i++)
        {
            strNum = Integer.toString(i);
            if (strNum.contains("3") || strNum.contains("6") || strNum.contains("9"))
            {
                cnt += checkDuplicaion(strNum) + 1;
            }
        }
        return cnt ;
    }
}
