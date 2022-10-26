package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer = checkNum(number);
        return answer;
    }

    public static int checkDuplicaion(String strNum)
    {
        int check = 30;
        int duplicaionCnt = 0;
        
        if (Integer.parseInt(strNum) >= check)
        {
            for (int i = check; i < strNum.length(); i++)
            {
                if (strNum.charAt(i) == '3' || strNum.charAt(i) == '6' || strNum.charAt(i) == '9')
                    duplicaionCnt++;
            }
        }
        return duplicaionCnt;
    }
    public static int checkNum(int number)
    {
        String strNum = null;
        int cnt = 0;

        for (int i = 1; i <= number; i++)
        {
            strNum = Integer.toString(i);
            if (strNum.contains("3") || strNum.contains("6") || strNum.contains("9"))
                cnt++;
        }
        cnt += checkDuplicaion(strNum);
        return cnt ;
    }
}
