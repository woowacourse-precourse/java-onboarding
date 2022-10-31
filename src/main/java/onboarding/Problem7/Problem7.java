package onboarding.Problem7;

import java.util.*;

public class Problem7
{
    public static final int FRIEND_SCORE = 10;
    public static final int VISITOR_SCORE = 1;
    public static final int MAX_RETURN_SIZE = 5;
    public static final int EXCEPTION_SCORE = 0;
    public static final int PADDDING_SIZE = 10;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors)
    {
        int graphSize = friends.size()*2 + visitors.size() + 1;
        graphSize += PADDDING_SIZE;
        Graph graph = new Graph(graphSize);
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
