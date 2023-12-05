package com.hackerRank.oneMonth.week.three;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombermanGame {
	/*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */
    public static List<String> bomberMan(int n, List<String> grid) {
    	char[][] g = initGrid(grid);

    	int finalGrid = finalGrid(n);
    	
    	char[][] g2 = null;
    	char[][] g3 = null;
    	char[][] g5 = null;

    	if (n >= 5) {
    		n = 5;
    	}
    	    	
    	for (int cycle = 2 ; cycle <= n; cycle++) {
	    	g = decrementFuses(g);

	    	if ((cycle % 2) == 0) {
		    	g = plantBombs(g);
	    	} else {
			    g = detonateBombs(g);
	    	}

	    	if (cycle == 2) {
	    		g2 = cloneArray(g);
	    	} else if (cycle == 3) {
	    		g3 = cloneArray(g);
	    	} else if (cycle == 5) {
	    		g5 = cloneArray(g);
	    	}
    	}

    	if (finalGrid == 2) {
    		g = g2;
    	} else if (finalGrid == 3) {
    		g = g3;
    	} else if (finalGrid == 5) {
    		g = g5;
    	}

    	return charToStringArray(g);
    }

	private static char[][] initGrid(List<String> grid) {
    	int rows = grid.size();
		char[][] toReturn = new char[rows][];
		for (int r = 0; r < rows; r++) {
			grid.set(r, grid.get(r).replace('O', '2'));
			toReturn[r] = grid.get(r).toCharArray();
		}
		
		return toReturn;
	}
	
	private static char[][] cloneArray(char[][] g) {
		int rows = g.length;
		int cols = g[0].length;
		
		char[][] toReturn = new char[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				toReturn[r][c] = g[r][c];
			}
		}
		
		return toReturn;
	}
		
	private static char[][] decrementFuses(char[][] toReturn) {
		int rows = toReturn.length;
		int cols = toReturn[0].length;
		
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (toReturn[r][c] == '3') {
					toReturn[r][c] = '2';
				} else if (toReturn[r][c] == '2') {
					toReturn[r][c] = '1';
				} else if (toReturn[r][c] == '1') {
					toReturn[r][c] = '0';
				}
			}
		}
		return toReturn;
	}
	
	private static char[][] detonateBombs(char[][] toReturn) {
		int rows = toReturn.length;
		int cols = toReturn[0].length;
		char[][] cg = cloneArray(toReturn);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (cg[r][c] == '0') {
										
					if (r > 0) {
						toReturn[r - 1][c] = '.';
					}
					
					if (r < rows - 1) {
						toReturn[r + 1][c] = '.';
					}
					
					if (c < cols - 1) {
						toReturn[r][c + 1] = '.';
					}
					
					if (c > 0) {
						toReturn[r][c - 1] = '.';
					}
					
					toReturn[r][c] = '.';
				}
			}
		}
		return toReturn;
	}
	
	private static char[][] plantBombs(char[][] toReturn) {
		int rows = toReturn.length;
		int cols = toReturn[0].length;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (toReturn[r][c] == '.') {
					toReturn[r][c] = '3';
				}
			}
		}
		return toReturn;
	}

	private static List<String> charToStringArray(char[][] g) {
		List<String> toReturn = new ArrayList<String>(0);
		int rows = g.length;
		
		char[][] copy = cloneArray(g);

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < copy[r].length; c++) {
				if (copy[r][c] >= '1' && copy[r][c] <= '3') {
					copy[r][c] = 'O';
				} else {
					copy[r][c] = '.';
				}
			}
			toReturn.add(new String(copy[r]));
		}
		return toReturn;
	}	
	
	private static int finalGrid(int n) {
		if (n <= 5) {
			return n;
		} else if (n % 2 == 0) {
			return 2;
		} else if ((n - 3) % 4 == 0) {
			return 3;
		} else if ((n - 5) % 4 == 0) {
			return 5;
		}

		return -1;
	}

    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);
    	String[] rcn = scanner.nextLine().split(" ");
        int r = Integer.parseInt(rcn[0]);
        int n = Integer.parseInt(rcn[2]);
        List<String> grid = new ArrayList<String>(0);
        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid.add(gridItem);
        }

    	List<String> result = bomberMan(n, grid);

        for (int i = 0; i < result.size(); i++) {
        	System.out.println(result.get(i));

            if (i != result.size() - 1) {
            	System.out.println("\n");
            }
        }
        System.out.println();

        scanner.close();
    }
}
