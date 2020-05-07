package day01;

public class Crain {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } };
		int[] moves = {1,5,3,5,1,2,1,4};
		
		int answer = 0;
        int[] basket = new int[moves.length];
        int deep = 0;
        
        for(int i = 0; i < moves.length; i++){
            int col = moves[i]-1;
            int row = 0;
            for(row = 0; row < board.length; row++){
                int temp = board[row][col];
                if(temp != 0){
                    basket[deep] = temp;
                    board[row][col] = 0;
                    deep++;
                    if(deep > 1){
                        if(basket[deep-1] == basket[deep-2]){
                            basket[deep-2] = 0;
                            basket[deep-1] = 0;
                            answer+=2;
                            deep -= 2;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(answer);
	}
}
