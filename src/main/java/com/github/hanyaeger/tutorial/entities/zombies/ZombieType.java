package com.github.hanyaeger.tutorial.entities.zombies;

public enum ZombieType {

    NORMAL_ZOMBIE(NormalZombie.class),
    CONE_ZOMBIE(ConeZombie.class),
    BUCKET_ZOMBIE(BucketZombie.class),
    BALLOON_ZOMBIE(BalloonZombie.class);

    // A reference to the class that extends Zombie, so we dont have to specify each class.
    private final Class<?extends Zombie> zombieClass;

    ZombieType(Class<? extends Zombie> zombieClass) {
        this.zombieClass = zombieClass;
    }

    public Class<?extends Zombie> getZombieClass() {
        return zombieClass;
    }
}
