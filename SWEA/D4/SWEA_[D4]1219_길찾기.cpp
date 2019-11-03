#include <cstdio>
#include <queue>
#include <memory.h>

using namespace std;

int T, from, to, length, map[100][2];
bool isVisited[100];

void bfs() {
	queue<int> q;
	q.push(0);
	isVisited[0] = true;
	while (!q.empty()) {
		int now = q.front();
		q.pop();
		for (int i = 0; i < 2; ++i) {
			int next = map[now][i];
			if (isVisited[next]) continue;
			isVisited[next] = true;
			q.push(next);
		}
	}
}

int main() {
	while (true) {
		for (int i = 0; i < 100; ++i) {
			map[i][0] = 0;
			map[i][1] = 1;
		}
		if (scanf("%d %d", &T, &length) != 2) break;
		for (int i = 0; i < length; ++i) {
			scanf("%d %d", &from, &to);
			if (map[from][0]) map[from][1] = to;
			else map[from][0] = to;
		}
		memset(isVisited, false, 100);
		bfs();
		if (isVisited[99]) printf("#%d 1\n", T);
		else printf("#%d 0\n", T);
	}
	return 0;
}
