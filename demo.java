import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class demo {

    public static void main(String[] args) {
        /*
         * System.out.
         * println("Leuk dat je een tournooi organiseert. \n Hoe heet je tournooi?");
         * Scanner scanner = new Scanner(System.in); String naamTournooi =
         * scanner.nextLine(); Tournooi karateTournooi = new Tournooi();
         * karateTournooi.setNaam(naamTournooi); karateTournooi.welkom();
         */
		/*
		System.out.println("Wil u al mensen aanmelden? \n 1 ja 2 nee");
		int antwoordNogEen = scanner.nextInt();
		if (antwoordNogEen == 1) {
			System.out.println("je hebt 1 gedrukt");
			karateTournooi.voegDeelnemersToe();
		} else {
			System.out.println("wordt een kort tournooi");
		}
		*/


        Tournooi karateTournooi = testToernooi.testData();

        karateTournooi.toernooiUitvoeren();
        /*System.out.println(karateTournooi.deelnemers.size());
        int aantalWedstrijden = karateTournooi.deelnemers.size()/2;
        for (int n= 0;n<aantalWedstrijden;n++){
            karateTournooi.speelWedstrijd();
        }*/

        /*karateTournooi.speelWedstrijd();
        karateTournooi.speelWedstrijd();
        System.out.println("Wat een spanning dames en heren. De finale gaat tussen " + karateTournooi.deelnemers.get(0)
                + " en " + karateTournooi.deelnemers.get(1));
        karateTournooi.speelWedstrijd();*/
    }
}

class Tournooi {
    String naam;
    ArrayList<Deelnemer> deelnemers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    void welkom() {
        System.out.println("Welkom bij " + naam);
    }

    void setNaam(String naam) {
        this.naam = naam;
    }

    void voegDeelnemersToe() {

        System.out.print("Wat is uw naam");
        String deNaam = scanner.next();
        Deelnemer deelnemer = new Deelnemer(deNaam);
        deelnemers.add(deelnemer);
        System.out.println("Wilt u nog iemand aanmelden?\n 1 ja 2 nee");
        int antwoordNogEen = scanner.nextInt();
        if (antwoordNogEen == 1) {
            voegDeelnemersToe();
        } else {
            shuffleDeelnemers();
        }
    }

    Deelnemer speelWedstrijd() {
        System.out.println("Lets get ready to rumble");
        System.out.println();
        System.out.println(deelnemers.get(0).naam + " speelt tegen " + deelnemers.get(1).naam);
        System.out.println();
        Deelnemer winnaar = deelnemers.get(random.nextInt(2));
        System.out.println("De winnaar is: " + winnaar.naam);
        System.out.println("-------------------------");
        deelnemers.remove(0);
        deelnemers.remove(0);
        deelnemers.add(deelnemers.size(), winnaar);
        return winnaar;
    }

    void toernooiUitvoeren(){
        while (this.deelnemers.size() >=2) {
            int aantalWedstrijden = this.deelnemers.size() / 2;
            for (int n = 0; n < aantalWedstrijden; n++) {
                if(this.deelnemers.size() ==2) {
                    System.out.println("Welkom bij de finale");
                    System.out.println();
                    this.speelWedstrijd();
                } else {
                    this.speelWedstrijd();
                }
            }
        }
    }



    void shuffleDeelnemers() {
        Collections.shuffle(deelnemers);
        for (int x=0; x < this.deelnemers.size(); x+=2)
        System.out.println(deelnemers.get(x).naam + " speelt tegen " + deelnemers.get(x+1).naam);
        System.out.println();

    }
}

class Deelnemer {
    String naam;

    Deelnemer(String deNaam) {
        naam = deNaam;
    }

    @Override
    public String toString() {
        return naam;
    }
}

class testToernooi {
    static Tournooi testData() {
        Deelnemer deelnemer1 = new Deelnemer("fred");
        Deelnemer deelnemer2 = new Deelnemer("jan");
        Deelnemer deelnemer3 = new Deelnemer("piet");
        Deelnemer deelnemer4 = new Deelnemer("kees");
        Deelnemer deelnemer5 = new Deelnemer("teun");
        Deelnemer deelnemer6 = new Deelnemer("klaas");
        Deelnemer deelnemer7 = new Deelnemer("bert");
        Deelnemer deelnemer8 = new Deelnemer("ernie");
        Tournooi toernooi1 = new Tournooi();
        toernooi1.setNaam("demoTournooi");
        toernooi1.deelnemers.add(deelnemer1);
        toernooi1.deelnemers.add(deelnemer2);
        toernooi1.deelnemers.add(deelnemer3);
        toernooi1.deelnemers.add(deelnemer4);
        toernooi1.deelnemers.add(deelnemer5);
        toernooi1.deelnemers.add(deelnemer6);
        toernooi1.deelnemers.add(deelnemer7);
        toernooi1.deelnemers.add(deelnemer8);
        toernooi1.shuffleDeelnemers();
        return toernooi1;
    }
}