package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    public static String decrypt(String crpytogram) {
        StringBuilder newString = new StringBuilder();
        boolean check;
        do {
            if (crpytogram.length() == 0) break;
            newString.append(crpytogram.charAt(0));
            int start = 0;
            int end = 0;
            check = false;
            for (int i = 0; i < crpytogram.length(); i++) {
                end += 1;
                int length = newString.length();
                if (end < crpytogram.length()) {
                    if (crpytogram.charAt(start) != crpytogram.charAt(end)) {
                        start = end;
                        newString.append(crpytogram.charAt(end));
                    } else if (length > 0) {
                        check = true;
                        if(newString.charAt(newString.length() - 1) == crpytogram.charAt(end)){
                            newString.deleteCharAt(newString.length() - 1);
                        }
                    }
                }
            }
            crpytogram = String.valueOf(newString);
            newString.delete(0,newString.length());
        } while (check);
        return crpytogram;
    }
}
