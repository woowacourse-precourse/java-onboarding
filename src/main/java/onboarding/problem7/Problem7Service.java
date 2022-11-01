package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7Service {
    private static Problem7SnsRepository repository=RepositoryFactory.makeProblem7SnsRepository();

    public void save(String userName) {
        User user = new User(userName);
        save(user);
    }
    public void save(User user) {
        user.validUserName();
        Optional<User> userOptional = repository.findByUserName(user.getUserName());
        userOptional.orElseGet(()-> (User) repository.save(user));
    }

    public void addFriend(String userName, String friendName) {
        User findUser = getUser(userName);
        User findFriend = getUser(friendName);
        findUser.addFriend(findFriend);
    }

    public List<User> suggestUser(String user, List<String> visitors){
        User findUser = getUser(user);
        return suggestUser(findUser,visitors);
    }

    private static Map<User,Integer> scoreMap;
    private static int[] depth;
    private static final int MAX_DEPTH=2;
    private static final int FRIEND_DEPTH=1;

    public List<User> suggestUser(User user, List<String> visitors) {
        depth =new int[repository.lastIdNumber()];
        Arrays.fill(depth,4);
        scoreMap =new HashMap<>();

        findSuggestUserAndCalcScore(user);

        visitorCalc(visitors);

        List<User> collect = scoreMap.entrySet().stream().sorted(scoreSort()).map(e -> e.getKey()).collect(Collectors.toList());
        return collect.subList(0,collect.size()<5?collect.size():5);
    }

    private void visitorCalc(List<String> visitors) {
        for(String visitor: visitors){
            User user = getUser(visitor);
            if(isNotFriend(depth[user.getId()])){
                if(!scoreMap.containsKey(user)){
                    scoreMap.put(user,0);
                }
                scoreMap.put(user, scoreMap.get(user)+1);
            }
        }
    }

    private boolean isNotFriend(int userId) {
        return userId >FRIEND_DEPTH;
    }

    private User getUser(String userName) {
        Optional<User> visitorOptional = repository.findByUserName(userName);
        visitorOptional.orElseThrow(()->new IllegalArgumentException());
        User user = visitorOptional.get();
        return user;
    }

    private void findSuggestUserAndCalcScore(User user) {
        ids(user);
    }

    private void ids(User user) {
        for(int i=0;i<=2;i++){
            dls(user,i,0);
        }
    }

    private Comparator<Map.Entry<User, Integer>> scoreSort() {
        return (e1, e2) -> {
            if (e2.getValue() < e1.getValue()) {
                return -1;
            } else if (e2.getValue() == e1.getValue()) {
                return e1.getKey().getUserName().compareTo(e2.getKey().getUserName());
            } else {
                return 1;
            }
        };
    }

    private void dls(User user, int deep,int deepCount) {
        depth[user.getId()]=deepCount;
        if(MAX_DEPTH==deepCount){
            if(!scoreMap.containsKey(user)){
                scoreMap.put(user,0);
            }
            scoreMap.put(user, scoreMap.get(user)+10);
            return;
        }
        if(deep==deepCount) return;

        Iterator<User> iterator = user.getFriends();
        while (iterator.hasNext()){
            User next = iterator.next();
            if(depth[next.getId()]> depth[user.getId()]){
                dls(next,deep,deepCount+1);
            }
        }
    }
}
