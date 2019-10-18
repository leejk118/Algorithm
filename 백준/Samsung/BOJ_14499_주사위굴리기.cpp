#include <cstdio>

using namespace std;

int N, M, x, y, K, num, map[20][20];
int dice[7], copyDice[7];
enum { RIGHT = 1, LEFT, UP, DOWN, TOP, BOTTOM };
int dir[5][2] = { {0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0} };

void input();
void rollDice();
bool rollLeft();
bool rollRight();
bool rollUp();
bool rollDown();
void copyCurrentDice();

int main() {
	input();
	rollDice();
	return 0;
}

void input() {
	scanf("%d %d %d %d %d", &N, &M, &x, &y, &K);
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < M; ++j) {
			scanf("%d", &map[i][j]);
		}
	}
}
void rollDice() {
	bool canMove;
	for (int i = 0; i < K; ++i) {
		scanf("%d", &num);
		switch (num) {
			case LEFT: canMove = rollLeft(); break;
			case RIGHT: canMove = rollRight(); break;
			case UP: canMove = rollUp(); break;
			case DOWN: canMove = rollDown(); break;
			default: break;
		}
		if (canMove) {
			printf("%d\n", dice[TOP]);
		}
	}
}
bool rollLeft() {
	copyCurrentDice();
	int nx = x + dir[LEFT][0];
	int ny = y + dir[LEFT][1];
	if (0 <= nx && nx < N && 0 <= ny && ny < M) {
		x = nx;
		y = ny;
		if (map[nx][ny]) {
			dice[BOTTOM] = map[nx][ny];
			map[nx][ny] = 0;
		}
		else {
			map[nx][ny] = dice[LEFT];
			dice[BOTTOM] = map[nx][ny];
		}
		dice[LEFT] = copyDice[TOP];
		dice[TOP] = copyDice[RIGHT];
		dice[RIGHT] = copyDice[BOTTOM];
		return true;
	}
	return false;
}
bool rollRight() {
	copyCurrentDice();
	int nx = x + dir[RIGHT][0];
	int ny = y + dir[RIGHT][1];
	if (0 <= nx && nx < N && 0 <= ny && ny < M) {
		x = nx;
		y = ny;
		if (map[nx][ny]) {
			dice[BOTTOM] = map[nx][ny];
			map[nx][ny] = 0;
		}
		else {
			map[nx][ny] = dice[RIGHT];
			dice[BOTTOM] = map[nx][ny];
		}
		dice[RIGHT] = copyDice[TOP];
		dice[TOP] = copyDice[LEFT];
		dice[LEFT] = copyDice[BOTTOM];
		return true;
	}
	return false;
}
bool rollUp() {
	copyCurrentDice();
	int nx = x + dir[UP][0];
	int ny = y + dir[UP][1];
	if (0 <= nx && nx < N && 0 <= ny && ny < M) {
		x = nx;
		y = ny;
		if (map[nx][ny]) {
			dice[BOTTOM] = map[nx][ny];
			map[nx][ny] = 0;
		}
		else {
			map[nx][ny] = dice[UP];
			dice[BOTTOM] = map[nx][ny];
		}
		dice[UP] = copyDice[TOP];
		dice[TOP] = copyDice[DOWN];
		dice[DOWN] = copyDice[BOTTOM];
		return true;
	}
	return false;
}
bool rollDown() {
	copyCurrentDice();
	int nx = x + dir[DOWN][0];
	int ny = y + dir[DOWN][1];
	if (0 <= nx && nx < N && 0 <= ny && ny < M) {
		x = nx;
		y = ny;
		if (map[nx][ny]) {
			dice[BOTTOM] = map[nx][ny];
			map[nx][ny] = 0;
		}
		else {
			map[nx][ny] = dice[DOWN];
			dice[BOTTOM] = map[nx][ny];
		}
		dice[DOWN] = copyDice[TOP];
		dice[TOP] = copyDice[UP];
		dice[UP] = copyDice[BOTTOM];
		return true;
	}
	return false;
}
void copyCurrentDice() {
	for (int i = 0; i <= 6; ++i) {
		copyDice[i] = dice[i];
	}
}
