private static final int PATHWAY_COLOR = 0;
	private static final int WALL_COLOR = 1;
	private static final int BLOCKED_COLOR = 2;
	private static final int PATH_COLOR = 3;
	
	public static boolean findMazePath(int x, int y) {
		if(x<0||y<0||x>=N||y>=N) {
			//좌표의 유효한 범위 밖이면 false를 반환한다.
			return false;
		}
		else if(maze[x][y] != PATHWAY_COLOR) {
			//wall, blocked, path color의 경우에는 false를 호출한다.
			return false;
		}
		else if(x==N-1 && y==N-1) {
			//출구의 경우 (배열의 끝 of 끝)
			maze[x][y] =  PATH_COLOR;
			return true;
		}
		else {
			//일반적인 경우
			maze[x][y]=PATH_COLOR;
			if(findMazePath(x-1,y)|| findMazePath(x,y+1) || findMazePath(x+1,y) || findMazePath(x,y-1)) {
				//서 → 북 → 동 → 남 순서로 시도
				return true;
			}
			maze[x][y] = BLOCKED_COLOR; //dead end
			return false;
		}
	}
