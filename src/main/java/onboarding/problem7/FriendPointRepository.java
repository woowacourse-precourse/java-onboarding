package onboarding.problem7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FriendPointRepository {

    private Map<String, Integer> repository;

    public FriendPointRepository(){
        this.repository = new HashMap<>();
    }

    public int addPoint(String nickname, int point){
        if (!repository.containsKey(nickname)){
            return initializePoint(nickname, point);
        } else {
            return addingPoint(nickname, point);
        }
    }

    private int initializePoint(String nickname, int point){
        repository.put(nickname, point);
        return point;
    }

    private int addingPoint(String nickname, int point){
        int finalPoint = repository.get(nickname) + point;
        repository.put(nickname, finalPoint);
        return finalPoint;
    }

    public List<String> findRecommendFriendsTop5(){
        return repository.keySet().stream()
                .sorted(Comparator.comparing(repository::get).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
