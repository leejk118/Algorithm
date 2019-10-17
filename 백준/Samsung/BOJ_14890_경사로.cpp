#include <cstdio>
#include <cstdlib>
#include <string.h>

using namespace std;

int N, L, map[100][100];
int answer;

void input();
void simulate();
bool check(int ary[], bool isVisited[]);
bool checkReverse(int ary[], bool isVisited[]);
void output();

int main() {
	input();
	simulate();
	output();
	return 0;
}

void input() {
	scanf("%d %d", &N, &L);
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			scanf("%d", &map[i][j]);
		}
	}
}
void simulate() {
	int row[100], col[100];
	bool isVisited[100];

	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			row[j] = map[i][j];
			col[j] = map[j][i];
		}

		memset(isVisited, false, N);
		if (check(row, isVisited) && checkReverse(row, isVisited)) {
			answer++;
		}
		memset(isVisited, false, N);
		if (check(col, isVisited) && checkReverse(col, isVisited)) {
			answer++;
		}
	}
}
bool check(int ary[], bool isVisited[]) {
	int current = ary[0];
	int currentCount = 1;
	for (int i = 1; i < N; ++i) {
		if (abs(current - ary[i]) >= 2) return false;
		if (current == ary[i]) currentCount++;
		else if (current > ary[i]) {
			current = ary[i];
			currentCount = 1;
		}
		else {
			if (currentCount < L) return false;
			for (int j = 1; j <= L; ++j) {
				isVisited[i - j] = true;
			}
			current = ary[i];
			currentCount = 1;
		}
	}
	return true;
}
bool checkReverse(int ary[], bool isVisited[]) {
	int current = ary[N - 1];
	int currentCount = 1;
	for (int i = N - 2; i >= 0; --i) {
		if (abs(current - ary[i]) >= 2) return false;
		if (current == ary[i]) currentCount++;
		else if (current > ary[i]) {
			current = ary[i];
			currentCount = 1;
		}
		else {
			if (currentCount < L) return false;
			for (int j = 1; j <= L; ++j) {
				if (isVisited[i + j]) return false;
			}
			current = ary[i];
			currentCount = 1;
		}
	}
	return true;
}
void output() {
	printf("%d\n", answer);
}
