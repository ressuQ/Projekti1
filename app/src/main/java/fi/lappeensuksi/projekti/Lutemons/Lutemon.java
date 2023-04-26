package fi.lappeensuksi.projekti.Lutemons;

public class Lutemon {
    String name;
    String color;
    String location;
    int attack;
    int defence;
    int experience;
    public int health;
    int maxHealth;
    int id;

    public Lutemon(String name, String color, String location, int attack, int defence, int experience,
                   int health, int maxHealth, int id) {
        this.name = name;
        this.color = color;
        this.location = location;
        this.attack = attack;
        this.defence = defence;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }
}
