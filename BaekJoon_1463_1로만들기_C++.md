# BaekJoon_1463_1로만들기
```
#include <iostream>
using namespace std;

int min(int a, int b);

int main()
{
	int N, dp[1000001];
	cin >> N;
	
	dp[1] = 0;
	for (int i = 2; i <= N; ++i) {
		dp[i] = dp[i - 1] + 1;
		if (i % 2 == 0) {
			dp[i] = min(dp[i / 2] + 1, dp[i]);
		}
		if(i % 3 == 0) {
			dp[i] = min(dp[i / 3] + 1, dp[i]);
		}
	}
	cout << dp[N];
    return 0;
}

int min(int a, int b) {
	if (a < b) return a;
	else return b;
}
```
