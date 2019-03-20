public class Plansza {

    int wielkoscPlanszy;
    int[][] pola;

    int punktyX;
    int punktyY;

    public Plansza(int wielkosc) {
        wielkoscPlanszy = wielkosc;
        punktyX = 0;
        punktyY = 0;
        pola = new int[wielkosc][wielkosc];
        for (int i = 0; i < wielkoscPlanszy; i++) {
            for (int j = 0; j < wielkoscPlanszy; j++) {
                pola[i][j] = 0;
            }
        }
    }

    public void wyswietlPlansze() {
        for(int i=0;i<wielkoscPlanszy;i++){
            if(i==0){
                System.out.print(" ");
            }
            System.out.print(i+"  ");
            if(i==wielkoscPlanszy-1){
                System.out.println("Y");
            }
        }
        for (int i = 0; i < wielkoscPlanszy; i++) {
            for (int j = 0; j < wielkoscPlanszy; j++) {

                if (pola[i][j] == 0) {
                    System.out.print(" - ");
                } else if (pola[i][j] == 1) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" Y ");
                }
                if(j == wielkoscPlanszy-1){
                    System.out.print(" "+i);
                }
                if(i==wielkoscPlanszy-1 && j == wielkoscPlanszy-1){
                    System.out.print(" X");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }

    public Boolean postawX(int x, int y) {
        if (pola[x][y] != 0) {
            return false;
        } else {
            pola[x][y] = 1;
            return true;
        }
    }

    public Boolean postawY(int x, int y) {
        if (pola[x][y] != 0) {
            return false;
        } else {
            pola[x][y] = 2;
            return true;
        }
    }

    public int sprawdzCzyBedaPunkty(int x, int y) {

        int punkty = 0;
        // Sprawdzanie pionowo
        boolean koniec = false;
        for (int i = 0; i < wielkoscPlanszy && !koniec; i++) {
            if (pola[i][y] == 0) {
                koniec = true;
            }
        }
        if (!koniec) {
            punkty += wielkoscPlanszy;
        }

        // Sprawdzanie poziomo
        koniec = false;
        for (int i = 0; i < wielkoscPlanszy && !koniec; i++) {
            if (pola[x][i] == 0) {
                koniec = true;
            }
        }
        if (!koniec) {
            punkty += wielkoscPlanszy;
        }












        // Sprawdzenie po ukosie

        boolean prawaGora = true;
        int prawaGoraint = 0;
        int noweX = x;
        int noweY = y;

        while(noweX >= 0 && noweY < wielkoscPlanszy && prawaGora){  //Prawa góra
            if(pola[noweX][noweY]==0){
                prawaGora = false;
            }
                prawaGoraint++;
                noweY += 1;
                noweX -= 1;
        }



        boolean lewaGora = true;
        int lewaGoraint = 0;
        noweX = x;
        noweY = y;
        while(noweX >= 0 && noweY >= 0 && lewaGora){  //Lewa góra
            if(pola[noweX][noweY]==0){
                lewaGora = false;
            }
                lewaGoraint++;
                noweY -= 1;
                noweX -= 1;
        }


        boolean lewyDol = true;
        int lewyDolint = 0;
        noweX = x;
        noweY = y;
        while(noweX < wielkoscPlanszy && noweY >= 0 && lewyDol){  //Lewy dół
            if(pola[noweX][noweY]==0){
                lewyDol = false;
            }
                lewyDolint++;
                noweY -= 1;
                noweX += 1;
        }




        boolean prawyDol = true;
        int prawyDolint = 0;
        noweX = x;
        noweY = y;
        while(noweX < wielkoscPlanszy && noweY < wielkoscPlanszy && prawyDol){  //Prawy dół
            if(pola[noweX][noweY]==0){
                prawyDol = false;
            }
                prawyDolint++;
                noweY += 1;
                noweX += 1;
        }



        if(prawaGora && lewyDol){
                int punktyDodane = prawaGoraint + lewyDolint - 1;
                if(punktyDodane > 1){
                    punkty += punktyDodane;
                }
        }
        if(lewaGora && prawyDol){
                int punktyDodane = lewaGoraint + prawyDolint - 1;
            if(punktyDodane > 1){
                punkty += punktyDodane;
            }
        }

        return punkty;
    }

    public boolean sprawdzCzyKoniec() {
        for (int i = 0; i < wielkoscPlanszy; i++) {
            for (int j = 0; j < wielkoscPlanszy; j++) {
                if (pola[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void drzewo(){
        
    }
}
