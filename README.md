#CONWAYS GAME OF LIFE


---
Kata Link: 
https://github.com/MYOB-Technology/General_Developer/tree/master/katas/kata-conways-game-of-life
---
###ABOUT CONWAYS:

The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.

The game is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves, or, for advanced players, by creating patterns with particular properties.

---
###THE RULES

1. Any live cell with two or three neighbors survives.
2. Any dead cell with three live neighbors becomes a live cell.
3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.
---
###DEMO
```
                "Welcome to Conway's Game of Life!",
                "The rules are as followed:",
                "Any live cell with fewer than two live neighbours dies",
                "as if caused by underpopulation.",
                "Any live cell with more than three live neighbours dies",
                "as if by overcrowding.",
                "Any live cell with two or three live neighbours lives on to the next generation.",
                "Any dead cell with exactly three live neighbours becomes a live cell.",
                "Press any key to continue;",
                
                
                
                
                "How big would you like your grid:",
                "Please enter the width:",
                5
                "Thank you!",
                "Please enter the height:",
                5
                "Thank you!",
                
                
                "You will have to start the evolution by entering the start phase of the board.",
                "Separate each X|Y coordinate by a comma, and each pair but a backslash. eg: 3,3/4,1",
                "Please input your coordinates:",
                1,2/2,2/3,2
                "Grid set.",
                "How many generations will it run for: ",
                3
                "Thank you!",
                
                
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▣  ▣  ▣  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n",
                
                
                        "▢  ▣  ▢  ▢  ▢  \n" +
                        "▢  ▣  ▢  ▢  ▢  \n" +
                        "▢  ▣  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n",
                        
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▣  ▣  ▣  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n",
                "Society stopped progressing, Thanks for playing!"
```

---
###INSTRUCTIONS:
clone the repo to your local machine:

```https://github.com/eathan-langford-myob/conwaysGameOfLife```

Then navigate to the root folder and run:
```javac Main.java```

followed by: 
```java main```

---

###PATTERNS
```
glider:
2,1/3,2/1,3/2,3/3,3

LWSS
1,1/4,1/5,2/5,3/5,4/4,4/3,4/2,4/1,3

MWSS
2,1/3,1/4,1/5,1/1,2/5,2/5,3/1,4/4,4/

toad
3,2/4,2/5,2/2,3/3,3/4,3
```