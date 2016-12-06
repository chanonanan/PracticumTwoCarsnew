package com.twocars.game;

import java.util.ArrayList;
import java.util.List;





public class World {
	private Bluecar bluecar;
	private Redcar redcar;
	private List<Ball> ball;
	private List<Box> box;
	private MyTwocarsGame mytwocarGame;
	private int score = 0;
	
	World(MyTwocarsGame mytwocarGame) {
		this.mytwocarGame = mytwocarGame;
		bluecar = new Bluecar(420,75);
	    redcar = new Redcar(35,75);
	    ball = new ArrayList<Ball>();
	    box = new ArrayList<Box>();
	}

	Bluecar getBluecar() {
		return bluecar;
	}
	
	Redcar getRedcar() {
		return redcar;
	}
	
	public List<Ball> getBall() {
		return ball;
	}
	
	public List<Box> getBox() {
		return box;
	}
	
    public void update(float delta) {
        redcar.update();
        bluecar.update();
        updateBall();
        updateBox();
        updateHighScore();
    }
    

	private void updateBox() {
		for(int i=0;i<box.size();i++)
		{
			box.get(i).update();
			if(box.get(i).hitBlueCar()) {
				mytwocarGame.dispose();
				mytwocarGame.create();
				continue;
			}
			if(box.get(i).hitRedCar()) {
				mytwocarGame.dispose();
				mytwocarGame.create();
				continue;
			}
			if(box.get(i).hitEdge()) {
				box.remove(i);
				i--;
			}

		}
		
	}

	private void updateBall() {
		for(int i=0;i<ball.size();i++) {
			ball.get(i).update();
			if(ball.get(i).hitBlueCar()) {
				ball.remove(i);
				i--;
				score++;
				continue;
			}
			if(ball.get(i).hitRedCar()) {
				ball.remove(i);
				i--;
		        score++;
				continue;
			}
			if(ball.get(i).hitEdge()) {
				mytwocarGame.dispose();
				mytwocarGame.create();
				ball.remove(i);
				i--;
			}

		}
	}

	public void updateHighScore() {
		if(score >= mytwocarGame.getHighScore()) mytwocarGame.setHighScore(score);
	}
	

	public int getScore() {
		return score;
	}
}
