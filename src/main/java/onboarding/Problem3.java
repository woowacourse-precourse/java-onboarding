package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer;
        int num_len;

        if(number > 1000000){
            answer = -1;
            return answer;
        }

        // calculate given number's digit
        num_len = (int)Math.log10(number)+1;

        answer = game_369(num_len, number);
        return answer;
    }

    // Count sequentially from the first digit
    private static int game_369(int num_len, int number) {
        int res = 0;
        int digit_num;
        int digit_1 = 3;
        int digit_2 = 60;
        int digit_3 = 900;
        int digit_4 = 12000;

        if(num_len > 0) {
            digit_num = number%10;
            res += digit_num/3;
        }

        if(num_len > 1) {
            digit_num = (number%100 - number%10)/10;
            if(digit_num == 0) {}
            else if(digit_num%3 == 0) res += digit_num*digit_1 + (digit_num/3-1)*10 + number%10+1;
            else res += digit_num*digit_1 + (digit_num/3)*10;
        }

        if(num_len > 2) {
            digit_num = (number%1000 - number%100)/100;
            if(digit_num == 0) {}
            else if(digit_num%3 == 0) res += digit_num*digit_2 + (digit_num/3-1)*100 + number%100+1;
            else res += digit_num*digit_2 + (digit_num/3)*100;
        }

        if(num_len > 3) {
            digit_num = (number%10000 - number%1000)/1000;
            if(digit_num == 0) {}
            else if(digit_num%3 == 0) res += digit_num*digit_3 + (digit_num/3-1)*1000 + number%1000+1;
            else res += digit_num*digit_3 + (digit_num/3)*1000;
        }

        if(num_len > 4) {
            digit_num = (number%100000 - number%10000)/10000;
            if(digit_num == 0) {}
            else if(digit_num%3 == 0) res += digit_num*digit_4 + (digit_num/3-1)*10000 + number%10000+1;
            else res += digit_num*digit_4 + (digit_num/3)*10000;
        }

        return res;
    }
}
