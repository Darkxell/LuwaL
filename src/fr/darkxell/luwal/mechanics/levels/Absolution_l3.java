package fr.darkxell.luwal.mechanics.levels;

import fr.darkxell.luwal.main.Meta;
import fr.darkxell.luwal.mechanics.Chunk;
import fr.darkxell.luwal.mechanics.Level;
import fr.darkxell.luwal.mechanics.chunks.StartChunk;

public class Absolution_l3 extends Level {

	public Absolution_l3() {
		super(Meta.absolution);
		super.chunks = new Chunk[] { new StartChunk(9) };
		super.height = chunks[0].getHeight();
	}
	
}
