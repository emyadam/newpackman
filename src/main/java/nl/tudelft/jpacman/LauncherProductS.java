package nl.tudelft.jpacman;


import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.game.GameFactory;
import nl.tudelft.jpacman.level.Level;
import java.io.IOException;

public class LauncherProductS {
	private LauncherProductProduct launcherProductProduct = new LauncherProductProduct();
	public static final PacManSprites SPRITE_STORE = new PacManSprites();
	private String levelMap = Launcher.DEFAULT_MAP;

	public static PacManSprites getSPRITE_STORE() {
		return SPRITE_STORE;
	}

	public String getLevelMap() {
		return levelMap;
	}

	/**
	* @return  A new factory using the sprites from  {@link #getSpriteStore()} and the ghosts from  {@link #getGhostFactory()} .
	*/
	public LevelFactory getLevelFactory() {
		return launcherProductProduct.getLevelFactory();
	}

	/**
	* @return  A new factory using the sprites from  {@link #getSpriteStore()} .
	*/
	public GhostFactory getGhostFactory() {
		return launcherProductProduct.getGhostFactory();
	}

	/**
	* @return  A new board factory using the sprite store from {@link #getSpriteStore()} .
	*/
	public BoardFactory getBoardFactory() {
		return launcherProductProduct.getBoardFactory();
	}

	/**
	* @return  A new factory using the sprites from  {@link #getSpriteStore()} .
	*/
	public PlayerFactory getPlayerFactory() {
		return new PlayerFactory(SPRITE_STORE);
	}

	/**
	* @return  A new map parser object using the factories from {@link #getLevelFactory()}  and  {@link #getBoardFactory()} .
	*/
	public MapParser getMapParser() {
		return launcherProductProduct.getMapParser();
	}

	/**
	* @return  A new factory using the players from  {@link #getPlayerFactory()} .
	*/
	public GameFactory getGameFactory() {
		return new GameFactory(getPlayerFactory());
	}

	/**
	* Set the name of the file containing this level's map.
	* @param fileName Map to be used.
	* @return  Level corresponding to the given map.
	*/
	public Launcher withMapFile(String fileName, Launcher launcher) {
		levelMap = fileName;
		return launcher;
	}

	/**
	* Creates a new level. By default this method will use the map parser to parse the default board stored in the <code>board.txt</code> resource.
	* @return  A new level.
	*/
	public Level makeLevel() {
		try {
			return launcherProductProduct.getMapParser().parseMap(levelMap);
		} catch (IOException e) {
			throw new PacmanConfigurationException("Unable to create level, name = " + levelMap, e);
		}
	}
}