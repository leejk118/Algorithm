#include <iostream>
#include <vector>

using namespace std;

int N, M, matrix[9][9];
struct CCTV{
	int x;
	int y;
	int type;
	bool direction[4];  
	CCTV(int x, int y, int type) : x(x), y(y), type(type){};
};
vector<CCTV> vc;
int answer = 100000;

void input();
void dfs(int index);
void check(int (*cpMatrix)[9], int x, int y, int direction);
int countBlindSpot();
void output();

int main(){
	input();
	dfs(0);
	output();
	return 0;
}

void input(){
	cin >> N >> M;
	for (int i = 0; i < N; ++i){
		for (int j = 0; j < M; ++j){
			cin >> matrix[i][j];
			if (1 <= matrix[i][j] && matrix[i][j] <= 5){
				vc.push_back( CCTV(i, j, matrix[i][j]) );
			}
		}
	}
}
void dfs(int index){
	if (index == vc.size()){
		int min = countBlindSpot();
		if (min < answer) answer = min;
		return ;
	}

	for (int i = index, size = vc.size(); i < size; ++i){
		switch(vc[i].type){
			case 1:
				for (int j = 0; j < 4; ++j){
					vc[i].direction[j] = true;
					dfs(i + 1);
					vc[i].direction[j] = false;
				}
				break;
			case 2:
				for (int j = 0; j < 2; ++j){
					vc[i].direction[j] = true;
					vc[i].direction[j + 2] = true;
					dfs(i + 1);
					vc[i].direction[j] = false;
					vc[i].direction[j + 2] = false;
				}
				break;
			case 3:
				for (int j = 0; j < 4; ++j){
					vc[i].direction[j] = true;
					vc[i].direction[(j + 1) % 4] = true;
					dfs(i + 1);
					vc[i].direction[j] = false;
					vc[i].direction[(j + 1) % 4] = false;
				}
				break;
			case 4:
				for (int j = 0; j < 4; ++j){
					vc[i].direction[j] = true;
					vc[i].direction[(j + 1) % 4] = true;
					vc[i].direction[(j + 2) % 4] = true;
					dfs(i + 1);
					vc[i].direction[j] = false;
					vc[i].direction[(j + 1) % 4] = false;
					vc[i].direction[(j + 2) % 4] = false;
				}
				break;
			case 5:
				vc[i].direction[0] = true;
				vc[i].direction[1] = true;
				vc[i].direction[2] = true;
				vc[i].direction[3] = true;
				dfs(i + 1);
				vc[i].direction[0] = false;
				vc[i].direction[1] = false;
				vc[i].direction[2] = false;
				vc[i].direction[3] = false;
				break;
		}	
	}
}

int countBlindSpot(){
	int min = 0;
	int cpMatrix[9][9];
	for (int i = 0; i < N; ++i){
		for (int j = 0; j < M; ++j){
			cpMatrix[i][j] = matrix[i][j];
		}
	}
	
	for (int i = 0, size = vc.size(); i < size; ++i){
		for (int j = 0; j < 4; ++j){
			if (vc[i].direction[j]){
				check(cpMatrix, vc[i].x, vc[i].y, j);
			}
		}
	}
	
	for (int i = 0; i < N; ++i){
		for (int j = 0; j < M; ++j){
			if (cpMatrix[i][j] == 0){
				min++;
			}
		}
	}
	return min;
}

void check(int (*cpMatrix)[9], int x, int y, int direction){
	if (direction == 0){ 
		while (true){
			y--;
			if (cpMatrix[x][y] == 6) break;
			if (1 <= cpMatrix[x][y] && cpMatrix[x][y] <= 5) continue;
			if (y < 0) break;
			cpMatrix[x][y] = 7;
		}
	}
	if (direction == 1){
		while (true){
			x++;
			if (cpMatrix[x][y] == 6) break;
			if (1 <= cpMatrix[x][y] && cpMatrix[x][y] <= 5) continue;
			if (x >= N) break;
			cpMatrix[x][y] = 7;
		}
	}
	if (direction == 2){
		while (true){
			y++;
			if (cpMatrix[x][y] == 6) break;
			if (1 <= cpMatrix[x][y] && cpMatrix[x][y] <= 5) continue;
			if (y >= M) break;
			cpMatrix[x][y] = 7;
		}
	}
	if (direction == 3){
		while (true){
			x--;
			if (cpMatrix[x][y] == 6) break;
			if (1 <= cpMatrix[x][y] && cpMatrix[x][y] <= 5) continue;
			if (x < 0) break;
			cpMatrix[x][y] = 7;
		}
	}
}

void output(){
	cout << answer << '\n';
}
