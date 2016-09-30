package fr.darkxell.luwal.main;

import fr.darkxell.luwal.mechanics.Level;
import fr.darkxell.luwal.mechanics.LevelMeta;
import fr.darkxell.luwal.mechanics.levels.Beginning_l1;
import fr.darkxell.luwal.mechanics.levels.Reactor_l2;
import fr.darkxell.luwal.mechanics.levels.Tutorial;
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

	public static final int ID_DEFAULT = 0;
	public static final int ID_TUTORIAL = 1;
	public static final int ID_SET1 = 11;
	public static final int ID_SET2 = 12;
	public static final int ID_SET3 = 13;
	public static final int ID_SET4 = 14;
	public static final int ID_SET5 = 15;
	public static final int ID_SET6 = 16;
	public static final int ID_SET7 = 17;
	public static final int ID_SET8 = 18;
	public static final int ID_SET9 = 19;

	/**
	 * Returns a new level from an ID. ID can be obtained from a finished level
	 * to reset it with new random patterns, or more.
	 */
	public static Level getNewLevelFromID(int levelID) {
		switch (levelID) {
		case ID_TUTORIAL:
			return new Tutorial();
		case ID_SET1:
			return new Beginning_l1();
		case ID_SET2:
			return new Reactor_l2();
		// TODO : add new levels to the ID list.
		default:
			System.err.println("ERROR : Unkown level ID when trying to get a level, returned null level.");
			return null;
		}
	}

}
