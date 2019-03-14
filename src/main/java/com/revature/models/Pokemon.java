package com.revature.models;

public class Pokemon {

  private int id;
  private String name;
  private String type;
  private int attack;
  private int defense;
  private int speed;
  private int special;
  private boolean canEvolve;

  public Pokemon() {
    super();
  }

  public Pokemon(int id, String name, String type, int attack, int defense, int speed, int special, boolean canEvolve) {
    super();
    this.id = id;
    this.name = name;
    this.type = type;
    this.attack = attack;
    this.defense = defense;
    this.speed = speed;
    this.special = special;
    this.canEvolve = canEvolve;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getAttack() {
    return attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public int getDefense() {
    return defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getSpecial() {
    return special;
  }

  public void setSpecial(int special) {
    this.special = special;
  }

  public boolean isCanEvolve() {
    return canEvolve;
  }

  public void setCanEvolve(boolean canEvolve) {
    this.canEvolve = canEvolve;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + attack;
    result = prime * result + (canEvolve ? 1231 : 1237);
    result = prime * result + defense;
    result = prime * result + id;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + special;
    result = prime * result + speed;
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pokemon other = (Pokemon) obj;
    if (attack != other.attack)
      return false;
    if (canEvolve != other.canEvolve)
      return false;
    if (defense != other.defense)
      return false;
    if (id != other.id)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (special != other.special)
      return false;
    if (speed != other.speed)
      return false;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Pokemon [id=" + id + ", name=" + name + ", type=" + type + ", attack=" + attack + ", defense=" + defense
        + ", speed=" + speed + ", special=" + special + ", canEvolve=" + canEvolve + "]";
  }

}
