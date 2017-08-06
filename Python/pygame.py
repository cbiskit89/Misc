#!/usr/env/python

from random import randint

class Enemy(object):
    def __init__(self, name, health, attack, defense):
        self.name = name
        self.health = health
        self.attack = attack
        self.defense = defense

    def intro(self):
        print ("I am %s. I will steal your cookies." % (self.name))

class Player(object):
    def __init__(self, name, health, attack, defense):
        self.name = name
        self.health = health
        self.attack = attack
        self.defense = defense

def print_menu():
    print ("Oh hai Scott! Welcome to World of Scottcraft.")
    return raw_input("1. Play\n2. Play Harder\n3. Die a lot\nChoice: ")

def basic_attack(atk_rate):
    return atk_rate * randint(1, 10)

def basic_heal(def_rate):
    return def_rate * randint(1, 10)

def health_check(health):
    if health <= 0:
        return False
    else:
        return True

def print_status(health_a, health_b):
    print ("=============\nPlayer HP: %s\nEnemy HP: %s\n==========" % (health_a, health_b))

def game(player, enemy):
    enemy.intro()
    while player.health > 0:
        print_status(player.health, enemy.health)
        move_chosen = raw_input("Choose your move:\n1. Attack\n2. Defend\nChoice: ")
        if move_chosen == '1':
            damage = basic_attack(player.attack)
            enemy.health -= damage
            print ("You do %s damage." % damage)
        elif move_chosen == '2':
            heal = basic_heal(player.defense)
            player.health += heal
            print ("You heal for %s." % heal)
        if not health_check(enemy.health):
            print ("You win.")
            return
        print_status(player.health, enemy.health)
        print ("Enemy turn!")
        if enemy.health < 200 and randint(1,3) == 2 or enemy.health < 150:
            heal = basic_heal(enemy.defense)
            enemy.health += heal
            print ("Enemy heals for %s." % heal)
        else:
            damage = basic_attack(enemy.attack)
            player.health -= damage
            print ("Enemy hits you for %s." % damage)
            if not health_check(player.health):
                print ("You lose.")
                return 
                
def main():
    valid_choice = False
    while valid_choice == False:
        choice = print_menu()
    
        if choice == '1':
            scott = Player("Scott", 500, 20, 20)
            boss = Enemy("The Butcher", 400, 18, 18) 
            valid_choice = True
            game(scott, boss)
        elif choice == '2':
            scott = Player("Scott", 500, 20, 20)
            boss = Enemy("The Baker", 550, 22, 22)
            valid_choice = True
            game(scott, boss)
        elif choice == '3':
            scott = Player("Scott", 500, 20, 20)
            boss = Enemy("The Candlestick Maker", 800, 25, 25)
            valid_choice = True
            game(scott, boss)
        else:
            print("Invalid choice. Please choose 1, 2, or 3.")

if __name__ == '__main__':
    main()
