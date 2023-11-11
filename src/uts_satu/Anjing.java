package uts_satu;

public class Anjing extends Hewan{
    public Anjing(){
        super("Guk Guk.");
    }

    @Override
    protected void bersuara() {
        System.out.println(jenisSuara);
    }
}
