#include <cstdio>
#include <memory.h>

#define NUM 100

using namespace std;

int T, N, map[NUM][NUM], dp[NUM][NUM];
int nx, ny;

void input() {
	scanf("%d", &N);
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			scanf("%d", &map[i][j]);
		}
	}
}
void init() {
	for (int i = 0; i < N; ++i) {
		memset(dp[i], 0, sizeof(dp[i]));
	}
	dp[0][0] = 1;
}
void check() {
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			if (!dp[i][j]) continue;
			nx = i + map[i][j];
			ny = j + map[i][j];

			if (nx < N) dp[nx][j]++;
			if (ny < N) dp[i][ny]++;
		}
	}
}
void output() {
	if (dp[N - 1][N - 1]) printf("YES\n");
	else printf("NO\n");
}

int main() {
	scanf("%d", &T);
	for (int tc = 1; tc <= T; ++tc) {
		input();
		init();
		check();
		output();
	}
	return 0;
}