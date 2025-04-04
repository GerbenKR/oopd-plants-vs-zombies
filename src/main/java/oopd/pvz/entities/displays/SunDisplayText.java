package oopd.pvz.entities.displays;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SunDisplayText extends TextEntity {
    public SunDisplayText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        setFill(Color.BLACK);
    }

    public void setSunDisplayText(int sunAmount) {
        setText("Aantal zonnen: " + sunAmount);
    }
}
