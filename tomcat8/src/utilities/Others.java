package utilities;

public class Others {
	public static double sqr(double a) {
        return a*a;
    }
 
    public static double Distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(sqr(y2 - y1) + sqr(x2 - x1));
    }
}
