
public class Card {
    
    private Suit mySuit;
    private int myNumber;
    
    public Card(Suit aSuit, int aNumber){
        this.mySuit = aSuit;
        
        if (aNumber >=1 && aNumber <= 13){
           this.myNumber = aNumber;
        } else{
            System.err.println(aNumber + "is not a valid Card Number");
            System.exit(1);
        }
    }
    
    public int getNumber(){
        return myNumber;
    } 
    
    public String toString(){
        
        String numStr = "Error";
        
        switch(this.myNumber){
            
        case 2:
            numStr = "Zwei";
            break;
            
        case 3:
            numStr = "Drei";
            break;
            
        case 4:
            numStr = "Vier";
            break;
            
        case 5:
            numStr = "Fünf";
            break;
            
        case 6:
            numStr = "Sechs";
            break;
            
        case 7:
            numStr = "Sieben";
            break;
            
        case 8:
            numStr = "Acht";
            break;
            
        case 9:
            numStr = "Neun";
            break;
            
        case 10:
            numStr = "Zehn";
            break;
            
        case 11:
            numStr = "Bube";
            break;
            
        case 12: 
            numStr = "Dame";
            break;
        case 13: 
            numStr = "König";
            break;
            
        case 1:
            numStr = "Ass";
            break;
            
        
        }
       return mySuit.toString() + "-" + numStr  ;
    }
}
