package onboarding.Problem7;

import java.util.*;

public class Problem7
{
    public static final int FRIEND_SCORE = 10;
    public static final int VISITOR_SCORE = 1;
    public static final int MAX_RETURN_SIZE = 5;
    public static final int EXCEPTION_SCORE = 0;

    private static final int MAX_VERTEX_SIZE= 10001*2;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors)
    {
        Graph graph = new Graph(MAX_VERTEX_SIZE);
        graph.enrollUserAndReturnVertex(user);
        for(int i = 0 ; i < friends.size();i++)
        {
            List<String> friend = friends.get(i);

            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            graph.connect(friend1,friend2);
        }
        List<String> visitorsArrayList = new ArrayList<>(visitors);
        graph.updateScore(user,visitorsArrayList);
        return graph.getResult(user);
    }
}
