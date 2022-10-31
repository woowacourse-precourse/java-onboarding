package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<number+1; i++)
        {
            String str_num = Integer.toString(i); // int to String
            for(int j=0; j<str_num.length(); j++) // 숫자에 3,6,9 갯수에 따라 count
            {
                int num = Character.getNumericValue(str_num.charAt(j));
                if(num % 3 == 0 && num != 0) answer += 1; // 각 숫자 3,6,9 비교
            }
        }
        return answer;
    }
}
