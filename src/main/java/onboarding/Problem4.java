package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQURTUVWXYZ";
        String lowerFrog = "zyxwvutsrqponmlkjihgfedcba";
        String upperFrog = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

        for(int i = 0; i < word.length();i++)
        {
            for(int j = 0; j < lower.length(); j++)
            {
                if(word.substring(i,i+1).equals(lower.substring(j,j+1)))
                {
                    answer += lowerFrog.substring(j,j+1);
                }
                else if(word.substring(i,i+1).equals(upper.substring(j,j+1)))
                {
                    answer += upperFrog.substring(j,j+1);
                }
                else if(word.substring(i,i+1).equals(" "))
                {
                    answer += " ";
                    break;
                }
            }
        }
        return answer;
    }
}
