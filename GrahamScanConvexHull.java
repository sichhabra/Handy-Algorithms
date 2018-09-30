import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class GrahamScanConvexHull {

	Stack<Point> stack = new Stack<>();
	Point p0;

	Point nextToTop() {
		Point top = stack.pop();
		Point res = stack.peek();
		stack.push(top);
		return res;
	}

	void swap(Point points[], int i, int j) {
		Point temp = points[i];
		points[i] = points[j];
		points[j] = temp;
	}

	int dist(Point p, Point q) {
		return (q.x - p.x) * (q.x - p.x) + (q.y - p.y) * (q.y - p.y);
	}

	int orient(Point p, Point q, Point r) {

		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
		if (val == 0)
			return 0;
		return val > 0 ? 1 : 2;// cw,ccw
	}

	Comparator comp = new Comparator<Point>() {
		public int compare(Point p, Point q) {
			int o = orient(p0, p, q);
			if (o == 0)
				return dist(p0, q) >= dist(p0, p) ? -1 : 1;
			return (o == 2) ? -1 : 1;
		}
	};

	public void convexHull(Point points[]) {
		int n = points.length;
		int ymin = points[0].y, min = 0;
		for (int i = 1; i < n; i++) {
			int y = points[i].y;
			if (y < ymin || (y == ymin && points[i].x < points[min].x)) {
				ymin = points[i].y;
				min = i;
			}
		}
		swap(points, 0, min);
		p0 = new Point(points[0].x, points[0].y);
		Arrays.sort(points, comp);
		int m = 1;
		for (int i = 1; i < n; i++) {
			while (i < n - 1 && orient(p0, points[i], points[i + 1]) == 0)
				i++;
			points[m++] = points[i];
		}
		if (m < 3) {
			return;
		}
		stack.push(points[0]);
		stack.push(points[1]);
		stack.push(points[2]);
		for (int i = 3; i < m; i++) {
			while (orient(nextToTop(), stack.peek(), points[i]) != 2)
				stack.pop();
			stack.push(points[i]);
		}
		while (!stack.isEmpty()) {
			Point p = stack.pop();
			System.out.println(p.x + ":" + p.y);
		}
	}

	public GrahamScanConvexHull() {
		Point points[] = { new Point(0, 3), new Point(1, 1), new Point(2, 2), new Point(4, 4), new Point(0, 0),
				new Point(1, 2), new Point(3, 1), new Point(3, 3) };
		convexHull(points);
	}

	public static void main(String[] args) {
		new GrahamScanConvexHull();
	}
}
