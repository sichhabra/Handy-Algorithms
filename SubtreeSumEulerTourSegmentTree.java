import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubtreeSumEulerTourSegmentTree {
// O(q*log(n)) : Sum of all nodes in subtree of given node
	int n;
	int tree[];

	public void init(int arr[]) {
		n = arr.length;
		tree = new int[2 * n];
		buildTree(arr);
	}

	public void buildTree(int arr[]) {
		for (int i = n, j = 0; i < 2 * n; i++, j++) {
			tree[i] = arr[j];
		}
		for (int i = n - 1; i > 0; i--) {
			tree[i] = tree[2 * i] + tree[2 * i + 1];
		}
	}

	public void update(int pos, int value) {
		pos += n;
		tree[pos] = value;
		while (pos > 0) {
			int left = pos, right = pos;
			if (pos % 2 == 0) {
				right++;
			} else {
				left--;
			}
			tree[pos / 2] = tree[left] + tree[right];
			pos /= 2;
		}
	}

	public int sumRange(int l, int r) {
		l += n;
		r += n;
		int sum = 0;
		while (l <= r) {
			if (l % 2 == 1) {
				sum += tree[l];
				l++;
			}
			if (r % 2 == 0) {
				sum += tree[r];
				r--;
			}
			l /= 2;
			r /= 2;
		}
		return sum;
	}

	class Node {
		int val;
		Node left, right;

		public Node(int val) {
			this.val = val;
		}
	}

	public int dfs(List<Integer> graph[], int node, List<Integer> nums) {
		nums.add(node);
		if (graph[node].size() == 0) {
			return node;
		}
		for (int x : graph[node]) {
			int temp = dfs(graph, x, nums);
			nums.add(temp);
		}
		return node;
	}

	public SubtreeSumEulerTourSegmentTree() throws Exception {
		// Segment Tree testcases:
		/*
		 * int arr[] = { 2, 1, 3, 4 }; init(arr); System.out.println(sumRange(0, 3));
		 * System.out.println(sumRange(1, 2)); update(1, 4);
		 * System.out.println(sumRange(0, 3)); System.out.println(sumRange(1, 2));
		 */

		// Subtree Sum testcases:
		List<Integer>[] graph = new List[7];
		for (int i = 1; i <= 6; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		graph[1].add(2);
		graph[1].add(3);
		graph[2].add(6);
		graph[2].add(5);
		graph[3].add(4);

		List<Integer> nums = new LinkedList<>();
		int res = dfs(graph, 1, nums);
		nums.add(res);
		int arr[] = new int[nums.size()];
		int i = 0;
		for (int x : nums) {
			arr[i++] = x;
		}
		// System.out.println(Arrays.toString(arr));
		HashMap<Integer, Integer> entry = new HashMap<>();
		HashMap<Integer, Integer> exit = new HashMap<>();
		for (int j = 0; j < arr.length; j++) {
			if (entry.containsKey(arr[j])) {
				exit.put(arr[j], j);
			} else {
				entry.put(arr[j], j);
			}
		}
		init(arr);
		System.out.println(sumRange(entry.get(1), exit.get(1))/2);
		update(entry.get(6), 10);
		update(exit.get(6),10);
		System.out.println(sumRange(entry.get(2), exit.get(2))/2);
	}

	public static void main(String[] args) throws Exception {
		new SubtreeSumEulerTourSegmentTree();
	}
}
