#include <cstdio>
#include <queue>

using namespace std;

int R, C, T, map[51][51], spreadDustSum[51][51];
int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };
int answer;
vector< pair<int, int> > cleaner;
queue< pair<int, int> > qDust;

void input();
void findDustLocation();
void spreadDust();
void cleanAir();
void cleanTop();
void cleanBottom();
void output();

int main() {	
	input();
	for (int i = 0; i < T; ++i) {
		findDustLocation();
		spreadDust();
		cleanAir();
	}
	output();
	return 0;
}

void input() {
	scanf("%d %d %d", &R, &C, &T);
	for (int i = 0; i < R; ++i) {
		for (int j = 0; j < C; ++j) {
			scanf("%d", &map[i][j]);
			if (map[i][j] == -1) {
				cleaner.push_back({ i, j });
			}
		}
	}
}
void findDustLocation() {
	for (int i = 0; i < R; ++i) {
		for (int j = 0; j < C; ++j) {
			if (map[i][j]) {
				qDust.push({ i, j });
			}
		}
	}
}
void spreadDust() {
	while(!qDust.empty()) {
		int x = qDust.front().first;
		int y = qDust.front().second;
		qDust.pop();

		int count = 0;
		int dustValue = map[x][y] / 5;
		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (map[nx][ny] == -1) continue;
			if (0 <= nx && nx < R && 0 <= ny && ny < C) {
				spreadDustSum[nx][ny] += dustValue;
				count++;
			}
		}
		map[x][y] -= dustValue * count;
	}
	for (int i = 0; i < R; ++i) {
		for (int j = 0; j < C; ++j) {
			map[i][j] += spreadDustSum[i][j];
			spreadDustSum[i][j] = 0;
		}
	}
}
void cleanAir() {
	cleanTop();
	cleanBottom();
}
void cleanTop() {
	int top = cleaner[0].first;
	int r = top - 1;
	int c = 0;
	map[r][c] = 0;
	while (true) {
		if (r == 0) break;
		map[r][c] = map[r - 1][c];
		r--;
	}
	while (true) {
		if (c == C - 1) break;
		map[r][c] = map[r][c + 1];
		c++;
	}
	while (true) {
		if (r == top) break;
		map[r][c] = map[r + 1][c];
		r++;
	}
	while (true) {
		if (c == 1) break;
		map[r][c] = map[r][c - 1];
		c--;
	}
	map[top][1] = 0;
}
void cleanBottom() {
	int bottom = cleaner[1].first;
	int r = bottom + 1;
	int c = 0;
	map[r][c] = 0;
	while (true) {
		if (r == R - 1) break;
		map[r][c] = map[r + 1][c];
		r++;
	}
	while (true) {
		if (c == C - 1) break;
		map[r][c] = map[r][c + 1];
		c++;
	}
	while (true) {
		if (r == bottom) break;
		map[r][c] = map[r - 1][c];
		r--;
	}
	while (true) {
		if (c == 1) break;
		map[r][c] = map[r][c - 1];
		c--;
	}
	map[bottom][1] = 0;
}
void output() {
	for (int i = 0; i < R; ++i) {
		for (int j = 0; j < C; ++j) {
			if (map[i][j] == -1) continue;
			answer += map[i][j];
		}
	}
	printf("%d\n", answer);
}
