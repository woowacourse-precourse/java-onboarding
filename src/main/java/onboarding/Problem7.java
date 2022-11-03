package onboarding;

import java.nio.charset.CoderMalfunctionError;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<Candidate> candidateList = getCandidateList(user, friends, visitors);
        sortCandidateList(candidateList);

        List<Candidate> top5CandidateList = candidateList.size() > 5 ? candidateList.subList(0, 5)
                                                                        : candidateList;
        answer = top5CandidateList.stream()
                .map(Candidate::getId)
                .collect(Collectors.toList());

        return answer;
    }

    static List<Candidate> getCandidateList(String user, List<List<String>> friends, List<String> visitors){
        List<Candidate> candidateList = new ArrayList<>();

        List<String> allUserList = getUsers(friends, visitors);
        List<String> userFriendList = getFriends(user, friends);
        Stream<String> candidateIdStream = allUserList.stream()
                .filter(id -> !userFriendList.contains(id) && !id.equals(user));

        candidateList = candidateIdStream
                .map(id -> new Candidate(id, getScore(user, id, friends, visitors)))
                .filter(candidate -> candidate.getScore() > 0)
                .collect(Collectors.toList());

        return candidateList;
    }

    static void sortCandidateList(List<Candidate> candidateList){
        Comparator<Candidate> candidateComparator = Comparator
                .comparing(Candidate::getScore)
                .reversed()
                .thenComparing(Candidate::getId);

        Collections.sort(candidateList, candidateComparator);
    }


    static List<String> getUsers(List<List<String>> friends, List<String> visitors) {
        List<String> result = new ArrayList<>();

        Stream<String> friendsStream = friends.stream().flatMap(Collection::stream);
        Stream<String> visitorsStream = visitors.stream();
        Stream<String> allUserStream = Stream.concat(friendsStream, visitorsStream).distinct();

        result = allUserStream.collect(Collectors.toList());

        return result;
    }

    static int getScore(String user, String anotherUser,
                        List<List<String>> friends, List<String> visitors){
        int friendScore = getSameFriendsCnt(user, anotherUser, friends) * 10;
        int visitScore = getVisitCnt(visitors, anotherUser);
        int totalScore = friendScore + visitScore;

        return totalScore;
    }

    static int getSameFriendsCnt(String user, String anotherUser, List<List<String>> friends){
        int sameFriendCnt = 0;
        List<String> userFriends = getFriends(user, friends);
        List<String> anotherUserFriends = getFriends(anotherUser, friends);

        Stream<String> sameFriendStream = userFriends.stream().filter(friend -> anotherUserFriends.contains(friend));
        sameFriendCnt = (int) sameFriendStream.count();

        return sameFriendCnt;
    }

    static List<String> getFriends(String user, List<List<String>> friends){
        Stream<List<String>> userContainedStream = friends.stream().filter(item -> item.contains(user));
        Stream<String> friendStream = userContainedStream.map(item -> item.get((item.indexOf(user) + 1) % 2));
        List<String> friendList = friendStream.collect(Collectors.toList());

        return friendList;
    }

    static int getVisitCnt(List<String> visitors, String visitor){
        return Collections.frequency(visitors, visitor);
    }
}

class Candidate {
    private String id;
    private int score;

    Candidate(String id, int score){
        this.id = id;
        this.score = score;
    }
    String getId() {
        return id;
    }

    int getScore() {
        return score;
    }

    void setScore(int score) {
        if (score <= 0) return;
        this.score = score;
    }
}
