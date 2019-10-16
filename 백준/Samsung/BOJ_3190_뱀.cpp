#include <cstdio>
#include <queue>

#define APPLE 7
#define UP 0
#define RIGHT 1
#define DOWN 2
#define LEFT 3

using namespace std;

int N, K, L, map[101][101], snakeDir;
int dir[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
bool trace[101][101];
queue< pair<int, int> > rot;
deque< pair<int, int> > snake;
int timeCount;

void input();
void simulate();
void output();

int main() {
	input();
	simulate();
	output();
	return 0;
}

void input() {
	int a, b;
	char c;

	scanf("%d %d", &N, &K);
	for (int i = 0; i < K; ++i) {
		scanf("%d %d", &a, &b);
		map[a][b] = APPLE;
	}
	scanf("%d", &L);
	for (int i = 0; i < L; ++i) {
		scanf("%d", &a);
		scanf(" %c", &c);
		if (c == 'D') rot.push({ a, RIGHT });
		else rot.push({ a, LEFT });
	}
}
void simulate() {
	trace[1][1] = true;
	snake.push_back({ 1, 1 });
	snakeDir = RIGHT;
	int x, y, nx, ny;

	while (true) {
		x = snake.front().first;
		y = snake.front().second;

		timeCount++;
		nx = x + dir[snakeDir][0];
		ny = y + dir[snakeDir][1];

		if (0 >= nx || nx > N || 0 >= ny || ny > N) break;
		if (trace[nx][ny] == true) break;

		if (map[nx][ny] == APPLE) {
			map[nx][ny] = 0;
			snake.push_front({ nx, ny });
			trace[nx][ny] = true;
		}
		else {
			snake.push_front({ nx, ny });
			pair<int, int> pr = snake.back();
			trace[nx][ny] = true;
			trace[pr.first][pr.second] = false;
			snake.pop_back();
		}
		
		if (!rot.empty() && timeCount == rot.front().first) {
			if (rot.front().second == LEFT) {
				snakeDir = (snakeDir + 3) % 4;
			}
			else { // RIGHT
				snakeDir = (snakeDir + 1) % 4;
			}
			rot.pop();
		}
	}
}
void output() {
	printf("%d\n", timeCount);
}
