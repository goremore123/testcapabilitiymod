package com.example.examplemod.capabilities;

public class Mana implements IMana{

    private int mana = 1;

    public Mana() {
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public int getMana() {
        return this.mana;
    }
}
