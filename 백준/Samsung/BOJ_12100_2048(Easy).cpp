#include <cstdio>
#include <algorithm>
#include <vector>
#define UP 0
#define LEFT 1
#define DOWN 2
#define RIGHT 3

using namespace std;

int N, map[20][20];
int answer;

void input();
void dfs(int count);
void moveMap(int index);
void copyMap(int cpMap[][20]);
void backUpMap(int cpMap[][20]);
void findMax();
void output();

int main() {
	input();
	dfs(1);
	output();
	return 0;
}

void input() {
	scanf("%d", &N);
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			scanf("%d", &map[i][j]);
		}
	}
}
void dfs(int count) {
	if (count > 5) {
		findMax();
		return;
	}

	int cpMap[20][20];
	copyMap(cpMap);

	for (int i = 0; i < 4; ++i) {
		moveMap(i);
		dfs(count + 1);
		backUpMap(cpMap);
	}
}
void moveMap(int index) {
	int temp[20];
	if (index == LEFT) {
		for (int i = 0; i < N; ++i) {
			vector<int> v;
			for (int j = 0; j <= N - 1; ++j) {
				if (map[i][j]) v.push_back(map[i][j]);
				map[i][j] = 0;
			}
			int index = 0;
			for (int k = 0, size = v.size(); k < size; ++k) {
				if (k + 1 < size && v[k] == v[k + 1]) {
					map[i][index++] = v[k] * 2;
					k++;
				}
				else map[i][index++] = v[k];
			}
		}
	}
	else if (index == UP) {
		for (int i = 0; i < N; ++i) {
			vector<int> v;
			for (int j = 0; j <= N - 1; ++j) {
				if (map[j][i]) v.push_back(map[j][i]);
				map[j][i] = 0;
			}
			int index = 0;
			for (int k = 0, size = v.size(); k < size; ++k) {
				if (k + 1 < size && v[k] == v[k + 1]) {
					map[index++][i] = v[k] * 2;
					k++;
				}
				else map[index++][i] = v[k];
			}
		}
	}
	else if (index == RIGHT) {
		for (int i = 0; i < N; ++i) {
			vector<int> v;
			for (int j = N - 1; j >= 0; --j) {
				if (map[i][j]) v.push_back(map[i][j]);
				map[i][j] = 0;
			}
			int index = N - 1;
			for (int k = 0, size = v.size(); k < size; ++k) {
				if (k + 1 < size && v[k] == v[k + 1]) {
					map[i][index--] = v[k] * 2;
					k++;
				}
				else map[i][index--] = v[k];
			}
		}
	}
	else { // DOWN
		for (int i = 0; i < N; ++i) {
			vector<int> v;
			for (int j = N - 1; j >= 0; --j) {
				if (map[j][i]) v.push_back(map[j][i]);
				map[j][i] = 0;
			}
			int index = N - 1;
			for (int k = 0, size = v.size(); k < size; ++k) {
				if (k + 1 < size && v[k] == v[k + 1]) {
					map[index--][i] = v[k] * 2;
					k++;
				}
				else map[index--][i] = v[k];
			}
		}
	}
}
void findMax() {
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			answer = max(answer, map[i][j]);
		}
	}
}
void copyMap(int cpMap[][20]) {
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			cpMap[i][j] = map[i][j];
		}
	}
}
void backUpMap(int cpMap[][20]) {
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			map[i][j] = cpMap[i][j];
		}
	}
}
void output() {
	printf("%d\n", answer);
}
