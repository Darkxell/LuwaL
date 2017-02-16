package fr.darkxell.luwal.mechanics.metas;

import java.util.concurrent.ThreadLocalRandom;

import fr.darkxell.luwal.audio.Song;
import fr.darkxell.luwal.mechanics.Chunk;
import fr.darkxell.luwal.mechanics.LevelMeta;
import fr.darkxell.luwal.mechanics.chunks.absolution.RandomChunk3_1;
import fr.darkxell.luwal.mechanics.chunks.absolution.RandomChunk3_2;
import fr.darkxell.luwal.mechanics.chunks.reactor.LadderChunk;
import fr.darkxell.luwal.mechanics.chunks.reactor.ReversedStairChunk;
import fr.darkxell.luwal.utility.AnimatedColor;

public class MetaAbsolution extends LevelMeta {

	public MetaAbsolution() {
		super.rotatespeed = 0.5d;
		super.scrollspeed = 0.4d;
		super.background = AnimatedColor.ABSOLUTION_BACKGROUND;
		super.level = AnimatedColor.ABSOLUTION_LEVEL;
		super.line = AnimatedColor.ABSOLUTION_LINE;
		super.player = AnimatedColor.ABSOLUTION_PLAYER;
		super.playerghost = AnimatedColor.ABSOLUTION_GHOST;
		super.levelSong = Song.CONVERGENCE;
	}

	@Override
	public Chunk getRandomPattern(double playerposition) {
		if (ThreadLocalRandom.current().nextDouble() > 0.7d)
			if (ThreadLocalRandom.current().nextDouble() > 0.5d)
				return new RandomChunk3_1();
			else
				return new RandomChunk3_2();
		else if (ThreadLocalRandom.current().nextDouble() > 0.5d)
			return new ReversedStairChunk();
		else
			return new LadderChunk();
	}

}
