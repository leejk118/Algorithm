import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Student {
	String name;
	int variety;
	Student(String name, int variety) {
		this.name = name;
		this.variety = variety;
	}
}
class StudentCompare implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
	//	return (s1.name.replaceAll(" ", "")).compareTo((s2.name.replaceAll(" ", "")));
		return s1.name.compareTo(s2.name);
	}
}
public class SWEA_D4_7792_반장선출 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int N;
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int max = 0;
			
			Student[] student = new Student[N];
			
			for (int i = 0; i < N; ++i) {
				String stuName = br.readLine();
				int variety = 0;
				boolean[] alphabet = new boolean[26];
				
				for (int j = 0, length = stuName.length(); j < length; ++j) {
					if (stuName.charAt(j) == ' ') continue;
					alphabet[stuName.charAt(j) - 'A'] = true;
				}
					
				for (int j = 0; j < 26; ++j)
					if (alphabet[j]) variety++;
				max = max > variety ? max : variety;

				student[i] = new Student(stuName, variety);
			}
			Arrays.sort(student, new StudentCompare());

			for (int k = 0, len = student.length; k < len; ++k) {
				if (student[k].variety == max) {
					System.out.println("#" + tc + " " + student[k].name);
					break;
				}
			}
		}
	}

}
