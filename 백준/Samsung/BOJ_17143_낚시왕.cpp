#include <cstdio>
#include <queue>

using namespace std;

typedef struct Shark {
	int s, d, z;
} Shark;

int R, C, M, r, c, s, d, z;
Shark shark[101][101];
priority_queue<Shark> waitingList[101][101];
enum { UP = 1, DOWN, RIGHT, LEFT};
int dir[5][2] = { {0, 0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
int answer;

void input();
void simulate();
void fishermanCatch(int column);
void sharkMove();
void output();

bool operator< (const Shark& a, const Shark& b) {
	return a.z < b.z;
}

int main() {	
	input();
	simulate();
	output();
	return 0;
}

void input() {
	scanf("%d %d %d", &R, &C, &M);
	for (int i = 0; i < M; ++i) {
		scanf("%d %d %d %d %d", &r, &c, &s, &d, &z);
		shark[r][c] = Shark({ s, d, z });
	}
}
void simulate() {
	for (int i = 1; i <= C; ++i) {
		fishermanCatch(i);
		sharkMove();
	}
}
void fishermanCatch(int column) {
	for (int i = 1; i <= R; ++i) {
		if (shark[i][column].z == 0) continue;
		answer += shark[i][column].z;
		shark[i][column] = Shark();
		break;
	}
}
void sharkMove() {
	int nr, nc, ns, nd, nz;
	int nnr, nnc;

	for (int i = 1; i <= R; ++i) {
		for (int j = 1; j <= C; ++j) {
			if (shark[i][j].z == 0) continue;
			Shark sh = shark[i][j];
			nr = i, nc = j;
			ns = sh.s, nd = sh.d, nz = sh.z;
			
			nnr = nr + dir[nd][0] * ns;
			nnc = nc + dir[nd][1] * ns;

			while (true) {
				if (1 <= nnr && nnr <= R && 1 <= nnc && nnc <= C) break;
				if (nnr < 1) {
					nd = DOWN;
					nnr = -nnr + 2;
				}
				else if (R < nnr) {
					nd = UP;
					nnr = R - (nnr - R);
				}
				else if (nnc < 1) {
					nd = RIGHT;
					nnc = -nnc + 2;
				}
				else { // C < nnc
					nd = LEFT;
					nnc = 2 * C - nnc;
				}
			}
			shark[i][j] = Shark();
			waitingList[nnr][nnc].push(Shark({ sh.s, nd, nz }));
		}
	}
	for (int i = 1; i <= R; ++i) {
		for (int j = 1; j <= C; ++j) {
			if (waitingList[i][j].empty()) continue;
			shark[i][j] = waitingList[i][j].top();

			while (!waitingList[i][j].empty()) {
				waitingList[i][j].pop();
			}
		}
	}
}
void output() {
	printf("%d\n", answer);
}
