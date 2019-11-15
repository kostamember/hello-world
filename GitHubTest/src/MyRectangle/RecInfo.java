package MyRectangle;

public class RecInfo {
	PointRec lu;
	int width;
	int height;
	
	public RecInfo(int x, int y, int w, int h) {
		lu = new PointRec(x, y);
		width = w;
		height = h;
	}
	public int calcArea() {
	
		return (width*height);
	}
	public String toString() {
		return ("("+lu.x+", "+lu.y+") "+width+" "+height);
	}
}
