package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7Service {
    static Problem7SnsRepository repository=RepositoryFactory.makeProblem7SnsRepository();

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
        Optional<User> userOptional = repository.findByUserName(userName);
        Optional<User> friendOptional = repository.findByUserName(friendName);
        userOptional.orElseThrow(()->new IllegalArgumentException());
        friendOptional.orElseThrow(()->new IllegalArgumentException());
        User findUser = (User)userOptional.get();
        User findFriend = (User)friendOptional.get();
        findUser.addFriend(findFriend);
    }

    public List<User> suggestUser(String user, List<String> visitors){
        Optional<User> userOptional = repository.findByUserName(user);
        userOptional.orElseThrow();
        return suggestUser(userOptional.get(),visitors);
    }

    public List<User> suggestUser(User user, List<String> visitors) {
        int[] visit=new int[repository.lastIdNumber()];
        Arrays.fill(visit,4);
        Map<User,Integer> cnt=new HashMap<>();
        for(int i=0;i<=2;i++){
            dls(cnt,visit,user,i,0);
        }
        for(String visitor:visitors){
            Optional<User> visitorOptional = repository.findByUserName(visitor);
            visitorOptional.orElseThrow(()->new RuntimeException());
            User user1 = visitorOptional.get();
            if(visit[user1.getId()]>1){
                if(!cnt.containsKey(user1)){
                    cnt.put(user1,0);
                }
                cnt.put(user1,cnt.get(user1)+1);
            }
        }
        List<User> collect = cnt.entrySet().stream().sorted((e1, e2) -> {
            if(e2.getValue()<e1.getValue()){
                return -1;
            }else if(e2.getValue()==e1.getValue()){
                return e1.getKey().getUserName().compareTo(e2.getKey().getUserName());
            }else{
                return 1;
            }

        }).map(e -> e.getKey()).collect(Collectors.toList());
        return collect.subList(0,collect.size()<5?collect.size():5);
    }

    private void dls(Map<User,Integer> cnt,int[] visit, User user, int deep,int deepCount) {
        visit[user.getId()]=deepCount;
        if(2==deepCount){
            if(!cnt.containsKey(user)){
                cnt.put(user,0);
            }
            cnt.put(user,cnt.get(user)+10);
            return;
        }
        if(deep==deepCount) return;

        Iterator<User> iterator = user.getFriends();
        while (iterator.hasNext()){
            User next = iterator.next();
            if(visit[next.getId()]>visit[user.getId()]){
                dls(cnt,visit,next,deep,deepCount+1);
            }
        }
    }
}
