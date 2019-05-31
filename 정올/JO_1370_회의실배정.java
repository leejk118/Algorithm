import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
	int index, start, end;
	public Meeting (int index, int start, int end) {
		this.index = index;
		this.start = start;
		this.end = end;
	}
	
	public int compareTo(Meeting meeting) {
		return this.end - meeting.end;
	}
}

public class JO_1370_회의실배정{

	public static int N;
	public static Meeting[] meeting;
	public static ArrayList<Integer> al = new ArrayList<>();
	
	public static void main(String[] args) {
		input();
		greedy();
		output();
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		meeting = new Meeting[N];
		
		int index, start, end;
		for (int i = 0; i < N; ++i) {
			index = sc.nextInt();
			start = sc.nextInt();
			end = sc.nextInt();
			meeting[i] = new Meeting(index, start, end);
		}
		sc.close();
	}
	public static void greedy() {
		Arrays.sort(meeting);

		int currentTime = meeting[0].end;
		al.add(meeting[0].index);
		for (int i = 1; i < N; ++i) {
			if (currentTime <= meeting[i].start) {
				al.add(meeting[i].index);
				currentTime = meeting[i].end;
			}
		}
	}
	public static void output() {
		System.out.println(al.size());
		for (Integer data : al)
			System.out.print(data + " ");
	}

}
