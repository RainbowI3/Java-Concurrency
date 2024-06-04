

public enum FigureType {
    TRIANGLE(3), RECTANGLE(4), OVAL(), CIRCLE();
    public static final int INFINITY = -1;
    private int points;
    FigureType(int points){
        this.points = points;
    }

    FigureType(){
        this.points = INFINITY;
    }

    public int getPoints(){
        return points;
    }
}
