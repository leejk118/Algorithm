#include <cstdio>
#include <vector>
#include <queue>

using namespace std;

int main(){
	const int PROBLEM = 32001;
	int N, M, A, B;
	int indegree[PROBLEM];
	vector<int> problem[PROBLEM]; 
	priority_queue<int> pq;
	
	scanf("%d %d", &N, &M);
	for (int i = 0; i < M; ++i){
		scanf("%d %d", &A, &B);
		problem[A].push_back(B);
		indegree[B]++;
	}
	
	for (int i = 1; i <= N; ++i){
		if (indegree[i] == 0){
			pq.push(-i);
		}
	}
	
	while(!pq.empty()){
		int now = -pq.top();
		pq.pop();
		printf("%d ", now);
		for (int i = 0, size = problem[now].size(); i < size; ++i){
			int next = problem[now][i];
			indegree[next]--;
			if (indegree[next] == 0){
				pq.push(-next);
			}
		}
	}
	
	return 0;
}
