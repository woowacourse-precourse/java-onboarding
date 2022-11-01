package onboarding.problem7;

import java.util.HashMap;
import java.util.Map;

public class TimelineRepository {
    private Map<String, Timeline> timelineMap = new HashMap<>();

    public Timeline getTimelineOfUser(String userId){
        if(!timelineMap.containsKey(userId)){
            timelineMap.put(userId, new Timeline());
        }

        return timelineMap.get(userId);
    }
}
