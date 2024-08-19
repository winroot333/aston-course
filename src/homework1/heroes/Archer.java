package homework1.heroes;

import homework1.enemies.Enemy;

public class Archer extends Hero {
    private int energy = 0;

    public Archer(String name) {
        super(name);
        this.setAttack(25);
    }

    @Override
    public void attackEnemy(Enemy enemy) {

        enemy.takeDamage(this.getAttack());
        System.out.println("Archer " + this.getName() + " shoots an arrow dealing " + this.getAttack() + " damage");

    }
}
