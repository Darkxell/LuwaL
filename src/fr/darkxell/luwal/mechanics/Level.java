package fr.darkxell.luwal.mechanics;

import java.awt.Graphics2D;

import fr.darkxell.luwal.main.Launcher;
import fr.darkxell.luwal.main.Meta;

/** A group of chunks that forms a playable level. */
public class Level {

	/** The level ID. */
	protected int levelID = Meta.ID_DEFAULT;
	/** The particles in this level. */
	private Particle[] particles;
	/** The chunks of this level. */
	protected Chunk[] chunks;
	/** Height of this level. */
	protected int height;
	/** The player in this level. */
	private Player player = new Player(this);
	/**
	 * The meta of the level. Can be changed at anytime, even tho this is not
	 * recommended.
	 */
	public LevelMeta meta;
	/** Is true if the player has failed in this stage. */
	public boolean killed = false;

	protected Level(LevelMeta meta) {
		this.meta = meta;
	}

	/**
	 * Creates a new playable level. Chunks will be generated procedurally from
	 * the specified meta.
	 */
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

	/**
	 * Displays this level on the line. <br/>
	 * Note that the parameters are automatically passed by the DisplayLine
	 * object. The Graphics object is transformed when parsed from the
	 * displayLine object, meaning that this method shouldn't be called from
	 * anywhere else than the DisplayLine object.
	 */
	public void display(Graphics2D g2, int rectheight, int rectY, int widthpx) {

		try {

			int framewidth = Launcher.gameframe.getWidth();
			double heightpx = (double) (rectheight) / this.getHeight();

			// Draws the player

			if (!killed) {

				g2.setColor(this.meta.getPlayerGhostColor());
				g2.fillRect(framewidth / 3, rectY - (rectheight / 2) + (int) (this.getPlayer().getY() * heightpx),
						(int) heightpx, (int) heightpx);

				g2.setColor(this.meta.getPlayerColor());
				g2.fillRect(framewidth / 3, (int) (rectY - (rectheight / 2)
						+ ((this.getPlayer().isSliding ? (this.getPlayer().getGravity() ? this.getPlayer().getY() - 2
								: this.getPlayer().getY() + 2) : this.getPlayer().getY()) * heightpx)),
						(int) heightpx, (int) heightpx);

			}
			// Draws the level

			for (int i = (int) this.getPlayer().getX() - 30; i < (int) this.getPlayer().getX() + 60; i++) {
				for (int j = 0; j < this.getHeight(); j++) {
					int xblock = (int) ((framewidth / 3) + ((double) i * widthpx)
							- ((double) this.getPlayer().getX() * widthpx));
					int yblock = (int) (rectY + (j * heightpx));
					g2.setColor(this.meta.getLevelColor());
					if (this.getBlockAt(i, j) == Block.BLOCK_SOLID)
						g2.fillRect(xblock, yblock - 2 - (rectheight / 2), widthpx + 2, (int) heightpx + 4);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
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

	/** Returns the ID of the level. */
	public int getLevelID() {
		return this.levelID;
	}

}
