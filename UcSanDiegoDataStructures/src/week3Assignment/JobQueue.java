//package week3Assignment;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JobQueue {
	private int num_workers;
	private int[] jobs;

	private int[] assigned_workers;
	private long[] start_times;

	private FastScanner in;
	private PrintWriter out;

	private void readData() throws IOException {
		num_workers = in.nextInt();


		int num_jobs = in.nextInt();
		jobs = new int[num_jobs];
		for (int i = 0; i < num_jobs; i++) {
			jobs[i] = in.nextInt();
		}
	}

	private void writeResponse() throws IOException {
		for (int i = 0; i < jobs.length; i++) {
			out.println(assigned_workers[i] + " " + start_times[i]);
		}
	}

	private void assignJobs() {
		assigned_workers = new int[jobs.length];
		start_times = new long[jobs.length];

		long[] worker_finish_times = new long[num_workers];

		for (int i = 0; i < jobs.length; i++) {
			int duration = jobs[i];
			int next_worker = getMinIndex(worker_finish_times);

			assigned_workers[i]= next_worker;
			start_times[i]=worker_finish_times[next_worker];
			worker_finish_times[next_worker]+=duration;
		}

	}

	private int getMinIndex(long[] arr) {
		int minIndex = -1;
		long minVal = Long.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (minVal > arr[i]) {
				minIndex = i;
				minVal = arr[i];
			}
		}
		return minIndex;
	}
	
	private long getMinValue(long[] arr) {
		int minIndex = -1;
		long minVal = Long.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (minVal > arr[i]) {
				minIndex = i;
				minVal = arr[i];
			}
		}
		return minVal;
	}

	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	private void solve() throws IOException {
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		readData();
		assignJobs();
		writeResponse();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new JobQueue().solve();
	}

}
