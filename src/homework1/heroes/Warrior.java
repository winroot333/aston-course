package homework1.heroes;

import homework1.enemies.Enemy;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name);
        this.setAttack(35);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(this.getAttack());
        System.out.println("Warrior "+this.getName()+" is striking the enemy dealing "+this.getAttack()+" damage");
    }
}
