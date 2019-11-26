package ariehmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class test {

    private String str = "";

    TimerTask task = new TimerTask()
    {
        public void run()
        {
            if(str.equals(""))
            {
            	System.out.println();
                System.out.println( "you input nothing. exit..." );
                System.exit( 0 );
            }
        }    
    };

    public void getInput() throws Exception
    {
        Timer timer = new Timer();
        timer.schedule( task, 10*1000 );
        
        int num1 = (int) (Math.random() * 100) + 1;
		int num2 = (int) (Math.random() * 100) + 1;
		int answer = num1 + num2;
		
		System.out.print(num1 + " + " + num2 + " = ");
        BufferedReader in = new BufferedReader(
        new InputStreamReader( System.in ) );
        str = in.readLine();
        int myAnswer = Integer.parseInt(str);
        timer.cancel();
        if (answer == myAnswer) {
			System.out.println("Great!");
		} else {
			System.out.println("You suck!");
		}
    }

    public static void main( String[] args )
    {
        try
        {
            (new test()).getInput();
        }
        catch( Exception e )
        {
            System.out.println( e );
        }
        System.out.println( "main exit..." );
    }
}