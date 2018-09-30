import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray {
	class L {
		int nr[] = new int[2], p;
	}

	public SuffixArray() {
		// variables
		char A[] = "apple".toCharArray();
		int N = A.length;
		int MAXN = N, MAXLG = 0;
		for (MAXLG = 1; 1 << MAXLG < N; MAXLG++)
			;
		int P[][] = new int[MAXLG + 2][MAXN];
		int stp = 0, cnt = 0;
		L l[] = new L[MAXN];

		for (int i = 0; i < N; i++) {
			P[0][i] = A[i] - 'a';
			l[i] = new L();
		}

		for (stp = 1, cnt = 1; (cnt >> 1) < N; stp++, cnt <<= 1) {
			for (int i = 0; i < N; i++) {
				l[i].nr[0] = P[stp - 1][i];
				l[i].nr[1] = i + cnt < N ? P[stp - 1][i + cnt] : -1;
				l[i].p = i;
				// System.out.println(l[i].nr[0] + ":" + l[i].nr[1] + ":" + l[i].p);
			}
			// System.out.println();
			Arrays.sort(l, new Comparator() {
				public int compare(Object o1, Object o2) {
					L O1 = (L) o1;
					L O2 = (L) o2;
					return O1.nr[0] == O2.nr[0] ? (O1.nr[1] < O2.nr[1] ? 0 : -1) : (O1.nr[0] < O2.nr[0] ? 0 : -1);
				}
			});
//			for (int i = 0; i < N; i++) {
//				System.out.println(l[i].nr[0] + ":" + l[i].nr[1] + ":" + l[i].p);
//			}
//			System.out.println();
			for (int i = 0; i < N; i++) {
				P[stp][l[i].p] = i > 0 && l[i].nr[0] == l[i - 1].nr[0] && l[i].nr[1] == l[i - 1].nr[1]
						? P[stp][l[i - 1].p]
						: i;
			}
		}
		// print(P);
	}

	public int lcp(int x, int y, int N, int P[][], int MAXLG) {
		int k, ret = 0;
		if (x == y)
			return N - x;
		for (k = MAXLG + 1; k >= 0; k--)
			if (P[k][x] == P[k][y]) {
				x += 1 << k;
				y += 1 << k;
				ret += 1 << k;
			}
		return ret;
	}

	public void print(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String args[]) {
		new SuffixArray();
	}
}