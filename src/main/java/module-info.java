module waterworld {
    requires hanyaeger;
    requires java.desktop;

    exports com.github.hanyaeger.tutorial;
    exports com.github.hanyaeger.tutorial.entities.map;

    opens audio;
    opens backgrounds;
    opens sprites;

    exports com.github.hanyaeger.tutorial.entities.buttons;
}
