package onboarding;

public class Recommend  {
    private String name;
    private Integer point;

    Recommend(){
        this.point=0;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPoint() {
        return this.point;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public void addPoint(Integer point) {
        this.point += point;
    }
}
