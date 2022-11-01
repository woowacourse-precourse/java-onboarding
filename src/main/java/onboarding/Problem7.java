package onboarding;

import java.util.*;

public class Problem7 {
    private static final int POINT_OF_FRIEND_TOGETHER = 10;
    private static final int POINT_OF_VISIT_COUNT_PER_TIMELINE = 1;
    private static final int BST_FRIEND_TOGETHER_LEVEL = 2;

    private static Map<String, ArrayList<String>> graph;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        graph = makeFriendGraph(friends);
        System.out.println(graph);

        List<List<String>> friendAndKnownFriendList = searchFriendAndKnownFriendListByBst(user, user, new LinkedList<String>(),
                new LinkedList<String>(), new ArrayList<String>(),0);

        List<String> friendList = friendAndKnownFriendList.get(0);
        List<String> knownFriendList = friendAndKnownFriendList.get(1);

        Map<String, Integer> point = calculateRecommendPoint(knownFriendList, visitors, friendList);


        return sortRecommendPoint(point);
    }

    /**
     * 제한조건에 맞게 결과 처리
     * @param caculatedPoint
     * @return
     */
    private static List<String> sortRecommendPoint(Map<String, Integer> caculatedPoint) {
        List<String> keySet = new ArrayList<>(caculatedPoint.keySet());
        keySet.sort((o1, o2) -> caculatedPoint.get(o2).compareTo(caculatedPoint.get(o1)));

        return keySet;
    }

    /**
     * 함께아는 친구 정보와 방문자 수를 통해 점수 도출
     * @param knownFriendList
     * @param visitors
     * @param friend
     * @return
     */
    private static Map<String, Integer> calculateRecommendPoint(List<String> knownFriendList, List<String> visitors, List<String> friend){
        Map<String, Integer> point = new TreeMap<>();

        for(String current:knownFriendList){
            if(point.containsKey(current)){
                point.replace(current, point.get(current)+ POINT_OF_FRIEND_TOGETHER);
            }
            else{
                point.put(current, POINT_OF_FRIEND_TOGETHER);
            }
        }

        for(String current:visitors){
            if(friend.contains(current)) continue;
            else if(point.containsKey(current)){
                point.replace(current, point.get(current)+POINT_OF_VISIT_COUNT_PER_TIMELINE);
            }
            else{
                point.put(current, POINT_OF_VISIT_COUNT_PER_TIMELINE);
            }
        }

        return point;
    }

    /**
     * 친구 관계 그래프 만들기 <br/>
     * - 인접 행렬을 통해 구현
     * @param friends
     * @return
     */
    private static Map<String, ArrayList<String>> makeFriendGraph(List<List<String>> friends) {
        Map<String, ArrayList<String>> graph = new HashMap();

        for(List<String> current:friends){
            String person1 = current.get(0);
            String person2 = current.get(1);


            if(graph.containsKey(person1)){
                graph.get(person1).add(person2);
            } else{
                ArrayList<String> newArrayList = new ArrayList();
                newArrayList.add(person2);
                graph.put(person1, newArrayList);

            }

            if(graph.containsKey(person2)){
                graph.get(person2).add(person1);
            } else{
                ArrayList<String> newArrayList = new ArrayList();
                newArrayList.add(person1);
                graph.put(person2, newArrayList);

            }
        }
        return graph;
    }

    /**
     * BST를 통해 함꼐아는 친구 및 친구 리스트를 만듬
     * @param user
     * @param currentVertex
     * @param currentLevelTargets
     * @param nextLevelTargets
     * @param visited
     * @param currentLevel
     * @return List.get(0)은 친구, List.get(1)은 함께 아는 친구
     */
    private static List<List<String>> searchFriendAndKnownFriendListByBst(String user, String currentVertex, Queue<String> currentLevelTargets,
                                       Queue<String> nextLevelTargets, List<String> visited, int currentLevel){

        if(currentVertex == null){
            if(currentLevel + 1 == BST_FRIEND_TOGETHER_LEVEL) {
                visited.remove(user);
                return List.of(List.copyOf(visited), List.copyOf(nextLevelTargets));
            }
            else
                return searchFriendAndKnownFriendListByBst(user, nextLevelTargets.poll(),
                        nextLevelTargets, currentLevelTargets, visited, currentLevel+1);
        }
        else{
            ArrayList<String> candidate = graph.get(currentVertex);
            if(!visited.contains(currentVertex))
                visited.add(currentVertex);

            for(String nextTargetCandidate: candidate){
                if(!visited.contains(nextTargetCandidate))
                    nextLevelTargets.add(nextTargetCandidate);
            }
            return searchFriendAndKnownFriendListByBst(user, currentLevelTargets.poll(), currentLevelTargets,
                    nextLevelTargets, visited, currentLevel);
        }
    }
}
