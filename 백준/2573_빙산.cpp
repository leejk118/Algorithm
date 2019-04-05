#include <iostream>
#include <queue>

using namespace std;

int N, M;
int iceberg[301][301];
bool isVisited[301][301];
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
struct Melt{
	int X, Y, W;
	Melt(int x, int y, int w) : X(x), Y(y), W(w) {}
};

void input();
void bfs(pair<int, int> pr);
void clearVisited();

int main(){
	input();	
	
	int chunk = 0;
	int year = 0;
	bool isExist = true;
	
	while (true){
		if (chunk > 1 || !isExist) {
			year--;
			break;
		}
		
		chunk = 0;
		year++;
		isExist = false;
		clearVisited();
		for (int i = 0; i < N; ++i){
			for (int j = 0; j < M; ++j){
				if (!isVisited[i][j] && iceberg[i][j] > 0){
					isExist = true;
					chunk++;
					bfs(make_pair(i, j));
				}
			}
		}
	}
	
	if (chunk == 0) year = 0;
	cout << year << '\n';
	
	return 0;
}

void input(){
	cin >> N >> M;
	for (int i = 0; i < N; ++i){
		for (int j = 0; j < M; ++j){
			cin >> iceberg[i][j];
		}
	}
}

void bfs(pair<int, int> pr){
	queue< pair<int, int> > q;
	queue<Melt> melt;
	q.push(make_pair(pr.first, pr.second));
	isVisited[pr.first][pr.second] = true;
	
	while(!q.empty()){
		int x = q.front().first;
		int y = q.front().second;
		
		q.pop();
		
		int water = 0;
		for (int i = 0; i < 4; ++i){
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (0 <= nx && nx < N && 0 <= ny && ny < M){
				if (isVisited[nx][ny]) continue;
				if (iceberg[nx][ny] == 0) water++;
				else {
					q.push(make_pair(nx,ny));
					isVisited[nx][ny] = true;	
				}
			}	
		}
		Melt melting(x, y, water);
		melt.push(melting);
	}
	
	while(!melt.empty()){
		iceberg[melt.front().X][melt.front().Y] -= melt.front().W;
		if (iceberg[melt.front().X][melt.front().Y] < 0) iceberg[melt.front().X][melt.front().Y] = 0;
		melt.pop();
	}
}

void clearVisited(){
	for (int i = 0; i < N; ++i){
		for (int j = 0; j < M; ++j){
			isVisited[i][j] = false;
		}
	}
}
