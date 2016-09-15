package fr.darkxell.luwal.mechanics.metas;

import java.util.concurrent.ThreadLocalRandom;

import fr.darkxell.luwal.mechanics.Chunk;
import fr.darkxell.luwal.mechanics.LevelMeta;
import fr.darkxell.luwal.mechanics.chunks.tutorial.TutorialChunk;
import fr.darkxell.luwal.mechanics.chunks.tutorial.TutorialChunk2;

public class MetaTutorial extends LevelMeta {

	public MetaTutorial() {
		super.rotatespeed = 0.1d;
		super.scrollspeed = 0.1d;
	}

	@Override
	public Chunk getRandomPattern(double playerposition) {
		if (playerposition < 200)
			return new TutorialChunk();
		if(ThreadLocalRandom.current().nextDouble()>0.5d)
			return new TutorialChunk();
		else 
			return new TutorialChunk2();
	}

}
