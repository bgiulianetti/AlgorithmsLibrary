package test;

import backtracking.MochilaBt;

public class TestMochilaBacktracking {

	public static void main(String[] args) {

		MochilaBt mbt = new MochilaBt(20);
		mbt.resolverProblemaBT(0, 0);
		mbt.mostrarMochila();

	}

}
