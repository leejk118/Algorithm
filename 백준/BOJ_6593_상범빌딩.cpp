#include <cstdio>
#include <queue>

#define INF 987654321

using namespace std;

struct Node {
	int x, y, z;
	Node(int x, int y, int z) : x(x), y(y), z(z){
	}
};

int L, R, C;
char map[31][31][31];
int dist[31][31][31];
int dx[] = {1, 0, -1, 0, 0, 0};
int dy[] = {0, 1, 0, -1, 0, 0};
int dz[] = {0, 0, 0, 0, 1, -1};
int answerX, answerY, answerZ;
queue<Node> q;

void clear();
bool bfs();
	
int main(){
	while (true){
		scanf("%d %d %d", &L, &R, &C);
		if (L == 0 && R == 0 && C == 0) break;
		for (int i = 0; i < L; ++i){
			for (int j = 0; j < R; ++j){
				char ch[31];
				scanf("%s", ch);
				for (int k = 0; k < C; ++k){
					//scanf(" %c ", &map[i][j][k]);
					map[i][j][k] = ch[k];
					if (map[i][j][k] == 'S') q.push(Node(i, j, k));
				}
			}
		}
		clear();
		if (bfs()) printf("Escaped in %d minute(s).\n", dist[answerX][answerY][answerZ]);
		else printf("Trapped!\n");
		while(!q.empty()) q.pop();
	}
	return 0;
}

void clear(){
	for (int i = 0; i < L; ++i){
		for (int j = 0; j < R; ++j){
			for (int k = 0; k < C; ++k){
				dist[i][j][k] = INF;
			}
		}
	}
	dist[q.front().x][q.front().y][q.front().z] = 0;
}
bool bfs(){
	while(!q.empty()){
		int x = q.front().x;
		int y = q.front().y;
		int z = q.front().z;
		q.pop();
		for (int i = 0; i < 6; ++i){
			int nx = x + dx[i];
			int ny = y + dy[i];
			int nz = z + dz[i];
			if (0 <= nx && nx < L && 0 <= ny && ny < R && 0 <= nz && nz < C){
				if (map[nx][ny][nz] == '#') continue;
				if (dist[nx][ny][nz] > dist[x][y][z] + 1){
					dist[nx][ny][nz] = dist[x][y][z] + 1;
					if (map[nx][ny][nz] == 'E') {
						answerX = nx;
						answerY = ny;
						answerZ = nz;
						return true;	
					}
					q.push(Node(nx, ny, nz));
				}
			}
		}
	}
	return false;
}
