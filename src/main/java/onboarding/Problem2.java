package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "";
        cryptogram='A'+cryptogram;

        boolean flag = true;

        while(flag) {
            Character before = cryptogram.charAt(0);
            boolean overLap=false;
            for (int i = 1; i < cryptogram.length(); i++) {

                if (cryptogram.charAt(i) == before) {
                    overLap = true;
                    continue;
                }
                else{
                    if(overLap){

                        answer = answer.substring(0, answer.length() - 1);

                        overLap=false;
                    }
                    before = cryptogram.charAt(i);
                    answer+=cryptogram.charAt(i);
                }

            }
            if(overLap){
                answer = answer.substring(0, answer.length() - 1);
            }

            if(cryptogram.equals('A'+answer)){
                flag = false;
            }
            else{
                cryptogram = 'A'+answer;
                answer = "";
            }
        }
        return answer;

    }
}
