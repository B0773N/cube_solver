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
		// Cube c = s.cube;
		// Figur f = s.cube.figurs.next();
		// Rotation r = f.rotations.next();
		// r.postions.next();
		// r.postions.next();
		// r.postions.next();
		// r.postions.next();
		// Position p = r.postions.next();
		// c.fit(cube, r, p);
		// c.print(cube);
		//
		// f = c.figurs.next();
		// r = f.rotations.next();
		// r.postions.next();
		// r.postions.next();
		// p = r.postions.next();
		//
		// int[][][] cube2 = new int[3][3][3];
		// c.fit(cube2, r, p);
		// c.print(cube2);
		//
		// System.out.println(c.fit(cube, r, p));
		// c.print(cube);

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
