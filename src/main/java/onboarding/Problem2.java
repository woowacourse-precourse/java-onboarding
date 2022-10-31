package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "answer";

        answer = check(cryptogram);

        return answer;
    }

    public static String check(String cryptogram) {

        String answer = remove(cryptogram);

        if (answer.equals("0")) {

            answer = cryptogram;

        }

        while (!remove(answer).equals("0")) {

            answer = remove(answer);

        }

        return answer;
    }

    public static String remove(String cryptogram){

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
