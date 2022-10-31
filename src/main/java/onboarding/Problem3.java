package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = countNum(stringNum(number));
        return answer;
    }

    public static String stringNum(int num) {
        String strnum = "";
        for (int i=1;i<num+1;++i) {
            strnum = strnum + i;
        }
        return strnum;
    }

    public static int countNum(String Num) {
        int count = 0;
        int lenNum = Num.length();
        for (int i=0;i<lenNum;++i) {
            if (Num.charAt(i) == '3' || Num.charAt(i) == '6' || Num.charAt(i) == '9')
                count++;
        }
        return count;
    }
}
