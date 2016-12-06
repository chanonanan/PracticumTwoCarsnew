package com.twocars.game;

import com.badlogic.gdx.math.Vector2;

public class Box {
	private Vector2 position;
	private float speed = 7f;
    private World world; 
    private MyTwocarsGame myTwocarsGame;
	public static float width = 50;
	public static float height = 50;
    private Bluecar bluecar;
    private Redcar redcar;

    
    public Box(float x, float y,MyTwocarsGame myTwocarsGame,World world) {
    	position = new Vector2(x,y);
    	this.myTwocarsGame = myTwocarsGame;
    	this.world = world;
     	bluecar = world.getBluecar();
    	redcar = world.getRedcar();
    }   
    
    public Vector2 getPosition() {
		return position;
	}
    

	public void update() {
		position.y -= speed;
	}
	
	public boolean hitEdge(){
		return position.y <= -height;
	}

	public boolean hitBlueCar() {
		float x = position.x + width/2;
		float y = position.y + height/2;
		return x > bluecar.getPosition().x
				&& x < bluecar.getPosition().x+Bluecar.width
				&& y > bluecar.getPosition().y
				&& y < bluecar.getPosition().y+Bluecar.height;
	}

	public boolean hitRedCar() {
		float x = position.x + width/2;
		float y = position.y + height/2;
		return x > redcar.getPosition().x
				&& x < redcar.getPosition().x+Redcar.width
				&& y > redcar.getPosition().y
				&& y < redcar.getPosition().y+Redcar.height;
	}


}
