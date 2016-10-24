package fr.darkxell.luwal.mechanics.levels;

import fr.darkxell.luwal.main.Meta;
import fr.darkxell.luwal.mechanics.Chunk;
import fr.darkxell.luwal.mechanics.Level;
import fr.darkxell.luwal.mechanics.chunks.StartChunk;

public class Reactor_l2 extends Level {

	public Reactor_l2() {
		super(Meta.reactor);
		super.chunks = new Chunk[] { new StartChunk(9) };
		super.height = chunks[0].getHeight();
	}

}
