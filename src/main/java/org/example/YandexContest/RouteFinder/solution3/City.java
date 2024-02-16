package org.example.YandexContest.RouteFinder.solution3;

public class City {
    private boolean isVisited;
    private final int x;
    private final int y;

    public City(int x, int y) {
        this.isVisited = false;
        this.x = x;
        this.y = y;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
