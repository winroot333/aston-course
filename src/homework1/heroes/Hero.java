package homework1.heroes;

import homework1.enemies.Enemy;
import homework1.Mortal;

public abstract class Hero implements Mortal {
    private String name;
    private int attack;
    private double health = 100;

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    abstract public void attackEnemy(Enemy enemy);

    public String getName() {
        return name;
    }

    public Hero(String name) {
        this.name = name;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
