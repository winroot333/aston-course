package homework1.enemies;

import homework1.heroes.Hero;

public class Ogre extends Enemy {

    private boolean rageState = false;
    private int rageAttacksRemaining = 0;

    public Ogre(double health) {
        super(health, "Ogre", 45);
    }

    @Override
    public void attack(Hero hero) {
        int damage = this.getAttack();
        if (this.rageState) {
            damage *= 3;
            this.rageAttacksRemaining--;
            if (this.rageAttacksRemaining < 1) {
                this.rageState = false;
            }
        }
        System.out.println("Ogre hits " + hero.getName() + " for " + damage + " damage");
        hero.takeDamage(damage);

    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (super.getHealth() < 120 && !this.rageState && this.isAlive()) {
            this.rageState = true;
            this.rageAttacksRemaining = 2;
            System.out.println("Ogre entered berserk state. His attack power is tripled for 2 attacks");
        }
    }
}
