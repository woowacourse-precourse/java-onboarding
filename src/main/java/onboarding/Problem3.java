package onboarding;

public class Problem3 {
    public static int COUNT_3(int num){
        int result = 0;
        String N_to_S = String.valueOf(num);
        int[] Number = new int[N_to_S.length()];

        for(int i = 0; i < N_to_S.length(); i++){
            char One_num = N_to_S.charAt(N_to_S.length() - i - 1);
            Number[i] = Character.getNumericValue(One_num);
        }

        for (int i = 0; i < Number.length; i++){
            if((Number[i] == 3) || (Number[i] == 6) || (Number[i] == 9)){
                result += 1;
            }

        }
        return result;

    }
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++){
            answer += COUNT_3(i);
        }
        return answer;
    }
}
