package main;

import java.util.Random;
import java.util.Scanner;


public class Main {

   
    public static void main(String[] args) {
    
        //System objects 
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        
        //Game variables
        String[] enemies = {"Skeleton","Zombie","Warrior","Assassin"};
        int maxEnemyHealth = 75;
        int enemyAtackDamage = 25;
        
        //Player variables
        int health = 100;
        int atackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealthAmount = 30;
        int healthPotionDropChance = 50; //Percentage
        
        boolean running = true;
        
        System.out.println("Welcome to the Dungeon!");
        
        GAME:
        while(running) {
            System.out.println("---------------------------------------------");
            
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");
            
            while(enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Atack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");
                
                String input = in.nextLine();
                if(input.equals("1")){
                    int damageDealt = rand.nextInt(atackDamage);
                    int damageTaken = rand.nextInt(enemyAtackDamage);
                    
                    enemyHealth -= damageDealt;
                    health -= damageTaken;
                    
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " Damage !!!");
                    System.out.println("\t> You recieve " + damageTaken + " in retaliation!");
                    
                    if(health < 1){
                        System.out.println("\t> You have taken to much damage, you are too weak to go on!");
                        break;
                    }
                }
                else if(input.equals("2")){
                    if(numHealthPotions > 0) {
                        health +=healthPotionHealthAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealthAmount 
                                            + "\n\t> You now have " + health + "HP"
                                            + "\n\t> You have " + numHealthPotions + " health potions left.\n");  
                    }
                    else{
                        System.out.println("\t> You have no potions left! Deafeat enemies to get 'em!!!");
                    }
                }
                else if(input.equals("3")){
                    System.out.println("\tYou run away from the " + enemy + "!");
                    continue GAME;
                }
                else{
                    System.out.println("\tInvalid command!");
                }
            }
            
            if(health < 1){
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
            }
            System.out.println("---------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left. #");
            if(rand.nextInt(100) < healthPotionDropChance){
                numHealthPotions++;
                System.out.println(" # The " + enemy + "dropped a health potion! # ");
                System.out.println(" # You have " + numHealthPotions + "health potion(s). # ");
            }
            System.out.println("---------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continuea fighting");
            System.out.println("2. Exit the dungeon");
            
            
            String input = in.nextLine();
            
            
            while(!input.equals("1") && !input.equals("2")){
                    System.out.println("Invalid command!");
                    input = in.nextLine();
            }
            
            if(input.equals("1")){
                System.out.println("You continue your adventure!");
            }
            else if(in.equals("2")){
                System.out.println("You exit the dungeon, succesful from your adventures!");
                break;
            }
        }
        
        System.out.println("#######################");
        System.out.println(" # Thanks for Playing #");
        System.out.println("#######################");
        
        
    }
    
}
