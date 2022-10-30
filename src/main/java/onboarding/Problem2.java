package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        if(overlapRemove(cryptogram).equals("0")){
            answer =cryptogram;
        }
        if (!overlapRemove(cryptogram).equals("0")){
            answer = overlapRemove(cryptogram);
        }

        while (!overlapRemove(answer).equals("0")) {
            if (!overlapRemove(answer).equals("0")) {
                answer = overlapRemove(answer);
            }

        }

        return answer;
    }
    public static String overlapRemove(String cryptogram){
        String [] letter = cryptogram.split("");
        StringBuilder answer = new StringBuilder();
        int num = 0;
        for(int i = 0; i<letter.length-1 ; i++){
            if(letter[i].equals(letter[i+1])){
                letter[i]= "";
                letter[i+1]= "";
                num++;
            }
            if(!letter[i].equals(letter[i+1])){
                answer.append(letter[i]);
            }
            if(i == letter.length-2){
                answer.append(letter[i + 1]);
            }
        }

        if(num==0){
            answer = new StringBuilder("0");
        }

        return answer.toString();
    }
}
