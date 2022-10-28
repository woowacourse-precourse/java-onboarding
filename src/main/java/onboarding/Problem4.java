package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char [] wordMap = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N',	'M', 'L', 'K',
                'J','I','H','G','F','E','D','C', 'B', 'A'};

        String answer = "";

        for(String wo:word.split("")){
            if(!wo.matches("[a-zA-Z]")){
                answer += wo;
                continue;
            }
            int key = wo.toUpperCase().charAt(0)-'A';

            if(wo.equals(wo.toUpperCase()))
                answer+= wordMap[key];
        }
        return answer;
    }
}
