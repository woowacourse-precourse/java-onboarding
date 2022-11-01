package onboarding.problem7;

public class SNSId {
    private static final int MAX = 30;
    private final String user;

    public SNSId(String user) {
        checkInput(user);
        this.user = user;
    }

    private static void checkInput(String user) {
        checkBlack(user);
        checkMax(user);
    }

    private static void checkMax(String user) {
        if (user.length() > MAX) {
            throw new UserInputException("아이디는 30자 이상이 될 수 없습니다.");
        }
    }

    private static void checkBlack(String user) {
        if (user.isBlank()) {
            throw new UserInputException("아이디는 1자 이상이어야 합니다.");
        }
    }

    public String getUser() {
        return user;
    }
}
