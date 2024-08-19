package homework1.heroes;

import homework1.enemies.Enemy;

public class Mage extends Hero {
    public Mage(String name) {
        super(name);
        this.setAttack(75);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(this.getAttack());
        System.out.println("Mage " + this.getName() + " casts magic bolt spell dealing "+this.getAttack()+" damage");
    }
}
