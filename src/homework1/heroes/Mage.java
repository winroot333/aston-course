package homework1.heroes;

import homework1.enemies.Enemy;

public class Mage extends Hero {
    public Mage(String name, int health) {
        super(name);
        this.setHealth(health);
        this.setAttack(75);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.printf("Mage %s casts magic bolt at %s dealing %d damage\n",
                this.getName(), enemy.getName(), this.getAttack());
        enemy.takeDamage(this.getAttack());
    }
}
