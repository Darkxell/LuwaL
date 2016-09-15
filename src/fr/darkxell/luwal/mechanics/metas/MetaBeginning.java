package fr.darkxell.luwal.mechanics.metas;

import java.util.concurrent.ThreadLocalRandom;

import fr.darkxell.luwal.mechanics.Chunk;
import fr.darkxell.luwal.mechanics.LevelMeta;
import fr.darkxell.luwal.mechanics.chunks.beginning.ClassyChunk;
import fr.darkxell.luwal.mechanics.chunks.beginning.FlipChunk;
import fr.darkxell.luwal.mechanics.chunks.beginning.StairsChunk;

public class MetaBeginning extends LevelMeta {

	public MetaBeginning() {
		super.rotatespeed = 0.3d;
		super.scrollspeed = 0.25d;
	}

	@Override
	public Chunk getRandomPattern(double playerposition) {
		if(ThreadLocalRandom.current().nextDouble()>0.8d)
			return new FlipChunk();
		else if(ThreadLocalRandom.current().nextDouble()>0.4d)
			return new StairsChunk();
		else
			return new ClassyChunk();
	}
	
}
