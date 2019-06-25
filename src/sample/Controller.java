package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    public TextField IdIme;
    public TextField IdUsername;
    public TextField IdEmail;
    public TextField IdPrezime;
    public PasswordField IdPassword;
    public ListView<Korisnik> lista;

    public KorisniciModel model = new KorisniciModel();
    public Button btnIdKraj;

    @FXML
    public void initialize () {
        model.napuni();;
        lista.setItems(model.getKorisnici());

        model.trenutniKorisnikProperty().addListener(
                (nesta, oldKorisnik, newKorisnik) -> {
                    if (oldKorisnik != null) {
                        IdIme.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                        IdPrezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                        IdUsername.textProperty().unbindBidirectional(oldKorisnik.usernameProperty());
                        IdEmail.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                        IdPassword.textProperty().unbindBidirectional(oldKorisnik.passwordProperty());
                    }
                    if (newKorisnik == null) {
                        IdIme.setText("");
                        IdPrezime.setText("");
                        IdUsername.setText("");
                        IdEmail.setText("");
                        IdPassword.setText("");
                    }
                    else {
                        IdIme.textProperty().bindBidirectional(newKorisnik.imeProperty());
                        IdPrezime.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                        IdUsername.textProperty().bindBidirectional(newKorisnik.usernameProperty());
                        IdEmail.textProperty().bindBidirectional(newKorisnik.emailProperty());
                        IdPassword.textProperty().bindBidirectional(newKorisnik.passwordProperty());
                    }
                }
        );

        lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik korisnik, Korisnik t1) {
                System.out.println("Usoo sam");
                model.setTrenutniKorisnik(t1);

            }
        });
    }

    public void btnDodaj(ActionEvent actionEvent) {
        model.DodajKorisnika();
    }

    public void BtnObrisi(ActionEvent actionEvent) {
        model.ObrisiTrenutnogKorisnika();
    }

    public void btnKraj(ActionEvent actionEvent) {
        Stage stage = (Stage) btnIdKraj.getScene().getWindow();
        stage.close();
    }
}
