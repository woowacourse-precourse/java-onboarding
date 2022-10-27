package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        Problem2 problem = new Problem2;
        String answer = "answer";

        return answer;
    }

    public String delDupliChar(String cryptogram) {
        String[] splitstring = cryptogram.split("");
        String result = "";

        for(int i=0; i<splitstring.length-1; i++) {
            if(splitstring[i].equals(splitstring[i+1])) {
                splitstring[i] = "";
                splitstring[i+1] = "";
            }
        }

        for(int i=0; i< splitstring.length; i++) {
            result = result.concat(splitstring[i]);
        }

        return result;
    }
}
