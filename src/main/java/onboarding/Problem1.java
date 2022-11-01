package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            final Player playerPobi = new Player(pobi);
            final Player playerCrong = new Player(crong);

            final Game game = new Game(playerPobi, playerCrong);
            final Player winner = game.findWinner();

            if (winner == playerPobi) {
                return 1;
            }

            if (winner == playerCrong) {
                return 2;
            }

            return 0;
        } catch (IllegalStateException e) {
            return -1;
        }
    }
}

class Game {
    List<Player> players;

    public Game(Player a, Player b) {
        players = List.of(a, b);
    }

    public Player findWinner() {
        final List<Player> sortedPlayers = players.stream()
                .sorted((a, b) -> b.getMaxNumber() - a.getMaxNumber())
                .collect(Collectors.toList());

        int biggestNumber = sortedPlayers.get(0).getMaxNumber();
        final boolean draw = sortedPlayers.stream()
                .allMatch(p -> p.getMaxNumber() == biggestNumber);

        if (draw) {
            return null;
        }

        return sortedPlayers.get(0);
    }
}

class Player {
    private List<Integer> leftNumbers;
    private List<Integer> rightNumbers;

    private int maxNumber;

    public Player(List<Integer> numbers) {
        final int left = numbers.get(0);
        final int right = numbers.get(1);

        if (left + 1 != right) {
            throw new IllegalStateException("invalid number");
        }

        this.leftNumbers = IntegerSplitter.fromInteger(left);
        this.rightNumbers = IntegerSplitter.fromInteger(right);

        final int leftMax = Math.max(MathUtil.sumNumbers(leftNumbers), MathUtil.multiNumbers(leftNumbers));
        final int rightMax = Math.max(MathUtil.sumNumbers(rightNumbers), MathUtil.multiNumbers(rightNumbers));

        maxNumber = Math.max(leftMax, rightMax);
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}

class MathUtil {
    public static int multiNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(1, Math::multiplyExact);
    }

    public static int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }
}

class IntegerSplitter {
    public static List<Integer> fromInteger(int number) {
        return Stream.of(String.valueOf(number)
                        .split("")
                )
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}