/*
기능목록
i) checkRedupl -> 중복 문자가 있는지 확인하며 중복 문자가 있는 index를 반환한다.
ii) reduceRedupl -> 입력받은 문자열에서 같이 입력받은 index에 해당하는 문자룰 없애준다
iii) solution -> i) ii) 기능을 적절히 이용하여 답을 반환한다.
 */


package onboarding;

public class Problem2 {

    int[] checkRedupl(String cryptogram) {
        int[] temp_array = new int[cryptogram.length()];

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                temp_array[i] = 1;
                temp_array[i+1] = 1;
            }
        }

        return temp_array;
    }


    public static String solution(String cryptogram) {

        Problem2 agent = new Problem2();
        String answer = cryptogram;


        for (int i = 0; i < 10; i++){
            int[] indexarray = agent.checkRedupl(answer);
            answer = agent.reduceRedupl(answer, indexarray);
        }

        return answer;
    }
}
