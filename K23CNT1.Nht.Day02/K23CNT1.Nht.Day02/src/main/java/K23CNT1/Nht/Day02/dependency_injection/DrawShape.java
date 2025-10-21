package K23CNT1.Nht.Day02.dependency_injection;

public class DrawShape {
    private Shape shape;

    // Constructor Injection
    public DrawShape(Shape shape) {
        this.shape = shape;
    }

    public void Draw() {
        shape.draw();
    }

    public static void main(String[] args) {
        // Tiêm phụ thuộc CircleShape qua Constructor
        DrawShape drawShape = new DrawShape(new CircleShape());
        drawShape.Draw();

        // Tiêm phụ thuộc RectangleShape qua Constructor
        drawShape = new DrawShape(new RectangleShape());
        drawShape.Draw();
    }
}