package homework1;

import homework1.enemies.Enemy;
import homework1.enemies.Zombie;
import homework1.heroes.Archer;
import homework1.heroes.Hero;
import homework1.heroes.Mage;
import homework1.heroes.Warrior;
import java.util.ArrayList;
import java.util.List;

public class BattleGround {
    public static void main(String[] args) {
        List<Hero> heroesParty = new ArrayList<>();
        heroesParty.add(new Warrior("Viktor"));
        heroesParty.add(new Mage("Elena"));
        heroesParty.add(new Archer("Clint"));

        List<Enemy> enemyParty = new ArrayList<>();
        enemyParty.add(new Zombie(100));
        enemyParty.add(new Zombie(140));
        enemyParty.add(new Zombie(120));

        while (!enemyParty.isEmpty() && !heroesParty.isEmpty()) {
            for (Hero hero : heroesParty) {
                hero.attackEnemy(enemyParty.getFirst());
                if (!enemyParty.getFirst().isAlive()) {
                    enemyParty.removeFirst();
                    if (enemyParty.isEmpty()) {
                        System.out.println("Hero party defeated all monsters!");
                        break;
                    }
                }
            }
            for (Enemy enemy : enemyParty) {
                enemy.attack(heroesParty.getFirst());
                if (!heroesParty.getFirst().isAlive()) {
                    System.out.println("Hero " + heroesParty.getFirst().getName() + " is defeated");
                    heroesParty.removeFirst();
                    if (heroesParty.isEmpty()) {
                        System.out.println("Hero party is dead, monsters won!");
                        break;
                    }
                }
            }
        }


    }
}
