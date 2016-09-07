package fr.darkxell.luwal.mechanics;

public class Chunk {

	/** the height of this chunk of blocks. */
	private int height;
	/** the length of this chunk of blocks. */
	private int length;

	/** the blocks of this chunk. */
	protected byte[] blocks;

	public Chunk(byte[] blockslist, int height, int length) {
		this.blocks = blockslist;
		this.height = height;
		this.length = length;
	}

	/** Gets the height of this chunk, in blocks. */
	public int getHeight() {
		return this.height;
	}

	/** Gets the length of this chunk, in blocks. */
	public int getLength() {
		return this.length;
	}

	/**
	 * Gets the block type at the wanted location in this chunk. If the block
	 * doesn't exist, returns a default air block.
	 */
	public byte getBlockTypeAt(int x, int y) {
		int index = x + (length * y);
		return index >= blocks.length || index < 0 ? Block.BLOCK_AIR : blocks[index];
	}

	/**
	 * Chunk constructor that transform the wanted string into the wanted
	 * pattern. <br/>
	 * Use <code>0-9</code> for blocks and <code>\n</code> for new lines. <br/>
	 * <br/>
	 * <b>Exemple:</b><br/>
	 * <code>s = "000000"<br/>+"\n001111"<br/>+"\n000000"<br/>+"\n111100"<br/>+"\n000000"</code>
	 */
	public Chunk(String regex) {
		String[] buffer = regex.split("\n");
		this.height = buffer.length;
		this.length = buffer[0].length();
		this.blocks = new byte[this.height * this.length];
		int index = 0;
		for (int i = 0; i < buffer.length; i++) {
			char[] line = buffer[i].toCharArray();
			for (int j = 0; j < line.length; j++) {
				this.blocks[index] = Byte.parseByte("" + line[j]);
				++index;
			}
		}
	}

}
