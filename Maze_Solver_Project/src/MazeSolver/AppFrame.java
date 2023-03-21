package MazeSolver;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppFrame extends JFrame {

    public Image backgroundImage;
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
    public List<Integer> path = new ArrayList<>();

    JPanel panel;
    public AppFrame() {
        setTitle("Maze Explorer");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFS.searchPath(maze, 1, 1, path);

        //backgroundImage = new ImageIcon("images/jungle.png").getImage();

    }
    @Override
    public void paint(Graphics g){

        Image img = Toolkit.getDefaultToolkit().getImage("images/381-3813016_download-jungle-background-png-clipart-tropical-and-cartoon.png");
       
        g.drawImage(img, 0, 0 , null);

        g.translate(130, 70);


        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                Color color;

                switch(maze[i][j]){
                    case 1 : color=new Color(143, 69, 5);

                        break;
                    case 9 : color=new Color(21, 184, 199);
                        break;
                    default:color=new Color(110, 211, 104, 255);
                        break;
                }

                g.setColor(color);
                g.fillRect(40*j, 40*i, 40, 40);

                g.setColor(new Color(121, 81, 38));
                g.drawRect(40*j, 40*i, 40, 40);

                
            }
        }

         boolean visible = true; // flag to track visibility of circles

        for(int i=0; i<path.size(); i+=2){
            int pathx=path.get(i);
            int pathy=path.get(i+1);

            g.setColor(new Color(217, 62, 62, 255));
            g.fillOval(40*pathx+10, 40*pathy+10, 20, 20 );

        }
    }

    public static void main(String[]args){
        AppFrame view=new AppFrame();
        view.setVisible(true);
            }
    }


