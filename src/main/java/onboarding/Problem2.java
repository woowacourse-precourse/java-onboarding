package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        while (!cryptogram.equals(decrypt(cryptogram))) {
            cryptogram = decrypt(cryptogram);
        }
        return cryptogram;
    }

    private static String decrypt(String cryptogram) {

        StringBuilder sb = new StringBuilder();

        if (cryptogram.isEmpty())
            return "";

        for(int i = 0; i < cryptogram.length()-1; i++){
            if(cryptogram.charAt(i) != cryptogram.charAt(i+1))
                sb.append(cryptogram.charAt(i));
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1))
                i++;
        }
        if(cryptogram.charAt(cryptogram.length()-2) != cryptogram.charAt(cryptogram.length()-1)){
            sb.append(cryptogram.charAt(cryptogram.length()-1));
        }

        return sb.toString();
    }
}