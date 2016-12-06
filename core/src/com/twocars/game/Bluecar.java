package com.twocars.game;


import com.badlogic.gdx.math.Vector2;

public class Bluecar {
	private Vector2 position;
	public static float width = 50;
	public static float height = 96;
	private static final int SPEED = 5;
    private int currentDirection;
    private int nextDirection;
    public static final int DIRECTION_STILL = 0;

    
    private static final int [][] DIR_OFFSETS = new int [][] {{0,0}, {0,-1}, {1,0}, {0,1}, {-1,0}};

  
    public Bluecar(int x, int y) {
        position = new Vector2(x,y);
    }    
    
     
    public Vector2 getPosition() {
        return position;    
    }
    
    public void update() {
    	if(isAtCenter()) {
            if(canMoveInDirection(nextDirection)) {
                currentDirection = nextDirection;  
                
            } else {
                currentDirection = DIRECTION_STILL;    
            }
    	}
        position.x += SPEED * DIR_OFFSETS[currentDirection][0];
    }
    
    private boolean canMoveInDirection(int next) {
		if((next == 4 && position.x <=290 )||(next == 2 && position.x >= 420)) {
			return false;
		}
		else {
			return true;
		}
	}


	private boolean isAtCenter() {
		if(position.x == 420 || position.x == 290) {
 			return true;
 		} else {
 			return false;
 		}
	}




	public void move(boolean isBluecarMoved) {
		if(isBluecarMoved) {
			nextDirection = 4;
		}
		else {
			nextDirection = 2;
		}
	}

}
