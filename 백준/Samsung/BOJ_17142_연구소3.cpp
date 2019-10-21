#include <cstdio>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N, M, map[50][50], copyMap[50][50];
vector< pair<int, int> > virus;
enum { VIRUS = 2, MAX_VALUE = 1000000000};
bool isVisited[50];
int dir[4][2] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
int answer = MAX_VALUE;

void input();
void dfs(int count, int current);
int bfs();
void output();

int main() {
	input();
	dfs(0, 0);
	output();
	return 0;
}

void input() {
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			scanf("%d", &map[i][j]);
			if (map[i][j] == VIRUS) virus.push_back({i, j});
		}
	}
}
void dfs(int count, int current) {
	if (count == M) {
		int time = bfs();
		if (time != -1) {
			answer = min(answer, time);
		}
		return ;
	}
	for (int i = current, size = virus.size(); i < size; ++i) {
		isVisited[i] = true;
		dfs(count + 1, i + 1);
		isVisited[i] = false;
	}
}
int bfs() {
	int time = 0;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			copyMap[i][j] = map[i][j];
		}
	}

	queue< pair<int, int> > q;
	for (int i = 0; i < 50; ++i) {
		if (isVisited[i]) {
			q.push({ virus[i].first, virus[i].second });
			copyMap[virus[i].first][virus[i].second] = 10;
		}
	}

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; ++i) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (copyMap[nx][ny] == 0) {
					q.push({ nx, ny });
					copyMap[nx][ny] = copyMap[x][y] + 1;
					time = max(time, copyMap[nx][ny]);
				}
				else if (copyMap[nx][ny] == VIRUS) {
					q.push({ nx, ny });
					copyMap[nx][ny] = copyMap[x][y] + 1;
				}
			}
		}
	}

 	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			if (copyMap[i][j] == 0) {
				return -1;
			}
		}
	}
	if (time == 0) return 0;
	return time - 10;
}
void output() {
	if (answer == MAX_VALUE) printf("-1\n");
	else printf("%d\n", answer);
}
