#include <stdio.h>

using namespace std;

int n, k;
int map[101];
int cache[101][10001];

int main() {

	freopen("inputs/2293.txt","r",stdin);
	scanf("%d %d", &n, &k);
	
	for(int i = 1; i <= n ; i++) {
		scanf("%d", &map[i]);
	}
	
	cache[0][0] = 1;
	cache[1][0] = 1;
	cache[0][1] = 0;
	
	for(int i = 1; i <= n ; i++) {
		for(int j = 0; j <= k; j++) {
			
				cache[i][j] = cache[i-1][j];
				
			if (j-map[i] >= 0) {
				cache[i][j] = cache[i-1][j] + cache[i][j-map[i]];	
			}
			
		}
	}
	
	printf("%d",cache[n][k]);
		
}
