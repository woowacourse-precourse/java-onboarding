package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        Cryptogram crypto = new Cryptogram(cryptogram);
        doingZip(crypto);
        return crypto.getCryptogram();
    }

    private static void doingZip(Cryptogram crypto) {
        while (crypto.canZip()){
            crypto.zipCryptogram();
        }
    }

    static class Cryptogram{
        private String cryptogram;
        private final char REPLACE_CHAR = 0;

        public Cryptogram(String word) {
            if (Validator.isValidate(word)){
                setCryptogram(word);
            }
        }

        public boolean canZip(){
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (charAt(i) == charAt(i + 1)){
                    return true;
                }
            }
            return false;
        }

        public void zipCryptogram(){
            char[] cryCharArr = cryptogram.toCharArray();
            setRemoveChar(cryCharArr);
            this.cryptogram = getZippedString(cryCharArr);
        }

        private void setRemoveChar(char[] cryCharArr) {
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (charAt(i) == charAt(i + 1)){
                    cryCharArr[i] = REPLACE_CHAR;
                    cryCharArr[i + 1] = REPLACE_CHAR;
                }
            }
        }

        private String getZippedString(char[] cryCharArr) {
            String newString = "";
            for (char ch : cryCharArr){
                if (ch != REPLACE_CHAR){
                    newString += String.valueOf(ch);
                }
            }
            return newString;
        }

        public char charAt(int i){
            return cryptogram.charAt(i);
        }

        public String getCryptogram() {
            return cryptogram;
        }

        public void setCryptogram(String cryptogram) {
            this.cryptogram = cryptogram;
        }
    }

    static class Validator{

        public static boolean isValidate(String cryptogram){
            try {
                isCorrectSize(cryptogram);
                isOnlyLowerCase(cryptogram);
                return true;
            } catch (Exception error) {
                return false;
            }
        }

        private static void isCorrectSize(String str){
            if (str.length() < 1 || str.length() > 1000){
                throw new IllegalArgumentException("is not correct size");
            }
        }

        private static void isOnlyLowerCase(String str){
            String diff = str.toLowerCase();
            if (!str.equals(diff)){
                throw new IllegalArgumentException("is not only lower case");
            }
        }
    }
}

