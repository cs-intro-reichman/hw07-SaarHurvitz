/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));

		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}
	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
        curve1(n, x1, y1, x2, y2);
    }
	private static void curve1(int n, double x1, double y1, double x2, double y2) {

        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }
		//I used the cos sin calculating functions instead of what you have suggested in the HW file
        double p3x = (x1 + (x2 - x1) / 3.0) + ((x2 - x1) / 3.0) * Math.cos(Math.toRadians(60)) - ((y2 - y1) / 3.0) * Math.sin(Math.toRadians(60));
        double p3y = (y1 + (y2 - y1) / 3.0) + ((x2 - x1) / 3.0) * Math.sin(Math.toRadians(60)) + ((y2 - y1) / 3.0) * Math.cos(Math.toRadians(60));
        
        curve1(n - 1, x1, y1, x1 + (x2 - x1) / 3.0, y1 + (y2 - y1) / 3.0);
        curve1(n - 1, x1 + (x2 - x1) / 3.0, y1 + (y2 - y1) / 3.0, p3x, p3y);
        curve1(n - 1, p3x, p3y, x1 + 2 * (x2 - x1) / 3.0, y1 + 2 * (y2 - y1) / 3.0);
        curve1(n - 1, x1 + 2 * (x2 - x1) / 3.0, y1 + 2 * (y2 - y1) / 3.0, x2, y2);
    }

    
    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		// // Draws a Koch snowflake of depth n
		StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 902);
        StdDraw.setYscale(0, 902);
		double l = 600;
		double h = l * Math.sqrt(3) / 2;
		double x1 = 100, x2 = 450, x3 = 800;
		double y1 = 600, y2 = 600 - h;
		curve(n, x1, y1, x3, y1);
		curve(n, x3,y1, x2, y2);
		curve(n, x2, y2, x1, y1);
		
	}
}
