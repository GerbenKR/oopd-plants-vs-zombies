package oopd.pvz.entities.items;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import oopd.pvz.entities.managers.SunManager;
import javafx.scene.input.MouseButton;

public class Sun extends SpriteEntity implements MouseButtonPressedListener {
    private SunManager manager;

    public Sun(Coordinate2D location, SunManager manager) {
        super("sprites/sun.gif", location, new Size(50, 50));
        this.manager = manager;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        this.manager.addSun(25);
        remove();
    }
}
