package uts_satu;

public class Hewan {
    protected String jenisSuara;

    public Hewan(String jenisSuara){
        this.jenisSuara = jenisSuara;
    }

    protected void bersuara(){
        System.out.println(jenisSuara);
    }
}
