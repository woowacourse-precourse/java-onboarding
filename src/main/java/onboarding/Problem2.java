package onboarding;

public class Problem2 {

    public boolean validation(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return false;
        } else if (!cryptogram.equals(cryptogram.toLowerCase())) {
            return false;
        } else {
            return true;
        }
    }

    public static int countDuplicatedNeighbor(char[] cryptogram, int start) {
        int cnt = 1;
        for (int i = start; i < cryptogram.length - 1; i++) {
            if (cryptogram[i] == cryptogram[i+1]){
                cnt++;
            }
            else{
                break;
            }
        }
        return cnt;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        char[] charArr = cryptogram.toCharArray();


        return answer;
    }
}
