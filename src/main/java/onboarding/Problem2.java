package onboarding;

public class Problem2 {
    public static String deleteDup(String cryptogram){
        for(int i=0; i<cryptogram.length()-1; i++){
            String twoChar = cryptogram.substring(i,i+2);

            StringBuffer sb = new StringBuffer(twoChar);
            String reversedtwoChar = sb.reverse().toString();

            if(twoChar.equals(reversedtwoChar)) {
                return cryptogram.substring(0,i) + cryptogram.substring(i+2,cryptogram.length());
            }
        }
        return cryptogram;
    }
    public static String solution(String cryptogram) {
        if(cryptogram.length()<2){
            return cryptogram;
        }

        String answer = deleteDup(cryptogram);

        while(answer != deleteDup(answer)){
            answer = deleteDup(answer);
        }
        return answer;
    }
}
