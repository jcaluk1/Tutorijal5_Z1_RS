package sample;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

public class KorisniciModel {
    ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    void napuni () {
        korisnici.add(new Korisnik("Jasmin","Caluk","jasmin@email","jcaluk","oki"));
        korisnici.add(new Korisnik("Korisnik","Korisnik","koris@email","kk","kk"));
        korisnici.add(new Korisnik("Rejs","Efendija","iz@email","ekavazovic","efendija"));
        trenutniKorisnik.set(null);
    }
    void DodajKorisnika () {
        Korisnik novi = new Korisnik("-","-","-","-","-");
        korisnici.add(novi);
        trenutniKorisnik.set(novi);
    }
    void ObrisiTrenutnogKorisnika() {
        korisnici.remove(getTrenutniKorisnik());
        trenutniKorisnik.set(null);
    }


}
