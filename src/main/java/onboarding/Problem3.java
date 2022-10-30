package onboarding;
import java.util.Arrays;
public class Problem3 {
    public static int findNumberThree(int number) {
        int count = 0;
        String[] stringToSearch = new String[]{"3", "6", "9"};

        for(int i = 1; i <= number; i++) {
            String str = String.valueOf(i);
            String[] list = str.split("");
            for(int j = 0; j < list.length; j++) {
                if(list[j].equals("3") || list[j].equals("6") || list[j].equals("9")) {
                    count++;
                }
            }
        };
        return count;
    };
    public static int solution(int number) {
        int answer = 0;
        answer = findNumberThree(number);
        return answer;
    }
}
