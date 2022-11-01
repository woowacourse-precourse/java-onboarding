package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;

        Cryptogram crypto = new Cryptogram(cryptogram);

        int initLength = crypto.getCryptogramLength();
        crypto.removeDuplication();

        while(initLength != crypto.getCryptogramLength()){

            initLength = crypto.getCryptogramLength();
            crypto.removeDuplication();
        }

        answer = crypto.getCryptogram();
        return answer;
    }

    static class Cryptogram{
        private final static int MIN_CRYPTOGRAM_LENGTH = 1;
        private final static int MAX_CRYPTOGRAM_LENGTH = 1000;

        private String cryptogram;

        public String getCryptogram() {
            return cryptogram;
        }

        public int getCryptogramLength() {
            return cryptogramLength;
        }

        private int cryptogramLength;

        public Cryptogram(String cryptogram){
            validateCryptogramLength(cryptogram);
            validateCryptogramLowerCase(cryptogram);

            this.cryptogram = cryptogram;
            this.cryptogramLength = cryptogram.length();
        }

        public void validateCryptogramLength(String cryptogram){
            int cryptogramLength = cryptogram.length();
            if(cryptogramLength < MIN_CRYPTOGRAM_LENGTH ||
                    cryptogramLength > MAX_CRYPTOGRAM_LENGTH){
                throw new IllegalArgumentException("cryptogram은 길이가 1 이상 1000 이하인 문자열이어야 합니다.");
            }
        }

        public void validateCryptogramLowerCase(String cryptogram){
            for(int i = 0; i < cryptogram.length(); i++){
                char c = cryptogram.charAt(i);
                if(Character.isUpperCase(c)){
                    throw new IllegalArgumentException("cryptogram은 알파벳 소문자로만 이루어져 있다.");
                }
            }
        }

        public void removeDuplication(){
            String newCryptogram = "";
            char prev = ' ';

            boolean check = false;

            int idx = 0;
            while(idx < this.cryptogramLength){

                if(prev != this.cryptogram.charAt(idx)){
                    newCryptogram += String.valueOf(prev);
                    prev = this.cryptogram.charAt(idx);

                }else{

                    idx++;
                    if(idx < this.cryptogramLength) {
                        prev = this.cryptogram.charAt(idx);

                    }else{
                        check = true;
                    }
                }

                idx++;
            }

            if(!check) {
                newCryptogram += String.valueOf(prev);
            }

            this.cryptogram = newCryptogram.substring(1);
            this.cryptogramLength = cryptogram.length();
        }
    }
}
