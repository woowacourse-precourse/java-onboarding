package onboarding;

import java.util.*;

public class Problem7 {

    /**
     * 사용자 아이디와 추천친구 점수를 저장할 클래스
     */
    static class Candidate {
        private String name;
        private int grade;

        public Candidate(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getGrade() {
            return grade;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Set<String> personList = new HashSet<>();   //사용자와 친구를 제외한 관련된 모든 사람 리스트
        List<String> friendList = new ArrayList<>();    //사용자와 친구관계를 가지는 사람 리스트

        for(List<String> friendShip : friends) {
            personList.add(friendShip.get(0));
            personList.add(friendShip.get(1));

            addToFriendList(friendShip, user, friendList);
        }

        for(String person : visitors) {
            personList.add(person);
        }

        //personList에서 사용자와 친구들을 삭제
        personList.remove(user);
        for(String person : friendList) {
            personList.remove(person);
        }

        List<Candidate> candidateList = new ArrayList<>();   //추천 친구 후보자 리스트

        for(String person : personList) {
            candidateList.add(new Candidate(person, 0));    //점수를 모두 0으로 초기화
        }
        
        //후보자 중 사용자와 함께 아는 친구가 있는지, 있으면 점수 10점 추가
        for(Candidate candidate : candidateList) {
            plusGradeForFriend(friends, friendList, candidate);
        }

        for(String visitor : visitors) {
            plusGradeForVisit(candidateList, visitor);
        }

        //후보자 리스트에서 점수가 0인 후보를 제거할, 인덱스를 저장하는 리스트
        List<Integer> removeIndexList = new ArrayList<>();

        for(int i = 0; i < candidateList.size(); i++) {
            addToRemoveIndexList(candidateList, removeIndexList, i);
        }

        //점수가 0인 후보들 제거
        for(int index : removeIndexList) {
            candidateList.remove(index);
        }

        //Candidate 객체 리스트 정렬
        //각 객체의 member 변수인 grade에 따라 내림차순으로 정렬, BUT 점수가 같으면 아이디 이름순(오름차순)으로 정렬
        candidateList.sort(Comparator.comparing(Candidate::getGrade).reversed()
                .thenComparing(Candidate::getName));

        List<String> answer = new ArrayList<>();
        for(int i = 0; i < candidateList.size() && i < 5; i++) {
            answer.add(candidateList.get(i).name);
        }

        return answer;
    }

    /**
     * 사용자와 친구관계인 아이디를 firendList에 추가하는 메서드
     */
    private static void addToFriendList(List<String> friendShip, String user, List<String> friendList) {
        if(friendShip.get(0).equals(user)) {
            friendList.add(friendShip.get(1));
        }
        if(friendShip.get(1).equals(user)) {
            friendList.add(friendShip.get(0));
        }
    }

    /**
     * 사용자와 함께 아는 친구관계인 후보자 점수를 10점 추가하는 메서드
     */
    private static void plusGradeForFriend(List<List<String>> friends, List<String> friendList, Candidate candidate) {
        for(List<String> friendShip : friends) {
            checkSameFriend(friendList, candidate, friendShip);
        }
    }

    /**
     * 사용자와 함께 아는 친구관계가 맞는지 체크, 맞으면 후보자 점수를 10점 추가하는 메서드
     */
    private static void checkSameFriend(List<String> friendList, Candidate candidate, List<String> friendShip) {
        //friendShip 중 0번째 인덱스 값이 후보자일때
        if(friendShip.get(0).equals(candidate.name)) {
            //1번째 인덱스 값이 사용자 친구 관계 리스트에 있을때
            checkInFriendList(friendList, candidate, friendShip.get(1));
        }
        //friendShip 중 1번째 인덱스 값이 후보자일때
        if(friendShip.get(1).equals(candidate.name)) {
            //0번째 인덱스 값이 사용자 친구 관계 리스트에 있을때
            checkInFriendList(friendList, candidate, friendShip.get(0));
        }
    }

    /**
     *  후보자의 친구가 사용자 친구 리스트인 friendList에 있는지 체크, 있으면 후보자 점수를 10점 추가하는 메서드
     */
    private static void checkInFriendList(List<String> friendList, Candidate candidate, String friendName) {
        if(friendList.contains(friendName)) {
            candidate.grade += 10;
        }
    }

    /**
     * 타임라인 방문자들에 대해서 점수 1점을 추가하는 메서드
     */
    private static void plusGradeForVisit(List<Candidate> candidateList, String visitor) {
        for(Candidate candidate : candidateList) {
            checkVisitor(visitor, candidate);
        }
    }

    /**
     * 타임라인 방문자가 특정 후보자 아이디와 일치할 때 1점을 추가하는 메서드
     */
    private static void checkVisitor(String visitor, Candidate candidate) {
        if(visitor.equals(candidate.name)) {
            candidate.grade += 1;
        }
    }

    /**
     * 후보자들 중 점수가 0인 후보자들의 인덱스를 removeIndexList에 추가하는 메서드
     */
    private static void addToRemoveIndexList(List<Candidate> candidateList, List<Integer> removeIndexList, int i) {
        if(candidateList.get(i).grade == 0) {
            removeIndexList.add(i);
        }
    }

}
