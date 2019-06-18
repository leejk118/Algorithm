import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = "0" + br.readLine();
		String str2 = "0" + br.readLine();
		
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] lcs = new int[len1 + 1][len2 + 1];
		for (int i = 1; i < len1; ++i) {
			for (int j = 1; j < len2; ++j) {
				if (str1.charAt(i) == str2.charAt(j)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				}
				else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		System.out.println(lcs[len1 - 1][len2 - 1]);
	}

}
