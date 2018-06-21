package cube_solver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solver {
	// ListIterator<int[][][]> cubes;
	ArrayList<Figur> figursArr;
	ListIterator<Figur> figurs;
	int fitted;

	public Solver() {
		Figur f1 = new Figur(new int[][][] { { { 1, 1, 1 }, { 1, 0, 0 } } });
		Figur f2 = new Figur(new int[][][] { { { 2, 2, 2 }, { 0, 2, 0 } } });
		Figur f3 = new Figur(new int[][][] { { { 3, 3, 3 }, { 0, 3, 0 } }, { { 3, 0, 0 }, { 0, 0, 0 } } });
		Figur f4 = new Figur(new int[][][] { { { 4, 4, 4 }, { 0, 4, 0 } }, { { 0, 0, 0 }, { 0, 4, 0 } } });
		Figur f5 = new Figur(new int[][][] { { { 5, 5, 0 }, { 0, 5, 5 } }, { { 0, 5, 0 }, { 0, 0, 0 } } });
		Figur f6 = new Figur(new int[][][] { { { 6, 6 }, { 0, 6 } }, { { 0, 0 }, { 0, 6 } } });
		figursArr = new ArrayList<Figur>(Arrays.asList(new Figur[] { f1, f2, f3, f4, f5, f6 }));
		figurs = figursArr.listIterator();
		fitted = 0;
		// ArrayList<int[][][]> cubesArr = new ArrayList<int[][][]>();
		// for (int i = 0; i < 6; i++) {
		// cubesArr.add(new int[3][3][3]);
		// }
		// cubes = cubesArr.listIterator();
	}

	public int exec() {
		Figur f = figurs.next();
		Rotation r = f.rotations.next();
		Position p = r.postions.next();
		int[][][] c1 = new int[3][3][3];
		int i = 0;
		return find(c1, null, 0, f, null, r, null, p, null, i);
	}

	public int find2(int start, int end, int index, int u, int[][][] c1, int[][][] c2, Figur f1, Figur f2, Rotation r1,
			Rotation r2, Position p1, Position p2, int n) {

		for (int i = start; i < figursArr.size(); i++) {
			f1 = figursArr.get(i);
			for (int j = 0; j < f1.rotationsArr.size(); j++) {
				r1 = f1.rotationsArr.get(j);
				for (int h = 0; h < f1.rotationsArr.size(); h++) {
					if (fit(c1, r1, p1))
						find2(start, end, index, u, c1, c2, f1, f2, r1, r2, p1, p2, n);
				}
			}
		}
		return n;
	}

	public int go(int start, int end, int index, int r, int[][][] c1, int[][][] c2, Figur f1, Figur f2, Rotation r1,
			Rotation r2, Position p1, Position p2, int n) {

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			// data[index] = arr[i];

		}

		return 0;
	}

	public int find(int[][][] c1, int[][][] c2, int y, Figur f1, Figur f2, Rotation r1, Rotation r2, Position p1,
			Position p2, int n) {

		c2 = c1;
		if (fit(c2, r1, p1)) {
			if (y == 6) {
				print(c2);
			}

			if (r1.postions.hasNext()) {
				r2 = r1;
				p2 = r2.postions.next();
				n += find(c2, c2, y, f1, f2, r2, r2, p2, p2, n);
			}
			if (f1.rotations.hasNext()) {
				f2 = f1;
				r2 = f2.rotations.next();
				r2.resetPosPointer();
				p2 = r2.postions.next();
				n += find(c2, c2, y, f2, f2, r2, r2, p2, p2, n);

			}
			if (figurs.hasNext()) {
				f2 = figurs.next();
				figurs.previous();
				f2 = f1;
				f2.resetRotPointer();
				r2 = f2.rotations.next();
				r2.resetPosPointer();
				p2 = r2.postions.next();
				n += find(c2, c2, y, f2, f2, r2, r2, p2, p2, n);
			}
			n++;
		}

		if (r1.postions.hasNext()) {
			p1 = r1.postions.next();
			n += find(c2, c2, y, f1, f2, r1, r2, p1, p2, n);
		}
		if (f1.rotations.hasNext()) {
			r1 = f1.rotations.next();
			r1.resetPosPointer();
			p1 = r1.postions.next();
			n += find(c2, c2, y, f1, f2, r1, r2, p1, p2, n);
		}
		if (figurs.hasNext()) {
			f1 = figurs.next();
			f1.resetRotPointer();
			r1 = f1.rotations.next();
			r1.resetPosPointer();
			p1 = r1.postions.next();
			n += find(c2, c2, y, f1, f2, r1, r2, p1, p2, n);

		}
		n++;

		return n;
	}

	public boolean fit(int[][][] cube, Rotation r, Position p) {
		boolean fit = true;
		search: for (int h = p.z; h < (p.z + r.dep); h++) {
			for (int j = p.y; j < (p.y + r.row); j++) {
				for (int i = p.x; i < (p.x + r.col); i++) {
					if (cube[h][j][i] != 0 && r.fig[h - p.z][j - p.y][i - p.x] != 0) {
						fit = false;
						break search;
					}
				}
			}
		}
		if (fit) {
			int val;
			for (int h = 0; h < r.dep; h++) {
				for (int j = 0; j < r.row; j++) {
					for (int i = 0; i < r.col; i++) {
						val = r.fig[h][j][i];
						if (val != 0)
							cube[h + p.z][j + p.y][i + p.x] = val;
					}
				}
			}
		}
		return fit;
	}

	public void print(int[][][] cube) {
		int h, j, i, m;
		h = 0;
		j = 0;
		i = 0;
		String line;
		String line1 = "";
		String line2 = "";
		String line3 = "";
		m = j % cube[0].length;
		for (h = 0; h < cube.length; h++) {

			for (j = 0; j < cube[0].length; j++) {

				line = "{";
				m = j % cube[0].length;
				if (m == 0)
					line1 += line;
				else if (m == 1)
					line2 += line;
				else
					line3 += line;

				for (i = 0; i < cube[0][0].length; i++) {

					line = " " + cube[h][j][i];
					m = j % cube[0].length;
					if (m == 0)
						line1 += line;
					else if (m == 1)
						line2 += line;
					else
						line3 += line;
				}
				line = " }";
				if (m == 0)
					line1 += line;
				else if (m == 1)
					line2 += line;
				else
					line3 += line;
			}
		}
		if (!line1.isEmpty())
			System.out.println(line1);
		if (!line2.isEmpty())
			System.out.println(line2);
		if (!line3.isEmpty())
			System.out.println(line3);
		System.out.println();
	}

	public class Figur {
		int[][][] curRotation;
		int dep, row, col;
		ArrayList<Rotation> rotationsArr;
		ListIterator<Rotation> rotations;

		public Figur(int[][][] startFig) {
			this.curRotation = startFig;
			dep = startFig.length;
			row = startFig[0].length;
			col = startFig[0][0].length;
			calcRotations();
		}

		public void resetRotPointer() {
			while (rotations.hasPrevious())
				rotations.previous();
		}

		public void calcRotations() {
			HashSet<Rotation> possibleRots = new HashSet<Rotation>();
			// LinkedList<Rotation> possibleRots = new LinkedList<Rotation>();
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 4; j++) {
					possibleRots.add(new Rotation(this.curRotation, dep, row, col));
					this.rotate90();
				}
				this.rotate90Horizontal();
				if (i == 3) {
					this.rotate90();
					this.rotate90Horizontal();
				} else if (i == 4) {
					this.rotate90Horizontal();
				}
			}
			rotationsArr = new ArrayList<Rotation>(possibleRots);
			rotations = rotationsArr.listIterator();
		}

		public void rotate90() {
			int[][][] temp = new int[dep][col][row];
			for (int h = 0; h < dep; h++) {
				for (int j = 0; j < row; j++) {
					for (int i = 0; i < col; i++) {
						temp[h][i][row - j - 1] = curRotation[h][j][i];
					}
				}
			}
			curRotation = temp;
			dep = curRotation.length;
			row = curRotation[0].length;
			col = curRotation[0][0].length;
			temp = null; // todo test speed
		}

		public void rotate90Horizontal() {
			int[][][] temp = new int[row][dep][col];
			for (int h = 0; h < dep; h++) {
				for (int j = 0; j < row; j++) {
					for (int i = 0; i < col; i++) {
						temp[j][dep - h - 1][i] = curRotation[h][j][i];
					}
				}
			}
			curRotation = temp;
			dep = curRotation.length;
			row = curRotation[0].length;
			col = curRotation[0][0].length;
			temp = null;
		}
	}

	public class Rotation {
		public int[][][] fig;
		ArrayList<Position> postionsArr;
		ListIterator<Position> postions;
		int dep, row, col;

		public Rotation(int[][][] fig, int dep, int row, int col) {
			this.fig = fig;
			this.dep = dep;
			this.row = row;
			this.col = col;
			postionsArr = new ArrayList<Position>();
			calcPossiblePositions();
		}

		public void calcPossiblePositions() {
			for (int h = 0; h < 4 - dep; h++) {
				for (int j = 0; j < 4 - row; j++) {
					for (int i = 0; i < 4 - col; i++) {
						postionsArr.add(new Position(h, j, i));
					}
				}
			}
			postions = postionsArr.listIterator();
		}

		public void resetPosPointer() {
			while (postions.hasPrevious())
				postions.previous();
		}

		@Override
		public int hashCode() {
			int hashCode = 0;
			int k = 0;
			int l = 1;
			for (int h = 0; h < dep; h++) {
				for (int j = 0; j < row; j++) {
					for (int i = 0; i < col; i++) {
						if (k == 9)
							System.out.println("hj");
						if (fig[h][j][i] != 0)
							hashCode += l * (int) Math.pow(10, k);
						k++;
					}
					k = 3 + 3 * j;
				}
				k = 0;
				l++;
				if (l == 2)
					l++;
			}
			return hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			return this.hashCode() == obj.hashCode();
		}
	}

	class Position {
		int z, y, x;

		public Position(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
}
