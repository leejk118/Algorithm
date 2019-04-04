#include <iostream>
#include <vector>
#include <cstdlib>

using namespace std;

int N;
int matrix[21][21];
bool isVisited[21];
int answer = 100000;

void input();
void dfs(int index, int count);
void calAbility();
void output(); 

int main(){
	input();
	dfs(0, 0);
	output();
	return 0;
}

void input(){
	cin >> N;
	for (int i = 0; i < N; ++i){
		for (int j = 0; j < N; ++j){
			cin >> matrix[i][j];
		}
	}
}

void dfs(int index, int count){
	if (count == (N / 2)){
		calAbility();
		return ;
	}
	for (int i = index; i < N; ++i){
		if (isVisited[i]) continue;
		isVisited[i] = true;
		dfs(i + 1, count + 1);
		isVisited[i] = false;
	}
}
void calAbility(){
	vector<int> home, away;
	int homeSum = 0, awaySum = 0;
	for (int i = 0; i < N; ++i){
		if (isVisited[i]){
			home.push_back(i);
		}
		else {
			away.push_back(i);
		}
	}
	for(int i = 0, size = home.size(); i < size; ++i){
		for (int j = 0; j < size; ++j){
			if (i == j) continue;
			homeSum += matrix[home[i]][home[j]];
		}
	}
	for(int i = 0, size = away.size(); i < size; ++i){
		for (int j = 0; j < size; ++j){
			if (i == j) continue;
			awaySum += matrix[away[i]][away[j]];
		}
	}
	int min = abs(homeSum - awaySum);
	if (min < answer) answer = min;
}

void output(){
	cout << answer << '\n';
}
