package onboarding;

import java.util.*;
import java.util.stream.Collectors;

class Game {
    private final Players players;
    private int result = -1;

    public Game(List<Player> playerList) {
        this.players = new Players(playerList);
    }

    public void play() {
        try {
            this.result = players.getResult();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            this.result = -1;
        }
    }

    public int getResult() {
        return result;
    }
}

class Players {
    private final List<Player> playerList;

    public Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public int getResult() {
        if (playerList.size() < 2) {
            throw new IllegalArgumentException("플레이어는 2명 이상이여야 한다.");
        }

        for (Player p : playerList) {
            p.initScore();
        }

        playerList.sort(Collections.reverseOrder());

        Set<Integer> scoreSet = playerList.stream().map(Player::getScore).collect(Collectors.toSet());

        if (scoreSet.size() == 1) {
            return 0;
        }

        return playerList.get(0).getNumber();
    }
}

class Player implements Comparable<Player> {
    private final List<Integer> pageResult;
    private final int number;
    private int score;

    public Player(List<Integer> pageResult, int number) {
        this.pageResult = pageResult;
        this.number = number;
    }

    public void initScore() {
        if (pageResult.size() != 2) throw new IllegalArgumentException("페이지 개수는 2개여야 한다.");
        if (pageResult.get(0) + 1 != pageResult.get(1)) throw new IllegalArgumentException("페이지는 연속되어야 한다.");

        int max = Integer.MIN_VALUE;

        for (Integer num : pageResult) {
            String[] split = String.valueOf(num).split("");

            int plus = 0;
            for (String s : split) {
                plus += Integer.parseInt(s);
            }
            max = Math.max(max, plus);

            int multi = 1;
            for (String s : split) {
                multi *= Integer.parseInt(s);
            }
            max = Math.max(max, multi);
        }

        score = max;
    }

    @Override
    public int compareTo(Player p) {
        return Integer.compare(this.score, p.score);
    }

    public int getNumber() {
        return number;
    }

    public int getScore() {
        return score;
    }

}

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<Player> players = Arrays.asList(new Player(pobi, 1), new Player(crong, 2));

        Game game = new Game(players);
        game.play();
        return game.getResult();
    }
}