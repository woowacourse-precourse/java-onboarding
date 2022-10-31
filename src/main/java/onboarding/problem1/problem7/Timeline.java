package onboarding.problem1.problem7;

import java.util.HashMap;
import java.util.Map;

public class Timeline {
    private Map<String,Map<String,Integer>> visitLoggerOfEachTimeLine = new HashMap<>();

    public Map<String,Integer> getUserTimeline(String user){
        return visitLoggerOfEachTimeLine.get(user);
    }

    public void addUserTimeline(String user){
        visitLoggerOfEachTimeLine.put(user, new HashMap<>());
    }

    public void addVisitInfo(String host, String visitor){
        if(getUserTimeline(host) == null){
            addUserTimeline(host);
        }

        Map<String,Integer> userTimeline = getUserTimeline(host);
        Integer currentVisitTime = userTimeline.get(visitor);

        if(currentVisitTime == null){
            userTimeline.put(visitor,1);
        }
        else{
            userTimeline.replace(visitor,userTimeline.get(visitor) + 1);
        }
    }

    public int getVisitTimes(String host, String visitor){
        return getUserTimeline(host).get(visitor);
    }

}
