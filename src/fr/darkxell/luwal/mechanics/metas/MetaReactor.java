package fr.darkxell.luwal.mechanics.metas;

import java.util.concurrent.ThreadLocalRandom;

import fr.darkxell.luwal.audio.Song;
import fr.darkxell.luwal.mechanics.Chunk;
import fr.darkxell.luwal.mechanics.LevelMeta;
import fr.darkxell.luwal.mechanics.chunks.reactor.HChunk;
import fr.darkxell.luwal.mechanics.chunks.reactor.LadderChunk;
import fr.darkxell.luwal.mechanics.chunks.reactor.ReversedStairChunk;

public class MetaReactor extends LevelMeta {

	public MetaReactor() {
		super.rotatespeed = 0.45d;
		super.scrollspeed = 0.3d;
		super.levelSong = Song.ECLIPSE;
	}

	@Override
	public Chunk getRandomPattern(double playerposition) {
		if(ThreadLocalRandom.current().nextDouble()>0.66d)
			return new HChunk();
		else if(ThreadLocalRandom.current().nextDouble()>0.33d)
			return new ReversedStairChunk();
		else
			return new LadderChunk();
	}
}
