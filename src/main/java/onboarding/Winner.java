package onboarding;

public enum Winner {
    DRAW(0),
    POBI(1),
    CRONG(2);

    private int winner;

    Winner(int winner) {
        this.winner = winner;
    }

    public int getWinner() {
        return winner;
    }

}

