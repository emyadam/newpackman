package nl.tudelft.jpacman;


import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.level.MapParser;

public class LauncherProductProduct {
	/**
	* @return   A new factory using the sprites from   {@link #getSpriteStore()}  and the ghosts from   {@link #getGhostFactory()}  .
	*/
	public LevelFactory getLevelFactory() {
		return new LevelFactory(LauncherProduct.SPRITE_STORE, getGhostFactory());
	}

	/**
	* @return   A new factory using the sprites from   {@link #getSpriteStore()}  .
	*/
	public GhostFactory getGhostFactory() {
		return new GhostFactory(LauncherProduct.SPRITE_STORE);
	}

	/**
	* @return   A new board factory using the sprite store from  {@link #getSpriteStore()}  .
	*/
	public BoardFactory getBoardFactory() {
		return new BoardFactory(LauncherProduct.SPRITE_STORE);
	}

	/**
	* @return   A new map parser object using the factories from  {@link #getLevelFactory()}   and   {@link #getBoardFactory()}  .
	*/
	public MapParser getMapParser() {
		return new MapParser(getLevelFactory(), getBoardFactory());
	}
}