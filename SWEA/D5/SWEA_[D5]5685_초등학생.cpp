#include <cstdio>
#include <memory.h>

#define NUM 1234567891
#define RANGE 20

using namespace std;

int T, N, ary[100], answer;
long long dp[100][RANGE + 1];

void init() {
	for (int i = 0; i < 100; ++i) {
		memset(dp[i], 0, sizeof(dp[i]));
	}
	dp[0][ary[0]]++;
}
void search() {
	for (int i = 1; i < N - 1; ++i) {
		for (int j = 0; j <= RANGE; ++j) {
			if (dp[i - 1][j]) {
				if (j + ary[i] <= RANGE) {
					dp[i][j + ary[i]] += dp[i - 1][j];
					if (dp[i][j + ary[i]] > NUM) dp[i][j + ary[i]] %= NUM;
				}
				if (0 <= j - ary[i]) {
					dp[i][j - ary[i]] += dp[i - 1][j];
					if (dp[i][j - ary[i]] > NUM) dp[i][j - ary[i]] %= NUM;
				}
			}
		}
	}
}

int main() {
	scanf("%d", &T);
	for (int tc = 1; tc <= T; ++tc) {
		scanf("%d", &N);
		for (int i = 0; i < N; ++i) scanf("%d", &ary[i]);
		
		init();
		search();
		
		printf("#%d %lld\n", tc, dp[N - 2][ary[N - 1]]);
	}
	return 0;
}