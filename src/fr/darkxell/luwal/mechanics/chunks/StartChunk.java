package fr.darkxell.luwal.mechanics.chunks;

import fr.darkxell.luwal.mechanics.Block;
import fr.darkxell.luwal.mechanics.Chunk;

public class StartChunk extends Chunk {

	private static final int LENGTH = 40;

	public StartChunk(int levelheight) {
		super(null, levelheight, LENGTH);
		byte[] blockslist = new byte[LENGTH * levelheight];
		for (int i = 0; i < blockslist.length; i++) {
			blockslist[i] = (i >= LENGTH * (levelheight - 2) && i < LENGTH * (levelheight - 1)) ? Block.BLOCK_SOLID
					: Block.BLOCK_AIR;
		}

		super.blocks = blockslist;
	}

}
