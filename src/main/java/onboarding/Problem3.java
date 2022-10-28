package onboarding;
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        int num = 1;
        while(num <= number) {
        	char[] num_arr = String.valueOf(num).toCharArray();

        	for(int i = 0; i < num_arr.length; i++) {
        		if(num_arr[i] == '3') answer++;
        		if(num_arr[i] == '6') answer++;
        		if(num_arr[i] == '9') answer++;
        	}
        	num++;
        }

        return answer;
    }
}