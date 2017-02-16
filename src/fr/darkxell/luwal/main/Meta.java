package fr.darkxell.luwal.main;

import fr.darkxell.luwal.mechanics.LevelMeta;
import fr.darkxell.luwal.mechanics.metas.MetaAbsolution;
import fr.darkxell.luwal.mechanics.metas.MetaBeginning;
import fr.darkxell.luwal.mechanics.metas.MetaReactor;
import fr.darkxell.luwal.mechanics.metas.MetaTutorial;

/**
 * Class holding all of the meta stuff. Difficulty of levels, levels color and
 * stuff.
 */
public class Meta {

	public static LevelMeta tutorial = new MetaTutorial();

	public static LevelMeta beginning = new MetaBeginning();

	public static LevelMeta reactor = new MetaReactor();
	
	public static LevelMeta absolution = new MetaAbsolution();

}
