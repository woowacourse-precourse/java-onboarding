package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    static String TAG = Problem1.class.getName();
    public static void MY_LOG(String tag, int logline) {
        System.out.println(String.format("%s : %d", tag, logline));
    }
    public static int GET_ADD(int num){
        int result = 0;
        String N_to_S = String.valueOf(num);
        int[] Number = new int[N_to_S.length()];

        for(int i = 0; i < N_to_S.length(); i++){
            char One_num = N_to_S.charAt(N_to_S.length() - i - 1);
            Number[i] = Character.getNumericValue(One_num);
        }
        for (int i = 0; i < Number.length; i++){
            result += Number[i];
        }
        return result;
    }

    public static int GET_MUL(int num){
        int result = 1;
        String N_to_S = String.valueOf(num);
        int[] Number = new int[N_to_S.length()];

        for(int i = 0; i < N_to_S.length(); i++){
            char One_num = N_to_S.charAt(N_to_S.length() - i - 1);
            Number[i] = Character.getNumericValue(One_num);
        }
        for (int i = 0; i < Number.length; i++){
            result *= Number[i];
        }
        return result;
    }
    public static int GET_MAX(int a, int b, int c, int d){
        int i[] = {a, b, c, d};
        Arrays.sort(i);
        for (int i1 = 0; i1 < 4; i1++){
            MY_LOG(TAG, i[i1]);
        }
        return i[3];
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if((pobi.get(0)+1 != pobi.get(1)) || (crong.get(0)+1 != crong.get(1))){
            answer = -1;
            return answer;
        }
        if((pobi.get(1) >= 400) || (pobi.get(0) <= 1)){
            answer = -1;
            return answer;
        }
        if((crong.get(1) >= 400) || (crong.get(0) <= 1)){
            answer = -1;
            return answer;
        }

        int pobi_score = GET_MAX(GET_ADD(pobi.get(0)), GET_ADD(pobi.get(1)),GET_MUL(pobi.get(0)),GET_MUL(pobi.get(1)));
        int crong_score = GET_MAX(GET_ADD(crong.get(0)), GET_ADD(crong.get(1)),GET_MUL(crong.get(0)),GET_MUL(crong.get(1)));

        if(pobi_score > crong_score){
            answer = 1;
        } else if(pobi_score < crong_score){
            answer = 2;
        } else if(pobi_score == crong_score){
            answer = 0;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}