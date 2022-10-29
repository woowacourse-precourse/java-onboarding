package onboarding;

public class Problem2 {
    static class RFCryptogram {

        StringBuilder cryptogramToBuilder;
        int cryptogramLength;
        Integer[] checkString;
        static int checkNum;
        boolean flag;

        RFCryptogram(String cryptogram) {
            cryptogramToBuilder = new StringBuilder(cryptogram);
            cryptogramLength = cryptogramToBuilder.length();
            checkNum = 1;
            flag = false;
        }

        private void makingCheckList () {
            checkString = new Integer[cryptogramLength];
            for (int i = 0; i < cryptogramLength; i++) {
                checkString[i] = 0;
            }
        }

        private void findDupString() {
            for (int i = cryptogramLength - 1; i > 0; i--) {
                if (cryptogramToBuilder.charAt(i) == cryptogramToBuilder.charAt(i - 1)) {
                    checkString[i] = checkNum;
                    checkString[i - 1] = checkNum;
                    flag = true;
                }
            }
        }

        private void deleteString() {
            for (int i = cryptogramLength - 1; i>= 0; i--) {
                isDuplicate(checkString[i], i);
            }
        }

        private void isDuplicate(int checkStringIdx, int i) {
            if (checkStringIdx > 0) {
                cryptogramToBuilder.deleteCharAt(i);
            }
        }
    }

    public static String solution(String cryptogram) {

        RFCryptogram rfCryptogram = new RFCryptogram(cryptogram);

        do {
            rfCryptogram.makingCheckList();
            rfCryptogram.findDupString();
            rfCryptogram.deleteString();

        } while (rfCryptogram.flag);

        return rfCryptogram.cryptogramToBuilder.toString();
    }
}
