#include <cstdio>
#include <queue>

using namespace std;

int H, W, N, map[1002][1002], info[1002][1002];
queue< pair<int, int> > q;

int main(){	
	scanf("%d %d %d", &H, &W, &N);
	for (int i = 1; i <= H; ++i){
		for (int j = 1; j <= W; ++j){
			scanf("%d", &map[i][j]);
		}
	}
	
	info[1][1] = N - 1;
	for (int i = 1; i <= H; ++i){
		for (int j = 1; j <= W; ++j){
			if (info[i][j] == 0) continue;
			
			if (info[i][j] % 2 == 0){
				info[i + 1][j] += info[i][j] / 2;
				info[i][j + 1] += info[i][j] / 2;
				info[i][j] = 0;
			}
			else { // info[i][j]는 홀수  
				if (map[i][j] == 0){
					if (info[i][j] == 1) info[i + 1][j] += 1;
					else {
						info[i + 1][j] += info[i][j] / 2 + 1;
						info[i][j + 1] += info[i][j] / 2;	
					}
					map[i][j] = 1;	
					info[i][j] = 0;
				}
				else {
					if (info[i][j] == 1) info[i][j + 1] += 1;
					else {
						info[i + 1][j] += info[i][j] / 2;
						info[i][j + 1] += info[i][j] / 2 + 1;	
					}
					map[i][j] = 0;
					info[i][j] = 0;
				}
			}
		}
	}
	
	q.push({1, 1});
	while(!q.empty()){
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		if (x == H + 1 || y == W + 1){
			printf("%d %d\n", x, y);
			break;
		}
		if (map[x][y] == 0) q.push({x + 1, y});
		else q.push({x, y + 1});
	}
	 
	return 0;
}
