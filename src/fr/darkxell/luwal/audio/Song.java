package fr.darkxell.luwal.audio;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;

import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

public enum Song {

	ADVENTURES("adventures.mp3"),
	ALL_THING_SEND("allthingsend.mp3"),
	BASS_IS_ON_REALITY("bassisonreality.mp3"),
	BORN_SYNTHETIC("bornsynthetic.mp3"),
	BURN("burn.mp3"),
	CONVERGENCE("convergence.mp3"),
	DAWN("dawn.mp3"),
	ECLIPSE("eclipse.mp3"),
	EXHALE("exhale.mp3"),
	FIREFIGHT("firefight.mp3"),
	FOLLOWED("followed.mp3"),
	INANIMATE("inanimate.mp3"),
	LASER("laser.mp3"),
	NO_KING_OF_MINE("nokingofmine.mp3"),
	PUSH("push.mp3"),
	REMEMBER("remember.mp3"),
	RINCE_AND_REPEAT("rincerepeat.mp3"),
	SEVEN("seven.mp3"),
	ULTRAVIOLET("ultraviolet.mp3"),
	SOUND_DEATH("death.mp3");

	/** The filepath to the .mp3 file */
	private String filepath;
	private String displayname;
	private String name = null;
	private String author = null;
	/** the length of the .mp3 file */
	public int length;

	/** Constructs a Song object from a .mp3 filepath. */
	private Song(String path) {
		this.filepath = path + "";
		AudioFileFormat baseFileFormat;
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream(path);
		try {
			baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(is);
			@SuppressWarnings("rawtypes")
			Map properties = baseFileFormat.properties();
			long duration = (long) properties.get("duration");
			this.length = (int) duration / 1000;
			this.author = (String) properties.get("author");
			this.name = (String) properties.get("title");
		} catch (Exception e) {
			System.err.println("Couldn't read the detailed informations for song:" + path);
		}
		File tempfile = new File(path);
		this.displayname = tempfile.getName();
		if (this.author != null && !this.author.equals("") && this.name != null && !this.name.equals(""))
			this.displayname = this.author + " - " + this.name;
	}

	public String getfilepath() {
		return this.filepath;
	}

	/**
	 * Returns the displayname of the song. Usually Artist - Name , but just the
	 * name of the mp3 file if not specified.
	 */
	public String getdipsplayname() {
		return this.displayname;
	}

	/**
	 * Returns the duration of an mp3 file in miliseconds. Don't work with .wav
	 * files. Returns 0 in case of errors.<br/>
	 * Note : I'm aware that this is not hte best method to get it, but I just
	 * couldn't find something better. <br/>
	 * <strong>Deprecated :</strong> this method has been deprecated due to high
	 * and not necessary CPU usage. It is also rather slow. MP3 length can now
	 * be obtained by creating a Song Object with the filepath, and using the
	 * public Song.length attribute.
	 */
	@Deprecated
	public static int getmp3Length(File file) {
		AudioFileFormat baseFileFormat;
		try {
			baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(file);
			@SuppressWarnings("rawtypes")
			Map properties = baseFileFormat.properties();
			long duration = (long) properties.get("duration");
			return (int) duration / 1000;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}