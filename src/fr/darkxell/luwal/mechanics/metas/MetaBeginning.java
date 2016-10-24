package fr.darkxell.luwal.mechanics.metas;

import java.awt.Color;
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
		super.background = new Color(100,75,100);
		super.level = new Color(100,75,100);
		super.line = new Color(150,130,150);
		super.player = new Color(200,150,200);
		super.playerghost = new Color(120,90,120);
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
