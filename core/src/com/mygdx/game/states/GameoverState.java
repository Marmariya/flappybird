package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FlappyBird;

public class GameoverState extends State {
    private Texture background;
    private Texture playBtn;
    private Texture gameover;
    private Texture gameoverBtn;

    public GameoverState(GameStateManager gsm) {
        super(gsm);
        gameover = new Texture("bg.png");
       gameoverBtn = new Texture("gameover.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(gameover, 0, 0, camera.position.x - gameoverBtn.getWidth()/2, camera.position.y -gameoverBtn.getHeight()/2);
        sb.draw(gameoverBtn, camera.position.x - gameover.getWidth()/2, camera.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        gameover.dispose();
        gameoverBtn.dispose();
    }
}
