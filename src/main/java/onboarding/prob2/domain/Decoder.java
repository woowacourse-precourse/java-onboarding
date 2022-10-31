package onboarding.prob2.domain;

public class Decoder {

    public String decode(String password) {
        int length = password.length();
        if (isLengthOne(length)) return password;
        return eraseSameWord(password);
    }

     private boolean isLengthOne(int length) {
        return length == 1;
    }

    final String eraseSameWord(String password) {
        int prev = 0;
        for (int post = 1; post < password.length(); post++) {
            String processedPassword = eraseIfSame(password, prev, post);
            if (!processedPassword.equals(password)) {
                return processedPassword;
            }
            prev = post;
        }
        return password;
    }

    final String eraseIfSame(String password, int prev, int post) {
        if (isSameChar(password, prev, post)) {
            int idx = getLastPosition(prev, password);
            return password.substring(0, prev) + password.substring(idx + 1);
        }
        return password;
    }

    private boolean isSameChar(String password, int prev, int post) {
        return password.charAt(prev) == password.charAt(post);
    }

    final int getLastPosition(int prev, String password) {
        int idx = -1;
        for (int i = prev; i < password.length(); i++) {
            if (password.charAt(i) != password.charAt(prev)) break;
            idx = i;
        }
        return idx;
    }

}
