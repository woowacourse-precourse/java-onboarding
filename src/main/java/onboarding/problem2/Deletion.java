package onboarding.problem2;

public class Deletion {
    public static String executeDeletion(String cryptogram) {
        int index = 0;

        while (isAbleComparison(cryptogram, index) && isExistDuplication(cryptogram)) {
            index %= (cryptogram.length() - 1);

            DeleteResult deleteResult = deleteDuplication(cryptogram, index);

            cryptogram = deleteResult.cryptogram;
            index += deleteResult.index;
        }

        if (cryptogram.length() == 2 && (cryptogram.charAt(0) == cryptogram.charAt(1))) {
            cryptogram = "";
        }

        return cryptogram;
    }

    private static boolean isAbleComparison(String cryptogram, int index) {
        return cryptogram.length() > 2 && index >= 0;
    }

    private static boolean isExistDuplication(String cryptogram) {
        int index = 0;
        boolean result = false;

        while (index < cryptogram.length() - 1) {
            result = (result || (cryptogram.charAt(index) == cryptogram.charAt(index + 1)));
            index++;
        }

        return result;
    }

    private static DeleteResult deleteDuplication(String cryptogram, int index) {
        String originalCryptogram = cryptogram;
        int duplicateIndex = index;

        while ((index < cryptogram.length()) &&
                (cryptogram.charAt(index) == cryptogram.charAt(duplicateIndex + 1))) {
            duplicateIndex++;
        }

        if (duplicateIndex != index) {
            cryptogram = cryptogram.substring(0, index) + cryptogram.substring(duplicateIndex + 1);
            return new DeleteResult(cryptogram, 0);
        }

        return new DeleteResult(originalCryptogram, 1);
    }

    private static class DeleteResult {
        private String cryptogram;
        private int index;

        public DeleteResult(String cryptogram, int index) {
            this.cryptogram = cryptogram;
            this.index = index;
        }
    }
}