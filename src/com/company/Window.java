package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.UnsupportedEncodingException;

/**
 * Created by Maksym Zieliński aka JOogway
 */
public class Window extends JFrame implements ActionListener {
    public static int witch = 0;
    String money = "100", imieS, nazwiskoS, adresZamieszkaniaS, peselS, rodzajS, markaS,
            dotychNrRejestracyjnyS, nrSilnikaS, numerVINS, nrKartyPojazduS, typMaszyny, cb1S = "nie", cb2S = "nie", nowuzy;
    JButton register, unregister, sendRequest, insertDoc, insertDoc1,
            checkIfSteal, setPayment, insertVehicleType, insertVehicleType2, printAplication,
            acceptRegistration, acceptUnregister, nextToChecker, send, count, printReport, nextToPrint, nextToVehicleType;
    JToggleButton moto, bus, autoB, autoS, kombajn, traktor;
    JLabel wlasciciel, pojazd, imieL, nazwiskoL, adresZamieszkaniaL,
            peselL, rodzajL, markaL, dotychNrRejestracyjnyL, nrSilnikaL,
            rokProdukcjiL, numerVINL, nrKartyPojazduL, typPojazduL, dotychNumerRejestrL,
            rokProdukcjiL2, oplataZaL, info, moneyCounterL, pkm, pg, pNU,
            putInStampsL, putInTablesL, putInNumberOfConstansRegistersL, putInNumberOfVariousRegistersL;
    JMenuBar MenuBar;
    JMenu plik, pomoc;
    JMenuItem Choose, Zmodyfikuj, Wyjscie, About_Program;
    String[] tekst;
    int number = 100, odpowiedz;
    JTextArea textArea;
    JTextField imieTF, nazwiskoTF, adresZamieszkaniaTF, peselTF,
            rodzajTF, markaTF, dotychNrRejestracyjnyTF, nrSilnikaTF,
            rokProdukcjiTF, numerVINTF, nrKartyPojazduTF, typPojazduTF,
            dotychNumerRejestrTF, rokProdukcjiTF2, oplataZaTF, moneyCounterTF,
            putInStampsTF, putInTablesTF, putInNumberOfConstansRegistersTF,
            putInNumberOfVariousRegistersTF, pojazdTF;

    JSeparator separator, separator2;
    JCheckBox cb1, cb2;

    public void Window() throws Exception, IOException, FileNotFoundException {

        setSize(700, 400);
        setTitle("Aplikacja");
        /*/getContentPane().setBackground(Color.blue);/*/
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        Ekran1();
        repaint();
    }

    void saveToFileTxt() throws IOException, UnsupportedEncodingException {
        FileWriter fw = new FileWriter(new File(peselS + ".txt"));

        fw.write(peselS + "\n " + imieS + "\n " + nazwiskoS + "\n " + adresZamieszkaniaS + "\n " +
                peselS + "\n " + rodzajS + "\n " + markaS + "\n " + dotychNrRejestracyjnyS + "\n " + nrSilnikaS + "\n " + numerVINS
                + "\n " + nrKartyPojazduS);

        fw.close();

    }

    void saveToFileDoc() throws IOException {
        FileWriter fw1 = new FileWriter(new File(peselS + ".doc"));
        fw1.write("Pan " + imieS + " " + nazwiskoS + " legitymuj¹cy sie numerem PESEL: " + peselS + " zlozy³ wniosek o rejestracje/wyrejestrowanie pojazdu: " + markaS + " " + dotychNrRejestracyjnyS + ". Pojazd(nowy/u¿ywany):"
                + nowuzy + " Pojazd Komunikacji miejskiej(tak/nie)" + cb1S + ". Pojazd gospodarczy(tak/nie):" + cb2S + ". Typ:" + typMaszyny + ". Otrzymuje dokument tymczasowy " +
                "uprawniajacy do jazdy. Za 30 dni prosze o zg³oszenie sie po odbiór do placowki " +
                "po orygina³ dokumentu");
        fw1.close();


    }

   /*/ void saveToFile(String pesel, JTextField peselTF) throws Exception {
        FileOutputStream out = new FileOutputStream(pesel, true);
        out.write(peselTF.getText().getBytes());

    }/*/
    /*/
    public void Zapis() throws IOException  {
        for(int witch = 1;witch<2;witch++) {
            if(witch==1)
            {
                PrintWriter zapis = new PrintWriter("%pesel.txt");
                String[] tablica = new String[11];
                tablica[1] = String.valueOf(new Window[1]);

                for(int i=0;i<10;i++)
                {
                    zapis.printf(tablica[i]);}
                zapis.close();

            }
        }
    }/*/

    public void Ekran1() { //Starter
        Rejestruj();
        Wyrejestruj();
        WyslijZapotrzebowanie();
        getContentPane().add(register);
        getContentPane().add(unregister);
        getContentPane().add(sendRequest);
    }

    public void Rejestruj() {
        register = new JButton("Rejestruj");
        register.setVisible(true);
        register.setBounds(30, 100, 200, 50);
        register.addActionListener(this);
    }

    public void Wyrejestruj() {
        unregister = new JButton("Wyrejestruj");
        unregister.setVisible(true);
        unregister.setBounds(450, 100, 200, 50);
        unregister.addActionListener(this);
    }

    public void WyslijZapotrzebowanie() {
        sendRequest = new JButton("Wylij Zapotrzebowanie");
        sendRequest.setVisible(true);
        sendRequest.setBounds(235, 225, 210, 50);
        sendRequest.addActionListener(this);
    }

    public void Ekran2() { //Rejestruj

        WprowadzDokumenty();
        SprCzyKradziony();
        UstalOplate();
        WprowadzTypPojazdu();
        DrukujWniosek();
        ZatwierdRejestracje();
        getContentPane().add(insertDoc);
        getContentPane().add(checkIfSteal);
        getContentPane().add(setPayment);
        getContentPane().add(insertVehicleType);
        getContentPane().add(printAplication);
        getContentPane().add(acceptRegistration);
    }

    public void WprowadzDokumenty() {
        insertDoc = new JButton("Wprowad wymagane dokumenty");
        insertDoc.setVisible(true);
        insertDoc.addActionListener(this);
        insertDoc.setBounds(30, 30, 200, 70);
        ;
    }

    public void SprCzyKradziony() {
        checkIfSteal = new JButton("Sprawd czy pojazd nie by³ kradziony");
        checkIfSteal.setVisible(true);
        checkIfSteal.addActionListener(this);
        checkIfSteal.setBounds(30, 140, 200, 70);

    }

    public void UstalOplate() {
        setPayment = new JButton("Ustal wysokoæ op³aty");
        setPayment.setVisible(true);
        setPayment.addActionListener(this);
        setPayment.setBounds(30, 250, 200, 70);
    }

    public void WprowadzTypPojazdu() {
        insertVehicleType = new JButton("Wprowad typ pojazdu");
        insertVehicleType.setVisible(true);
        insertVehicleType.addActionListener(this);
        insertVehicleType.setBounds(450, 30, 200, 70);
    }

    public void DrukujWniosek() {
        printAplication = new JButton("Drukuj wniosek");
        printAplication.setVisible(true);
        printAplication.addActionListener(this);
        printAplication.setBounds(450, 140, 200, 70);

    }

    public void ZatwierdRejestracje() {
        acceptRegistration = new JButton("Zatwierd rejestracjê");
        acceptRegistration.setVisible(true);
        acceptRegistration.addActionListener(this);
        acceptRegistration.setBounds(450, 250, 200, 70);
    }

    public void Ekran3() {//Wprowad wymagane dokumenty
        Labels();
        NextToChecker();
        getContentPane().add(nextToChecker);
        getContentPane().add(wlasciciel);
        getContentPane().add(pojazd);
        getContentPane().add(imieL);
        getContentPane().add(imieTF);
        getContentPane().add(nazwiskoL);
        getContentPane().add(nazwiskoTF);
        getContentPane().add(adresZamieszkaniaL);
        getContentPane().add(adresZamieszkaniaTF);
        getContentPane().add(peselL);
        getContentPane().add(peselTF);
        getContentPane().add(rodzajL);
        getContentPane().add(rodzajTF);
        getContentPane().add(markaL);
        getContentPane().add(markaTF);
        getContentPane().add(dotychNrRejestracyjnyL);
        getContentPane().add(dotychNrRejestracyjnyTF);
        getContentPane().add(nrSilnikaL);
        getContentPane().add(nrSilnikaTF);
        getContentPane().add(rokProdukcjiL);
        getContentPane().add(rokProdukcjiTF);
        getContentPane().add(numerVINL);
        getContentPane().add(numerVINTF);
        getContentPane().add(nrKartyPojazduL);
        getContentPane().add(nrKartyPojazduTF);
    }

    public void Labels() {
        wlasciciel = new JLabel("W³aciciel pojazdu");
        wlasciciel.setVisible(true);
        wlasciciel.setBounds(20, 10, 200, 30);

        pojazd = new JLabel("Pojazd");
        pojazd.setVisible(true);
        pojazd.setBounds(300, 10, 200, 30);

        imieL = new JLabel("Imiê: ");
        imieL.setVisible(true);
        imieL.setBounds(20, 50, 100, 30);
        imieTF = new JTextField();
        imieTF.setVisible(true);
        imieTF.setBounds(130, 50, 150, 30);

        nazwiskoL = new JLabel("Nazwisko: ");
        nazwiskoL.setVisible(true);
        nazwiskoL.setBounds(20, 90, 100, 30);
        nazwiskoTF = new JTextField();
        nazwiskoTF.setVisible(true);
        nazwiskoTF.setBounds(130, 90, 150, 30);

        adresZamieszkaniaL = new JLabel("Adres zam. : ");
        adresZamieszkaniaL.setVisible(true);
        adresZamieszkaniaL.setBounds(20, 130, 100, 30);
        adresZamieszkaniaTF = new JTextField();
        adresZamieszkaniaTF.setVisible(true);
        adresZamieszkaniaTF.setBounds(130, 130, 150, 30);

        peselL = new JLabel("PESEL:");
        peselL.setVisible(true);
        peselL.setBounds(20, 170, 100, 30);
        peselTF = new JTextField();
        peselTF.setVisible(true);
        peselTF.setBounds(130, 170, 150, 30);

        rodzajL = new JLabel("Rodzaj pojazdu i przeznaczenie:");
        rodzajL.setVisible(true);
        rodzajL.setBounds(300, 50, 200, 30);
        rodzajTF = new JTextField();
        rodzajTF.setVisible(true);
        rodzajTF.setBounds(500, 50, 150, 30);

        markaL = new JLabel("Marka, model: ");
        markaL.setVisible(true);
        markaL.setBounds(300, 90, 200, 30);
        markaTF = new JTextField();
        markaTF.setVisible(true);
        markaTF.setBounds(500, 90, 150, 30);

        dotychNrRejestracyjnyL = new JLabel("Dotychczasowy \n" +
                "numer rejestracyjny:");
        dotychNrRejestracyjnyL.setVisible(true);
        dotychNrRejestracyjnyL.setBounds(300, 130, 200, 30);
        dotychNrRejestracyjnyTF = new JTextField();
        dotychNrRejestracyjnyTF.setVisible(true);
        dotychNrRejestracyjnyTF.setBounds(500, 130, 150, 30);

        nrSilnikaL = new JLabel("Numer silnika:");
        nrSilnikaL.setVisible(true);
        nrSilnikaL.setBounds(300, 170, 200, 30);
        nrSilnikaTF = new JTextField();
        nrSilnikaTF.setVisible(true);
        nrSilnikaTF.setBounds(500, 170, 150, 30);

        rokProdukcjiL = new JLabel("Rok produkcji:");
        rokProdukcjiL.setVisible(true);
        rokProdukcjiL.setBounds(300, 210, 200, 30);
        rokProdukcjiTF = new JTextField();
        rokProdukcjiTF.setVisible(true);
        rokProdukcjiTF.setBounds(500, 210, 150, 30);

        numerVINL = new JLabel("Numer VIN:");
        numerVINL.setVisible(true);
        numerVINL.setBounds(300, 250, 200, 30);
        numerVINTF = new JTextField();
        numerVINTF.setVisible(true);
        numerVINTF.setBounds(500, 250, 150, 30);

        nrKartyPojazduL = new JLabel("Numer karty pojazdu:");
        nrKartyPojazduL.setVisible(true);
        nrKartyPojazduL.setBounds(300, 290, 200, 30);
        nrKartyPojazduTF = new JTextField();
        nrKartyPojazduTF.setVisible(true);
        nrKartyPojazduTF.setBounds(500, 290, 150, 30);

    }

    public void NextToChecker() {
        nextToChecker = new JButton("Dalej");
        nextToChecker.setVisible(true);
        nextToChecker.addActionListener(this);
        nextToChecker.setBounds(50, 300, 150, 30);

    }

    public void Ekran4() {//Checker
        Labels4();
        NextToVehicleType();
        Count();
        getContentPane().add(typPojazduL);
        getContentPane().add(typPojazduTF);
        getContentPane().add(dotychNumerRejestrL);
        getContentPane().add(dotychNumerRejestrTF);
        getContentPane().add(rokProdukcjiL2);
        getContentPane().add(rokProdukcjiTF2);
        getContentPane().add(oplataZaL);
        getContentPane().add(oplataZaTF);
        getContentPane().add(info);
        getContentPane().add(nextToVehicleType);
        getContentPane().add(count);
        getContentPane().add(moneyCounterL);
        getContentPane().add(moneyCounterTF);
    }

    public void Labels4() {
        typPojazduL = new JLabel("Typ pojazdu: ");
        typPojazduL.setVisible(true);
        typPojazduL.setBounds(20, 50, 100, 30);
        typPojazduTF = new JTextField();
        typPojazduTF.setVisible(true);
        typPojazduTF.setBounds(130, 50, 150, 30);

        dotychNumerRejestrL = new JLabel("Dotychczasowy \n" +
                "numer rejestracyjny: ");
        dotychNumerRejestrL.setVisible(true);
        dotychNumerRejestrL.setBounds(20, 90, 100, 30);
        dotychNumerRejestrTF = new JTextField();
        dotychNumerRejestrTF.setVisible(true);
        dotychNumerRejestrTF.setBounds(130, 90, 150, 30);

        rokProdukcjiL2 = new JLabel("Rok produkcji : ");
        rokProdukcjiL2.setVisible(true);
        rokProdukcjiL2.setBounds(20, 130, 100, 30);
        rokProdukcjiTF2 = new JTextField();
        rokProdukcjiTF2.setVisible(true);
        rokProdukcjiTF2.setBounds(130, 130, 150, 30);

        oplataZaL = new JLabel("Op³ata za:");
        oplataZaL.setVisible(true);
        oplataZaL.setBounds(20, 170, 100, 30);
        oplataZaTF = new JTextField();
        oplataZaTF.setVisible(true);
        oplataZaTF.setBounds(130, 170, 150, 30);

        info = new JLabel("(osobowy, ciê¿arowy, rolniczy)");
        info.setVisible(true);
        info.setBounds(280, 50, 250, 30);

        moneyCounterL = new JLabel("KWOTA do zap³aty");
        moneyCounterL.setBounds(450, 300, 150, 30);
        moneyCounterL.setVisible(true);
        moneyCounterTF = new JTextField();
        moneyCounterTF.setBounds(600, 300, 70, 20);
        moneyCounterTF.setEditable(true);
        moneyCounterTF.setVisible(true);

    }

    public void NextToVehicleType() {
        nextToVehicleType = new JButton("Dalej");
        nextToVehicleType.setVisible(true);
        nextToVehicleType.setBounds(50, 300, 150, 30);
        nextToVehicleType.addActionListener(this);
    }

    public void Count() {
        count = new JButton("Wylicz");
        count.setVisible(true);
        count.addActionListener(this);
        count.setBounds(400, 100, 150, 40);
    }

    public void Ekran6() {//Wprowad typ pojazdu
        Labels3();
        Separator();
        NextToPrint();
        CheckBoxes();
        Moto();
        Bus();
        AutoB();
        AutoS();
        Kombajn();
        Traktor();
        PojazdTF();
        getContentPane().add(separator);
        getContentPane().add(separator2);
        getContentPane().add(pNU);
        getContentPane().add(pkm);
        getContentPane().add(pg);
        getContentPane().add(cb1);
        getContentPane().add(cb2);
        getContentPane().add(nextToPrint);
        getContentPane().add(moto);
        getContentPane().add(bus);
        getContentPane().add(autoB);
        getContentPane().add(autoS);
        getContentPane().add(kombajn);
        getContentPane().add(traktor);
        getContentPane().add(pojazdTF);

    }

    public void NextToPrint() {
        nextToPrint = new JButton("Dalej");
        nextToPrint.setVisible(true);
        nextToPrint.setBounds(50, 300, 150, 30);
        nextToPrint.addActionListener(this);
    }

    public void PojazdTF() {
        pojazdTF = new JTextField();
        pojazdTF.setVisible(true);
        pojazdTF.setBounds(200, 30, 200, 30);
        pojazdTF.addActionListener(this);

    }

    public void Labels3() {
        pNU = new JLabel("Pojazd (nowy/u¿ywany):");
        pNU.setVisible(true);
        pNU.setBounds(30, 30, 200, 40);
        getContentPane();
        pkm = new JLabel("Pojazd komunikacji miejskiej(zaznacz):");
        pkm.setVisible(true);
        pkm.setBounds(30, 60, 200, 40);
        pg = new JLabel("Pojazd gospodarczy (zaznacz):");
        pg.setVisible(true);
        pg.setBounds(300, 60, 200, 40);
    }

    public void Separator() {
        separator = new JSeparator();
        separator.setBounds(0, 65, 700, 1);
        separator.setVisible(true);
        separator2 = new JSeparator();
        separator2.setBounds(0, 275, 700, 1);
        separator2.setVisible(true);
    }

    public void CheckBoxes() {
        cb1 = new JCheckBox();
        cb1.setVisible(true);
        cb1.setBounds(240, 73, 20, 15);
        cb1.addActionListener(this);

        cb2 = new JCheckBox();
        cb2.setVisible(true);
        cb2.setBounds(505, 73, 20, 15);
        cb2.addActionListener(this);
    }

    public void Moto() {
        moto = new JToggleButton("Motocykl");
        moto.setVisible(true);
        moto.setBounds(30, 100, 100, 30);
        moto.addActionListener(this);
    }

    public void Bus() {
        bus = new JToggleButton("Autobus");
        bus.setVisible(true);
        bus.setBounds(150, 100, 100, 30);
        bus.addActionListener(this);
    }

    public void AutoB() {
        autoB = new JToggleButton("Samochód ciê¿arowy");
        autoB.setVisible(true);
        autoB.setBounds(30, 150, 100, 30);
        autoB.addActionListener(this);
    }

    public void AutoS() {
        autoS = new JToggleButton("Samochód osobowy");
        autoS.setVisible(true);
        autoS.setBounds(150, 150, 100, 30);
        autoS.addActionListener(this);
    }

    public void Kombajn() {
        kombajn = new JToggleButton("Kombajn");
        kombajn.setVisible(true);
        kombajn.setBounds(400, 100, 100, 30);
        kombajn.addActionListener(this);
    }

    public void Traktor() {
        traktor = new JToggleButton("Ci¹gnik rolniczy");
        traktor.setVisible(true);
        traktor.setBounds(400, 150, 100, 30);
        traktor.addActionListener(this);
    }

    public void Ekran7() {
        WprowadDok();
        Wyrejestruj2();
        ZaakceptujWyrejestrowanie();
        getContentPane().add(insertDoc1);
        getContentPane().add(insertVehicleType2);
        getContentPane().add(acceptUnregister);
    }

    public void WprowadDok() {
        insertDoc1 = new JButton("Wprowad wymagane dokumenty");
        insertDoc1.setVisible(true);
        insertDoc1.setBounds(30, 100, 200, 50);
        insertDoc1.addActionListener(this);
    }

    public void Wyrejestruj2() {
        insertVehicleType2 = new JButton("Wprowad typ pojazdu");
        insertVehicleType2.setVisible(true);
        insertVehicleType2.setBounds(450, 100, 200, 50);
        insertVehicleType2.addActionListener(this);
    }

    public void ZaakceptujWyrejestrowanie() {
        acceptUnregister = new JButton("Zatwierd wyrejestrowanie");
        acceptUnregister.setVisible(true);
        acceptUnregister.setBounds(235, 225, 210, 50);
        acceptUnregister.addActionListener(this);
    }

    public void Ekran8() {
        DrukujRaport();
        getContentPane().add(printReport);
    }

    public void DrukujRaport() {
        printReport = new JButton("Drukuj Raport");
        printReport.setVisible(true);
        printReport.setBounds(235, 225, 210, 50);
        printReport.addActionListener(this);

    }

    public void Ekran9() {
        Labels5();
        TextFields();
        Send();
        getContentPane().add(putInStampsL);
        getContentPane().add(putInStampsTF);
        getContentPane().add(putInTablesL);
        getContentPane().add(putInTablesTF);
        getContentPane().add(putInNumberOfConstansRegistersL);
        getContentPane().add(putInNumberOfConstansRegistersTF);
        getContentPane().add(putInNumberOfVariousRegistersL);
        getContentPane().add(putInNumberOfVariousRegistersTF);
        getContentPane().add(send);
    }

    public void Labels5() {
        putInStampsL = new JLabel("Wprowad iloæ naklejek kontrolnych:");
        putInStampsL.setVisible(true);
        putInStampsL.setBounds(250, 20, 300, 20);

        putInTablesL = new JLabel("Wprowad iloæ tablic rejestracyjnych:");
        putInTablesL.setVisible(true);
        putInTablesL.setBounds(250, 90, 300, 20);

        putInNumberOfConstansRegistersL = new JLabel("Wprowad iloæ dowodów rejestracyjnych sta³ych:");
        putInNumberOfConstansRegistersL.setVisible(true);
        putInNumberOfConstansRegistersL.setBounds(220, 160, 300, 20);

        putInNumberOfVariousRegistersL = new JLabel("Wprowad iloæ dowodów rejestracyjnych tymczasowych:");
        putInNumberOfVariousRegistersL.setVisible(true);
        putInNumberOfVariousRegistersL.setBounds(200, 230, 500, 20);
    }

    public void TextFields() {
        putInStampsTF = new JTextField();
        putInStampsTF.setVisible(true);
        putInStampsTF.setBounds(325, 50, 50, 20);

        putInTablesTF = new JTextField();
        putInTablesTF.setVisible(true);
        putInTablesTF.setBounds(325, 120, 50, 20);

        putInNumberOfConstansRegistersTF = new JTextField();
        putInNumberOfConstansRegistersTF.setVisible(true);
        putInNumberOfConstansRegistersTF.setBounds(325, 190, 50, 20);

        putInNumberOfVariousRegistersTF = new JTextField();
        putInNumberOfVariousRegistersTF.setVisible(true);
        putInNumberOfVariousRegistersTF.setBounds(325, 260, 50, 20);

    }

    public void Send() {
        send = new JButton("Wylij");
        send.setVisible(true);
        send.addActionListener(this);
        send.setBounds(300, 300, 100, 50);


    }
    /*/
      void zapis(tablica[] e){}
     public void PDF() throws IOException {
         PrintWriter zapis = new PrintWriter("%pesel.txt");
         String[] tablica = new String[11];
         tablica[11] = {imieS;imieS,nazwiskoS,adresZamieszkaniaS,peselS,rodzajS,markaS,dotychNrRejestracyjnyS,nrSilnikaS,numerVINS,nrKartyPojazduS}
         zapis.printf(tablica[i]);
         zapis.close();
   FileOutputStream fop = null;
        File file;
        String content = "This is the text content";

      try {

            file = new File("c:/PDFs/%peselTF.pdf");
            fop = new FileOutputStream(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            String[] contentInBytes = new String[11];
            String[] tablica = new String[11];
            tablica[1] = imieS; (imieS,nazwiskoS,adresZamieszkaniaS,peselS,rodzajS,markaS,dotychNrRejestracyjnyS,nrSilnikaS,numerVINS,nrKartyPojazduS}
            tablica[2] = nazwiskoS;
            for(int i=0;i<10;i++)
            {
            zapis.printf(tablica[i]);}
            zapis.close();

            fop.toString();
            fop.close();


            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

              /*/





    @Override

    public void actionPerformed(ActionEvent e) {
        Object bSource = e.getSource();
        if (bSource == register) {
            remove(register);
            remove(unregister);
            remove(sendRequest);
            Ekran3();
            repaint();
        } else if (bSource == insertDoc1) {
            remove(insertDoc1);
            remove(insertVehicleType2);
            remove(acceptUnregister);
            Ekran3();
            repaint();
        } else if (bSource == insertVehicleType2) {
            remove(insertDoc1);
            remove(insertVehicleType2);
            remove(acceptUnregister);
            Ekran6();
            repaint();
        } else if (bSource == insertDoc) {
            remove(insertDoc);
            remove(checkIfSteal);
            remove(setPayment);
            remove(insertVehicleType);
            remove(printAplication);
            remove(acceptRegistration);
            Ekran3();
            repaint();
        } else if (bSource == setPayment) {
            remove(insertDoc);
            remove(checkIfSteal);
            remove(setPayment);
            remove(insertVehicleType);
            remove(printAplication);
            remove(acceptRegistration);
            Ekran4();
            repaint();
        } else if (bSource == nextToVehicleType) {
            remove(typPojazduL);
            remove(typPojazduTF);
            remove(dotychNumerRejestrL);
            remove(dotychNumerRejestrTF);
            remove(rokProdukcjiL2);
            remove(rokProdukcjiTF2);
            remove(oplataZaL);
            remove(oplataZaTF);
            remove(info);
            remove(nextToVehicleType);
            remove(count);
            remove(moneyCounterTF);
            remove(moneyCounterL);
            Ekran6();
            repaint();
        }/*/ else if (bSource == ) {
            remove(separator);
            remove(separator2);
            remove(pNU);
            remove(pkm);
            remove(pg);
            remove(cb1);
            remove(cb2);
            remove(moto);
            remove(bus);
            remove(autoB);
            remove(autoS);
            remove(kombajn);
            remove(traktor);
            remove(back1);
            remove(pojazdTF);
            Ekran8();
            repaint();

        } /*/ else if (bSource == count) {

            moneyCounterTF.setText(money);
            moneyCounterTF.setVisible(true);
            repaint();
        } else if (bSource == nextToChecker) {

            imieS = imieTF.getText();
            nazwiskoS = nazwiskoTF.getText();
            adresZamieszkaniaS = adresZamieszkaniaTF.getText();
            peselS = peselTF.getText();
            rodzajS = rodzajTF.getText();
            markaS = markaTF.getText();
            dotychNrRejestracyjnyS = dotychNrRejestracyjnyTF.getText();
            nrSilnikaS = nrSilnikaTF.getText();
            numerVINS = numerVINTF.getText();
            nrKartyPojazduS = nrKartyPojazduTF.getText();
            System.getProperty(imieS);
            witch = 1;
            try {
                saveToFileTxt();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

          /*/  try {
                saveToFile(imieS, imieTF);
                saveToFile(nazwiskoS,nazwiskoTF);
                saveToFile(adresZamieszkaniaS,adresZamieszkaniaTF);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                saveToFile(nazwiskoS,nazwiskoTF);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                saveToFile(adresZamieszkaniaS,adresZamieszkaniaTF);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                saveToFile(peselS,peselTF);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                saveToFile(rodzajS,rodzajTF);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                saveToFile(markaS,markaTF);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                saveToFile(dotychNrRejestracyjnyS,dotychNrRejestracyjnyTF);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                saveToFile(nrSilnikaS,nrSilnikaTF);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                saveToFile(numerVINS, numerVINTF);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                saveToFile(nrKartyPojazduS,nrKartyPojazduTF);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
/*/
            remove(nextToChecker);
            remove(wlasciciel);
            remove(pojazd);
            remove(imieL);
            remove(imieTF);
            remove(nazwiskoL);
            remove(nazwiskoTF);
            remove(adresZamieszkaniaL);
            remove(adresZamieszkaniaTF);
            remove(peselL);
            remove(peselTF);
            remove(rodzajL);
            remove(rodzajTF);
            remove(markaL);
            remove(markaTF);
            remove(dotychNrRejestracyjnyL);
            remove(dotychNrRejestracyjnyTF);
            remove(nrSilnikaL);
            remove(nrSilnikaTF);
            remove(rokProdukcjiL);
            remove(rokProdukcjiTF);
            remove(numerVINL);
            remove(numerVINTF);
            remove(nrKartyPojazduL);
            remove(nrKartyPojazduTF);
            Ekran4();
            repaint();


        } else if (bSource == insertVehicleType) {
            remove(insertDoc);
            remove(checkIfSteal);
            remove(setPayment);
            remove(insertVehicleType);
            remove(printAplication);
            remove(acceptRegistration);
            Ekran6();
            repaint();
        } else if (bSource == moto) {
            typMaszyny = "motocykl";
            moto.setEnabled(true);
            bus.resetKeyboardActions();
            autoB.resetKeyboardActions();
            autoS.resetKeyboardActions();
            kombajn.resetKeyboardActions();
            traktor.resetKeyboardActions();
            repaint();
        } else if (bSource == bus) {
            typMaszyny = "autobus";
            moto.resetKeyboardActions();
            bus.setEnabled(true);
            autoB.resetKeyboardActions();
            autoS.resetKeyboardActions();
            kombajn.resetKeyboardActions();
            traktor.resetKeyboardActions();
            repaint();
        } else if (bSource == autoB) {
            typMaszyny = "samochód ciê¿arowy";
            moto.resetKeyboardActions();
            bus.resetKeyboardActions();
            autoB.setEnabled(true);
            autoS.resetKeyboardActions();
            kombajn.resetKeyboardActions();
            traktor.resetKeyboardActions();
            repaint();
        } else if (bSource == autoS) {
            typMaszyny = "samochód osobowy";
            moto.resetKeyboardActions();
            bus.resetKeyboardActions();
            autoB.resetKeyboardActions();
            autoS.setEnabled(true);
            kombajn.resetKeyboardActions();
            traktor.resetKeyboardActions();
            repaint();
        } else if (bSource == kombajn) {
            typMaszyny = "kombajn";
            moto.resetKeyboardActions();
            bus.resetKeyboardActions();
            autoB.resetKeyboardActions();
            autoS.resetKeyboardActions();
            kombajn.setEnabled(true);
            traktor.resetKeyboardActions();
            repaint();
        } else if (bSource == traktor) {
            typMaszyny = "ci¹gnik rolniczy";
            moto.resetKeyboardActions();
            bus.resetKeyboardActions();
            autoB.resetKeyboardActions();
            autoS.resetKeyboardActions();
            kombajn.resetKeyboardActions();
            traktor.setEnabled(true);
            repaint();
        } else if (bSource == unregister) {
            remove(register);
            remove(unregister);
            remove(sendRequest);
            try {
                saveToFileTxt();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Ekran7();
            repaint();
        } else if (bSource == acceptRegistration) {
            remove(insertDoc);
            remove(checkIfSteal);
            remove(setPayment);
            remove(insertVehicleType);
            remove(printAplication);
            remove(acceptRegistration);
            Ekran8();
            repaint();
        } else if (bSource == acceptUnregister) {
            remove(insertDoc1);
            remove(insertVehicleType2);
            remove(acceptUnregister);
            Ekran8();
            repaint();
        } else if (bSource == nextToPrint) {
            nowuzy = pojazdTF.getText();
            remove(separator);
            remove(separator2);
            remove(pNU);
            remove(pkm);
            remove(pg);
            remove(cb1);
            remove(cb2);
            remove(moto);
            remove(bus);
            remove(autoB);
            remove(autoS);
            remove(kombajn);
            remove(traktor);
            remove(nextToPrint);
            remove(pojazdTF);
            Ekran8();
            repaint();
        } else if (bSource == printReport) {
            try {
                saveToFileDoc();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            remove(printReport);
            Ekran1();
            repaint();
        } else if (bSource == sendRequest) {
            remove(register);
            remove(unregister);
            remove(sendRequest);
            Ekran9();
            repaint();
        }else if (cb1.isSelected()){
            cb1S = "tak";
        }else if (cb2.isSelected()){
            cb2S = "tak";
        }


    }

}




