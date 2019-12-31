package studyAlgo_Chapter2;

public class Code01_Maze {
// path_color : visited�̸� ���� �ⱸ�� ���� ��ΰ� �� ���ɼ��� �ִ� cell
// blocked_color : visited�̸� �ⱸ������ ��λ� ���� ������ ������ cell	
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
		// x, y��ǥ�� ��ȿ�� �����ȿ� �ִ°�.
		//��, ������ �迭�� ������ �Ѿ���� �ʾҴ°�. x�̵� y�̵� ������ 0���� n-1�����̴�.
		if(x<0 || y<0 || x>=N || y>=N)
			return false;
		// visited�̰ų� wall�� ���, pathway_colour�� �ƴϴ�
		else if(maze[x][y] != PATHWAY_COLOUR)
			return false;
		// ��, ���Ⱑ �ٷ� �ⱸ��� ��.
		else if (x==N-1 && y==N-1) {
			maze[x][y] = PATH_COLOUR;
			return true;
			
		} else {
			// �� ��ġ�� �湮�ߴ�. �׷��� ������ �ƴ����� ���� ��.
			maze[x][y] = PATH_COLOUR;
			// x,y�� ������ �� ���� ĭ��. �� �� �ϳ��� �ⱸ���� ���°� �ִٸ�, true.
			if(findMazePath(x-1, y) || findMazePath(x, y+1)
					|| findMazePath(x+1, y) || findMazePath(x, y-1)) {
				return true;
			}
			// return ���� �ʰ� ������� �Դٴ°���, ���� �̹� ����ģ ���� �� ����ġ�� �ʰ�� �ⱸ����
			// �� �� ���ٴ� ���� �ȴ�. 
			// �׷��Ƿ� �� �ڸ��� ���̴�.
			maze[x][y] = BLOCKED_COLOUR;		// dead end
			return false;
		}
			
	}
	
	public static void main(String[] args) {
		 printMaze();
		 // �Ա����� ����ؼ�, �ⱸ���� ���� ��ΰ� �ִ��� �˾Ƴ���.
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
