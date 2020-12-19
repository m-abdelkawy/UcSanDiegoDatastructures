//package week1Assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Data Structures UC San Diego MOOC Coursera Week 1 Network packet processing
 * simulation
 * 
 * @author Mohammed Abdelkawy: December 13, 2020
 */

class Request {
	public int arrival_time;
	public int process_time;

	public Request(int _arrival_time, int _process_time) {
		arrival_time = _arrival_time;
		process_time = _process_time;
	}
}

class Response {
	public int start_time;
	public boolean isDropped;

	public Response(int _start_time, boolean _isDropped) {
		start_time = _start_time;
		isDropped = _isDropped;
	}
}

class Buffer {
	private int size;
	private ArrayList<Integer> lst_finish_time;
	Queue<Response> response_queue;

	public Buffer(int _size) {
		size = _size;
		lst_finish_time = new ArrayList<Integer>();
	}

	public Response process_request(Request request) {

		if (!lst_finish_time.isEmpty() && lst_finish_time.get(0) <= request.arrival_time) {
			lst_finish_time.remove(0);
		}
		if (lst_finish_time.size() == size) {
			return new Response(-1, true);
		}
		int start_time = lst_finish_time.isEmpty() ? request.arrival_time
				: lst_finish_time.get(lst_finish_time.size() - 1);
		lst_finish_time.add(start_time + request.process_time);
		return new Response(start_time, false);

	}
}

public class process_packages {
	private static ArrayList<Request> ReadQueries(Scanner scanner) throws IOException {
		int requests_count = scanner.nextInt();
		ArrayList<Request> lst_Request = new ArrayList<Request>();
		for (int i = 0; i < requests_count; i++) {
			int arrival_time = scanner.nextInt();
			int process_time = scanner.nextInt();
			lst_Request.add(new Request(arrival_time, process_time));
		}
		return lst_Request;
	}

	private static ArrayList<Response> process_requests(ArrayList<Request> lst_request, Buffer buffer) {
		ArrayList<Response> lst_response = new ArrayList<Response>();
		for (int i = 0; i < lst_request.size(); ++i) {
			lst_response.add(buffer.process_request(lst_request.get(i)));
		}
		return lst_response;
	}

	private static void print_responses(ArrayList<Response> lst_response) {
		for (int i = 0; i < lst_response.size(); ++i) {
			Response response = lst_response.get(i);
			if (response.isDropped) {
				System.out.println(-1);
			} else {
				System.out.println(response.start_time);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		int buffer_max_size = scanner.nextInt();
		Buffer buffer = new Buffer(buffer_max_size);

		ArrayList<Request> requests = ReadQueries(scanner);
		ArrayList<Response> responses = process_requests(requests, buffer);
		print_responses(responses);
	}

}
