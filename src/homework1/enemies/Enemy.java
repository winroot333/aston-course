package homework1.enemies;

import homework1.Mortal;
import homework1.heroes.Hero;

abstract public class Enemy implements Mortal {
    private double health;
    private final String name;
    private int attack;

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public Enemy(double health, String name, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public abstract void attack(Hero hero);

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
