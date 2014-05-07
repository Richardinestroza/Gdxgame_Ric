package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private Texture texture_nave;
	private Sprite sprite_nave;
	private Texture texture_enemigo;
	private Sprite sprite_enemigo;
	private Texture texture_fondo;
	private Sprite sprite_fondo;
	Stage stage;
	Image image;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		texture_nave = new Texture(Gdx.files.internal("data/nave.png"));
		texture_enemigo = new Texture(Gdx.files.internal("data/enemigo.png"));
		texture_fondo = new Texture(Gdx.files.internal("data/fondo.png"));
		
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite_nave = new Sprite(texture_nave,512,512); 
		sprite_nave.setPosition(-0.5f,-0.3f); 
		sprite_nave.setSize(0.4f,0.4f);
		
		sprite_enemigo = new Sprite(texture_enemigo,512,512); 
		sprite_enemigo.setPosition(0.1f,-0.1f); 
		sprite_enemigo.setSize(0.4f,0.4f);

		sprite_fondo = new Sprite(texture_fondo,512,512); 
		sprite_fondo.setPosition(-0.5f,-0.4f); 
		sprite_fondo.setSize(1f,1f);
		
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		stage = new Stage();
		image = new Image(region);
		
		
		
		
		image.setRotation(45);
		
		stage.addActor(image);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
	
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//sprite.draw(batch);
		sprite_fondo.draw(batch);
		sprite_nave.draw(batch);
		sprite_enemigo.draw(batch);
		
		batch.end();
		//image.setRotation(image.getRotation()+1);//
		//image.setX(image.getX()+5);
		//if(image.getX()>700)
			//image.setX(-500);
		//stage.draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
