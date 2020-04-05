package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import org.w3c.dom.css.Rect;

public class Bird {
    private Vector3 velocity;
    private Vector3 position;
    private Texture bird;
    private Rectangle bounds;
    private Sound flap;

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }

    public static final int GRAVITY = -5;
    public static final int MOVEMENT = 100;

    public Bird(int x, int y) {
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        bird = new Texture("bird.png");
        bounds = new Rectangle(x,y,bird.getWidth(),bird.getHeight());
        flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public void update(float dt) {
        velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(0, velocity.y, 0);
        position.add(MOVEMENT* dt, velocity.y, 0);
        flap.play();



        // коэффициент скорости падения
        velocity.scl(1/dt);
        // движение коллайдера 'птиц' вслед за текстурой птица
        bounds.setPosition(position.x,position.y);
    }

    public void jump() {
        velocity.y = 250;
    }
    public Rectangle getBounds(){
        return bounds;
        // при вызове метода вренем в точку вызова коллайдер 'птиц'
    }
}
