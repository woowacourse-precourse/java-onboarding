package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        char [] chars = cryptogram.toCharArray();
        char prev;
        char next;
        String a = "";
        StringBuilder b = new StringBuilder();
        int count = 0;

        while (count != cryptogram.length()){
            for(int i = 0; i<cryptogram.length()-1; i++){
                chars = cryptogram.toCharArray();
                prev = chars[i];
                next = chars[i+1];
                if(prev == next){
                    b.append(prev);
                    b.append(next);
                    a = b.toString();
                    cryptogram = cryptogram.replaceFirst(a,"");
                    b.setLength(0);
                    i = 0;
                    count++;
                    if(cryptogram.equals("")){
                        return cryptogram;
                    }
                }

            }
        }
        //하나로 치환

        return cryptogram;
    }









}
