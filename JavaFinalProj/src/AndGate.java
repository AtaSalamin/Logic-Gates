import java.awt.*;
import java.awt.geom.Path2D;

public class AndGate {
    private int x, y;

    public AndGate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Path2D.Double path = new Path2D.Double();
        path.moveTo(x, y);
        path.lineTo(x + 20, y);
        path.curveTo(x + 40, y, x + 40, y + 40, x + 20, y + 40);
        path.lineTo(x, y + 40);
        path.closePath();
        g2.draw(path);
        g2.drawLine(x - 20, y + 10, x, y + 10);
        g2.drawLine(x - 20, y + 30, x, y + 30);
        g2.drawLine(x + 40, y + 20, x + 60, y + 20); 
    }
}
