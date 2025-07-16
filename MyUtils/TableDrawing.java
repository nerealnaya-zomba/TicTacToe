package MyUtils;

public class TableDrawing {
    //Top | Center | Bottom
    public static void printCircleField(String position)
    {
        switch(position)
        {
            case "Top": System.out.print("  #  ooo  #  "); break;
            case "Center": System.out.print("  #  o o  #  "); break;
            case "Bottom": System.out.print("  #  ooo  #  "); break;
            default: System.out.print("  #  NO_ARGUMENT"); break;
        }
    }
    //Top | Center | Bottom
    public static void printCrossField(String position)
    {
        switch(position)
        {
            case "Top": System.out.print("  #  x x  #  "); break;
            case "Center": System.out.print("  #   x   #  "); break;
            case "Bottom": System.out.print("  #  x x  #  "); break;
            default: System.out.print("  #  NO_ARGUMENT  #  "); break;
        }
    }
    //Top | Center | Bottom
    public static void printEmptyField()
    {
        System.out.print("  #       #  ");
    }
    public static void printTable(TicTacToeField[] arr)
    {
        System.out.println("  ###################################");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==0)
                {
                    for (int j2 = 0; j2 < 3; j2++) {
                        switch(arr[j2])
                        {
                            case EMPTY:
                                TableDrawing.printEmptyField();
                                break;
                            case CROSS:
                                if(j==0) TableDrawing.printCrossField("Top");
                                else if(j==1)TableDrawing.printCrossField("Center");
                                else if(j==2)TableDrawing.printCrossField("Bottom");
                                break;
                            case CIRCLE:
                                if(j==0) TableDrawing.printCircleField("Top");
                                else if(j==1)TableDrawing.printCircleField("Center");
                                else if(j==2)TableDrawing.printCircleField("Bottom");
                                break;
                        }
                    }
                }
                else if(i==1)
                {
                    for (int j2 = 3; j2 < 6; j2++) {
                        switch(arr[j2])
                        {
                            case EMPTY:
                                TableDrawing.printEmptyField();
                                break;
                            case CROSS:
                                if(j==0) TableDrawing.printCrossField("Top");
                                else if(j==1)TableDrawing.printCrossField("Center");
                                else if(j==2)TableDrawing.printCrossField("Bottom");
                                break;
                            case CIRCLE:
                                if(j==0) TableDrawing.printCircleField("Top");
                                else if(j==1)TableDrawing.printCircleField("Center");
                                else if(j==2)TableDrawing.printCircleField("Bottom");
                                break;
                        }
                    }
                }
                else if(i==2)
                {
                    for (int j2 = 6; j2 < 9; j2++) {
                        switch(arr[j2])
                        {
                            case EMPTY:
                                TableDrawing.printEmptyField();
                                break;
                            case CROSS:
                                if(j==0) TableDrawing.printCrossField("Top");
                                else if(j==1)TableDrawing.printCrossField("Center");
                                else if(j==2)TableDrawing.printCrossField("Bottom");
                                break;
                            case CIRCLE:
                                if(j==0) TableDrawing.printCircleField("Top");
                                else if(j==1)TableDrawing.printCircleField("Center");
                                else if(j==2)TableDrawing.printCircleField("Bottom");
                                break;
                        }
                    }
                }
                System.out.println();
                
            }
            //New line
            System.out.println("  ###################################");
        }
    }
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}
