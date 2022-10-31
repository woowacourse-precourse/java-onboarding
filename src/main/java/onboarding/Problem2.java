package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (!answer.equals(checkStr(answer))){
            answer = checkStr(answer);
        }
        return answer;
    }

    static String checkStr(String a){
        for (int i =0; i < a.length()-1;i++){
            if (a.charAt(i) == a.charAt(i+1)){
                if (i==0){
                    if (a.length()==2){
                        a= "";
                        return a;
                    }else {
                        a = a.substring(2);
                        return a;
                    }
                }
                else {
                    a= a.substring(0,i) +a.substring(i+2);
                    return a;
                }
            }
        }
        return a;
    }
}