package homework1.heroes;

import homework1.enemies.Enemy;

public class Warrior extends Hero {
    public Warrior(String name, int health) {
        super(name);
        this.setHealth(health);
        this.setAttack(35);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.printf("Warrior %s strikes %s dealing %d damage\n",
                this.getName(), enemy.getName(), this.getAttack());
        enemy.takeDamage(this.getAttack());
    }
}
