#include <cstdio>
#include <stack>

using namespace std;

int main() {
	int length;
	char ch;
	
	for (int tc = 1; tc <= 10; ++tc) {
		stack<char> st;
		scanf("%d", &length);
		getchar();
		for (int i = 1; i <= length; ++i) {
			scanf("%c", &ch);
			switch (ch) {
			case ')': if (st.top() == '(') { st.pop(); } else st.push(ch); break;
			case ']': if (st.top() == '[') { st.pop(); } else st.push(ch); break;
			case '}': if (st.top() == '{') { st.pop(); } else st.push(ch); break;
			case '>': if (st.top() == '<') { st.pop(); } else st.push(ch); break;
			default: st.push(ch); break;
			}
		}
		if (st.empty()) printf("#%d 1\n", tc);
		else printf("#%d 0\n", tc);
	}
	return 0;
}