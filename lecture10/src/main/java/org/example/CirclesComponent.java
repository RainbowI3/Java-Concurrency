package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.List;

public class CirclesComponent extends JComponent {
    private int circlesCount;
    private static final List<Color> colors = List.of(
            Color.BLUE,
            Color.RED,
            Color.GREEN
    );
    public void setCirclesCount(int circlesCount) {
        this.circlesCount = circlesCount;
        repaint();
    }



    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < circlesCount; i++) {
            g.setColor(randomColor());
            g.drawOval(randCoordinate(),randCoordinate(),randomWidth(),randomHeight());
        }
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(500,500);
    }

    @Override
    public Dimension getPreferredSize() {
        return getMinimumSize();
    }
    private  static int randCoordinate(){
        return new Random().nextInt(40);
    }
    private int randomWidth(){
        return new Random().nextInt(getWidth());

    }
    private int randomHeight(){
        return new Random().nextInt(getHeight());
    }
    private Color randomColor(){
        return colors.get(new Random().nextInt(colors.size()));
    }
}
