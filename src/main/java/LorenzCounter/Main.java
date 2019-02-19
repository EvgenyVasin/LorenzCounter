package LorenzCounter;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*простейшая графическая визуализация аттракотора*/
public class Main extends Application {
    GraphicsContext context;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1500,1000);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,1500,1000);
        root.getChildren().add(canvas);
        primaryStage.setScene(scene);
        primaryStage.show();
        context = canvas.getGraphicsContext2D();
        Thread t = new Thread((Runnable) new LorenzCounter(956956, this), "myThread");
        t.start();
    }

    public synchronized void pain(float x, float y, float z, int col) {
        context.setFill(Color.grayRgb(col)); // устанавливаем цвет
        context.fillOval(Math.round(19.3 * (y - x * 0.292893) + 750), Math.round(-11 * (z + x * 0.292893) + 900), 1, 1); // рисуем овал с левым верхним углом в точке (10;20) и высотой = ширине = 50px
    }
}

