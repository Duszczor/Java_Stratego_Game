import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Plansza plansza = new Plansza(4);
        //zacznijGre(plansza);
        graNaRandoma(plansza, 1);
    }

        public static void zacznijGre(Plansza plansza) {
        boolean koniec = false;
        Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od użytkownika
        int punktyX = 0;
        int punktyY = 0;
        int poleX;
        int poleY;
        while (!koniec) {
            plansza.wyswietlPlansze();
            boolean postawiono = false;
            while (!postawiono) {
                System.out.println("Ruch gracza X");
                poleX = odczyt.nextInt();
                poleY = odczyt.nextInt();
                if (plansza.postawX(poleX, poleY)) {
                    int punkty = plansza.sprawdzCzyBedaPunkty(poleX, poleY);
                    if (punkty != 0) {
                        punktyX += punkty;
                        System.out.println("Gracz X zdobywa " + punkty + " punktów!!!" + " Aktualnie ma " + punktyX);
                    }
                    postawiono = true;
                } else {
                    System.out.println("BLEDNE WSPOLRZEDNE!!");
                }
                plansza.wyswietlPlansze();
            }
            if (!plansza.sprawdzCzyKoniec()) {
                postawiono = false;
                while (!postawiono) {
                    System.out.println("Ruch gracza Y");
                    poleX = odczyt.nextInt();
                    poleY = odczyt.nextInt();
                    if (plansza.postawY(poleX, poleY)) {
                        int punkty = plansza.sprawdzCzyBedaPunkty(poleX, poleY);
                        if (punkty != 0) {
                            punktyY += punkty;
                            System.out.println("Gracz Y zdobywa " + punkty + " punktów!!!" + " Aktualnie ma " + punktyY);
                        }
                        postawiono = true;
                    } else {
                        System.out.println("BLEDNE WSPOLRZEDNE!!");
                    }

                }
            } else {
                postawiono = true;
            }
            if (plansza.sprawdzCzyKoniec()) {
                postawiono = true;
            }
        }

        System.out.println("Koniec gry");
        if (punktyX > punktyY) {
            System.out.println("Wygrywa gracz X");
        }
        if (punktyY > punktyX) {
            System.out.println("Wygrywa gracz Y");
        }
        if (punktyX == punktyY) {
            System.out.println("Remis");
        }

    }

        public static void graNaRandoma(Plansza plansza, int ktoZaczyna) {
        boolean koniec = false;
        Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od użytkownika
        int punktyX = 0;
        int punktyY = 0;
        int poleX;
        int poleY;
        while (!koniec) {
            plansza.wyswietlPlansze();
            boolean postawiono = false;
            while (!postawiono) {
                System.out.println("Ruch gracza");
                poleX = odczyt.nextInt();
                poleY = odczyt.nextInt();
                if (plansza.postawX(poleX, poleY)) {
                    int punkty = plansza.sprawdzCzyBedaPunkty(poleX, poleY);
                    if (punkty != 0) {
                        punktyX += punkty;
                        System.out.println("Gracz zdobywa " + punkty + " punktów!!!" + " Aktualnie ma " + punktyX);
                    }
                    postawiono = true;
                } else {
                    System.out.println("BLEDNE WSPOLRZEDNE!!");
                }
                plansza.wyswietlPlansze();
            }

            if (!plansza.sprawdzCzyKoniec()) {
                postawiono = false;
                while (!postawiono) {
                    Random generator = new Random();
                    poleX = generator.nextInt(plansza.wielkoscPlanszy);
                    poleY = generator.nextInt(plansza.wielkoscPlanszy);
                    if (plansza.postawY(poleX, poleY)) {
                        System.out.println("Ruch komputera");
                        int punkty = plansza.sprawdzCzyBedaPunkty(poleX, poleY);
                        if (punkty != 0) {
                            punktyY += punkty;
                            System.out.println("Komputer losowy zdobywa " + punkty + " punktów!!!" + " Aktualnie ma " + punktyY);
                        }
                        postawiono = true;
                    }
                }
            }
            if (plansza.sprawdzCzyKoniec()) {
                koniec = true;
            }
        }

            System.out.println("Koniec gry");
            if (punktyX > punktyY) {
                System.out.println("Wygrywa gracz X");
            }
            if (punktyY > punktyX) {
                System.out.println("Wygrywa gracz Y");
            }
            if (punktyX == punktyY) {
                System.out.println("Remis");
            }

        }

    }
