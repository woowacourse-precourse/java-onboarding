package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return count_clab(number);
    }

    static int count_clab(int num)
    {
        int i = 0;
        int count = 0;
        while(true)
        {
            if(i > num)
                break;
            count = count + count_three_six_nine(i);
            i ++;
        }
        return count;
    }
    static int count_three_six_nine(int i)
    {
        int count = 0;
        while(true)
        {
            if(i == 0)
                break;
            int tmp_digit = i % 10;
            if(tmp_digit == 3 || tmp_digit == 6 || tmp_digit == 9)
                count ++;
            i = i / 10;
        }
        return count;
    }
}
