package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean duplicate;
        int start;
        int end;
        String substr1 = "";
        String substr2 = "";

        while(true){
            duplicate = false;
            for(int i = 0; i < cryptogram.length() - 1; i++){
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                    duplicate = true;
                    start = i;
                    substr1 = cryptogram.substring(0, start);
                    end = i + 1;
                    if (end + 1 < cryptogram.length()){
                        for(int j = i + 1; j < cryptogram.length(); j++){
                            if(cryptogram.charAt(j) != cryptogram.charAt(j + 1)) {
                                end = j;
                                break;
                            }
                        }
                        substr2 = cryptogram.substring(end + 1);
                    }
                    else
                        substr2 = "";

                    cryptogram = substr1 + substr2;
                    if(start > 0)
                        i = start - 1;
                    else
                        i = 0;
                }
            }
            if (duplicate == false)
                break;
        }
        answer = cryptogram;
        return answer;
    }
}