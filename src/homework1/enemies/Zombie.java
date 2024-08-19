package homework1.enemies;

import homework1.heroes.Hero;

public class Zombie extends Enemy {
    private boolean resurrected = false;

    public Zombie(double health) {
        super(health, "Zombie", 25);
    }

    @Override
    public void attack(Hero hero) {
        System.out.println("Zombie bites " + hero.getName() + " for 25 damage");
        hero.takeDamage(this.getAttack());
    }

    @Override
    public boolean isAlive() {
        if (this.getHealth() <= 0 && !resurrected) {
            resurrected = true;
            resurrect();
        }
        return super.isAlive();
    }

    private void resurrect() {
        if (Math.random() < 0.5) {
            this.setHealth(120);
            System.out.println("Zombie resurrected with 120hp");
        }
    }

}
