package onboarding.p2;

public class DuplicateStringDecrypt implements StringDecrypt{
    // 주어진 문자를 해독하여 반환
    public String getDecryptString(final String cryptogram) {
        if (cryptogram == null || cryptogram.isBlank()) {
            return null;
        }
        if (cryptogram.length() == 1) {
            return cryptogram;
        }

        boolean isDuplicate = isDuplicate(cryptogram);
        String decryptString = cryptogram;

        while (isDuplicate) {
            decryptString = rmDuplicateCharacters(decryptString);
            isDuplicate = isDuplicate(decryptString);
        }
        return decryptString;
    }

    // 중복 문자를 제외한 문자열을 반환
    private String rmDuplicateCharacters(String str) {
        StringBuilder result = new StringBuilder();
        char dup = 0;

        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if (i == str.length() - 1) {
                if (c != str.charAt(i - 1)) {
                    result.append(c);
                }
            } else {
                if (c != str.charAt(i+1) && c != dup) {
                    result.append(c);
                    dup = 0;
                } else {
                    dup = c;
                }
            }
        }

        return result.toString();
    }

    // 주어진 문자열에 중복 문자가 있는지 판별
    private boolean isDuplicate(String str){
        if (str.isBlank()) {
            return false;
        }
        for (int i = 0; i < str.length() - 1; i++){
            if (str.charAt(i) == str.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }
}
