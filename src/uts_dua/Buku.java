package uts_dua;

class Buku {
    private String judul;
    private String penulis;
    private String genre;

    public Buku(String judul, String penulis, String genre){
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
    }

    public String toString(){
        return "Judul: " + judul + ", Penulis: " + penulis + ", genre: " + genre;
    }
}
