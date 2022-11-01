package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int ascUp[][] = {{97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122},
                {122,121,120,119,118,117,116,115,114,113,112,111,110,109,108,107,106,105,104,103,102,101,100,99,98,97}};
        int ascLow[][] ={{65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90},
                {90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65}};
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ' '){
                answer += " ";
                continue;
            }
            char tmp = word.charAt(i);
            int change = 0;
            int n = (int)tmp;
            for(int j = 0; j < ascUp[0].length; j++){
                if(ascUp[0][j] == n){
                    answer += (char) ascUp[1][j];
                    break;
                }
            }
            for(int j = 0; j < ascLow[0].length; j++){
                if(ascLow[0][j] == n){
                    answer += (char) ascLow[1][j];
                    break;
                }
            }
        }
        return answer;
    }
}
