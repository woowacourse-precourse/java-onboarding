package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        Problem2 problem = new Problem2();

        String firstcopy = "";
        String secondcopy = cryptogram;
        String answer = "answer";

        while(true) {
            firstcopy = problem.delDupliChar(secondcopy);
            secondcopy = problem.delDupliChar(firstcopy);

            if (firstcopy.equals(secondcopy)) {
                answer = secondcopy;
                break;
            }
        }

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
