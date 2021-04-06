import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameGui extends JFrame implements ActionListener {
    PS photoShop = new PS();
    JPanel a1 = new JPanel() {};
    static JLabel errorLabel;
    JTextField a = new JTextField();
    JTextField b = new JTextField();
    JTextField tLiniowa = new JTextField();
    JTextField tPotegowa = new JTextField();
    JTextField tprzezroczystosc = new JTextField();
    JLabel adres1 = new JLabel("Podaj adres 1 obrazka");
    JLabel adres2 = new JLabel("Podaj adres 2 obrazka");
    JLabel tLiniowaVal = new JLabel("Liczba z zakresu[-255,255]");
    JLabel tPotegowaVal = new JLabel("Liczba z zakresu[0.0,1.0]");
    JLabel tPrzezroczystoscVal = new JLabel("[0.0,1.0]");
    JButton registerFirstImage = new JButton("Pobierz pierwszy obraz");
    JButton registerSecImage = new JButton("Pobierz drugi obraz");
    JButton transformacjaLiniowa = new JButton("Transformacja Liniowa");
    JButton transformacjaPotegowa = new JButton("Transformacja Potegowa");
    JButton transformacjaNegatyw = new JButton("Transformacja Negatyw");
    ButtonGroup mieszanie = new ButtonGroup();
    JRadioButton suma, odejmowanie, roznica, mnozenie, mnozenieOdwrotnosci, negacja, ciemniejsze, jasniejsze, wylaczenie, nakladka, ostreSwiatlo, lagodneSwiatlo, rozcienczenie, wypalenie, reflectMode, przezroczystosc;

    public FrameGui() {
        gui();
    }

    private void gui() {
        a.setBounds(0, 20, 200, 30);
        b.setBounds(220, 20, 200, 30);
        adres1.setBounds(0,0,200,20);
        adres2.setBounds(220,0,200,20);
        suma = new JRadioButton("Suma", false);
        odejmowanie = new JRadioButton("Odejmowanie", false);
        roznica = new JRadioButton("Różnica", false);
        mnozenie = new JRadioButton("Mnożenie", false);
        mnozenieOdwrotnosci = new JRadioButton("mOdwrotności", false);
        negacja = new JRadioButton("Negacja", false);
        ciemniejsze = new JRadioButton("Ciemniejsze", false);
        jasniejsze = new JRadioButton("Jaśniejsze", false);
        wylaczenie = new JRadioButton("Wyłączenie", false);
        nakladka = new JRadioButton("Nakładka", false);
        ostreSwiatlo = new JRadioButton("oSwiatło", false);
        lagodneSwiatlo = new JRadioButton("lSwiatło", false);
        rozcienczenie = new JRadioButton("Rozcięczenie", false);
        wypalenie = new JRadioButton("Wypalenie", false);
        reflectMode = new JRadioButton("ReflectMode", false);
        przezroczystosc = new JRadioButton("Przezroczystość", false);

        mieszanie.add(suma);
        mieszanie.add(odejmowanie);
        mieszanie.add(roznica);
        mieszanie.add(mnozenie);
        mieszanie.add(mnozenieOdwrotnosci);
        mieszanie.add(negacja);
        mieszanie.add(ciemniejsze);
        mieszanie.add(jasniejsze);
        mieszanie.add(wylaczenie);
        mieszanie.add(nakladka);
        mieszanie.add(ostreSwiatlo);
        mieszanie.add(lagodneSwiatlo);
        mieszanie.add(rozcienczenie);
        mieszanie.add(wypalenie);
        mieszanie.add(reflectMode);
        mieszanie.add(przezroczystosc);

        suma.setBounds(0, 170, 100, 30);
        odejmowanie.setBounds(0, 200, 150, 30);
        roznica.setBounds(0, 230, 100, 30);
        mnozenie.setBounds(0, 260, 100, 30);
        mnozenieOdwrotnosci.setBounds(0, 290, 150, 30);
        negacja.setBounds(0, 320, 100, 30);
        ciemniejsze.setBounds(0, 350, 100, 30);
        jasniejsze.setBounds(0, 380, 100, 30);
        wylaczenie.setBounds(150, 170, 100, 30);
        nakladka.setBounds(150, 200, 100, 30);
        ostreSwiatlo.setBounds(150, 230, 100, 30);
        lagodneSwiatlo.setBounds(150, 260, 100, 30);
        rozcienczenie.setBounds(150, 290, 150, 30);
        wypalenie.setBounds(150, 320, 100, 30);
        reflectMode.setBounds(150, 350, 100, 30);
        przezroczystosc.setBounds(150, 380, 150, 30);
        tprzezroczystosc.setBounds(300, 390, 50, 20);
        tPrzezroczystoscVal.setBounds(350,390,150,20);

        suma.addActionListener(this);
        odejmowanie.addActionListener(this);
        roznica.addActionListener(this);
        mnozenie.addActionListener(this);
        mnozenieOdwrotnosci.addActionListener(this);
        negacja.addActionListener(this);
        ciemniejsze.addActionListener(this);
        jasniejsze.addActionListener(this);
        wylaczenie.addActionListener(this);
        nakladka.addActionListener(this);
        ostreSwiatlo.addActionListener(this);
        lagodneSwiatlo.addActionListener(this);
        rozcienczenie.addActionListener(this);
        wypalenie.addActionListener(this);
        reflectMode.addActionListener(this);
        przezroczystosc.addActionListener(this);


        registerFirstImage.setBounds(0, 50, 200, 30);
        registerFirstImage.addActionListener(this);

        registerSecImage.setBounds(220, 50, 200, 30);
        registerSecImage.addActionListener(this);

        transformacjaLiniowa.setBounds(0, 80, 200, 30);
        transformacjaLiniowa.addActionListener(this);
        tLiniowa.setBounds(220, 80, 50, 30);
        tLiniowaVal.setBounds(270,80,200,30);

        transformacjaPotegowa.setBounds(0, 110, 200, 30);
        transformacjaPotegowa.addActionListener(this);
        tPotegowa.setBounds(220, 110, 50, 30);
        tPotegowaVal.setBounds(270,110,200,30);

        transformacjaNegatyw.setBounds(0, 140, 200, 30);
        transformacjaNegatyw.addActionListener(this);


        a1.setBounds(0, 0, 420, 600);
        a1.setLayout(null);

        a1.add(tPrzezroczystoscVal);
        a1.add(tPotegowaVal);
        a1.add(tLiniowaVal);
        a1.add(adres2);
        a1.add(adres1);
        a1.add(tprzezroczystosc);
        a1.add(suma);
        a1.add(odejmowanie);
        a1.add(roznica);
        a1.add(mnozenie);
        a1.add(mnozenieOdwrotnosci);
        a1.add(negacja);
        a1.add(ciemniejsze);
        a1.add(jasniejsze);
        a1.add(wylaczenie);
        a1.add(nakladka);
        a1.add(ostreSwiatlo);
        a1.add(lagodneSwiatlo);
        a1.add(rozcienczenie);
        a1.add(wypalenie);
        a1.add(reflectMode);
        a1.add(przezroczystosc);
        a1.add(a);
        a1.add(b);
        a1.add(registerFirstImage);
        a1.add(registerSecImage);
        a1.add(transformacjaLiniowa);
        a1.add(transformacjaNegatyw);
        a1.add(transformacjaPotegowa);
        a1.add(tLiniowa);
        a1.add(tPotegowa);
        errorLabel = new JLabel();
        Color color =new Color(255,0,0) ;
        errorLabel.setForeground(color);
        errorLabel.setBounds(150, 420, 500, 30);
        a1.add(errorLabel);

        add(a1);

        setSize(430, 500);
        setTitle("Operacje na obrazie");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {

            if (source == registerFirstImage) {
                PS.setImage(a.getText());
            }
            if (source == registerSecImage) {
                PS.setImage2(b.getText());
            }
            if (source == transformacjaLiniowa) {
                PS.setImage(a.getText());
                photoShop.transformacjaLiniowa(Integer.parseInt(tLiniowa.getText()));
            }
            if (source == transformacjaNegatyw) {
                PS.setImage(a.getText());
                photoShop.transformacjaLiniowaNegatyw();
            }
            if (source == transformacjaPotegowa) {
                PS.setImage(a.getText());
                photoShop.transformacjaPotegowa(Double.parseDouble(tPotegowa.getText()));
            }
            if (source == suma) {
                PS.setImage(a.getText());
                photoShop.mieszanieSuma();
            }
            if (source == odejmowanie) {
                PS.setImage(a.getText());
                photoShop.mieszanieOdejmowanie();
            }
            if (source == roznica) {
                PS.setImage(a.getText());
                photoShop.mieszanieRoznica();
            }
            if (source == mnozenie) {
                PS.setImage(a.getText());
                photoShop.mieszanieMnozenie();
            }
            if (source == mnozenieOdwrotnosci) {
                PS.setImage(a.getText());
                photoShop.mieszanieMnozenieOdwrtonosci();
            }
            if (source == negacja) {
                PS.setImage(a.getText());
                photoShop.mieszanieNegacja();
            }
            if (source == ciemniejsze) {
                PS.setImage(a.getText());
                photoShop.mieszanieCiemniejsze();
            }
            if (source == jasniejsze) {
                PS.setImage(a.getText());
                photoShop.mieszanieJasniejsze();
            }
            if (source == wylaczenie) {
                PS.setImage(a.getText());
                photoShop.mieszanieWylaczenie();
            }
            if (source == nakladka) {
                PS.setImage(a.getText());
                photoShop.mieszanieNakladka();
            }
            if (source == ostreSwiatlo) {
                PS.setImage(a.getText());
                photoShop.mieszanieOstreSwiatlo();
            }
            if (source == lagodneSwiatlo) {
                PS.setImage(a.getText());
                photoShop.mieszanieLagodneSwiatlo();
            }
            if (source == rozcienczenie) {
                PS.setImage(a.getText());
                photoShop.mieszanieRozceinczenie();
            }
            if (source == wypalenie) {
                PS.setImage(a.getText());
                photoShop.mieszanieWypalenie();
            }
            if (source == reflectMode) {
                PS.setImage(a.getText());
                photoShop.mieszanieReflectMode();
            }
            if (source == przezroczystosc) {
                PS.setImage(a.getText());
                if (Double.parseDouble(tprzezroczystosc.getText()) >= 0 && Double.parseDouble(tprzezroczystosc.getText()) <= 1)
                    photoShop.mieszaniePrzezroczystosc(Double.parseDouble(tprzezroczystosc.getText()));
                else
                    photoShop.mieszaniePrzezroczystosc(0);
            }


        } catch (Exception z) {

            errorLabel.setText("aasdsad");
        }

    }
}
