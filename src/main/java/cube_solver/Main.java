package cube_solver;

import cube_solver.Solver;
import cube_solver.Solver.Figur;
import cube_solver.Solver.Position;
import cube_solver.Solver.Rotation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solver s = new Solver();

		int i = s.exec();
		System.out.println(i);

		//
		// while(s.cube.figurs.hasNext()) {
		// Figur f = s.cube.figurs.next();
		// Rotation r = f.rotations.next();
		//
		// }

		// fit test
		// int[][][] cube = new int[3][3][3];
		// // Figur f = s.figurs.next();
		// // Rotation r = f.rotations.next();
		//
		// int j = 0;
		// for (Figur f : s.figursArr) {
		// s.print(f.curRotation);
		// int i = 0;
		// for (Rotation r : f.rotationsArr) {
		// i++;
		// // s.print(r.fig);
		// }
		// System.out.println("Rotations: " + i);
		// System.out.println();
		// j += i;
		// }
		// System.out.println("i alt: " + j);

		// for (Position p : r.postionsArr) {
		// cube = new int[3][3][3];
		// s.fit(cube, r, p);
		// s.print(cube);
		// }

		// Position p = r.postions.next();
		// s.fit(cube, r, p);
		// s.print(cube);
		//
		// f = s.figurs.next();
		// r = f.rotations.next();
		// r.postions.next();
		// r.postions.next();
		// p = r.postions.next();
		//
		// int[][][] cube2 = new int[3][3][3];
		// s.fit(cube2, r, p);
		// s.print(cube2);
		//
		// System.out.println(s.fit(cube, r, p));
		// s.print(cube);

		// System.out.println(p.z + ", " + p.y + ", " + p.x);

	}

	// private static void print(int[][][] cube) {
	// String res = "";
	// res += "{";
	// for (int h = 0; h < cube.length; h++) {
	// res += (h > 0 && h < cube.length ? ", \n " : "") + "{";
	// for (int j = 0; j < cube[0].length; j++) {
	// res += (j > 0 && j < cube[0].length ? "\n " : "") + "{";
	// for (int i = 0; i < cube[0][0].length; i++) {
	// res += (i > 0 && i < cube[0][0].length ? ", " : " ") + cube[h][j][i];
	// }
	// res += " }";
	// }
	// res += "}";
	// }
	// res += "}";
	// System.out.println(res);
	// }
}
