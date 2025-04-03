module waterworld {
    requires hanyaeger;
    requires java.desktop;
    requires com.google.guice;

    exports oopd.pvz;
    exports oopd.pvz.entities.map;

    opens audio;
    opens backgrounds;
    opens sprites;

    exports oopd.pvz.entities.buttons;
}
