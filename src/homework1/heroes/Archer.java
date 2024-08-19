package homework1.heroes;

import homework1.enemies.Enemy;

public class Archer extends Hero {

    public Archer(String name, int health) {
        super(name);
        this.setHealth(health);
        this.setAttack(25);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.printf("Archer %s shoots at %s dealing %d damage\n",
                this.getName(), enemy.getName(), this.getAttack());
        enemy.takeDamage(this.getAttack());
    }
}
