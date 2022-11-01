package onboarding;
import java.util.ArrayList;
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int temp;
        ArrayList<Integer> array = new ArrayList<>();

        for(int i = 1; i<=number; i++){
                temp = i;
                while(temp > 0){
                    if((temp % 10) % 3 == 0){
                        if((temp % 10) != 0)
                        answer += 1;
                    }
                    temp /= 10;
                }
        }
        return answer;
    }
}
