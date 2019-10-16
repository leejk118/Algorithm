#include <cstdio>
#include <math.h>

using namespace std;

int N, M, map[50][50];
int robotX, robotY, robotDir;
int dir[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
int answer;

void input();
void simulate();
void cleanCurrentArea();
void output();

int main() {
	input();
	simulate();
	output();
	return 0;
}

void input() {
	scanf("%d%d", &N, &M);
	scanf("%d%d%d", &robotX, &robotY, &robotDir);
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < M; ++j) {
			scanf("%d", &map[i][j]);
		}
	}
}
void simulate() {
	int flag = 0;
	int left, behind;
	bool isOver = false;
	while (true) {
		if (isOver) break;
		cleanCurrentArea();

		while (true) {
			left = (robotDir + 3) % 4;
			if (map[robotX + dir[left][0]][robotY + dir[left][1]] == 0) {
				robotX += dir[left][0];
				robotY += dir[left][1];
				robotDir = left;
				flag = 0;
				break;
			}
			else {
				robotDir = left;
				flag = flag | (int)pow(2, left);
				if (flag == 15) {
					flag = 0;
					behind = (robotDir + 2) % 4;
					if (map[robotX + dir[behind][0]][robotY + dir[behind][1]] == 1) {
						isOver = true;
						break;
					}
					robotX += dir[behind][0];
					robotY += dir[behind][1];
				}
				
			}
		}
	}
}
void cleanCurrentArea() {
	if (map[robotX][robotY] == 0) {
		map[robotX][robotY] = --answer;
	}
}
void output() {
	printf("%d\n", -answer);
}
