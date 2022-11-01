package onboarding.problem7;

class RecommendPoint implements Comparable<RecommendPoint> {

    private final String name;
    private int point;

    public RecommendPoint(String name) {
        this.name = name;
        point = 0;
    }

    public void addPoints(int point) {
        this.point += point;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(RecommendPoint o) {
        if (this.point == o.point) {
            return this.name.compareTo(o.getName());
        }
        return -(this.point - o.getPoint());
    }
}
