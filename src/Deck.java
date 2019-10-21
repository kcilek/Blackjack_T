import java.util.Random;

public class Deck {
    
    private Card[] myCards;
    private int numCards;
    
    public Deck(){
        this(1, false);
    }
    
    public Deck(int numDecks, boolean shuffle){
        
        this.numCards = numDecks * 52;
        this.myCards = new Card[this.numCards];
        
        //Kartenindex
        int k = 0;
        //Für jedes Deck  
        for(int d = 0; d < numDecks; d++){
            //Für jedes Suit
            for(int s = 0; s < 4; s++){
              //Für jede Nummer
              for(int n = 1; n <= 13; n++){
                //Karte zum Deck hinzufügen
                this.myCards[k] = new Card(Suit.values()[s], n);
                k++;
              }
            }
        }
        
       //Mischeln
       if(shuffle){
           this.shuffle();
       }
    }
    
    public void shuffle(){
         Random rng = new Random();
         
         //temporäre karte
         Card temp;
         
         int j;
         for(int i = 0; i < this.numCards; i++){
             
             //zufällige karte j
             j = rng.nextInt(this.numCards);
             
             //tausch
             temp = this.myCards[i];
             this.myCards[i] = this.myCards[j];
             this.myCards[j] = temp;
             
         }
      }
      
   public Card dealNextCard(){
       // oberste Karte nehmen
       Card top = this.myCards[0];
       
       //übrige karten nach um 1 nach links verschieben
       for(int c = 1; c < this.numCards; c++){
           this.myCards[c-1] = this.myCards[c];
       }
       this.myCards[this.numCards-1] = null;
       
       this.numCards--;
       
       return top;
   }
   
   //nächste Karten im Deck ausgeben
   public void printDeck(int numToPrint){
     for(int i = 0; i < numToPrint; i++){
       System.out.printf("% 3d/%d %s\n", i+1, this.numCards,
       this.myCards[i].toString());  
     }
     System.out.printf("\t[%d others]\n", this.numCards-numToPrint);
   }
   
  
}
