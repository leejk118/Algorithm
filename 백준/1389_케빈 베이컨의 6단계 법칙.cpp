#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M, a, b;
vector<int> user[101];

int bfs(int start);

int main(){
	int bacon[101];
	int min = 999;
	
	cin >> N >> M;
	for (int i = 0; i < M; ++i){
		cin >> a >> b;
		user[a].push_back(b);
		user[b].push_back(a);
	}
	
	for (int i = 1; i <= N; ++i){
		bacon[i] = bfs(i);
		if (bacon[i] < min) min = bacon[i];
	}
	
	for (int i = 1; i <= N; ++i){
		if (bacon[i] == min){
			cout << i;
			break;
		}
	} 
	
	return 0;
}

int bfs(int start){
	int count = 1;
	int baconNum = 0;
	int friends[101] = {0, };	
	bool isVisited[101] = {false, };
	queue<pair<int, int> > q;
	
	isVisited[start] = true;
	for (int i = 0, size = user[start].size(); i < size; ++i){
		int nx = user[start][i];
		friends[nx] = count;
		isVisited[nx] = true;
		q.push(make_pair(nx, count + 1));
	}

	while(!q.empty()){
		int next = q.front().first;
		count = q.front().second;
		q.pop();
		for (int i = 0, size = user[next].size(); i < size; ++i){
			int nx = user[next][i];
			if (isVisited[nx]) continue;
			q.push(make_pair(nx, count + 1));
			if (friends[nx] == 0 || friends[nx] > count){
				friends[nx] = count;
				isVisited[nx] = true;
			}
		}
		
	}
	
	for (int i = 1; i <= N; ++i){
		if (i == start) continue;
		baconNum += friends[i];
	}
	
	return baconNum;
}
