package LorenzCounter;


/*реализация странного аттрактора Лоренца*/
public class LorenzCounter implements Runnable {

    int a = 15;
    int b = 40; //масштаб
    int c = 3;
    float delta = 0.0018f;

    int col = 0;

    int result = 0;
    int i = 0;

    int count;


    float dx, dy, dz;
    float x, y, z;

    Main main;

    //Аттрактор Лоренца
    public LorenzCounter(int count, Main main) {
        this.main = main;
        this.count = count;

        this.x = 1;
        this.y = 3;
        this.z = 7;
    }

    @Override
    public void run() {

        while (true) {

            dx = x + a * (-x + y) * delta;
            dy = y + (b * x - y - z * x) * delta;
            dz = z + (x * y - c * z) * delta;

            x = dx;
            y = dy;
            z = dz;

            col++;

            if (col > 255) col = 0;

            i++;

            if (i > count) break;

            /*Получение количества итераций для выпадения того или иного числа*/
            /*
            if (result + 1 == Math.round(Math.abs(count * x / 7))) {
                result = (int) Math.round(Math.abs(count * x / 7));
                System.out.println(result + "  Колличество итераций для получения этого числа:(" + i + ")");
                i = 0;
            }
            if (result ==count) break;*/

            main.pain(x, y, z, col);

            /*Можем расскоментировать таймаут для динамической отрисовки*/
            /*try {
                Thread.sleep(1, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

        }
    }

}

