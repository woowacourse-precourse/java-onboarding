package onboarding.problem7;

import java.util.HashMap;
import java.util.Map;

public class Timeline {
    private Map<String, Integer> timelineVisitInfo = new HashMap<>();

    public int getTimelineVisitTime(String userId){
        int visitTime = 0;
        if(timelineVisitInfo.containsKey(userId)) {
            visitTime = timelineVisitInfo.get(userId);
        }
        return visitTime;
    }

    public void addTimelineVisitInfo(String userId){
        timelineVisitInfo.put(userId, getTimelineVisitTime(userId) + 1);
    }
}
