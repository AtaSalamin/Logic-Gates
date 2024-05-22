import java.awt.*;
import java.awt.geom.Path2D;

public class NotGate {
    private int x, y;

    public NotGate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Path2D.Double path = new Path2D.Double();
        path.moveTo(x, y);
        path.lineTo(x + 20, y + 10);
        path.lineTo(x, y + 20);
        path.closePath();
        g2.drawOval(x + 20, y + 7, 6, 6);
        g2.draw(path);
        g2.drawLine(x - 20, y + 10, x, y + 10); 
        g2.drawLine(x + 26, y + 10, x + 40, y + 10); 
    }
}
