package fr.darkxell.luwal.mechanics.levels;

import fr.darkxell.luwal.main.Meta;
import fr.darkxell.luwal.mechanics.Chunk;
import fr.darkxell.luwal.mechanics.Level;
import fr.darkxell.luwal.mechanics.chunks.StartChunk;

public class Beginning_l1 extends Level{

	public Beginning_l1() {
		super(Meta.beginning);
		super.chunks = new Chunk[] { new StartChunk(9) };
		super.height = chunks[0].getHeight();
		super.levelID = Meta.ID_SET1;
	}
	
}
