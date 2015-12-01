import java.util.ArrayList;
import java.util.Iterator;

public class Bauholzlager {
    private final String name;
    private final ArrayList<KantholzGehobelt> lagerKG = new ArrayList<>();
    private final ArrayList<KantholzSaegerauh> lagerKS = new ArrayList<>();
    private final ArrayList<RundholzGehobelt> lagerRG = new ArrayList<>();
    private final ArrayList<RundholzSaegerauh> lagerRS = new ArrayList<>();

    public Bauholzlager(String name) {
        this.name = name;
    }

    public void add(KantholzGehobelt v) {
        v.add(lagerKG);
    }

    public void add(KantholzSaegerauh v) {
        v.add(lagerKS);
    }

    public void add(RundholzGehobelt v) {
        v.add(lagerRG);
    }

    public void add(RundholzSaegerauh v) {
        v.add(lagerRS);
    }


    public Bauholz get(Dachstuhl d) {
        for (Iterator<KantholzSaegerauh> i = this.lagerKS.iterator(); i.hasNext(); ) {
            KantholzSaegerauh ks = i.next();
            if (d.isValidWood(ks)) {
                i.remove();
                return ks;
            }
        }
        for (Iterator<KantholzGehobelt> i = this.lagerKG.iterator(); i.hasNext(); ) {
            KantholzGehobelt kg = i.next();
            if (d.isValidWood(kg)) {
                i.remove();
                return kg;
            }
        }
        for (Iterator<RundholzSaegerauh> i = this.lagerRS.iterator(); i.hasNext(); ) {
            RundholzSaegerauh rs = i.next();
            if (d.isValidWood(rs)) {
                i.remove();
                return rs;
            }
        }
        for (Iterator<RundholzGehobelt> i = this.lagerRG.iterator(); i.hasNext(); ) {
            RundholzGehobelt rg = i.next();
            if (d.isValidWood(rg)) {
                i.remove();
                return rg;
            }
        }
        return null;
    }

    public void list() {
        for (KantholzGehobelt aLagerKG : this.lagerKG) {
            System.out.println(aLagerKG);
        }
        for (KantholzSaegerauh lagerKS : this.lagerKS) {
            System.out.println(lagerKS);
        }
        for (RundholzGehobelt aLagerRG : this.lagerRG) {
            System.out.println(aLagerRG);
        }
        for (RundholzSaegerauh lagerRS : this.lagerRS) {
            System.out.println(lagerRS);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
