import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import javax.swing.JPanel;

public class OrGate {
    private int x, y;

    public OrGate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Path2D.Double path = new Path2D.Double();
        path.moveTo(x, y + 10);
        path.curveTo(x + 30, y - 10, x + 60, y + 20, x + 30, y + 50);
        path.curveTo(x + 60, y + 30, x + 30, y + 50, x, y + 40);
        path.moveTo(x + 10, y + 10);
        path.curveTo(x + 20, y + 20, x + 20, y + 30, x + 10, y + 40);
        g2.draw(path);
        g2.drawLine(x - 20, y + 10, x + 10, y + 10); 
        g2.drawLine(x - 20, y + 30, x + 10, y + 30); 
        g2.drawLine(x + 60, y + 20, x + 80, y + 20); 
    }
}
