#include <cstdio>

using namespace std;

int main() {
	int T, K;
	long long dp[91][2];

	dp[1][0] = 2;
	dp[1][1] = 1;
	for (int i = 2; i <= 90; ++i) {
		dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
		dp[i][1] = dp[i - 1][0];
	}

	scanf("%d", &T);
	for (int tc = 1; tc <= T; ++tc) {
		scanf("%d", &K);
		printf("#%d %lld %lld\n", tc, dp[K][0], dp[K][1]);
	}
	return 0;
}
