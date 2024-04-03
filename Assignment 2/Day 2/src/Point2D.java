public class Point2D{
    private int x;
    private int y;

    public Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point2D(){}

    public String show(){
        return "Value of x is: " + this.x + " Value of Y is: " + this.y;
    }

    public boolean isEqual(Point2D p2){
        return this.x == p2.x && this.y == p2.y;
    }

    public double calculateDistance(Point2D p2){
        double dx = this.x - p2.x;
        double dy = this.y - p2.y;

        double ans = Math.sqrt((dx*dx) + (dy*dy));
        return ans;
    }

}