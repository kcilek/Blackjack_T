import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
	    Deck theDeck = new Deck(1, true);

	    Player me = new Player("Kevin");
	    Player dealer = new Player("Dealer");

	    //2 Karten an Spieler und Dealer austeilen
	    me.addCard(theDeck.dealNextCard());
	    dealer.addCard(theDeck.dealNextCard());
        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());

        //Starthände ausgeben
        System.out.println("Karten verteilt\n");
        me.printHand(true);
        dealer.printHand(false);
        System.out.println("\n");

        //ist jeder fertig mit ziehen?
        boolean meDone = false;
        boolean dealerDone = false;
        String ans;

        while(!meDone || !dealerDone) {
            //Spieler ist drann
            if (!meDone) {

                System.out.println("Hit or Stay? (Drücke H oder S):");
                ans = scan.next();
                System.out.println();

                //Wenn Spieler hittet
                if (ans.compareToIgnoreCase("H") == 0) {
                    meDone = !me.addCard(theDeck.dealNextCard());
                    me.printHand(true);

                }
                else {
                    meDone = true;
                }
                //Dealer ist drann
                if (!dealerDone) {
                    if (dealer.getHandSum() < 17) {
                        System.out.println("Der Dealer zieht eine weitere Karte\n");
                        dealerDone = !dealer.addCard(theDeck.dealNextCard());
                        dealer.printHand(false);
                    } else {
                        System.out.println("Der Dealer zieht keine weitere Karte\n");
                        dealerDone = true;
                    }
                }
                System.out.println();
            }
        }

        //Finale Hände ausgeben
        me.printHand(true);
        dealer.printHand(true);

        int mySum = me.getHandSum();
        int dealerSum = dealer.getHandSum();

        if(mySum > dealerSum && mySum <= 21 || dealerSum > 21){
            System.out.print("Spieler gewinnt");
        } else if(mySum == dealerSum){
            System.out.print("Eure Hände sind gleich viel Wert, keiner gewinnt");
        }
        else{
            System.out.print("Dealer gewinnt");
        }
        scan.close();
    }
}
