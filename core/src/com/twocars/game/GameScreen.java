package com.twocars.game;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import org.usb4java.Device;



public class GameScreen extends ScreenAdapter {
	private MyTwocarsGame mytwocarsGame;
	World world;
	WorldRenderer worldRenderer;
	public boolean isBluecarMoved = false;
	public boolean isRedcarMoved = false;
	public static McuWithPeriBoard peri;
	int input1,input2;
    public GameScreen(MyTwocarsGame mytwocarsGame) {
        this.mytwocarsGame = mytwocarsGame;
        world = new World(mytwocarsGame);
        worldRenderer = new WorldRenderer(mytwocarsGame,world);
        McuBoard.initUsb();
        Device[] devices = McuBoard.findBoards();
        peri = new McuWithPeriBoard(devices[0]);
      

    }
    
    @Override
    public void render(float delta) {
    	update(delta);
    	Gdx.gl.glClearColor(0, 0, 0, 1);
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	worldRenderer.render(delta);
    }

	private void update(float delta) {
		getInput();
  	  	world.update(delta);
	}
	
	private void getInput() {
		Bluecar bluecar = world.getBluecar();
		Redcar redcar = world.getRedcar();
		try {
			input1 = peri.getLight_C();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (input1 >= 300) {
			isRedcarMoved = false;
			redcar.move(isRedcarMoved);
		}
		if (input1 < 300) {
			isRedcarMoved = true;
			redcar.move(isRedcarMoved);
		}
		
		try {
			input2 = peri.getLight_B();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (input2 < 300) {
			isBluecarMoved = false;
			bluecar.move(isBluecarMoved);
		}
		if (input2 >= 300) {
			isBluecarMoved = true;
			bluecar.move(isBluecarMoved);
		}
	}
}
