#include <cstdio>
#include <algorithm>

using namespace std;

int N, M, map[500][500], sum, answer;

void calculateTwoByTwo();
void calculateTwoByThree();
void calculateThreeByTwo();
void calculateFourByOne();
void calcaulteOneByFour();

int main() {
	// input
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < M; ++j) {
			scanf("%d", &map[i][j]);
		}
	}

	// calculate
	calculateTwoByTwo();
	calculateTwoByThree();
	calculateThreeByTwo();
	calculateFourByOne();
	calcaulteOneByFour();

	// output
	printf("%d\n", answer);

	return 0;
}

void calculateTwoByTwo() {
	for (int i = 0; i <= N - 2; ++i) {
		for (int j = 0; j <= M - 2; ++j) {
			answer = max(answer, map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1]);
		}
	}
}
void calculateTwoByThree() {
	for (int i = 0; i <= N - 2; ++i) {
		for (int j = 0; j <= M - 3; ++j) {
			answer = max(answer, map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j]);
			answer = max(answer, map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1]);
			answer = max(answer, map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2]);
			
			answer = max(answer, map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j]);
			answer = max(answer, map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 1]);
			answer = max(answer, map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 2]);

			answer = max(answer, map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2]);
			answer = max(answer, map[i][j + 1] + map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1]);
		}
	}
}
void calculateThreeByTwo() {
	for (int i = 0; i <= N - 3; ++i) {
		for (int j = 0; j <= M - 2; ++j) {
			answer = max(answer, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i][j + 1]);
			answer = max(answer, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1]);
			answer = max(answer, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1]);

			answer = max(answer, map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i][j]);
			answer = max(answer, map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i + 1][j]);
			answer = max(answer, map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i + 2][j]);

			answer = max(answer, map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1]);
			answer = max(answer, map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j]);
		}
	}
}
void calculateFourByOne() {
	for (int i = 0; i <= N - 4; ++i) {
		for (int j = 0; j <= M - 1; ++j) {
			answer = max(answer, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j]);
		}
	}
}
void calcaulteOneByFour() {
	for (int i = 0; i <= N - 1; ++i) {
		for (int j = 0; j <= M - 4; ++j) {
			answer = max(answer, map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3]);
		}
	}
}