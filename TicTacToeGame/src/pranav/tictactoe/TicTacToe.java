package pranav.tictactoe;

import java.util.*;

public class TicTacToe {

    static List<Integer> playerPositions = new ArrayList<>();
    static List<Integer> computerPositions = new ArrayList<>();
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		char[][] gameBoard = {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
				};
		
		TicTacToe.printBoard(gameBoard);
		Scanner inp = null;
		 
		while(true){
			try {
        inp = new Scanner(System.in);
		System.out.print("Enter your number choice : ");
		int choice = inp.nextInt();
		
		if(choice < 0 || choice > 9) {
			throw new IllegalArgumentException("\nPlease enter a valid number from 0-9.\n");
		}
	
	    while(playerPositions.contains(choice) || computerPositions.contains(choice)){
	      System.out.print("\nPosition taken!! Enter a new position: ");
	      choice = inp.nextInt();
	    }
		
		TicTacToe.placeSymbol(choice,gameBoard,"player"); 
		
		if(TicTacToe.resultOccurred(gameBoard)){
		 break;
		}
		
		Random rand = new Random();
		int computerChoice = rand.nextInt(9) + 1;
		
		while(playerPositions.contains(computerChoice) || computerPositions.contains(computerChoice)){
	      computerChoice = rand.nextInt(9) + 1;
	    }
		
		TicTacToe.placeSymbol(computerChoice,gameBoard,"computer");
	   
	    if(TicTacToe.resultOccurred(gameBoard)){
		 break;
		} 
	    
	    TicTacToe.printBoard(gameBoard);
	   }catch(IllegalArgumentException ex) {
		   System.out.println(ex.getMessage());
	     }catch(Exception ex){
	    	 System.out.println("\nPlease enter integer format only!\n");
	     }finally {
	    	 if(inp != null) {
	    		 //inp.close();
	    	 }
	     }
	   }
		inp.close();
	    System.out.println("\nHope you enjoyed the game..");
	}
	
	private static void printBoard(char[][] board) {
		
		System.out.println();
		for(char[] row: board) {
			for(char column : row) {
				System.out.print(column + " ");
			}
			System.out.println();
		}
	}
	
	private static boolean resultOccurred(char[][] board){
	
	 String result = TicTacToe.performGameLogic();
		
		if(result != null){
			TicTacToe.printBoard(board);
	        System.out.println(result);
	        return true;
	     }
	     
	  return false;
	}
	
	private static void placeSymbol(int choice,char[][] gameBoard,String user){
	
	
	    char symbol = ' ';
	    
	    if(user.equals("player")){
	       symbol = 'X';
	       playerPositions.add(choice);
	    }else if(user.equals("computer")){                //if it is computer
	      symbol = 'O';
	      computerPositions.add(choice);
	    }else{}
	    
	 
	  switch(choice) {
	    
	    case 1: gameBoard[0][0] = symbol;
	            break;
	            
	    case 2: gameBoard[0][2] = symbol;
                break;
        
        case 3: gameBoard[0][4] = symbol;
                break;
                
        case 4: gameBoard[2][0] = symbol;
                break;
        
        case 5: gameBoard[2][2] = symbol;
                break;
        
        case 6: gameBoard[2][4] = symbol;
                break;
        
        case 7: gameBoard[4][0] = symbol;
                break;
                
        case 8: gameBoard[4][2] = symbol;
                break;
                
        case 9: gameBoard[4][4] = symbol;
                break;
                
        default: System.out.println("Invalid choice!!");
                 break;
	    }
	}
	
	private static String performGameLogic(){
	
	  List<Integer> topRow = Arrays.asList(1,2,3);
	  List<Integer> midRow = Arrays.asList(4,5,6);
	  List<Integer> botRow = Arrays.asList(7,8,9);
	  List<Integer> leftCol = Arrays.asList(1,4,7);
	  List<Integer> midCol = Arrays.asList(2,5,8);
	  List<Integer> rightCol = Arrays.asList(3,6,9);
	  List<Integer> leftDiag = Arrays.asList(1,5,9);
	  List<Integer> rightDiag = Arrays.asList(3,5,7);
	  
	  List<List<Integer>> winningPositions = new ArrayList<>();
	  
	  winningPositions.add(topRow);
	  winningPositions.add(midRow);
	  winningPositions.add(botRow);
	  winningPositions.add(leftCol);
	  winningPositions.add(midCol);
	  winningPositions.add(rightCol);
	  winningPositions.add(leftDiag);
	  winningPositions.add(rightDiag);
	  
	  for(List<Integer> triad : winningPositions){
	  
	   if(playerPositions.containsAll(triad)){
	      return "\nPlayer has won!!";
	   }
	   
	   if(computerPositions.containsAll(triad)){
	     return "\nComputer has won!!";
	   }
	}
	
	if((playerPositions.size() + computerPositions.size()) == 9 ){
	   return "\nThe Game is tied!!";
	}
	
	return null;
	}

}
