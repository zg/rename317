package rs2;
// Thanks sadistic :3
final class BZ2Entry {

	BZ2Entry() {
		unzftab = new int[256];
		cftab = new int[257];
		inUse = new boolean[256];
		inUse16 = new boolean[16];
		seqToUnseq = new byte[256];
		yy = new byte[4096];
		tmp = new int[16];
		selector = new byte[18002];
		selectorMtf = new byte[18002];
		len = new byte[6][258];
		limit = new int[6][258];
		base = new int[6][258];
		perm = new int[6][258];
		minLens = new int[6];
	}
	byte inputBuffer[];
	int nextIn;
	int compressedSize;
	int totalInLo32;
	int totalInHi32;
	byte outputBuffer[];
	int availOut;
	int decompressedSize;
	int totalOutLo32;
	int totalOutHi32;
	byte stateOutCh;
	int stateOutLen;
	boolean randomized;
	int bsBuff;
	int bsLive;
	int blockSize;
	int junk3;
	int origPointer;
	int nextOut;
	int k0;
	final int[] unzftab;
	int nBlockUsed;
	final int[] cftab;
	public static int anIntArray587[];
	int inUseOff;
	final boolean[] inUse;
	final boolean[] inUse16;
	final byte[] seqToUnseq;
	final byte[] yy;
	final int[] tmp;
	final byte[] selector;
	final byte[] selectorMtf;
	final byte[][] len;
	final int[][] limit;
	final int[][] base;
	final int[][] perm;
	final int[] minLens;
	int nBlock_pp;
}
