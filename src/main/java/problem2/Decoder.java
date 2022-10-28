package problem2;

public class Decoder {
    private String cryptogram;

    public Decoder(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String decode() {
        String now = eliminateDuplication(cryptogram);
        if (now.equals(""))
            return "";
        String next = eliminateDuplication(now);

        while (isContinue(now, next)) {
            now = next;
            next = eliminateDuplication(now);
        }
        return next;
    }

    private boolean isContinue(String now, String next) {
        return !next.equals("") && !now.equals(next);
    }

    private String eliminateDuplication(String cryptogram) {
        StringBuilder decryption = new StringBuilder(cryptogram);
        handleLastProcess(decryption, handleMidProcess(decryption));

        return removeSpace(decryption);
    }

    private String removeSpace(StringBuilder decryption) {
        return decryption.toString().replace(" ", "");
    }

    private int handleMidProcess(StringBuilder decryption) {
        char now = decryption.charAt(0);
        int start = -1;

        for (int i = 1; i < decryption.length(); i++) {
            char next = decryption.charAt(i);
            start = getFirst(isSame(now, next), start, i);
            start = convertSpace(decryption, !isSame(now, next), new RangeDto(start, i));

            now = next;
        }
        return start;
    }

    private int convertSpace(StringBuilder decryption, boolean different, RangeDto rangeDto) {
        int start = rangeDto.getStart();
        int end = rangeDto.getEnd();

        if (isLast(different, start)) {
            decryption.replace(start, end, getSpace(end - start));
            start = -1;
        }
        return start;
    }

    private boolean isLast(boolean different, int start) {
        return different && start != -1;
    }

    private int getFirst(boolean same, int start, int index) {
        if (same && isFirst(start)) {
            start = index - 1;
        }
        return start;
    }

    private boolean isFirst(int start) {
        return start == -1;
    }

    private boolean isSame(char now, char next) {
        return now == next;
    }

    private void handleLastProcess(StringBuilder decryption, int start) {
        if (start != -1){
            int end = decryption.length();
            decryption.replace(start, end, getSpace(end - start));
        }
    }

    private String getSpace(int cnt) {
        StringBuilder space = new StringBuilder();
        for (int j = 0; j < cnt; j++) {
            space.append(" ");
        }
        return space.toString();
    }
}
