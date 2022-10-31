package onboarding.prob7.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.IntStream;

public class DummyUser {

    private PriorityQueue<User> tmp;
    private Random random = new Random();
    private User getUser() {
        int leftLimit = 97; // a
        int rightLimit = 122; // z
        int targetStringLength = 4;
        String generatedString = random.ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
        return new User(generatedString, random.nextInt(100));
    }

    public PriorityQueue<User> getNumberOfUser(int x) {
        PriorityQueue<User> q = new PriorityQueue<>();
        while (q.size() != x) {
            User user = getUser();
            q.add(user);
        }
        tmp = new PriorityQueue<>(q);
        return q;
    }

    public List<String> top5() {
        List<String> ret = new ArrayList<>();
        while (!tmp.isEmpty()) {
            if (ret.size() == 5) break;
            User poll = tmp.poll();
            if (poll.getScore() == 0) break;
            ret.add(poll.getName());
        }
        return ret;
    }

}
