public class Player {

    private String name;
    private Card[] hand = new Card[10];
    private int numCards;

    public Player(String aName){
        this.name = aName;
        //Hand leeren
        this.emptyHand();
    }

    public void emptyHand(){

        for(int i=0; i<10; i++){
            this.hand[i] = null;
        }
        this.numCards = 0;
    }

    public boolean addCard(Card aCard){
        //Error wenn maximale Kartenanzahl in Hand erreicht
        //Kann eigentlich garnicht passieren
        if(this.numCards == 10){
            System.err.printf("%s's Hand hat bereits 10 Karten; " +
                    "Es kann keine weitere hinzugefügt werden\n", this.name);
            System.exit(1);
        }

        //Neue Karte der Hand hinzufügen
        this.hand[this.numCards] = aCard;
        this.numCards++;

        return(this.getHandSum() >= 21);

    }

    public int getHandSum(){

        int handSum = 0;
        int cardNum;
        int numAces = 0;

        //jede karte einzeln berechnen
        for(int i=0; i < this.numCards; i++){
          //kartennummer erhalten
          cardNum = this.hand[i].getNumber();

          if(cardNum == 1) { //Ass
             numAces++;
             handSum += 11;
          } else if(cardNum > 10){//Bild(Bube,Dame,...)
             handSum += 10;
          } else {
              handSum += cardNum;//Zahlenkarte
          }
        }

        //wenn die summe bei mehreren assen > 21 ist, setze den wert von manchen / allen auf 1 statt 11
        while(handSum > 21 && numAces > 0){
            handSum -= 10;
            numAces--;
        }

        return handSum;

    }

    public void printHand(boolean showFirstCard){
        System.out.printf("%s's Karten:\n", this.name);
        for(int i = 0; i < this.numCards; i++){
            if(i == 0 && !showFirstCard){
                System.out.println(" [verdeckt]");
            } else{
                System.out.printf(" %s\n", this.hand[i].toString());
            }
        }
    }
}
