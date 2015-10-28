public class KlimaModel implements Modelable {

    public static final short KLIMA_SOMMER = 1;
    public static final short KLIMA_WINTER = 2;
    private short klima = 0;

    public KlimaModel(short klima) {
        this.klima = klima;
    }

    @Override
    public double getGrowth(int age) {
        return 0.1 * getFaktor();
    }

    @Override
    public double getLoss(int age) {
        return 0.01 * getFaktor();
    }

    @Override
    public double getDeadRot(int age) {
        return 0.2 * getFaktor();
    }

    @Override
    public double getHarvest(int age) {
        return 0.05 * getFaktor();
    }

    @Override
    public double getHarvestedRot(int age) {
        return 0.05 * getFaktor();
    }

    private double getFaktor() {
        double temperatur = 0.0;
        double niederschlag = 0.0;

        switch (this.klima) {
            case KlimaModel.KLIMA_SOMMER:
                temperatur = 1.1;
                niederschlag = 0.5;
                break;
            case KlimaModel.KLIMA_WINTER:
                temperatur = 0.2;
                niederschlag = 1.0;
                break;
        }

        return niederschlag + temperatur;
    }
}
