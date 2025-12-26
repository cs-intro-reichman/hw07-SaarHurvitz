/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		
		sierpinski(Integer.parseInt(args[0]));

	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		StdDraw.setCanvasSize(600, 600);
           StdDraw.setXscale(0, 802);
           StdDraw.setYscale(0, 802);

		   sierpinski(n, 2, 10, 800, 10, 400, 800);
	}
	//x1 = left side
	//x2 = right side
	//x3 = middle
	//y1 = bottom
	//y2 = bottom
	//y3 = up
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double y1, double x2,
		                                 double y2, double x3, double y3) {
		if(n == 0) return;
		    
		StdDraw.line(x1, y1, x2 , y2);
        StdDraw.line(x1, y1, x3, y3);
        StdDraw.line(x3, y3, x2, y2);

        sierpinski(n-1,x1, y1, x3, y2, (x3 + x1) / 2, (y3 + y1) / 2);
        sierpinski(n-1,x3, y2, x2, y2, (x2 + x3) / 2, (y2 + y3) / 2);
        sierpinski(n-1, (x3 + x1) / 2, (y3 + y1) / 2, (x2 + x3) / 2, (y2 + y3) / 2, x3, y3);
	}
}
