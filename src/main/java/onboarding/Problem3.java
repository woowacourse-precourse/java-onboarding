package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String number_str = "";

        for(int i = 1; i <= number; i++){
            number_str += i;
        }

        for(int i = 0; i < number_str.length(); i++){
            String number_i = number_str.substring(i, i+1);
            if(number_i.equals("3") || number_i.equals("6") || number_i.equals("9")){
                answer++;
            }
        }

        return answer;
    }
}
