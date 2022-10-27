package onboarding.problem1.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final Player leftPlayer;
    private final Player rightPlayer;
    
    public Players(final List<Integer> leftPlayer, final List<Integer> rightPlayer) {
        this(new Player(initPlayerParameter(leftPlayer)), new Player(initPlayerParameter(rightPlayer)));
    }
    
    public Players(final Player leftPlayer, final Player rightPlayer) {
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
    }
    
    private static List<Page> initPlayerParameter(final List<Integer> leftPlayer) {
        return leftPlayer.stream()
                .map(Page::new)
                .collect(Collectors.toList());
    }
    
    public int playResult() {
        return leftPlayer.compareTo(rightPlayer);
    }
}
