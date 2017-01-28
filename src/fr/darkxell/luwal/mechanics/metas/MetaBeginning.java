package fr.darkxell.luwal.mechanics.metas;

import java.util.concurrent.ThreadLocalRandom;

import fr.darkxell.luwal.audio.Song;
import fr.darkxell.luwal.mechanics.Chunk;
import fr.darkxell.luwal.mechanics.LevelMeta;
import fr.darkxell.luwal.mechanics.chunks.beginning.ClassyChunk;
import fr.darkxell.luwal.mechanics.chunks.beginning.FlipChunk;
import fr.darkxell.luwal.mechanics.chunks.beginning.StairsChunk;
import fr.darkxell.luwal.utility.AnimatedColor;

public class MetaBeginning extends LevelMeta {

	public MetaBeginning() {
		super.rotatespeed = 0.3d;
		super.scrollspeed = 0.25d;
		super.background = AnimatedColor.BEGINNING_BACKGROUND;
		super.level = AnimatedColor.BEGINNING_LEVEL;
		super.line = AnimatedColor.BEGINNING_LINE;
		super.player = AnimatedColor.BEGINNING_PLAYER;
		super.playerghost = AnimatedColor.BEGINNING_GHOST;
		super.levelSong = Song.BORN_SYNTHETIC;
	}

	@Override
	public Chunk getRandomPattern(double playerposition) {
		if (ThreadLocalRandom.current().nextDouble() > 0.8d)
			return new FlipChunk();
		else if (ThreadLocalRandom.current().nextDouble() > 0.4d)
			return new StairsChunk();
		else
			return new ClassyChunk();
	}

}
