package uts_satu;

public class Kucing extends Hewan{
    public Kucing(){
        super("Meong");
    }

    @Override
    protected void bersuara() {
        System.out.println(jenisSuara);
    }
}
