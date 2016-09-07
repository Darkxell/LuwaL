package fr.darkxell.luwal.mechanics;

/** A group of chunks that forms a playable level. */
public class Level {

	/** The particles in this level. */
	private Particle[] particles;
	/** The chunks of this level. */
	protected Chunk[] chunks;
	/** Height of this level. */
	protected int height;
	/** The player in this level. */
	private Player player = new Player(this);
	/** The meta of the level. */
	public LevelMeta meta;
	/** is true if the player has failed in this stage. */
	public boolean killed = false;

	protected Level(LevelMeta meta) {
		this.meta = meta;
	}

	public Level(Chunk[] data, LevelMeta meta) {
		this.meta = meta;
		this.chunks = data;
		this.height = chunks[0].getHeight();
	}

	/** gets the length of this level, in blocks. */
	public int getlength() {
		int length = 0;
		for (int i = 0; i < chunks.length; i++)
			length += chunks[i].getLength();
		return length;
	}

	/** updates the player and particles of this level. */
	public void update() {
		this.player.update();
		if (this.player.getX() > this.getlength() - 100)
			this.addchunk(this.meta.getRandomPattern(this.player.getX()));

	}

	/** Returns the height of this level, in blocks. */
	public int getHeight() {
		return height;
	}

	public Particle[] getParticles() {
		return particles;
	}

	/** Gets the block type at the wanted position in the level. */
	public byte getBlockAt(int x, int y) {
		if (x < 0 || y < 0 || y >= height)
			return Block.BLOCK_AIR;
		int chunkposition = 0;
		for (int i = 0; i < chunks.length; i++)
			if (x < chunks[i].getLength() + chunkposition) {
				return chunks[i].getBlockTypeAt(x - chunkposition, y);
			} else
				chunkposition += chunks[i].getLength();
		return Block.BLOCK_AIR;
	}

	/** Returns the player in this level. */
	public Player getPlayer() {
		return this.player;
	}

	/** Adds the wanted chunk to the level, at the end of it. */
	protected void addchunk(Chunk toAdd) {
		Chunk[] chunks2 = new Chunk[chunks.length + 1];
		System.arraycopy(chunks, 0, chunks2, 0, chunks.length);
		chunks2[chunks.length] = toAdd;
		this.chunks = chunks2;
	}

}
