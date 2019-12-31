package studyAlgo_Chapter2;

public class Code01_Maze {
// path_color : visited이며 아직 출구로 가는 경로가 될 가능성이 있는 cell
// blocked_color : visited이며 출구까지의 경로상에 있지 않음이 밝혀진 cell	
	private static int N=8;
	private static int [][] maze = {
			{0, 0, 0, 0, 0, 0, 0, 1},
			{0, 1, 1, 0, 1, 1, 0, 1},
			{0, 0, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 0, 1, 1, 0, 0},
			{0, 1, 1, 1, 0, 0, 1, 1},
			{0, 1, 0, 0, 0, 1, 0, 1},
			{0, 0, 0, 1, 0, 0, 0, 1},
			{0, 1, 1, 1, 0, 1, 0, 0}
	};
	
	private static final int PATHWAY_COLOUR = 0;	// white
	private static final int WALL_COLOUR = 1;		// blue
	private static final int BLOCKED_COLOUR = 2;	// red
	private static final int PATH_COLOUR = 3;		// green

	
	public static boolean findMazePath(int x, int y) {
		// x, y좌표가 유효한 범위안에 있는가.
		//즉, 이차원 배열의 범위를 넘어서지는 않았는가. x이든 y이든 범위는 0부터 n-1까지이다.
		if(x<0 || y<0 || x>=N || y>=N)
			return false;
		// visited이거나 wall인 경우, pathway_colour가 아니다
		else if(maze[x][y] != PATHWAY_COLOUR)
			return false;
		// 즉, 여기가 바로 출구라는 것.
		else if (x==N-1 && y==N-1) {
			maze[x][y] = PATH_COLOUR;
			return true;
			
		} else {
			// 이 위치를 방문했다. 그러나 꽝이지 아닌지는 아직 모름.
			maze[x][y] = PATH_COLOUR;
			// x,y에 인접한 네 개의 칸들. 이 중 하나라도 출구까지 가는게 있다면, true.
			if(findMazePath(x-1, y) || findMazePath(x, y+1)
					|| findMazePath(x+1, y) || findMazePath(x, y-1)) {
				return true;
			}
			// return 되지 않고 여기까지 왔다는것은, 내가 이미 지나친 것을 또 지나치지 않고는 출구까지
			// 갈 수 없다는 말이 된다. 
			// 그러므로 이 자리는 꽝이다.
			maze[x][y] = BLOCKED_COLOUR;		// dead end
			return false;
		}
			
	}
	
	public static void main(String[] args) {
		 printMaze();
		 // 입구에서 출발해서, 출구까지 가는 경로가 있는지 알아낸다.
		 findMazePath(0,0);
		 printMaze();

	}

	private static void printMaze() {
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[i].length; j++) {
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	

}
