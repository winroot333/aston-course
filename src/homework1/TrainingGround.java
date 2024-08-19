package homework1;

import homework1.enemies.Enemy;
import homework1.enemies.Ogre;
import homework1.heroes.Hero;
import homework1.heroes.Mage;


public class TrainingGround {
    public static void main(String[] args) {
        Enemy enemy = new Ogre(250);
        Hero hero = new Mage("Merlin",150);
        enemy.attack(hero);
        hero.attackEnemy(enemy);
        hero.attackEnemy(enemy);
        enemy.attack(hero);

    }
}
