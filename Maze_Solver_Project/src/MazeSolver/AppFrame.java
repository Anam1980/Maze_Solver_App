package MazeSolver;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppFrame extends JFrame {

    //2D Grid as maze 
    private int[][] maze=
            {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 0, 0, 1, 0, 1},
                    {1, 0, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 1, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 9, 1}
            };
    
    //list to add solution path
    public List<Integer> path = new ArrayList<>();

    //Initializing GUI
    public AppFrame() {
        setTitle("Maze Explorer");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFS.searchPath(maze, 1, 1, path);
    }
    
    //create the paint() for visualizing the solution and maze
    @Override
    public void paint(Graphics g){
        
        //added a jungle image in background
        //get
        Image img = Toolkit.getDefaultToolkit().getImage("images/381-3813016_download-jungle-background-png-clipart-tropical-and-cartoon.png");
        //add
        g.drawImage(img, 0, 0 , null);

        //location 
        g.translate(130, 70);

        
        //create maze and give color
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                //initialize color
                Color color;
                
                switch(maze[i][j]){
                        //1->wall
                    case 1 : color=new Color(143, 69, 5);
                        break;
                        //9->destination
                    case 9 : color=new Color(21, 184, 199);
                        break;
                        //0->path
                    default:color=new Color(110, 211, 104, 255);
                        break;
                }
                
                //fill colors int each block
                g.setColor(color);
                g.fillRect(40*j, 40*i, 40, 40);
               
                //draw rectangle to visualize the each block of grid
                g.setColor(new Color(121, 81, 38));
                g.drawRect(40*j, 40*i, 40, 40);

                
            }
        }

        //fill the solution path
        for(int i=0; i<path.size(); i+=2){
            int pathx=path.get(i);
            int pathy=path.get(i+1);

            //with circle 
            g.setColor(new Color(217, 62, 62, 255));
            g.fillOval(40*pathx+10, 40*pathy+10, 20, 20 );

        }
    }

    //launch the app i.e GUI
    public static void main(String[]args){
        AppFrame view=new AppFrame();
        view.setVisible(true);
            }
    }


