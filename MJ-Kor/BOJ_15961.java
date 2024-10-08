package algorithm_study.september.day_09_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15961 {
    private static int N, d, k, c;
	private static Queue<Integer> queue = new ArrayDeque<>();
	private static int[] valid;
	private static int numType = 0;
	private static int max = Integer.MIN_VALUE;
	private static int[] sushi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

//		System.out.println("------");

		valid = new int[d + 1];
		sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 1;
		int idx = 0;

		while(cnt <= N + k - 1) {
//			System.out.println(cnt + " " + idx);
			if(queue.size() == k) {
				int outputNum = queue.poll();
				checkType(outputNum, false);
				queue.offer(sushi[idx % N]);
				checkType(sushi[idx % N], true);
			}
			else {
				queue.offer(sushi[idx % N]);
				checkType(sushi[idx % N], true);
			}
			cnt++;
			idx++;

//			System.out.println("----qs---");
//			Iterator iter = queue.iterator();
//			while(iter.hasNext()) {
//				System.out.println(iter.next());
//			}
//			System.out.println("----qe---");

			if(valid[c]==0) {
				numType++;
				if(max < numType) max = numType;
				numType--;
			}
			else {
				if(max < numType) max = numType;
			}
//			System.out.println(Arrays.toString(valid));
//			System.out.println();

		}
//		System.out.println();
		System.out.println(max);
	}

	private static void checkType(int Num, boolean in) {
		if(in) {
			if(valid[Num] == 0) {
				valid[Num]++;
				numType++;
			}
			else valid[Num]++;
		}
		else {
			if(valid[Num] == 1) {
				valid[Num]--;
				numType--;
			}
			else valid[Num]--;
		}


	}
}
