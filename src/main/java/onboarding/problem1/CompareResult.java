package onboarding.problem1;

public class CompareResult {
    private static final Integer POBI_WIN_NUMBER  = 1;
    private static final Integer CRONG_WIN_NUMBER = 2;
    private static final Integer DRAW_NUMBER      = 0;

    public Integer compare(Player playerPobi, Player playerCrong) {
        Integer playerPobiNumber  = playerPobi.number();
        Integer playerCrongNumber = playerCrong.number();

        if (playerPobiNumber > playerCrongNumber) {
            return POBI_WIN_NUMBER;
        }
        if (playerPobiNumber.equals(playerCrongNumber)) {
            return DRAW_NUMBER;
        }
        return CRONG_WIN_NUMBER;
    }
}
