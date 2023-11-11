package uts_satu;

public class Kucing extends Hewan{
    public Kucing(){
        super("Meong");
    }

    @Override
    public void bersuara() {
        System.out.println(jenisSuara);
    }
}
