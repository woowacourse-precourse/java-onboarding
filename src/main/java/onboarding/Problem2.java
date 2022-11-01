package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int foundDuplicate=0;

        do {
            foundDuplicate=0;
            for (int i = 0; i < cryptogram.length()-1; i++) {
                if (cryptogram.charAt(i) != cryptogram.charAt(i + 1)) continue;

                foundDuplicate++;
                String tmp = cryptogram.substring(0,i);
                tmp=tmp.concat(cryptogram.substring(i + 2));
                cryptogram = tmp;

                i--;
            }
        }while(foundDuplicate!=0);
        answer=cryptogram;

        return answer;
    }

}
