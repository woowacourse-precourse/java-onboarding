package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = cryptogram;

        boolean loop = true;

        while(loop){
            String tempString = "";
            loop = false;
            for(int i=0;i<answer.length(); i++){
                if(i != answer.length() - 1){
                    if(answer.charAt(i) == answer.charAt(i+1)){
                        loop = true;
                        i++;
                    }
                    else{
                        tempString += answer.charAt(i);
                    }
                }

                else{
                    tempString += answer.charAt(i);
                }
            }
            answer = tempString;

        }

        return answer;
    }
}
