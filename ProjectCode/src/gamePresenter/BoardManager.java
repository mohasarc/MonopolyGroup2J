package gamePresenter;

import javax.swing.JPanel;

import models.*;
import userInterface.menus.MenuManager;
import userInterface.scene.EndTurnPrompt;
import userInterface.scene.InteractionArea;
import userInterface.scene.Map;
import userInterface.scene.RentChoicePrompt;

public class BoardManager extends JPanel {    //needs to change eventually to not extend JPanel
	private static BoardManager boardManager = null;
	
	private Map map;
	private InteractionArea interactionArea;
	private RentChoicePrompt rentChoicePrompt;
	private EndTurnPrompt endturnPrompt;
	
	private BoardManager() {
		setBounds(100, 100, 1900, 1000);
		setLayout(null);
		map = new Map();
		add(map);
		interactionArea = new InteractionArea();
		add(interactionArea);
	}
	
	public static BoardManager getInstance() {
		if( boardManager == null ) {
			boardManager = new BoardManager();
		}
		return boardManager;
	}
	
	public void updateMap(PlayerManager playerMngr) {
		
	}
	
	public void updateInteractionArea(PlayerManager playerMngr) {
		
	}
	
	public void updateDiceResults(Dice dice) {
		
	}
	
	private void pauseGame() {  //should be public I think -G
		
	}
	
	public void displayRentChoicePrompt() {
		
	}
	
	public void hideRentChoicePrompt() {
		
	}
	
	public void displayEndTurnPrompt() {
		
	}
	
	public void hideEndTurnPrompt() {
		
	}
}
