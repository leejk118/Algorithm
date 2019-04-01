#include <iostream>
#include <queue>

using namespace std;

int N;
int answer1, answer2;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
char matrix[101][101][2];
bool isVisited[101][101][2];

void bfs(int i, int j, int k); 

int main(){
	// input
	cin >> N;
	for (int i = 0; i < N; ++i){
		for (int j = 0; j < N; ++j){
			cin >> matrix[i][j][0];
			matrix[i][j][1] = matrix[i][j][0];
			if (matrix[i][j][1] == 'R')
				matrix[i][j][1] = 'G';
		} 
	}
	
	// solution : BFS
	for (int i = 0; i < N; ++i){
		for (int j = 0; j < N; ++j){
			if (!isVisited[i][j][0]){
				bfs(i, j, 0);
				answer1++;
			}
			if (!isVisited[i][j][1]){
				bfs(i, j, 1);
				answer2++;
			}
		}
	}
	
	// output
	cout << answer1 << " " << answer2 << '\n';
	
	return 0;
}

void bfs(int i, int j, int k){
	queue<pair<int, int> > q;
	q.push(make_pair(i, j));
	isVisited[i][j][k] = true;
	while (!q.empty()){
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; ++i){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N){
				if (!isVisited[nx][ny][k] && matrix[nx][ny][k] == matrix[x][y][k]){
					isVisited[nx][ny][k] = true;
					q.push(make_pair(nx,ny));
				}
			}
		}
	}
}
