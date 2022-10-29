package onboarding;

public class Problem2 {
    static class RFCryptogram {

        StringBuilder cryptogramToBuilder;
        int cryptogramLength;
        static int checkNum;
        boolean flag;

        RFCryptogram(String cryptogram) {
            cryptogramToBuilder = new StringBuilder(cryptogram);
            checkNum = 1;
            flag = false;
        }

        private void calculatorLength() {
            cryptogramLength = cryptogramToBuilder.length();
        }

        private Integer[] makingCheckList () {
            Integer[] checkString = new Integer[cryptogramLength];
            for (int i = 0; i < cryptogramLength; i++) {
                checkString[i] = 0;
            }

            return checkString;
        }

        private boolean findDupString(Integer[] checkString) {
            for (int i = cryptogramLength - 1; i > 0; i--) {
                if (cryptogramToBuilder.charAt(i) == cryptogramToBuilder.charAt(i - 1)) {
                    checkString[i] = checkNum;
                    checkString[i - 1] = checkNum;
                    flag = true;
                }
            } if (flag) {
                flag = false;
                return true;
            } return false;
        }

        private void deleteString(Integer[] checkString) {
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
            rfCryptogram.calculatorLength();
            Integer[] checkList = rfCryptogram.makingCheckList();
            if (!rfCryptogram.findDupString(checkList)) {
                break;
            }
            rfCryptogram.deleteString(checkList);
        } while(true);

        return rfCryptogram.cryptogramToBuilder.toString();
    }
}
