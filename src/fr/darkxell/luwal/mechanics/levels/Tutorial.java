package fr.darkxell.luwal.mechanics.levels;

import fr.darkxell.luwal.main.Meta;
import fr.darkxell.luwal.mechanics.Chunk;
import fr.darkxell.luwal.mechanics.Level;
import fr.darkxell.luwal.mechanics.chunks.StartChunk;

public class Tutorial extends Level {

	public Tutorial() {
		super(Meta.tutorial);
		super.chunks = new Chunk[] { new StartChunk(9) };
		super.height = chunks[0].getHeight();
	}

}
