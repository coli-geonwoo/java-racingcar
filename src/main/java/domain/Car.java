package domain;

public class Car implements Comparable<Car> {

    private final String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void move() {
        this.score++;
    }

    @Override
    public String toString(){
        return this.name + " : " + "-".repeat(this.score);
    }
    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.score, this.score);
    }
}
